/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddemess.dvd_library.controller;

import com.ddemess.dvd_library.dao.DvdDao;
import com.ddemess.dvd_library.dao.DvdDaoException;
import com.ddemess.dvd_library.dao.DvdDaoFileImpl;
import com.ddemess.dvd_library.dto.DVD;
import com.ddemess.dvd_library.ui.DVD_libraryView;
import com.ddemess.dvd_library.ui.UserIO;
import com.ddemess.dvd_library.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author mawidemess
 */
public class DVD_Controll {
    private DVD_libraryView view;
    private DvdDao dao;
    //private UserIO io;
    private final UserIO io = new UserIOConsoleImpl();
  //  private final DVD_libraryView view = new DVD_libraryView();
 //   DvdDaoFileImpl dao = new DvdDaoFileImpl();
    public DVD_Controll(DvdDao dao, DVD_libraryView view) {
        this.dao = dao;
        this.view = view;
}
    private void addDVD() throws DvdDaoException {
        view.displayAddDVDBanner();
        DVD newDvd = view.getDvdInfo();
        dao.addDvd(newDvd.getDvdTitle(), newDvd);
        view.displayAddSuccessBanner();
    }

    private void removeDVD() throws DvdDaoException {
        view.displayRemoveDVDBanner();
        String dvdTitle = view.getDVDtitle();
        if (dao.getDvd(dvdTitle)!=null){
            dao.removeDvd(dvdTitle);
        view.displayDvdTitle("Removed DVD : " + dvdTitle);
        }
        else{
            view.displayRemoveEmpty();
        }
    }

    private void listAllDVD() throws DvdDaoException {

        view.displayDisplayAllBanner();
        List<String> studentList = dao.getAllDvd();
        view.displayDvdList(studentList);
    }

    private void editDVD(DVD newD, int editChoice, String editTo) throws DvdDaoException {
        //if editing the key DVD TITLE
        if (editChoice == 1) {
            dao.removeDvd(newD.getDvdTitle());
        }
        view.displayEditingDVDTitle(newD.getDvdTitle());
        dao.editDvd(newD, editChoice, editTo);

    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

    /*
private void listAllDVD() {
    view.displayRemoveStudentBanner();
    String studentId = view.getStudentIdChoice();
    Student removedStudent = dao.removeStudent(studentId);
    view.displayRemoveResult(removedStudent);
}

private void search_DVD_byTitle() {
    view.displayRemoveStudentBanner();
    String studentId = view.getStudentIdChoice();
    Student removedStudent = dao.removeStudent(studentId);
    view.displayRemoveResult(removedStudent);
}*/
    public void run() throws DvdDaoException {
        boolean keepGoing = true;
        int menuSelection = 0;
        int editSelection = 0;
        boolean selectGoing = true;
        int actVal = 0;
        String choice = "";
        while (keepGoing) {
            io.print("Main Menu");
            io.print("1. Add DVD");
            io.print("2. Remove DVD");
            io.print("3. Edit DVD");
            io.print("4. List of all DVDs");
            io.print("5. Detail about a DVD");
            io.print("6. Search DVD by title");
            io.print("7. EXIT");

            menuSelection = io.readInt("Please select from the"
                    + " above choices.", 1, 7);

            switch (menuSelection) {
                case 1:
                    addDVD();
                    break;
                case 2:
                    removeDVD();
                    break;
                case 3:
                    String dvdTitle = view.getDVDtitle();
                    DVD newD = dao.getDvd(dvdTitle);
                    io.print("Select Edit Choice number");
                    io.print("1. DVD title");
                    io.print("2. Release Date");
                    io.print("3. MPAA rating");
                    io.print("4. Directors name");
                    io.print("5. Studio name");
                    io.print("6. User rating");
                    io.print("7. EXIT");

                    editSelection = io.readInt("Please select from the"
                            + " above choices.", 1, 7);

                    switch (editSelection) {
                        case 1:
                            choice = io.readString("Please enter new Title");
                            editDVD(newD, editSelection, choice);
                            break;
                        case 2:
                            choice = io.readString("Please enter new release date");
                            editDVD(newD, editSelection, choice);
                            break;
                        case 3:
                            choice = io.readString("Please enter new MPAA rating");
                            editDVD(newD, editSelection, choice);

                            break;
                        case 4:
                            choice = io.readString("Please enter new directors name");
                            editDVD(newD, editSelection, choice);
                            break;
                        case 5:
                            choice = io.readString("Please enter new studio name");
                            editDVD(newD, editSelection, choice);
                            break;
                        case 6:
                            choice = io.readString("Please enter new user rating");
                            editDVD(newD, editSelection, choice);
                            break;
                        case 7:
                            selectGoing = false;
                            break;
                        default:
                            unknownCommand();
                    }
                    break;

                case 4:
                    listAllDVD();
                    break;
                case 5:
                    String newS = view.getDVDtitle();
                    DVD newDv = dao.getDvd(newS);
                    view.displayDetailDvdBanner(newDv);
                    break;
                case 6:
                    String neS = view.getDVDtitle();
                    DVD newv = dao.getDvd(neS);
                    view.displayDetailDvdBanner(newv);
                    break;
                case 7:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }

        }
        exitMessage();
    }

}
