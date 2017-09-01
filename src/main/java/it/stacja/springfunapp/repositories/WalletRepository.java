package it.stacja.springfunapp.repositories;

import it.stacja.springfunapp.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;
import java.util.Optional;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Optional<Wallet> findFirstBy();

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Wallet> findForUpdateFirstBy();
}
