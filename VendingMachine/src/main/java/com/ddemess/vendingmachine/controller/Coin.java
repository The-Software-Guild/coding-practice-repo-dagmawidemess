/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddemess.vendingmachine.controller;

/**
 *
 * @author mawidemess
 */
import java.math.BigDecimal;

public enum Coin {
    PENNY(new BigDecimal(1)),
    NICKLE(new BigDecimal(5)),
    DIME(new BigDecimal(10)),
    QUARTER(new BigDecimal(25));

    private BigDecimal value;

    private Coin(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }
}
