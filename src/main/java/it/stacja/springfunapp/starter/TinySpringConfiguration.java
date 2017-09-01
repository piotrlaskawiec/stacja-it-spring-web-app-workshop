package it.stacja.springfunapp.starter;

import it.stacja.springfunapp.tinyspring.TinySpringContext;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(TinySpringContext.class)
@EnableConfigurationProperties(TinySpringProperties.class)
public class TinySpringConfiguration {
    private final TinySpringProperties tinySpringProperties;

    public TinySpringConfiguration(TinySpringProperties tinySpringProperties) {
        this.tinySpringProperties = tinySpringProperties;
    }

    @Bean
    @ConditionalOnMissingBean
    public TinySpringContext tinySpringContext() {
        return new TinySpringContext(this.tinySpringProperties.getPrefix());
    }
}
