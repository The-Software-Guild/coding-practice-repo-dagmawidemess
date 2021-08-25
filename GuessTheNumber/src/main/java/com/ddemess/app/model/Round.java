/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddemess.app.model;

import java.util.Date;

/**
 *
 * @author Dagmawi Demess
 */
public class Round {
    
    private int roundId;
    private String guess;
    private String guessTime;
    private String result;
    private int gameId;
    

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getGuessTime() {
        return guessTime;
    }

    public void setGuessTime(String guessTime) {
        this.guessTime = guessTime;
    }

      public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getRoundId() {
        return roundId;
    }

    public void setRoundId(int roundId) {
        this.roundId = roundId;
    }

  
    
    
}

