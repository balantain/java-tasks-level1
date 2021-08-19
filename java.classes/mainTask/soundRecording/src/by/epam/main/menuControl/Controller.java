package by.epam.main.menuControl;

import by.epam.main.actionClasses.PlaylistCreator;
import by.epam.main.enums.Genres;
import by.epam.main.objectClasses.Track;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    public static void runProgramme(Scanner scanner){
        switch (getUserInputCorrectValue(scanner, Menu.MAIN_MENU, 1, 3)) {
            case 1:
                burnDisk(scanner, PlaylistCreator.createPersonalPlaylist(scanner));
                break;
            case 2: burnDisk(scanner, PlaylistCreator.createPlaylistByMood(scanner));
                break;
            case 3:
                break;
        }
        scanner.close();
        System.out.println(Menu.PROGRAMME_EXIT_MESSAGE);
    }

    public static void burnDisk(Scanner scanner, ArrayList<Track> playlist) {
        int playlistLength = 0;
        for (Track track : playlist) {
            playlistLength += track.getTrackLength();
        }
        switch (Controller.getUserInputCorrectValue(scanner, Menu.BURN_DISK_MENU, 1, 2)) {
            case 1:
                PlaylistCreator.sortListByGenre(playlist).forEach(System.out::println);
                System.out.println(Menu.DISK_LENGTH_MESSAGE + " " + PlaylistCreator.getTrackLengthAsString(playlistLength));
                break;
            case 2:
                playlist.forEach(System.out::println);
                System.out.println(Menu.DISK_LENGTH_MESSAGE + " " + PlaylistCreator.getTrackLengthAsString(playlistLength));
                break;
        }
    }

    public static int getUserInputCorrectValue(Scanner scanner, String menu, int valueDiapasonStart, int valueDiapasonEnd) {
        System.out.println(menu);
        int userInput = 0;
        boolean isInputIsCorrect = false;
        while (!isInputIsCorrect) {
            while (!scanner.hasNextInt()) {
                System.out.println(Menu.WRONG_INPUT_ERROR);
                System.out.println(menu);
                scanner.next();
            }
            userInput = scanner.nextInt();
            if (userInput < valueDiapasonStart || userInput > valueDiapasonEnd) {
                System.out.println(Menu.WRONG_INPUT_ERROR);
                System.out.println(menu);
            } else {
                isInputIsCorrect = true;
            }
        }
        return userInput;
    }

    public static ArrayList<Track> getSongBase() {
        ArrayList<Track> songBase = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("src/resources/songBase.txt");
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                Track track = new Track();
                String[] songInfo = scanner.nextLine().split("-");
                track.setArtistName(songInfo[0].trim());
                track.setTrackName(songInfo[1].trim());
                String[] trackLength = songInfo[2].split(":");
                int minutes = Integer.parseInt(trackLength[0].trim());
                int seconds = Integer.parseInt(trackLength[1].trim());
                int length = minutes * 60 + seconds;
                track.setTrackLength(length);
                String genre = songInfo[3].trim();
                switch (genre) {
                    case "ROCK":
                        track.setGenre(Genres.ROCK);
                        break;
                    case "POP":
                        track.setGenre(Genres.POP);
                        break;
                    case "RAP":
                        track.setGenre(Genres.RAP);
                        break;
                    case "ELECTRONIC":
                        track.setGenre(Genres.ELECTRONIC);
                        break;
                    case "DANCE":
                        track.setGenre(Genres.DANCE);
                        break;
                    default:
                        track.setGenre(Genres.OTHER);
                        break;
                }
                track.setMood(songInfo[4].trim());
                songBase.add(track);
            }
            fileReader.close();
        } catch (Exception e) {
            System.out.println("No song base found! Put it to the next root:\"src/resources/songBase.txt\"");
        }
        return songBase;
    }
}