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
    @Override
        public void loadRoster() throws FileNotFoundException  {
        Scanner scanner;

            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader("dagmawi.txt")));
        
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentStudent holds the most recent student unmarshalled
        VendingMachine currentDvd;
        // Go through ROSTER_FILE line by line, decoding each line into a 
        // Student object by calling the unmarshallStudent method.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a Student
            currentDvd = unmarshallStudent(currentLine);

            // We are going to use the student id as the map key for our student object.
            // Put currentStudent into the map using student id as the key
            item.put(currentDvd.getItem(), currentDvd);
        }
        
        // close scanner
        scanner.close();
    }
 private String marshallDvd(VendingMachine aDvd) {
        // 4321::Charles::Babbage::Java-September1842
        String studentAsText = aDvd.getItem()+ DELIMITER;
        studentAsText += aDvd.getItemPrice()+ ":";
       
        studentAsText += String.valueOf(aDvd.getInventoryCout());
        // Turn  a dvd to text! Return it!
        return studentAsText;
    }
  private VendingMachine unmarshallStudent(String studentAsText) {
        // We then split that line on our DELIMITER - which we are using as ::
        // Leaving us with an array of Strings, stored in studentTokens.
        // Which should look like this:
     
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
  public List<String> getPostiveItems(){
        try {
            loadRoster();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VendingMachineDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       List <VendingMachine> vals=  new ArrayList<VendingMachine>();
       for(VendingMachine x: item.values()){
           vals.add(x);
      
  }
              // item.values(); 
      List<String> ans = new ArrayList<String>();
      for(VendingMachine temp : vals){
             if (temp.getInventoryCout() > 0){
              ans.add(temp.getItem());
             }
      }
        
      return ans;
  }
    @Override
    public void updatePrice(String items) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public int getCountOfItems (){
        //NEED TO WORK ON
        return 1;
    }
    @Override
    public void updateInventory(String items) {
        item.get(items).setInventoryCout(item.get(items).getInventoryCout()-1);
        //price.setInventoryCout(price.getInventoryCout()-1);
    }

    @Override
    public String getPrice(String items) {
        VendingMachine price= item.get(items);
        return price.getItemPrice();
    }

    @Override
    public int getInventoryNum(String items) {
        VendingMachine  val= item.get(items);
        return val.getInventoryCout();
    }
    @Override
    public List<VendingMachine> getAllItems(){
        return new ArrayList(item.values());
    }
    
}
