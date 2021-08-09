/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddemess.vendingmachine.service;

import com.ddemess.vendingmachine.dao.VendingMachineAuditDao;
import com.ddemess.vendingmachine.dao.VendingMachineDao;
import java.math.BigDecimal;

/**
 *
 * @author mawidemess
 */
public class VendingMachineServiceLayerImpl implements  VendingMachineServiceLayer{
    VendingMachineDao dao;

    public VendingMachineServiceLayerImpl(VendingMachineDao dao) {
      this.dao=dao;
    }


    @Override
    public boolean validateAmount(BigDecimal val,String bal) {
        boolean ans = dao.sufficentBalnce(val,bal);
        return ans;
    }
    
}
