package com.valterius.model;

public class genre {
    // PK
    private int genreId;
    private String genre;

    //default constructor

    //getters and setters
    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
