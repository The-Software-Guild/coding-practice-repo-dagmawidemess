/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddemess.vendingmachine.dao;

import com.ddemess.vendingmachine.dto.VendingMachine;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author mawidemess
 */
public interface VendingMachineDao {

    boolean sufficentBalnce(BigDecimal val, String bal);

    void updateInventory(String item);

    String getPrice(String item);

    int getInventoryNum(String item);

    List<String> getPostiveItems();

    void loadRoster() throws VendingMachineDaoException;

    void writeRoster(List<VendingMachine> val) throws VendingMachineDaoException;

    List<VendingMachine> getAllItems();
    public void  noInventory();
}
