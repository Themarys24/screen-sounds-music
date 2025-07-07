package br.com.alura.finalProject.screenSounds.repository;

import br.com.alura.finalProject.screenSounds.model.Musics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryMusics extends JpaRepository<Musics, Long> {
}
