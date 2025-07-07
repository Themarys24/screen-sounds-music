package br.com.alura.finalProject.screenSounds.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class ApiConsumption{
    public static String searchArtistSummary(String artistName) throws IOException {
    String urlStr = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=extracts&exintro&explaintext&titles="
            + URLEncoder.encode(artistName, "UTF-8");

    URL url = new URL(urlStr);
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");

    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuilder content = new StringBuilder();
    while((inputLine = in.readLine()) != null){
        content.append(inputLine);
    }
    in.close();
    con.disconnect();

    return content.toString();
}


}
