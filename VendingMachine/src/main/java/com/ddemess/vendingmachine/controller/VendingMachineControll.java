/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddemess.vendingmachine.controller;

import com.ddemess.vendingmachine.dao.NoItemInventoryException;
import com.ddemess.vendingmachine.dao.VendingMachineDao;
import com.ddemess.vendingmachine.dao.VendingMachineDaoException;
import com.ddemess.vendingmachine.dto.VendingMachine;
import com.ddemess.vendingmachine.service.VendingMachineServiceLayer;
import com.ddemess.vendingmachine.ui.UserIO;
import com.ddemess.vendingmachine.ui.VendingMachineView;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mawidemess
 */
public class VendingMachineControll {

    VendingMachineView view;
    VendingMachineServiceLayer service;
    VendingMachineDao dao;
    UserIO io;

    public VendingMachineControll(VendingMachineServiceLayer service, VendingMachineView view, VendingMachineDao dao, UserIO io) {
        this.service = service;
        this.view = view;
        this.dao = dao;
        this.io = io;
    }

    private void getMenuSelection() throws VendingMachineDaoException {
        view.printMenuAndGetSelection();
        List<VendingMachine> x = dao.getAllItems();
        for (VendingMachine temp : x) {
            if (temp.getInventoryCout() > 0) {
                io.print(temp.getItem() + ": $" + temp.getItemPrice());
            }
        }
        
        String exs = io.readString("Please Enter to start buying food or enter 'e' to exit");
        
        if (exs.equals("e")) {
            io.print("Good bye!!");
            writeTofile();
            System.exit(0);
        }
    }

    private void displayChange(BigDecimal bc) {
        Change change = new Change();
        change.coinChange(bc.multiply(new BigDecimal(100)));//takes in consideration only the first two decimal place user input
        io.print("Here is your change in coins : ");
        
        int x = change.getQuarter().intValue();
        if (x > 0) {
            if (x == 1) {
                io.print(x + " Quarter");
            } else {
                io.print(x + " Quarters");
            }
        }
        int y = change.getDime().intValue();
        if (y > 0) {
            if (y == 1) {
                io.print(y + " Dime");
            } else {
                io.print(y + " Dimes");
            }
        }
        int z = change.getNickle().intValue();
        if (z > 0) {
            if (z == 1) {
                io.print(z + " Nickel");
            } else {
                io.print(z + " Nickels");
            }
        }
        int m = change.getPenny().intValue();
        if (m > 0) {
            if (m == 1) {
                io.print(m + " Penny");
            } else {
                io.print(m + " Pennies");
            }

        }
    }

    private void writeTofile() throws VendingMachineDaoException {
        List<VendingMachine> list = new ArrayList<VendingMachine>();
        list = dao.getAllItems();
        dao.writeRoster(list);
    }

    public void run() throws FileNotFoundException, VendingMachineDaoException {
        boolean keepGoing = true;
        dao.loadRoster();
        while (keepGoing) {
            getMenuSelection();
            String balance = view.getUserBlance();
            String food = io.readString("Please input the food name you want to purchase");
            String foodPrice = dao.getPrice(food);
            if (foodPrice == null || foodPrice.isEmpty()) {
                dao.noInventory();
            } else {
                BigDecimal balance1 = new BigDecimal(balance);
                BigDecimal foodPrice1 = new BigDecimal(foodPrice);
                BigDecimal rem = balance1.subtract(foodPrice1);
                if (service.validateAmount(rem,balance) == false) {
                    io.print("Take your money back and come back again!\n");

                } else {

                    dao.updateInventory(food);
                    displayChange(rem);
                    String userOption = view.exitOrContinue();
                    if (userOption.equals("exit")) {
                        keepGoing = false;
                        writeTofile();
                        io.print("Good bye!!");
                    }
                }
            }
        }
    }

}
