/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddemess.dvd_library.dao;

/**
 *
 * @author mawidemess
 */
public class DvdDaoException extends Exception{
    
    public DvdDaoException(String message) {
        super(message);
    }
    
    public DvdDaoException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
