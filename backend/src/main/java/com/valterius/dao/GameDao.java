package com.valterius.dao;

import com.valterius.model.*;

import java.util.List;

public interface GameDao {
    //interface has no instance variables

    //basic CRUD methods to be implemented by JDBC Game DAO

    //Create
    public Game createGame(Game game);

    //Retrieve
    public List<Game> getAllGames();
    public Game getGameById(int gameId);

    ///TODO - More complex search functionality after MVP is finished
    public List<Game> getGamesByName(String name);
    public Game getGameBySourceUrl(String sourceUrl);
    public List<Game> getGamesByPublisherId(List<Publisher> publisherList);
    public List<Game> getGamesByMechanicId(List<Mechanic> mechanicList);

    public List<Game> getGamesByGenre(List<Genre> genreLst);
    public List<Game> getGamesByKeyword(List<Keyword> keywordList);

    //Update
    public Game updateGame(Game game, int gameId);

    //Delete
    public void deleteGameById(int gameId);
}
