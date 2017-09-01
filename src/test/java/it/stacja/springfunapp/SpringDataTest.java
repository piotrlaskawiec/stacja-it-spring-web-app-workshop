package it.stacja.springfunapp;

import it.stacja.springfunapp.model.Pixel;
import it.stacja.springfunapp.model.Wallet;
import it.stacja.springfunapp.repositories.PixelRepository;
import it.stacja.springfunapp.repositories.WalletRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SpringDataTest {

    @Autowired
    private PixelRepository pixelRepository;

    @Autowired
    private WalletRepository walletRepository;

    @Test
    public void name() throws Exception {
        this
                .pixelRepository
                .findAll()
                .forEach(System.out::println);
    }

    @Test
    public void saveTest() throws Exception {
        Pixel pixel = new Pixel();
        pixel.setRow(5);
        pixel.setColumn(5);
        pixel.setColor("#ffffff");

        this.pixelRepository.save(pixel);
    }

    @Test
    public void getPixelTest() throws Exception {
        Optional<Pixel> pixelOpt = this.pixelRepository.findByRowAndColumn(3, 0);
        Pixel pixel = pixelOpt.get();

        System.out.println(pixel.getRow());
        System.out.println(pixel.getColumn());
    }

    @Test
    public void shouldReturn10Tokens() throws Exception {
        Optional<Wallet> wallet = this.walletRepository.findFirstBy();
        System.out.println(wallet.get().getTokens());
    }
}
