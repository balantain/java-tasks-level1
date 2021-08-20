package by.epam.main.controllers;

import by.epam.main.model.Genres;
import by.epam.main.menu.Menu;
import by.epam.main.model.Track;

import java.util.*;

public class PlaylistCreatorController {

    final static Integer DISK_LIMIT = 3600;
    static int usedDiskLength;
    static Integer freeTrackSetLength = DISK_LIMIT;

    public static ArrayList<Track> createPersonalPlaylist(Scanner scanner) {
        ArrayList<Track> songBase = new ArrayList<>(UserActionController.getSongBase());
        System.out.println(Menu.DISK_MAXIMUM_CAPACITY_MESSAGE + getTrackLengthAsString(DISK_LIMIT));
        ArrayList<Track> playlist = new ArrayList<>();
        playlist.add(addFirstTrack(scanner, songBase));
        while (freeTrackSetLength > 0) {
            System.out.println(Menu.DISK_MAXIMUM_CAPACITY_MESSAGE + getTrackLengthAsString(DISK_LIMIT));
            System.out.println(Menu.DISK_FREE_SPACE_MESSAGE + " " + getTrackLengthAsString(freeTrackSetLength));
            if (freeTrackSetLength.equals(DISK_LIMIT)){
                playlist.add(addFirstTrack(scanner, songBase));
            }
            else {
                playlist.add(addMoreTracks(scanner, songBase));
            }
        }
        ArrayList<Track> finalList = new ArrayList<>();
        for (Track track : playlist){
            if (track.getTrackLength() != null && track.getTrackLength() != 0){
                finalList.add(track);
            }
        }
        return finalList;
    }

    public static Track addFirstTrack (Scanner scanner, ArrayList<Track> songBase) {
        Track track = new Track();
        switch (UserActionController.getUserInputCorrectValue(scanner, Menu.ADD_FIRST_TRACK_MENU, 1, 4)) {
            case 1:
                track = createPersonalTrack(scanner);
                break;
            case 2:
                track = searchTrackByArtist(scanner, songBase);                                                                                                    // 2. Поиск по исполнителю
                break;
            case 3:
                track = searchTrackByGenre(scanner, songBase);
                break;
            case 4:
                track = searchByLength(scanner, songBase);
                break;
        }
        usedDiskLength += track.getTrackLength();
        freeTrackSetLength = DISK_LIMIT - usedDiskLength;
        return track;
    }

    public static Track addMoreTracks(Scanner scanner, ArrayList<Track> songBase){
        Track track = new Track();
        switch (UserActionController.getUserInputCorrectValue(scanner, Menu.ADD_MORE_TRACK_MENU, 1, 5)){
            case 1: track = createPersonalTrack(scanner);
                usedDiskLength += track.getTrackLength();
                freeTrackSetLength = DISK_LIMIT - usedDiskLength;
                    break;
            case 2:
                track = searchTrackByArtist(scanner, songBase);
                usedDiskLength += track.getTrackLength();
                freeTrackSetLength = DISK_LIMIT - usedDiskLength;
                break;
            case 3:
                track = searchTrackByGenre(scanner, songBase);
                usedDiskLength += track.getTrackLength();
                freeTrackSetLength = DISK_LIMIT - usedDiskLength;
                break;
            case 4:
                track = searchByLength(scanner, songBase);
                usedDiskLength += track.getTrackLength();
                freeTrackSetLength = DISK_LIMIT - usedDiskLength;
                break;
            case 5: freeTrackSetLength = 0;
                break;
        }
    return track;
    }

    public static ArrayList<Track> sortListByGenre(ArrayList<Track> arrayList){
        arrayList.sort(Comparator.comparing(Track::getGenre));
        return arrayList;
    }

