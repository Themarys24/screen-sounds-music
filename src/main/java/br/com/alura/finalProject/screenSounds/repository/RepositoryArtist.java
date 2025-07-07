package br.com.alura.finalProject.screenSounds.repository;

import br.com.alura.finalProject.screenSounds.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositoryArtist extends JpaRepository<Artist, Long> {
    Optional<Artist> findByNameIgnoreCase(String name);
    boolean existsByNameIgnoreCase(String name);
}
