/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddemess.vendingmachine.dto;

/**
 *
 * @author mawidemess
 */
public class VendingMachine {
    private String itemPrice;
    private String item;
    private int inventoryCout;
    
    public String getItem() {
        return item;
    }
    public void setItem(String item){
        this.item = item;
    }

    public String getItemPrice() {
        return itemPrice;
    }
    public int getInventoryCout(){
        return inventoryCout;
    }
    public void setInventoryCout (int inventoryCout){
        this.inventoryCout = inventoryCout;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }
   
    
}
