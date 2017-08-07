package io.github.gitwebx.hubiitism;

/**
 * Created by Abhinav on 22-01-2017.
 */

public class Contact {
    private String name;
    private String numOfSongs;
    private int thumbnail;

    public Contact(String name, String numOfSongs, int thumbnail) {
        this.name = name;
        this.numOfSongs = numOfSongs;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumOfSongs() {
        return numOfSongs;
    }

    public int getThumbnail() {
        return thumbnail;
    }
}
