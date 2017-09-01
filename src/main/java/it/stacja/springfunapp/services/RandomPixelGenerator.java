package it.stacja.springfunapp.services;

import it.stacja.springfunapp.RandomColorGeneratorService;
import it.stacja.springfunapp.model.Pixel;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class RandomPixelGenerator {
    private final RandomColorGeneratorService randomColorGeneratorService;
    private final SecureRandom secureRandom = new SecureRandom();

    public RandomPixelGenerator(RandomColorGeneratorService randomColorGeneratorService) {
        this.randomColorGeneratorService = randomColorGeneratorService;
    }

    public Pixel getRandomPixel() {
        Pixel pixel = new Pixel();
        pixel.setRow(secureRandom.nextInt(100));
        pixel.setColumn(secureRandom.nextInt(100));
        pixel.setColor(randomColorGeneratorService.getRandomHtmlColor());

        return pixel;
    }
}
