/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddemess.vendingmachine.controller;

/**
 *
 * @author mawidemess
 */
import java.math.BigDecimal;

public class Change {
    
   private BigDecimal quarter, remQuarter, dime, remDime,nickle, remNickle, penny;
   
   
   public void coinChange(BigDecimal change){
       quarter= change.divide(Coin.QUARTER.getValue());
       remQuarter=change.remainder(Coin.QUARTER.getValue());
       
       if(remQuarter!=new BigDecimal(0)){
           dime=remQuarter.divide(Coin.DIME.getValue());
           remDime=remQuarter.remainder(Coin.DIME.getValue());
       }
       
       if(remDime != new BigDecimal(0)){
           nickle=remDime.divide(Coin.NICKLE.getValue());
           remNickle=remDime.remainder(Coin.NICKLE.getValue());
           
       }
       if(remNickle != new BigDecimal(0)){
           penny=remNickle;
       }
            
   }
   
    public BigDecimal getQuarter() {
        return quarter;
    }


    public BigDecimal getDime() {
        return dime;
    }

  
    public BigDecimal getNickle() {
        return nickle;
    }

 
    public BigDecimal getPenny() {
        return penny;
    }

 
    
    
    
}
