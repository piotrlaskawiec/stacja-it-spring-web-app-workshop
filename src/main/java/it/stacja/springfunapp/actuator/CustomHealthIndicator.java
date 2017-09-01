package it.stacja.springfunapp.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class CustomHealthIndicator implements HealthIndicator {
    private final SecureRandom secureRandom = new SecureRandom();

    @Override
    public Health health() {
        return secureRandom.nextInt() % 2 == 0 ?
                Health.up().build() :
                Health.down().withDetail("custom.health", "1234").build();
    }
}
