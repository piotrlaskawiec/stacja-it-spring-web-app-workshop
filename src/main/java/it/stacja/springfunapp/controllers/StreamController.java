package it.stacja.springfunapp.controllers;

import io.reactivex.disposables.Disposable;
import it.stacja.springfunapp.RandomColorGeneratorService;
import it.stacja.springfunapp.model.Pixel;
import it.stacja.springfunapp.services.PixelService;
import it.stacja.springfunapp.services.RandomPixelGenerator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Controller
public class StreamController {
    private List<SseEmitter> emitters = new CopyOnWriteArrayList<>();

    private final RandomPixelGenerator randomPixelGenerator;
    private final PixelService pixelService;

    public StreamController(RandomPixelGenerator randomPixelGenerator, PixelService pixelService) {
        this.randomPixelGenerator = randomPixelGenerator;
        this.pixelService = pixelService;
    }

    @RequestMapping("/stream")
    public SseEmitter stream() {
        SseEmitter sseEmitter = new SseEmitter();

        Disposable disposable = this.pixelService.getStream().subscribe(pixel -> {
            try {
                sseEmitter.send(pixel);
            } catch(Exception e) {
                // do nothing
            }
        });

        sseEmitter.onTimeout(() -> disposable.dispose());
        sseEmitter.onCompletion(() -> disposable.dispose());

//        emitters.add(sseEmitter);
//        sseEmitter.onCompletion(() -> emitters.remove(sseEmitter));
//        sseEmitter.onTimeout(() -> emitters.remove(sseEmitter));

        return sseEmitter;
    }

    //@Scheduled(fixedRate = 100)
    public void generateEvents() {
        List<SseEmitter> deadClients = new ArrayList<>();
        Pixel pixel = this.randomPixelGenerator.getRandomPixel();
        this.emitters.forEach(sseEmitter -> {
            try {
                sseEmitter.send(pixel);
            } catch (IOException e) {
                deadClients.add(sseEmitter);
            }
        });
        this.emitters.removeAll(deadClients);
    }

}
