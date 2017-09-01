package it.stacja.springfunapp.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("tinyspring")
public class TinySpringProperties {
    private String prefix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
