/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddemess.app.controller;

import com.ddemess.app.dao.GameDao;
import com.ddemess.app.model.Game;
import com.ddemess.app.model.Round;
import com.ddemess.app.service.ServiceLayer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.text.SimpleDateFormat;

/**
 *
 * @author Dagmawi Demess
 */
@RestController
@RequestMapping("/api")
public class GameController {

    private final GameDao dao;
    ServiceLayer service = new ServiceLayer();

    public GameController(GameDao dao) {
        this.dao = dao;
    }

    @PostMapping("/start")
    @ResponseStatus(HttpStatus.CREATED)
    public int start() {
        Game game = new Game();
        game.setAnswer(service.generateAnswer());
        game.setStatus("in progress");
        return dao.add(game).getId();
    }

    @PostMapping("/guess/{gameId}")
    public Round guess(@RequestBody Round rounds, @PathVariable int gameId) {

        Map<Character, Integer> guessResult = new HashMap<>();

        guessResult = service.userResult(rounds.getGuess(), gameId, dao.getGameById(gameId).getAnswer());
        String guessRes = "e:" + guessResult.get('e') + ":" + "p:" + guessResult.get('p');
        rounds.setResult(guessRes);
        // reveal the answer when finished
        if (guessResult.get('e') == 4) {
            dao.updateGameFinished(gameId);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        rounds.setGuessTime(formatter.format(date));
        return dao.saveRound(rounds, gameId);
    }

    @GetMapping("/game/{gameId}")
    public Game getGame(@PathVariable int gameId) {
        Game game = new Game();
        game = dao.getGameById(gameId);
        if (game.getStatus().equals("in progress")) {
            game.setAnswer("XXXX");
        }

        return game;

    }

    @GetMapping
    @RequestMapping("/game")
    public List<Game> allGames() {
        List<Game> allGames = dao.getAllGames();
        allGames = service.hideAnswers(allGames);
        return allGames;
    }

    @GetMapping("round/{gameId}")
    public List<Round> getRounds(@PathVariable int gameId) {
        return dao.getRounds(gameId);
    }

}
