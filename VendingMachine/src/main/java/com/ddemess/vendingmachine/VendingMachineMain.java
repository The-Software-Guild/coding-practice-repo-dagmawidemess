/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddemess.vendingmachine;

import com.ddemess.vendingmachine.controller.VendingMachineControll;
import com.ddemess.vendingmachine.dao.VendingMachineDao;
import com.ddemess.vendingmachine.dao.VendingMachineDaoException;
import com.ddemess.vendingmachine.dao.VendingMachineDaoImpl;
import com.ddemess.vendingmachine.service.VendingMachineServiceLayer;
import com.ddemess.vendingmachine.service.VendingMachineServiceLayerImpl;
import com.ddemess.vendingmachine.ui.UserIO;
import com.ddemess.vendingmachine.ui.UserIOConsoleImpl;
import com.ddemess.vendingmachine.ui.VendingMachineView;
import java.io.FileNotFoundException;

/**
 *
 * @author mawidemess
 */
public class VendingMachineMain {
    public static void main(String[] args) throws FileNotFoundException, VendingMachineDaoException {
        VendingMachineDao dao = new VendingMachineDaoImpl();
        VendingMachineView view= new VendingMachineView();
        UserIO myIo = new UserIOConsoleImpl();
          VendingMachineServiceLayer service = new VendingMachineServiceLayerImpl(dao);
        VendingMachineControll controller= new VendingMachineControll(service,view,dao,myIo);
        controller.run();
    }
    
}
