package it.stacja.springfunapp.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PAYMENT_REQUIRED)
public class WalletIsEmptyException extends RuntimeException {
}
