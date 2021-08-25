/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddemess.app.service;

import com.ddemess.app.model.Game;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author mawidemess
 */
public class ServiceLayer {
    public List<Game> hideAnswers(List<Game> listOfGames) {
        
        for(Game game: listOfGames){
            if(game.getStatus().equals("in progress"))
            {
                game.setAnswer("XXXX");
            }
        }
        return listOfGames;
    }
    
    public String generateAnswer(){
         Random rnd = new Random();
        int d1 = rnd.nextInt(10);

        int d2 = rnd.nextInt(10);
        while (d2 == d1) {
            d2 = rnd.nextInt(10);
        }

        int d3 = rnd.nextInt(10);
        while (d3 == d1 ||d3 == d2 ) {
            d3 = rnd.nextInt(10);
        }

        int d4 = rnd.nextInt(10);
        while (d4 == d1 || d4 == d2 || d4 == d3) {
            d4 = rnd.nextInt(10);
        }

        String answer = String.valueOf(d1) + String.valueOf(d2)
                + String.valueOf(d3) + String.valueOf(d4);
    
    return answer;
    }
    public Map<Character, Integer> userResult(String userGuess, int gameId, String userAns){
        int e=0;
        int p=0;
        Map<Character, Integer> outPutMap= new HashMap<>();
        Map<Character, Integer> guess= new HashMap<>();
        Map<Character, Integer> answer= new HashMap<>();
        
        //load answer and guess with index to map
        for(int i =0; i <userGuess.length(); i++ ){
            guess.put(userGuess.charAt(i),i);
            answer.put(userAns.charAt(i), i);
        }
        
      for(Map.Entry<Character,Integer> entry: guess.entrySet()){
          //check if at least they guessed digit
          if(answer.containsKey(entry.getKey())){
              //check if guess in correct spot
              if((entry.getValue()== answer.get(entry.getKey()))){
                  e=e+1;
              }
              else{
                  p=p+1;
              }
          }
          
      }
        
      outPutMap.put('e',e);
      outPutMap.put('p',p);
        
        return outPutMap;
    }

    
    
}
