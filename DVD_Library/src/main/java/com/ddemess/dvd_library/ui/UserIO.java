/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddemess.dvd_library.ui;

/**
 *
 * @author mawidemess
 */
public interface UserIO {

    public int readInt(String prompt);

    public String readString(String prompt);

    public void print(String msg);

    public int readInt(String prompt, int min, int max);
}
