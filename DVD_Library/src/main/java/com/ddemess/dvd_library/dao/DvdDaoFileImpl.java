/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddemess.dvd_library.dao;

import com.ddemess.dvd_library.dto.DVD;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mawidemess
 */
public class DvdDaoFileImpl implements DvdDao {
    public static final String ROSTER_FILE = "roster.txt";
    public static final String DELIMITER = "::";

    private Map<String, DVD> dvds = new HashMap<>();
    private DVD unmarshallStudent(String studentAsText){
    // studentAsText is expecting a line read in from our file.
    // For example, it might look like this:
    // 1234::Ada::Lovelace::Java-September1842
    //
    // We then split that line on our DELIMITER - which we are using as ::
    // Leaving us with an array of Strings, stored in studentTokens.
    // Which should look like this:
    // ______________________________________
    // |    |   |        |                  |
    // |1234|Ada|Lovelace|Java-September1842|
    // |    |   |        |                  |
    // --------------------------------------
    //  [0]  [1]    [2]         [3]
    String[] studentTokens = studentAsText.split(DELIMITER);

    // Given the pattern above, the student Id is in index 0 of the array.
    String studentId = studentTokens[0];

    // Which we can then use to create a new Student object to satisfy
    // the requirements of the Student constructor.
    Student studentFromFile = new Student(studentId);

    // However, there are 3 remaining tokens that need to be set into the
    // new student object. Do this manually by using the appropriate setters.

    // Index 1 - FirstName
    studentFromFile.setFirstName(studentTokens[1]);

    // Index 2 - LastName
    studentFromFile.setLastName(studentTokens[2]);

    // Index 3 - Cohort
    studentFromFile.setCohort(studentTokens[3]);

    // We have now created a student! Return it!
    return studentFromFile;
}
    @Override
    public DVD addDvd(String dvdTitle, DVD dvd) {
        /*Hash key will have DVD title, and values will be list of everything else accordingly to way listed initally. 
         
         */
        DVD newDvd = dvds.put(dvdTitle, dvd);
        return newDvd;
    }

    @Override
    public DVD getDvd(String dvdTitle) {
        DVD newDvd = dvds.get(dvdTitle);
        return newDvd;
    }

    @Override
    public void editDvd(DVD newD, int val, String editTo) {
        int ans;
        switch (val) {
            case 1:
                newD.addDvdTitle(editTo);
                dvds.put(newD.getDvdTitle(), newD);
                break;
            case 2:
                newD.setReleaseDate(editTo);
                dvds.put(newD.getDvdTitle(), newD);
                break;
            case 3:
                ans = Integer.parseInt(editTo);
                newD.setMPAArating(ans);
                dvds.put(newD.getDvdTitle(), newD);

                break;
            case 4:
                newD.addDirector(editTo);
                dvds.put(newD.getDvdTitle(), newD);
                newD.addDvdTitle(editTo);
                break;
            case 5:
                newD.addStudio(editTo);
                dvds.put(newD.getDvdTitle(), newD);
                newD.addDvdTitle(editTo);
                break;
            case 6:
                ans = Integer.parseInt(editTo);
                newD.add_userRating(ans);
                dvds.put(newD.getDvdTitle(), newD);

        }

    }

    @Override
    public List<String> getAllDvd() {
        return new ArrayList<>(dvds.keySet()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeDvd(String dvdTitle) {
        dvds.remove(dvdTitle);

    }

}
