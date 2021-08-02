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
    //private ClassRosterDao dao = new ClassRosterDaoFileImpl();
    public DVD_libraryView(UserIO io){
        this.io=io;
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
    io.print("Such DVD for removing doesn't exist in library");
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
        if (dvdT!=null){
        String studentInfo = String.format("Title: %s :: Release Date: %s :: MPAA Rating: %s :: Director's Name: %s\nStudio's name: %s :: User rating: %s",
                dvdT.getDvdTitle(),
                dvdT.releaseDate(),
                dvdT.MPAArating(),
                dvdT.directorName(),
                dvdT.studio(),
                dvdT.userRating());
        io.print(studentInfo);
        }
        else{
            io.print("Error: Such DVD doesn't exist in the library");
        }
        io.readString("Please hit enter to continue.");

    }

    /*
public String getStudentIdChoice() {
    return io.readString("Please enter the DVD you want to read about.");
}


public void displayRemoveResult(Student studentRecord) {
    if(studentRecord != null){
      io.print("Student successfully removed.");
    }else{
      io.print("No such student.");
    }
    io.readString("Please hit enter to continue.");
}    */
    public void displayDvdTitle(String dvdTitle) {

        io.print("DVD Title: " + dvdTitle);
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveDVDBanner() {
        io.print("=== Removing DVD... ===");
    }

    public String getStudentIdChoice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void displayEditingDVDTitle(String title) {
        io.print("=== Editing  DVD " + title + " ===");
    }

}
