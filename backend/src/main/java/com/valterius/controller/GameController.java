package com.valterius.controller;

import com.valterius.dao.GameDao;
import com.valterius.model.Game;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    private GameDao gameDao;

    public GameController(GameDao gameDao) {
        this.gameDao = gameDao;
    }

    //create
    @RequestMapping(path = "/{id}", method = RequestMethod.POST)
    public Game createGame(@Valid @RequestBody Game game){
        return gameDao.createGame(game);
    }

    //retrieve
    @RequestMapping(method = RequestMethod.GET)
    public List<Game> getAllGames() {
        return gameDao.getAllGames();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Game getGameById(@PathVariable int gameId){
        Game game = gameDao.getGameById(gameId);
        return game;
    }
    //update
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void updateGame(@Valid @RequestBody Game game){
        gameDao.updateGame(game);
    }

    //delete
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteGameById(@PathVariable int gameId){
        gameDao.deleteGameById(gameId);
    }

}
