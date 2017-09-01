package it.stacja.springfunapp.services;

import it.stacja.springfunapp.model.Wallet;
import it.stacja.springfunapp.repositories.WalletRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WalletService {
    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Optional<Wallet> getMainWallet() {
        return this.walletRepository.findFirstBy();
    }
}
