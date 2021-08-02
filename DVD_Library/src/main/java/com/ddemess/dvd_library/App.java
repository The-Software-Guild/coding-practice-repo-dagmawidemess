/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddemess.dvd_library;

import com.ddemess.dvd_library.controller.DVD_Controll;
import com.ddemess.dvd_library.dao.DvdDao;
import com.ddemess.dvd_library.dao.DvdDaoException;
import com.ddemess.dvd_library.dao.DvdDaoFileImpl;
import com.ddemess.dvd_library.ui.DVD_libraryView;
import com.ddemess.dvd_library.ui.UserIO;
import com.ddemess.dvd_library.ui.UserIOConsoleImpl;

/**
 *
 * @author mawidemess
 */

public class App {

    public static void main(String[] args) throws DvdDaoException {
    UserIO myIo = new UserIOConsoleImpl();
    
    DVD_libraryView myView = new DVD_libraryView(myIo);
    DvdDao myDao = new DvdDaoFileImpl();
    DVD_Controll controller =
            new DVD_Controll(myDao, myView);
    controller.run();
}
}
