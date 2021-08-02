/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddemess.dvd_library.dao;

import com.ddemess.dvd_library.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author mawidemess
 */
public class DvdDaoFileImpl implements DvdDao {

    public static final String ROSTER_FILE = "roster.txt";
    public static final String DELIMITER = "::";

    private Map<String, DVD> dvds = new HashMap<>();
    /**
 * Writes all students in the roster out to a ROSTER_FILE.  See loadRoster
 * for file format.
 * 
 * @throws ClassRosterDaoException if an error occurs writing to the file
 */
private void writeRoster() throws DvdDaoException{
    // NOTE FOR APPRENTICES: We are not handling the IOException - but
    // we are translating it to an application specific exception and 
    // then simple throwing it (i.e. 'reporting' it) to the code that
    // called us.  It is the responsibility of the calling code to 
    // handle any errors that occur.
    PrintWriter out;

    try {
        out = new PrintWriter(new FileWriter(ROSTER_FILE));
    } catch (IOException e) {
        throw new DvdDaoException(
                "Could not save student data.", e);
    }

    // Write out the Student objects to the roster file.
    // NOTE TO THE APPRENTICES: We could just grab the student map,
    // get the Collection of Students and iterate over them but we've
    // already created a method that gets a List of Students so
    // we'll reuse it.
    String studentAsText;
    List<String> dvdList = this.getAllDvd();
    for (String currentDvd : dvdList) {
        // turn a Student into a String
        DVD newD = this.getDvd(currentDvd);
        studentAsText = marshallDvd(newD);
        // write the Student object to the file
        out.println(studentAsText);
        // force PrintWriter to write line to the file
        out.flush();
    }
    // Clean up
    out.close();
}
    private String marshallDvd(DVD aDvd) {
        // We need to turn a Student object into a line of text for our file.
        // For example, we need an in memory object to end up like this:
        // 4321::Charles::Babbage::Java-September1842

        // It's not a complicated process. Just get out each property,
        // and concatenate with our DELIMITER as a kind of spacer. 
        // Start with the student id, since that's supposed to be first.
        String studentAsText = aDvd.getDvdTitle() + DELIMITER;

        // add the rest of the properties in the correct order:
        // FirstName
        studentAsText += aDvd.releaseDate() + DELIMITER;

        // LastName
        studentAsText += aDvd.MPAArating() + DELIMITER;

        // Cohort - don't forget to skip the DELIMITER here.
        studentAsText += aDvd.directorName() + DELIMITER;
        studentAsText += aDvd.studio() + DELIMITER;
        studentAsText += aDvd.userRating();
        // We have now turned a student to text! Return it!
        return studentAsText;
    }

    private void loadRoster() throws DvdDaoException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdDaoException(
                    "-_- Could not load roster data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentStudent holds the most recent student unmarshalled
        DVD currentDvd;
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
            dvds.put(currentDvd.getDvdTitle(), currentDvd);
        }
        // close scanner
        scanner.close();
    }

    private DVD unmarshallStudent(String studentAsText) {
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
        String[] dvdTokens = studentAsText.split(DELIMITER);
        DVD newDvds = new DVD();
        // Given the pattern above, the student Id is in index 0 of the array.
        newDvds.addDvdTitle(dvdTokens[0]);
        newDvds.setReleaseDate(dvdTokens[1]);
        newDvds.setMPAArating(dvdTokens[2]);
        newDvds.addDirector(dvdTokens[3]);
        newDvds.addStudio(dvdTokens[4]);
        newDvds.add_userRating(dvdTokens[5]);
        // We have now created a student! Return it!
        return newDvds;
    }

    @Override
    public DVD addDvd(String dvdTitle, DVD dvd) throws DvdDaoException
    {
        /*Hash key will have DVD title, and values will be list of everything else accordingly to way listed initally. 
         
         */
        loadRoster();
        DVD newDvd = dvds.put(dvdTitle, dvd);
        writeRoster();
        return newDvd;
    }

    @Override
    public DVD getDvd(String dvdTitle) throws DvdDaoException {
        if(dvds.get(dvdTitle)!=null){
            loadRoster();
        }
        
        DVD newDvd = dvds.get(dvdTitle);
        return newDvd;
    }

    @Override
    public void editDvd(DVD newD, int val, String editTo) throws DvdDaoException {
        switch (val) {
            
            case 1:
                loadRoster();
                newD.addDvdTitle(editTo);
                dvds.put(newD.getDvdTitle(), newD);
                writeRoster();
                break;
            case 2:
                loadRoster();
                newD.setReleaseDate(editTo);
                dvds.put(newD.getDvdTitle(), newD);
                writeRoster();
                break;
            case 3:
                loadRoster();
                newD.setMPAArating(editTo);
                dvds.put(newD.getDvdTitle(), newD);
                writeRoster();
                break;
            case 4:
                loadRoster();
                newD.addDirector(editTo);
                dvds.put(newD.getDvdTitle(), newD);
                newD.addDvdTitle(editTo);
                writeRoster();
                break;
            case 5:
                loadRoster();
                newD.addStudio(editTo);
                dvds.put(newD.getDvdTitle(), newD);
                newD.addDvdTitle(editTo);
                writeRoster();
                break;
            case 6:
                loadRoster();
                newD.add_userRating(editTo);
                dvds.put(newD.getDvdTitle(), newD);
                writeRoster();

        }

    }

    @Override
    public List<String> getAllDvd() throws DvdDaoException {
        if ((dvds.size())!=0){
            loadRoster();
        }
        loadRoster();
        return new ArrayList<>(dvds.keySet()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeDvd(String dvdTitle) throws DvdDaoException {
        if (dvdTitle!=null){
        loadRoster();
        dvds.remove(dvdTitle);
        writeRoster();
        }
    }

}
