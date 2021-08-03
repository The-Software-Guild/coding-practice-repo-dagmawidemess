/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddemess.dvd_library.ui;

import com.ddemess.dvd_library.dto.DVD;
import java.util.List;

/**
 *
 * @author mawidemess
 */
public class DVD_libraryView {

    private UserIO io;

    public DVD_libraryView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Add DVD");
        io.print("2. Remove DVD");
        io.print("3. Edit DVD");
        io.print("4. List of all DVDs");
        io.print("5. Detail about a DVD");
        io.print("6. Search DVD by title");
        io.print("7. EXIT");

        return io.readInt("Please select from the above choices.", 1, 7);
    }

    public int printSelection() {
        io.print("Select Edit Choice number");
        io.print("1. DVD title");
        io.print("2. Release Date");
        io.print("3. MPAA rating");
        io.print("4. Directors name");
        io.print("5. Studio name");
        io.print("6. User rating");
        io.print("7. EXIT");

        return io.readInt("Please select from the above choices.", 1, 7);
    }

    public DVD getDvdInfo() {
        String dvdTitle = io.readString("Please enter DVD Title");
        String releaseDate = io.readString("Please enter Release date in mm/dd/year");
        String studioName = io.readString("Please enter studio name");
        String MPAArating = io.readString("Please enter MPAA rating");
        String userRating = io.readString("Please enter user rating");
        String directorName = io.readString("Please enter Director's name");
        DVD newDVD = new DVD();
        newDVD.addDvdTitle(dvdTitle);
        newDVD.setReleaseDate(releaseDate);
        newDVD.addStudio(studioName);
        newDVD.add_userRating(userRating);
        newDVD.setMPAArating(MPAArating);
        newDVD.addDirector(directorName);
        return newDVD;

    }

    public DVD ediDvdInfo() {
        String dvdTitle = io.readString("Please enter DVD Title");
        String releaseDate = io.readString("Please enter Release date in mm/dd/year");
        String studioName = io.readString("Please enter studio name");
        String MPAArating = io.readString("Please enter MPAA rating");
        String userRating = io.readString("Please enter user rating");
        String directorName = io.readString("Please enter Director's name");
        DVD newDVD = new DVD();
        newDVD.addDvdTitle(dvdTitle);
        newDVD.setReleaseDate(releaseDate);
        newDVD.addStudio(studioName);
        newDVD.add_userRating(userRating);
        newDVD.setMPAArating(MPAArating);
        newDVD.addDirector(directorName);
        return newDVD;

    }

    public String getDVDtitle() {
        return io.readString("Please enter DVD title for details, editing and deletion.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayRemoveEmpty() {
        io.print("ERROR: Such DVD for removing or editing doesn't exist in library");
        io.readString("Please hit enter to continue.");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayAddDVDBanner() {
        io.print("=== Add DVD ===");
    }

    public void displayAddSuccessBanner() {
        io.readString(
                "DVD successfully added.  Please hit enter to continue");
    }

    public void displayDvdList(List<String> dvdList) {
        for (String val : dvdList) {
            String dvdInfo = val;
            io.print(dvdInfo);
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All DVDs ===");
    }

    public void displayDetailDvdBanner(DVD dvdT) {
        if (dvdT != null) {
            String studentInfo = String.format("\nTitle: %s\nRelease Date: %s\nMPAA Rating: %s \nDirector's Name: %s\n"
                    + "Studio's name: %s\nUser rating: %s\n",
                    dvdT.getDvdTitle(),
                    dvdT.releaseDate(),
                    dvdT.MPAArating(),
                    dvdT.directorName(),
                    dvdT.studio(),
                    dvdT.userRating());
            io.print(studentInfo);
        } else {
            io.print("Error: Such DVD doesn't exist in the library");
        }
        io.readString("Please hit enter to continue.");

    }

    public void displayDvdTitle(String dvdTitle) {

        io.print("DVD Title: " + dvdTitle);
        io.readString("Please hit enter to continue.");
    }

    public void emptyLib() {

        io.print("Library is empty :(");
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveDVDBanner() {
        io.print("=== Removing DVD... ===");
    }

    public void displayEditingDVDTitle(String title) {
        io.print("=== Editing  DVD " + title + " ===");
        io.readString("Please hit enter to continue.");
    }

    public String newDtitle() {
        return io.readString("Please enter new Title");
    }

    public String newRdate() {
        return io.readString("Please enter new release date");
    }

    public String newMPAA() {
        return io.readString("Please enter new MPAA rating");
    }

    public String newDirector() {
        return io.readString("Please enter new directors name");
    }

    public String newStudio() {
        return io.readString("Please enter new studio name");
    }

    public String newUser() {
        return io.readString("Please enter new user rating");
    }
}
