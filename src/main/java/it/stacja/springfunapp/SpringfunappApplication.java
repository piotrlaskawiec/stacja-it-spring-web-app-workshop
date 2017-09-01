package it.stacja.springfunapp;

import it.stacja.springfunapp.purespring.SampleBean1;
import it.stacja.springfunapp.purespring.SampleBean2;
import it.stacja.springfunapp.purespring.SampleBean3;
import it.stacja.springfunapp.purespring.SampleBean5;
import it.stacja.springfunapp.tinyspring.TinySpringContext;
import it.stacja.springfunapp.tinyspring.TinySpringSampleBean2;
import it.stacja.springfunapp.tinyspring.TinySpringSampleBean3;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan
@SpringBootApplication
public class SpringfunappApplication {
	public static void main(String[] args) {
        SpringApplication.run(SpringfunappApplication.class);
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringfunappApplication.class);
//
//        SampleBean1 sampleBean1 = applicationContext.getBean(SampleBean1.class);
//        sampleBean1.businessLogic();
//
//        SampleBean2 sampleBean2 = applicationContext.getBean(SampleBean2.class);
//        sampleBean2.businessLogic();
//
//        System.out.println(sampleBean2.hashCode());
//
//        SampleBean2 sampleBean2_2 = applicationContext.getBean(SampleBean2.class);
//        System.out.println(sampleBean2_2.hashCode());
//
//        SampleBean3 sampleBean3 = applicationContext.getBean(SampleBean3.class);
//        sampleBean3.businessLogic();
//
//        SampleBean5 sampleBean5_1 = applicationContext.getBean(SampleBean5.class);
//        SampleBean5 sampleBean5_2 = applicationContext.getBean(SampleBean5.class);
//
//        System.out.println(sampleBean5_1.hashCode());
//        System.out.println(sampleBean5_2.hashCode());
        // 1. @Configuration -> @Bean
        // 2. @Component
        // 3. -> 1,2
        // ...

//        TinySpringContext tinySpringContext =
//                new TinySpringContext("it.stacja.springfunapp.tinyspring");
//        TinySpringSampleBean2 tinySpringSampleBean2 = tinySpringContext.getElement(TinySpringSampleBean2.class);
//        tinySpringSampleBean2.businessMethod();

//        TinySpringSampleBean3 tinySpringSampleBean3_1 = tinySpringContext.getElement(TinySpringSampleBean3.class);
//        TinySpringSampleBean3 tinySpringSampleBean3_2 = tinySpringContext.getElement(TinySpringSampleBean3.class);
//
//        System.out.println(tinySpringSampleBean3_1.hashCode());
//        System.out.println(tinySpringSampleBean3_2.hashCode());

	}
}
