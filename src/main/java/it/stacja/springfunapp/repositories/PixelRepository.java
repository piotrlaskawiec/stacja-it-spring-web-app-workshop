package it.stacja.springfunapp.repositories;

import it.stacja.springfunapp.model.Pixel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PixelRepository extends JpaRepository<Pixel, Long> {
    Optional<Pixel> findByRowAndColumn(int row, int column);
}
