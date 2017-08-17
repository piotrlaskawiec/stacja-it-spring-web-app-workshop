package it.stacja.springfunapp;

import org.springframework.stereotype.Service;

import java.awt.*;
import java.security.SecureRandom;

@Service
public class RandomColorGeneratorService {
    private final SecureRandom random = new SecureRandom();

    public String getRandomHtmlColor() {
        Color color = new Color(random.nextFloat(), random.nextFloat(), random.nextFloat());
        return "#" + Integer.toHexString(color.getRGB()).substring(2);
    }
}
