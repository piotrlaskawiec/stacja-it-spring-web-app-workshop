package it.stacja.springfunapp.tinyspring;

import org.reflections.ReflectionUtils;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TinySpringContext {
    private final Map<Class, Object> instances = new HashMap<>();
    private final String prefix;

    public TinySpringContext(String prefix) {
        this.prefix = prefix;
        init();
    }

    private void init() {
        Reflections reflections = new Reflections(this.prefix);
        //ReflectionUtils.getMethods()
        Set<Class<?>> elements = reflections.getTypesAnnotatedWith(Element.class);
        elements
                .stream()
                .filter(aClass -> !aClass.isAnnotationPresent(Lazy.class))
                .forEach(this::resolve);
    }

    private Object resolve(Class<?> classType) {
        if(!classType.isAnnotationPresent(Element.class)) {
            throw new IllegalArgumentException("No @Element");
        }

        if(this.instances.containsKey(classType)) {
            return this.instances.get(classType);
        }

        Constructor<?>[] constructors = classType.getConstructors();

        if(constructors.length > 1) {
            throw new IllegalStateException(">1 constructors");
        }

        Constructor<?> primaryConstructor = constructors[0];
        Class<?>[] constructorParameterTypes = primaryConstructor.getParameterTypes();
        Object[] parameterValues = Arrays.stream(constructorParameterTypes).map(this::resolve).toArray();

        try {
            Object newInstance = primaryConstructor.newInstance(parameterValues);

            ReflectionUtils.getMethods(classType, input -> input.isAnnotationPresent(WhenCreated.class))
                    .forEach(method -> {
                        try {
                            method.invoke(newInstance);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    });

            if(!classType.isAnnotationPresent(Proto.class)) {
                this.instances.put(classType, newInstance);
            }

            return newInstance;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public <T> T getElement(Class<T> classType) {
        return (T) this.resolve(classType);
    }
}
