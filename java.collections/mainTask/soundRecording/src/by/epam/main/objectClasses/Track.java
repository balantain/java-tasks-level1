package by.epam.main.objectClasses;

import by.epam.main.actionClasses.PlaylistCreator;
import by.epam.main.enums.Genres;

public class Track {
    private String region;
    private String trackName;
    private String artistName;
    private Integer trackLength;
    private Genres genre;
    private String mood;

    public Track() {
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public Integer getTrackLength() {
        return trackLength;
    }

    public void setTrackLength(Integer trackLength){ // минуты + секунды
        this.trackLength = trackLength;
    }

    public Genres getGenre() {
        return genre;
    }

    public void setGenre(Genres genre) {
        this.genre = genre;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    @Override
    public String toString() {
        return artistName + " - " + "\"" + trackName + "\"" + " (" +
                "genre: " + genre + ", " + "length: " +
                PlaylistCreator.getTrackLengthAsString(trackLength) + ")";
    }
}
