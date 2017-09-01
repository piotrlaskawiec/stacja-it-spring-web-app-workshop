package it.stacja.springfunapp.purespring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleConfiguration {

    @Bean
    public SampleBean1 sampleBean1() {
        return new SampleBean1();
    }

    @Bean
    public SampleBean3 sampleBean3(SampleBean1 sampleBean1, SampleBean2 sampleBean2) {
        return new SampleBean3(sampleBean1, sampleBean2);
    }
}
