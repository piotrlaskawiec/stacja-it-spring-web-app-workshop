package it.stacja.springfunapp;

import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.security.SecureRandom;

@Service
public class RandomColorGeneratorService {
    private final SecureRandom random = new SecureRandom();

    private final CounterService counterService;

    public RandomColorGeneratorService(CounterService counterService) {
        this.counterService = counterService;
    }

    public String getRandomHtmlColor() {
        Color color = new Color(random.nextFloat(), random.nextFloat(), random.nextFloat());

        this.counterService.increment("random.color");

        return "#" + Integer.toHexString(color.getRGB()).substring(2);
    }
}
