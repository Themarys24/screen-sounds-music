
**🎵 ScreenSounds Music App**  

A simple console-based Java application that allows users to register music, artists, songs, search songs by artist, and retrieve artist summaries from Wikipedia using an AI-powered API call.  

📌 Features  

✅ Register music artists with types: SOLO, DUO, BAND

✅ Register songs with title, artist, and genre

✅ List all registered songs

✅ Search songs by artist

✅ Fetch a Wikipedia summary about an artist using an external API

✅ Uses Spring Boot, Spring Data JPA, and PostgreSQL

---

🛠️ Technologies

Java 17+

Spring Boot

Spring Data JPA

PostgreSQL

Hibernate

Wikipedia API (via HttpURLConnection)

---

🧩 Entities

🎤 Artist
id (auto-generated)

name

type: SOLO, DUO, or BAND

musics: list of songs linked to the artist

🎶 Musics

id (auto-generated)

title

artist (many-to-one relationship)

gender

---

💻 How It Works

When you run the application, a menu is displayed in the terminal:  

 *** Screen Sounds Musics ***  
1 - Register artist  
2 - Register song  
3 - List songs  
4 - Search songs by artist  
5 - Search data about artist  
9 - Exit  
You can interactively add or retrieve data through this menu.  


---

🌐 External API

Artist summaries are retrieved from the Wikipedia API in plain text format.

Example endpoint used:

`https://en.wikipedia.org/w/api.php?action=query&format=json&prop=extracts&exintro&explaintext&titles={artistName}`

---

🧪 How to Run

Configure your database in application.properties:

```
spring.datasource.url=jdbc:postgresql://localhost/screensoundsdb  
spring.datasource.username=your_username  
spring.datasource.password=your_password  
```

Run PostgreSQL and create a database named screensoundsdb:
CREATE DATABASE screensoundsdb;  

Build and run the application:  
./mvnw spring-boot:run  

The interactive menu will be shown in the terminal.

---

📁 Project Structure

├── model/
│   ├── Artist.java  
│   ├── Musics.java  
│   ├── ArtistType.java  
│   └── AI.java  
├── repository/  
│   ├── ArtistRepository.java  
│   ├── MusicsRepository.java  
├── service/  
│   └── ApiConsumption.java  
├── main/  
│   └── Main.java  
├── ScreenSoundsApplication.java  
└── StartupRunner.java  

---

🧠 AI Feature

The AI class uses the Wikipedia API to provide a brief summary of the artist entered by the user, giving contextual information and improving the app's experience.






