/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddemess.vendingmachine.ui;

import com.ddemess.vendingmachine.dao.VendingMachineDao;
import com.ddemess.vendingmachine.dao.VendingMachineDaoImpl;

/**
 *
 * @author mawidemess
 */
public class VendingMachineView {

    public VendingMachineDao dao = new VendingMachineDaoImpl();
    public UserIO io = new UserIOConsoleImpl();

    public void displayErrorMessage(String errorMsg) {
        io.print("ERROR: The food you want " + errorMsg + " doesn't exist!\n");

    }

    public void printMenuAndGetSelection() {
        io.print("Welcome to mthree Vending Machine, here are the list of foods avaliable: ");

    }

    public String getUserBlance() {
        String amount = io.readString("Enter the amount of money you want to use:");
        return amount;
    }

    public String exitOrContinue() {
        String option = io.readString("Please enter exit or Press Enter to continue:");
        return option;

    }
}
