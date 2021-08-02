/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddemess.dvd_library.dao;

import com.ddemess.dvd_library.dto.DVD;
import java.util.List;

/**
 *
 * @author mawidemess
 */
public interface DvdDao {

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */

    /**
     *
     * @author mawidemess
     */
    /**
     * Adds the given Student to the roster and associates it with the given
     * student id. If there is already a student associated with the given
     * student id it will return that student object, otherwise it will return
     * null.
     *
     * @param studentId id with which student is to be associated
     * @param student student to be added to the roster
     * @return the Student object previously associated with the given student
     * id if it exists, null otherwise
     */
    DVD addDvd(String dvdTitle, DVD dvd);

    DVD getDvd(String dvdTitle);

    List<String> getAllDvd(); // get all dvd title in key

    void removeDvd(String dvdTitle);

    void editDvd(DVD newD, int val, String editTo);

}
