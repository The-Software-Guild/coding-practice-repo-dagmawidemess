/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddemess.app.dao;

import com.ddemess.app.model.Game;
import com.ddemess.app.model.Round;
import java.util.List;

/**
 *
 * @author Dagmawi Demess
 */
public interface GameDao {

    public Round getRoundById(int roundId);


    Game add(Game game);

 

    List<Game> getAllGames();

    Game getGameById(int gameId);

    public List<Round> getAllRounds();

    Round saveRound(Round round, int gameId);

    public void updateGameFinished(int gameId);

    public List<Round> getRounds(int gameId);

}
