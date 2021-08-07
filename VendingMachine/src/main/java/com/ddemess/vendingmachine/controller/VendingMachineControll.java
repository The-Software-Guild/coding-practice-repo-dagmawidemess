/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddemess.vendingmachine.controller;

import com.ddemess.vendingmachine.dao.VendingMachineDao;
import com.ddemess.vendingmachine.dao.VendingMachineDaoImpl;
import com.ddemess.vendingmachine.dto.VendingMachine;
import com.ddemess.vendingmachine.ui.UserIO;
import com.ddemess.vendingmachine.ui.UserIOConsoleImpl;
import com.ddemess.vendingmachine.ui.VendingMachineView;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author mawidemess
 */
public class VendingMachineControll {

    private VendingMachineView view = new VendingMachineView();
    private VendingMachineDao dao = new VendingMachineDaoImpl();
    private UserIO io = new UserIOConsoleImpl();

    private void getMenuSelection() {
        view.printMenuAndGetSelection();
       List<VendingMachine> x = dao.getAllItems();
        for (VendingMachine temp : x) {
            if(temp.getInventoryCout()>0){
                io.print(temp.getItem());
            }
        }
    }

    public void run() throws FileNotFoundException {
        boolean keepGoing = true;
        int menuSelection = 0;
        dao.loadRoster();
        while (keepGoing) {

            getMenuSelection();
            String balance = view.getUserBlance();
            String food = io.readString("Please input the food name you want to purchase");
            int inventoryCout = dao.getInventoryNum(food);
            String val = String.valueOf(inventoryCout);
            io.print("INVENTOR" + val);

            String foodPrice = dao.getPrice(food);
            BigDecimal balance1 = new BigDecimal(balance);
            BigDecimal foodPrice1 = new BigDecimal(foodPrice);
            int res = balance1.compareTo(foodPrice1);
            if (res == 0) {
                io.print("equal");
            } else if (res == 1) {
                io.print("balance big");
            } else {
                io.print("foddPrice big");
            }
            BigDecimal rem = balance1.subtract(foodPrice1);
            //if food price > balance  -> print"insufficent balance"
            dao.updateInventory(food);
            int inventoryCou = dao.getInventoryNum(food);
            String va  = String.valueOf(inventoryCou);
            io.print("INVENTOR AFTER" + va);
            io.print("your remaning balnce is balance - foodPrice" + rem);
            String userOption = view.exitOrContinue();
            if (userOption.equals("exit")) {
                keepGoing = false;
                io.print("Good bye!!");
            }

        }

    }

}
