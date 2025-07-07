package br.com.alura.finalProject.screenSounds.main;

import br.com.alura.finalProject.screenSounds.repository.ArtistRepository;
import br.com.alura.finalProject.screenSounds.repository.MusicsRepository;
import br.com.alura.finalProject.screenSounds.model.AI;
import br.com.alura.finalProject.screenSounds.model.Artist;
import br.com.alura.finalProject.screenSounds.model.ArtistType;
import br.com.alura.finalProject.screenSounds.model.Musics;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Main {

    private final ArtistRepository artistRepository;
    private final MusicsRepository musicsRepository;

    public Main(ArtistRepository artistRepository, MusicsRepository musicsRepository) {
        this.artistRepository = artistRepository;
        this.musicsRepository = musicsRepository;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int option = -1;

        do{
           showMenu();
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Please enter a valid number.");
                option = -1; // Valor inválido para forçar a repetição do menu
                continue;
            }

            switch (option) {
                case 1 -> registerArtist(scanner);
                case 2 -> registerSong(scanner);
                case 3 -> listSongs();
                case 4 -> searchMusicByArtist(scanner);
                case 5 -> AI.searchArtist(scanner);
                case 9 -> System.out.println("Closing...");
                default -> System.out.println("Invalid operation.");
            }

        } while (option != 9);

        scanner.close();
    }
    private void registerArtist(Scanner scanner){
        System.out.println("Artist name: ");

        String name = scanner.nextLine();

        if (artistRepository.existsByNameIgnoreCase(name)) {
            System.out.println("Artist already registered.");
            return;
        }

        System.out.print("Enter artist type (SOLO, DUO, BAND): ");
        String typeInput = scanner.nextLine().toUpperCase();
        ArtistType type = ArtistType.valueOf(typeInput);

        artistRepository.save(new Artist(name, type));
        System.out.println("Registered artist!");

    }

    private void registerSong(Scanner scanner){
        System.out.println("Song title: ");
        String title = scanner.nextLine();

        System.out.println("Artist name: ");
        String artistName = scanner.nextLine();

        Artist artist = (Artist) artistRepository.findByNameIgnoreCase(artistName).orElse(null);


        if (artist == null){
            System.out.println("Artist not found. Please, register the artist before.");
            return;
        }

        System.out.println("Enter gender: ");
        String gender = scanner.nextLine();

        musicsRepository.save(new Musics(title, artist, gender));
        System.out.println("Registered song!");
    }

    private void listSongs(){
        System.out.println("\n-- Music List --");
        musicsRepository.findAll().forEach(System.out::println);

    }

    private void searchMusicByArtist(Scanner scanner){
        System.out.println("Enter artist name: ");
        String name = scanner.nextLine();

        musicsRepository.findAll().stream()
                .filter(m -> m.getArtist().getName().equalsIgnoreCase(name))
                .forEach(System.out::println);
    }


    public static void showMenu() {
        System.out.println("\n *** Screen Sounds Musics ***");
        System.out.println("1 - Register artist");
        System.out.println("2 - Register song");
        System.out.println("3 - List songs");
        System.out.println("4 - Search songs by artist");
        System.out.println("5 - Search data about artist");
        System.out.println("9 - Exit");
        System.out.print("Choose an option: ");
    }

}
