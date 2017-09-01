package it.stacja.springfunapp.api;

import it.stacja.springfunapp.model.Pixel;
import it.stacja.springfunapp.model.Wallet;
import it.stacja.springfunapp.services.PixelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pixels")
public class PixelController {

    private final PixelService pixelService;

    public PixelController(PixelService pixelService) {
        this.pixelService = pixelService;
    }

    @GetMapping
    public List<Pixel> pixels() {
        return this.pixelService.getAllPixels();
    }

    @PostMapping
    public Wallet reservePixel(@Valid PixelReservationRequest pixelReservationRequest) {
        return pixelService.reservePixel(pixelReservationRequest);
    }
}
