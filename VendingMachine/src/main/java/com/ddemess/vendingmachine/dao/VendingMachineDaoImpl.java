/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddemess.vendingmachine.dao;

import com.ddemess.vendingmachine.dto.VendingMachine;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mawidemess
 */
public class VendingMachineDaoImpl implements VendingMachineDao {

    private Map<String, VendingMachine> item = new HashMap<>();
    public static final String DELIMITER = "::";
    public static final String ROSTER_FILE = "dagmawi.txt";
    VendingMachineAuditDao auditDao = new VendingMachineAuditDaoImpl();

    @Override
    public void writeRoster(List<VendingMachine> val) throws VendingMachineDaoException {
        PrintWriter out = null;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException ex) {
            throw new VendingMachineDaoException(
                    "Could not save student data.", ex);
        }

        String vendingText = "";

        for (VendingMachine vendTex : val) {
            // turn a Student into a String
            vendingText = marshallDvd(vendTex);
            // write the Student object to the file
            out.println(vendingText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }

    @Override
    public void loadRoster() throws VendingMachineDaoException {
        Scanner scanner = null;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException ex) {
            throw new VendingMachineDaoException("couldn't", ex);
        }

        String currentLine;
        VendingMachine currentDvd;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentDvd = unmarshallStudent(currentLine);
            item.put(currentDvd.getItem(), currentDvd);
        }

        auditDao.writeAuditEntry("Loaded File");
        scanner.close();
    }

    private String marshallDvd(VendingMachine aDvd) {
        String studentAsText = aDvd.getItem() + DELIMITER;
        studentAsText += aDvd.getItemPrice() + ":";
        studentAsText += String.valueOf(aDvd.getInventoryCout());

        return studentAsText;
    }

    private VendingMachine unmarshallStudent(String studentAsText) {
        String[] dvdTokens = studentAsText.split(DELIMITER);
        String[] priceInventory = dvdTokens[1].split(":");
        VendingMachine newDvds = new VendingMachine();
        // Given the pattern above, the student Id is in index 0 of the array.
        newDvds.setItem(dvdTokens[0]);
        newDvds.setItemPrice(priceInventory[0]);
        newDvds.setInventoryCout((Integer.parseInt(priceInventory[1])));

        // We have now created a student! Return it!
        return newDvds;
    }

    @Override
    public List<String> getPostiveItems() {
        try {
            loadRoster();
        } catch (VendingMachineDaoException ex) {
            Logger.getLogger(VendingMachineDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<VendingMachine> vals = new ArrayList<VendingMachine>();
        /*for(VendingMachine x: item.values()){
           vals.add(x);
      
  }*/
        item.values().forEach(x -> {
            vals.add(x);
        });

        List<String> ans = new ArrayList<String>();
        for (VendingMachine temp : vals) {
            if (temp.getInventoryCout() > 0) {
                ans.add(temp.getItem());
            }
        }

        return ans;
    }


    @Override
    public void updateInventory(String items) {
        item.get(items).setInventoryCout(item.get(items).getInventoryCout() - 1);
    }

    @Override
    public String getPrice(String items) {
        if ((item.containsKey(items))) {
            VendingMachine price = item.get(items);
            return price.getItemPrice();
        }
        return null;
    }

    @Override
    public int getInventoryNum(String items) {
        VendingMachine val = item.get(items);
        return val.getInventoryCout();
    }

    @Override
    public List<VendingMachine> getAllItems() {
        return new ArrayList(item.values());
    }

    @Override
    public boolean sufficentBalnce(BigDecimal val,String bal) {
        try{
         if(val.compareTo(BigDecimal.ZERO) < 0){
             throw new InsufficientFundsException("\nThe amount you entered $" + bal + " is insufficient!" );
         }
         else{
             return true;
         }
         
        }
        catch(InsufficientFundsException e){
          System.out.println(e.toString());
        }
        return false;
    }
    @Override
    public void  noInventory() {
        
        try{
         
            throw new NoItemInventoryException("\nThere is no such item in the Vending Machine !\n" );
         
         
         
        }
        catch(NoItemInventoryException e){
          System.out.println(e.toString());
        }
    }

}