    public static Track searchTrackByArtist(Scanner scanner, ArrayList<Track> songBase){
        TreeSet<String> artistsSet = new TreeSet<>();
        for (Track track : songBase){
            artistsSet.add(track.getArtistName());
        }
        ArrayList<String> artists = new ArrayList<>(artistsSet);
        StringBuilder artistList = new StringBuilder(Menu.ARTIST_NAME_LIST);
        for (String artist : artists){
            artistList.append("\n").append(artists.indexOf(artist) + 1).append(". ").append(artist);
        }
        String artistName = artists.get(UserActionController.getUserInputCorrectValue(scanner, artistList.toString(), 1, artistsSet.size()) - 1);
        ArrayList<Track> songList = new ArrayList<>();
        for (Track track : songBase){
            if (track.getArtistName().equals(artistName)){
                songList.add(track);
            }
        }
        StringBuilder trackList = new StringBuilder(Menu.TRACK_NAME_LIST);
        for (Track track : songList){
            trackList.append("\n").append(songList.indexOf(track) + 1).append(". ").append(track);
        }
        return songList.get(UserActionController.getUserInputCorrectValue(scanner, trackList.toString(), 1, songList.size()) - 1);
    }

    public static Track searchTrackByGenre (Scanner scanner, ArrayList<Track> songBase){
        ArrayList<Track> artistsListOfGenre = new ArrayList<>();
        String genre = "";
        switch (UserActionController.getUserInputCorrectValue(scanner, Menu.USER_ADD_GENRE_MENU, 1, 6)){
            case 1: genre = "ROCK"; break;
            case 2: genre = "POP"; break;
            case 3: genre = "RAP"; break;
            case 4: genre = "ELECTRONIC"; break;
            case 5: genre = "DANCE"; break;
            case 6: genre = "OTHER"; break;
        }
        for (Track track : songBase){
            if (track.getGenre().toString().equals(genre)){
                artistsListOfGenre.add(track);
            }
        }
        return searchTrackByArtist(scanner, artistsListOfGenre);
    }

    public static Track searchByLength (Scanner scanner, ArrayList<Track> songBase){
        ArrayList<Track> tracksWithLengthInDiapason = new ArrayList<>();
        boolean hasTracksInDiapason = false;
        while (!hasTracksInDiapason){
            System.out.println(Menu.DIAPASON_START_MESSAGE);
            scanner.nextLine();
            int diapasonStart = getCorrectTrackLength(scanner);
            System.out.println(Menu.DIAPASON_END_MESSAGE);
            int diapasonEnd = getCorrectTrackLength(scanner);
            if (diapasonEnd <= diapasonStart){
                hasTracksInDiapason = false;
            }
            else {
                for (Track track : songBase){
                    if (track.getTrackLength() > diapasonStart && track.getTrackLength() < diapasonEnd){
                        tracksWithLengthInDiapason.add(track);
                    }
                }
                if (tracksWithLengthInDiapason.size() == 0){
                    System.out.println(Menu.NO_TRACKS_FOUND);
                    hasTracksInDiapason = false;
                }
                else {
                    hasTracksInDiapason = true;
                }
            }
        }
        return searchTrackByArtist(scanner, tracksWithLengthInDiapason);
    }

    public static int getCorrectTrackLength(Scanner scanner){
        int minutes;
        int seconds = 0;
        int trackLength = 0;
        boolean isInputCorrect = false;
        while (!isInputCorrect){
            String[] userInputTrackLength = scanner.nextLine().split(":");
            while (userInputTrackLength.length != 2){
                System.out.println(Menu.WRONG_INPUT_ERROR);
                userInputTrackLength = scanner.nextLine().split(":");
            }
            try {
                minutes = Integer.parseInt(userInputTrackLength[0].trim());
                seconds = Integer.parseInt(userInputTrackLength[1].trim());
                trackLength = minutes * 60 + seconds;
                isInputCorrect = true;
            } catch (Exception e){
                System.out.println(Menu.WRONG_INPUT_ERROR);
                isInputCorrect = false;
            }
            if (seconds > 59) {
                System.out.println(Menu.WRONG_INPUT_SECONDS);
                seconds = 0;
                isInputCorrect = false;
            }
            else if (trackLength < 0){
                System.out.println(Menu.WRONG_INPUT_ERROR);
                isInputCorrect = false;
            }
        }
        return trackLength;
    }

