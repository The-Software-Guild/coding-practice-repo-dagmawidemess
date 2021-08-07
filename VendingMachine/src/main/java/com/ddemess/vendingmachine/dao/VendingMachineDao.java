/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddemess.vendingmachine.dao;

import com.ddemess.vendingmachine.dto.VendingMachine;
import java.io.FileNotFoundException;
import java.util.List;

/**
 *
 * @author mawidemess
 */
public interface VendingMachineDao {
     
     void updatePrice(String item);
     void updateInventory ( String item);
     String getPrice(String item);
     int getInventoryNum (String item);
    List<String>  getPostiveItems();
      void loadRoster() throws FileNotFoundException;
     int getCountOfItems ();
     List<VendingMachine> getAllItems();
     
    //for updating price value 
    //for updating invenotry items for each items
    //if inventory is 0 for everything, no more option  for user
}
