/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddemess.vendingmachine;

import com.ddemess.vendingmachine.controller.VendingMachineControll;
import java.io.FileNotFoundException;

/**
 *
 * @author mawidemess
 */
public class VendingMachineMain {
    public static void main(String[] args) throws FileNotFoundException {
        VendingMachineControll controller = new VendingMachineControll();
        controller.run();
    }
    
}