    public static Track createPersonalTrack(Scanner scanner){
        Track track = new Track();
        scanner.nextLine();
        System.out.println(Menu.USER_ADD_ARTIST_NAME);
        track.setArtistName(scanner.nextLine().trim());
        System.out.println(Menu.USER_ADD_TRACK_NAME);
        track.setTrackName(scanner.nextLine().trim());
        switch (UserActionController.getUserInputCorrectValue(scanner, Menu.USER_ADD_GENRE_MENU, 1, 6)){
            case 1: track.setGenre(Genres.ROCK);
                break;
            case 2: track.setGenre(Genres.POP);
                break;
            case 3: track.setGenre(Genres.RAP);
                break;
            case 4: track.setGenre(Genres.ELECTRONIC);
                break;
            case 5: track.setGenre(Genres.DANCE);
                break;
            case 6: track.setGenre(Genres.OTHER);
                break;
        }
        scanner.nextLine();
        System.out.println(Menu.USER_ADD_TRACK_LENGTH);
        boolean isInputCorrect = false;
        int trackLength = 0;
        while (!isInputCorrect) {
            trackLength = getCorrectTrackLength(scanner);
            if (trackLength > freeTrackSetLength) {
                switch (UserActionController.getUserInputCorrectValue(scanner, Menu.DISK_LIMIT_EXCEPTION_MENU, 1, 3)) {
                    case 1:
                        trackLength = freeTrackSetLength;
                        isInputCorrect = true;
                        break;
                    case 2:
                        System.out.println(Menu.USER_ADD_TRACK_LENGTH);
                        trackLength = 0;
                        isInputCorrect = false;
                        scanner.nextLine();
                        break;
                    case 3:
                        trackLength = 0;
                        isInputCorrect = true;
                }
            }
            else isInputCorrect = true;
        }
        track.setTrackLength(trackLength);
        if (trackLength != 0){
            System.out.println(Menu.USER_TRACK_CREATION_CHECK + "\n" + track);
        }
        return track;
    }

    public static ArrayList<Track> createPlaylistByMood (Scanner scanner){
        ArrayList<Track> songBase = new ArrayList<>(UserActionController.getSongBase());
        String mood = "";
        switch (UserActionController.getUserInputCorrectValue(scanner, Menu.MOOD_PLAYLIST_CREATING_MENU, 1, 3)){
            case 1: mood = "calm"; break;
            case 2: mood = "energetic"; break;
            case 3 : mood = "aggressive"; break;
        }
        ArrayList<Track> songBaseByMood = new ArrayList<>();
        for (Track track : songBase){
            if (track.getMood().equals(mood)){
                songBaseByMood.add(track);
            }
        }
        HashSet<Track> trackSet = new HashSet<>();
        int trackSetLength = 0;
        while (trackSetLength < DISK_LIMIT){
            freeTrackSetLength = DISK_LIMIT - trackSetLength;
            trackSetLength = 0;
            Track track = songBaseByMood.get((int)(Math.random()*songBaseByMood.size()));
            if (track.getTrackLength() < freeTrackSetLength){
                trackSet.add(track);
            }
            else {
                break;
            }
            for (Track song : trackSet){
                trackSetLength += song.getTrackLength();
            }
        }
        return new ArrayList<>(trackSet);
    }

    public static String getTrackLengthAsString(Integer integer){
        int minutes = integer/60;
        String minutesAsString = Integer.toString(minutes);
        int seconds = integer%60;
        String secondsAsString = Integer.toString(seconds);
        if(minutesAsString.length() == 1){
            minutesAsString = "0".concat(minutesAsString);
        }
        if(secondsAsString.length() == 1){
            secondsAsString = "0".concat(secondsAsString);
        }
        return minutesAsString + " " + Menu.MINUTES + " : " + secondsAsString + " " + Menu.SECONDS;
    }
}