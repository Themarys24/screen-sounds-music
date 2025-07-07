package br.com.alura.finalProject.screenSounds.repository;

import br.com.alura.finalProject.screenSounds.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    boolean existsByNameIgnoreCase(String name);
    Optional<Artist> findByNameIgnoreCase(String name);
}
