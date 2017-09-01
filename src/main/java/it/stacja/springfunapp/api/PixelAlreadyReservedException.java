package it.stacja.springfunapp.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class PixelAlreadyReservedException extends RuntimeException {
}
