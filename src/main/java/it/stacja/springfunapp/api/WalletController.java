package it.stacja.springfunapp.api;

import it.stacja.springfunapp.model.Wallet;
import it.stacja.springfunapp.services.WalletService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallet")
public class WalletController {
    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping
    public Wallet wallet() {
        return this.walletService.getMainWallet().get();
    }
}
