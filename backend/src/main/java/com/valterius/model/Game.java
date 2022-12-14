package com.valterius.model;

public class Game {
    //PK
    private int gameId;
    private String name;
    private String sourceUrl;
    //FK - must be hydrated when creating a new game on database
    private int publisherId;
    //FK - must be hydrated when creating a new game on database
    private int mechanicId;

    //Default constructor

    //Getters and Setters for all
    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

//    public int getGenreId() {
//        return genreId;
//    }
//
//    public void setGenreId(int genreId) {
//        this.genreId = genreId;
//    }

    public int getMechanicId() {
        return mechanicId;
    }

    public void setMechanicId(int mechanicId) {
        this.mechanicId = mechanicId;
    }
}
