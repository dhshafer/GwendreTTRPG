package com.valterius.dao;

import com.valterius.model.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcGameDao implements GameDao{
    //Create new class variable of JDBCTemplate
    private final JdbcTemplate jdbcTemplate;

//    //Passed datasource into class constructor, instantiating the JDBC Template with the datasource
//    public JdbcGameDao(DataSource dataSource) {
//        this.jdbcTemplate = new JdbcTemplate(dataSource);
//    }
    //No need to pass in datasource since spring automatically checks application.properties file for datasource
    public JdbcGameDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = new JdbcTemplate();
    }

    //All sql query methods to be used by the controller
    // ************ Basic CRUD **************
    @Override
    public Game createGame(Game game) {
        String sql = "INSERT INTO game (name, source_url, publisher_id, mechanic_id) VALUES (?, ?, ?, ?) RETURNING game_id;";
        int gameId = jdbcTemplate.update(sql, Integer.class, game.getName(), game.getSourceUrl(), game.getPublisherId(), game.getMechanicId());
        //Use existing getGameById method
        return getGameById(gameId);
    }

    @Override
    public List<Game> getAllGames() {
        List<Game> allGames = new ArrayList<>();
        String sql = "SELECT * FROM game;";
        SqlRowSet sqlResults = jdbcTemplate.queryForRowSet(sql);
        while (sqlResults.next()){
            allGames.add(mapSqlRowToGame(sqlResults));
        }
        return allGames;
    }

    @Override
    public Game getGameById(int gameId) {
        Game game = new Game();
        String sql = "SELECT * FROM game WHERE game_id = ?;";
        SqlRowSet sqlResult = jdbcTemplate.queryForRowSet(sql, gameId);
        if (sqlResult.next()){
            game = mapSqlRowToGame(sqlResult);
        }
        return game;
    }

    //TODO - Implement after MVP ***************
    @Override
    public List<Game> getGamesByName(String name) {
        return null;
    }

    @Override
    public Game getGameBySourceUrl(String sourceUrl) {
        return null;
    }

    @Override
    public List<Game> getGamesByPublisherId(List<Publisher> publisherList) {
        return null;
    }

    @Override
    public List<Game> getGamesByMechanicId(List<Mechanic> mechanicList) {
        return null;
    }

    @Override
    public List<Game> getGamesByGenre(List<Genre> genreLst) {
        return null;
    }

    @Override
    public List<Game> getGamesByKeyword(List<Keyword> keywordList) {
        return null;
    }

    // *************** Basic CRUD ******************
    @Override
    public void updateGame(Game game) {
        String sql = "UPDATE game SET name = ?, source_url = ?, publisher_id = ?, mechanic_id = ? WHERE game_id = ?";
        jdbcTemplate.update(sql, game.getName(), game.getSourceUrl(), game.getPublisherId(), game.getMechanicId(), game.getGameId());
    }

    @Override
    public void deleteGameById(int gameId) {
        //I thought about creating JDBC DAO for keyword and genre here, then using their methods...
        //Not sure if this is going to work

        //Delete any associated keywords
        String sqlKeywords = "DELETE FROM game_keyword WHERE game_id = ?;";
        //Delete any associated genres
        String sqlGenre = "DELETE FROM game_genre WHERE game_id = ?;";
        //Finally, delete the game
        String sqlGame = "DELETE FROM game WHERE game_id = ?;";
        jdbcTemplate.update(sqlKeywords + sqlGenre + sqlGame, gameId);
    }

    // Reusable method that maps sql results to model
    private Game mapSqlRowToGame(SqlRowSet results){
        Game game = new Game();
        game.setGameId(results.getInt("id"));
        game.setName(results.getString("name"));
        game.setSourceUrl(results.getString("source_url"));
        game.setPublisherId(results.getInt("publisher_id"));
        game.setMechanicId(results.getInt("mechanic_id"));
        return game;
    }
}
