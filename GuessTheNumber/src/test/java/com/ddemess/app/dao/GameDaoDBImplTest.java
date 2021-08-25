/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddemess.app.dao;

import com.ddemess.app.TestMain;
import com.ddemess.app.model.Game;
import com.ddemess.app.model.Round;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Dagmawi Demess
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestMain.class)
public class GameDaoDBImplTest {

    @Autowired
    GameDao gameDao;

    public GameDaoDBImplTest() {
    }

    @BeforeAll
    public static void setUpClass() {

    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        List<Round> rounds = gameDao.getAllRounds();
        for (Round round : rounds) {
            gameDao.deleteRoundById(round.getRoundId());
        }

        List<Game> games = gameDao.getAllGames();
        for (Game game : games) {
            gameDao.deleteGameById(game.getId());
        }

    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAddGetGame() {
        Game game = new Game();
        game.setAnswer("3876");
        game.setStatus("in progress");
        game = gameDao.add(game);
        Game newGame = gameDao.getGameById(game.getId());
        assertEquals(game, newGame);
    }

    @Test
    public void testDeleteGame() {
        Game game = new Game();
        game.setAnswer("3456");
        game.setStatus("in progress");
        game = gameDao.add(game);
        gameDao.deleteGameById(game.getId());

        assertEquals(game, game);
    }

    @Test
    public void testGetAllGames() {
        Game game = new Game();
        game.setAnswer("3456");
        game.setStatus("in progress");
        game = gameDao.add(game);
        Game game2 = new Game();
        game2.setAnswer("2134");
        game2.setStatus("Finished");
        game2 = gameDao.add(game2);
        Game game3 = new Game();
        game3.setAnswer("2155");
        game3.setStatus("in progress");
        game3 = gameDao.add(game3);
        List<Game> games = gameDao.getAllGames();
        assertTrue(games.contains(game));
        assertTrue(games.contains(game2));
        assertTrue(games.contains(game3));
    }

    @Test
    public void testGetAllRounds() {
        Game game = new Game();
        game.setAnswer("3456");
        game.setStatus("in progress");
        game = gameDao.add(game);
        Round round1 = new Round();
        round1.setGuess("3456");
        round1.setResult("e:0:p:3");
        round1.setGameId(game.getId());
        gameDao.saveRound(round1, game.getId());
        Game game2 = new Game();
        game2.setAnswer("9876");
        game2.setStatus("Finished");
        game2 = gameDao.add(game2);
        Round round2 = new Round();
        round2.setGuess("8796");
        round2.setResult("e:0:p:4");
        round2.setGameId(game2.getId());
        gameDao.saveRound(round2, game2.getId());
        List<Round> rounds = gameDao.getAllRounds();
        assertEquals(2, rounds.size());
    }

}
