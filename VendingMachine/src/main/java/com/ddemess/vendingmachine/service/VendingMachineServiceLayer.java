/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddemess.vendingmachine.service;

import java.math.BigDecimal;

/**
 *
 * @author mawidemess
 */
public interface VendingMachineServiceLayer {
     public boolean validateAmount(BigDecimal val,String bal);
}
