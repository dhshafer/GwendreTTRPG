package com.valterius.dao;

import com.valterius.model.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class JdbcGameDao implements GameDao{
    //Create new class variable of JDBCTemplate
    private final JdbcTemplate jdbcTemplate;

    //Pass datasource into class constructor, instantiating the JDBC Template with the datasource
    public JdbcGameDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //All sql query methods to be used by the controller
    // ************ Basic CRUD **************
    @Override
    public Game createGame(Game game) {
        return null;
    }

    @Override
    public List<Game> getAllGames() {
        return null;
    }

    @Override
    public Game getGameById(int gameId) {
        return null;
    }

    // *********** TO-DO after MVP ***************
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
    public void updateGame(int gameId) {

    }

    @Override
    public void deleteGameWithGameId(int gameId) {

    }

    // Reusable mapper method
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
