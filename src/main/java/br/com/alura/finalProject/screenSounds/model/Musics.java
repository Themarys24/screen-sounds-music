package br.com.alura.finalProject.screenSounds.model;

import jakarta.persistence.*;

@Entity
@Table(name = "musics")
public class Musics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    private Artist artist;

    private String gender;

    public Musics() {
        // Construtor padrão obrigatório para JPA
    }

    public Musics(String title, Artist artist, String genre) {
        this.title = title;
        this.artist = artist;
        this.gender = genre;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Musics{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + gender + '\'' +
                ", artist=" + (artist != null ? artist.getName() : "null") +
                '}';
    }
}
