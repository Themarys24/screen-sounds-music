package br.com.alura.finalProject.screenSounds.model;

import br.com.alura.finalProject.screenSounds.service.ApiConsumption;
import org.json.JSONObject;

import java.util.Scanner;
import java.io.IOException;

public class AI {
    public static void searchArtist(Scanner scanner) {
        System.out.println("Enter the artist name to search: ");
        String name = scanner.nextLine();

        System.out.println(" searching about: " + name + "...");

        try {
            String jsonResult = ApiConsumption.searchArtistSummary(name);

            JSONObject obj = new JSONObject(jsonResult);
            JSONObject query = obj.getJSONObject("query");
            JSONObject pages = query.getJSONObject("pages");


            String pageId = pages.keys().next();
            JSONObject page = pages.getJSONObject(pageId);


            String extract = page.getString("extract");

            System.out.println("\nSummary:\n" + extract);



        } catch (IOException e) {
            System.out.println("Error while searching artist: " + e.getMessage());
        }

    }
}
