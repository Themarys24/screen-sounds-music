package br.com.alura.finalProject.screenSounds;

import br.com.alura.finalProject.screenSounds.main.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner {

    private final Main main;

    public StartupRunner(Main main) {
        this.main = main;
    }

    @Override
    public void run(String... args) {
        main.start(); // chama o menu interativo
    }
}

