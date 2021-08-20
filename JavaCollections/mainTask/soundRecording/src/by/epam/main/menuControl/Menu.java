package by.epam.main.menuControl;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Menu {

    static Scanner scanner = new Scanner(System.in);
    static Locale locale = new Locale(getLocalization(scanner));
    static ResourceBundle resourceBundle = ResourceBundle.getBundle("menuLanguage", locale);

    public static final String LOCALIZATION_MENU = "Выберите язык программы / Choose program language:\n1.Ru\n2.En";

    public static final String LOCALIZATION_ERROR = "Неправильный ввод! Попробуйте еще раз. / Wrong input! Try Again.";

    public static final String WRONG_INPUT_ERROR = resourceBundle.getString("error");
    public static final String WRONG_INPUT_SECONDS = resourceBundle.getString("error.Seconds");

    public static final String PROGRAMME_EXIT_MESSAGE = resourceBundle.getString("main.exitMessage");

    public static final String DISK_MAXIMUM_CAPACITY_MESSAGE = resourceBundle.getString("diskLength.message");

    public static final String DISK_FREE_SPACE_MESSAGE = resourceBundle.getString("diskLength.freeSpaceMessage");

    public static final String MINUTES = resourceBundle.getString("minutes");
    public static final String SECONDS = resourceBundle.getString("seconds");

    public static final String MAIN_MENU =
            resourceBundle.getString("main.createPersonalPlaylist") + "\n" +
            resourceBundle.getString("main.createMoodPlaylist") + "\n" +
            resourceBundle.getString("main.exit");

    public static final String ADD_FIRST_TRACK_MENU =
            resourceBundle.getString("personalPlaylist.addPersonalTrack") + "\n" +
            resourceBundle.getString("personalPlayList.searchByArtist") + "\n" +
            resourceBundle.getString("personalPlaylist.searchByGenre") + "\n" +
            resourceBundle.getString("personalPlaylist.searchByTrackLength");

    public static final String ADD_MORE_TRACK_MENU =
            resourceBundle.getString("personalPlaylist.addPersonalTrack") + "\n" +
                    resourceBundle.getString("personalPlayList.searchByArtist") + "\n" +
                    resourceBundle.getString("personalPlaylist.searchByGenre") + "\n" +
                    resourceBundle.getString("personalPlaylist.searchByTrackLength") + "\n" +
                    resourceBundle.getString("personalPlaylist.goToBurnMenu");

    public static final String MOOD_PLAYLIST_CREATING_MENU =
            resourceBundle.getString("mood.calm") + "\n" +
            resourceBundle.getString("mood.energetic") + "\n" +
            resourceBundle.getString("mood.aggressive");

    public static final String USER_ADD_TRACK_NAME = resourceBundle.getString("addPersonalTrack.addTrackName");
    public static final String USER_ADD_ARTIST_NAME = resourceBundle.getString("addPersonalTrack.addArtistName");
    public static final String USER_ADD_TRACK_LENGTH = resourceBundle.getString("addPersonalTrack.addTrackLength");
    public static final String USER_TRACK_CREATION_CHECK = resourceBundle.getString("addPersonalTrack.check");

    public static final String ARTIST_NAME_LIST = resourceBundle.getString("choose.artistName");
    public static final String TRACK_NAME_LIST = resourceBundle.getString("choose.trackName");
    public static final String DIAPASON_START_MESSAGE = resourceBundle.getString("choose.diapasonStart");
    public static final String DIAPASON_END_MESSAGE = resourceBundle.getString("choose.diapasonEnd");
    public static final String NO_TRACKS_FOUND = resourceBundle.getString("choose.noTracksFound");

    public static final String USER_ADD_GENRE_MENU =
            resourceBundle.getString("addPersonalTrack.addGenre") + ":\n" +
            resourceBundle.getString("genre.rock") + "\n" +
            resourceBundle.getString("genre.pop") + "\n" +
            resourceBundle.getString("genre.rap") + "\n" +
            resourceBundle.getString("genre.electric") + "\n" +
            resourceBundle.getString("genre.dance") + "\n" +
            resourceBundle.getString("genre.other");

    public static final String DISK_LIMIT_EXCEPTION_MENU =
            resourceBundle.getString("addPersonalTrack.diskLimitException") + "\n" +
            resourceBundle.getString("addPersonalTrack.diskLimitExceptionContinue") + "\n" +
            resourceBundle.getString("addPersonalTrack.diskLimitExceptionAnotherLength") + "\n" +
            resourceBundle.getString("addPersonalTrack.diskLimitExceptionReturn");

    public static final String BURN_DISK_MENU =
            resourceBundle.getString("personalPlaylist.sortListByGenre") + "\n" +
            resourceBundle.getString("personalPlaylist.finishPlayList") + "\n";

    public static final String DISK_LENGTH_MESSAGE = resourceBundle.getString("diskLengthMessage");

    public static String getLocalization(Scanner scanner) {
        String localization = " ";
        System.out.println(LOCALIZATION_MENU);
        boolean isInputCorrect = false;
        while (!isInputCorrect) {
            while (!scanner.hasNextInt()) {
                System.out.println(LOCALIZATION_ERROR);
                System.out.println(LOCALIZATION_MENU);
                scanner.next();
            }
            int userChoice = scanner.nextInt();
            if (userChoice < 1 || userChoice > 2) {
                System.out.println(LOCALIZATION_ERROR);
                System.out.println(LOCALIZATION_MENU);
            } else {
                isInputCorrect = true;
                switch (userChoice) {
                    case 1:
                        System.out.println("Выбран русский язык.\nВас приветствует программа записи музыкальных дисков!");
                        localization = "ru";
                        break;
                    case 2:
                        System.out.println("You chose english language.\nWelcome to the disk creating programme!");
                        localization = "en";
                        break;
                }
            }
        }
        return localization;
    }
}