package it.stacja.springfunapp.services;

import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import it.stacja.springfunapp.api.PixelAlreadyReservedException;
import it.stacja.springfunapp.api.PixelReservationRequest;
import it.stacja.springfunapp.api.WalletIsEmptyException;
import it.stacja.springfunapp.model.Pixel;
import it.stacja.springfunapp.model.Wallet;
import it.stacja.springfunapp.repositories.PixelRepository;
import it.stacja.springfunapp.repositories.WalletRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PixelService {
    private final PixelRepository pixelRepository;
    private final WalletRepository walletRepository;

    private final Subject<Pixel> pixelStream = PublishSubject.<Pixel>create().toSerialized();

    public PixelService(PixelRepository pixelRepository, WalletRepository walletRepository) {
        this.pixelRepository = pixelRepository;
        this.walletRepository = walletRepository;
    }

    public List<Pixel> getAllPixels() {
        return this.pixelRepository.findAll();
    }

    @Transactional
    public Wallet reservePixel(PixelReservationRequest pixelReservationRequest) {
        Optional<Pixel> reservedPixel = this.pixelRepository.findByRowAndColumn(
                pixelReservationRequest.getRow(),
                pixelReservationRequest.getColumn());

        if(reservedPixel.isPresent()) {
            throw new PixelAlreadyReservedException();
        }

        Wallet wallet = this.walletRepository.findForUpdateFirstBy().get();
        if(wallet.getTokens() == 0) {
            throw new WalletIsEmptyException();
        }
        wallet.setTokens(wallet.getTokens()-1);

        Pixel newPixel = new Pixel();
        newPixel.setRow(pixelReservationRequest.getRow());
        newPixel.setColumn(pixelReservationRequest.getColumn());
        newPixel.setColor(pixelReservationRequest.getColor());

        pixelRepository.save(newPixel);
//        walletRepository.save(wallet);

        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
            @Override
            public void afterCommit() {
                super.afterCommit();
                PixelService.this.pixelStream.onNext(newPixel);
            }
        });

        return wallet;
    }

    public Subject<Pixel> getStream() {
        return this.pixelStream;
    }
}
