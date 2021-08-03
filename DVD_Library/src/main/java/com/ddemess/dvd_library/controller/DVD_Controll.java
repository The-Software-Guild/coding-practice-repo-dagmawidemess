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
    private final UserIO io = new UserIOConsoleImpl();

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
        if (dao.getDvd(dvdTitle) != null) {
            dao.removeDvd(dvdTitle);
            view.displayDvdTitle("Removed DVD : " + dvdTitle);
        } else {
            view.displayRemoveEmpty();
        }
    }

    private void listAllDVD() throws DvdDaoException {

        view.displayDisplayAllBanner();
        List<String> dvdList = dao.getAllDvd();
        if(dvdList.size()==0){
            view.emptyLib();
        }
        else{
        view.displayDvdList(dvdList);
        }
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
private int getMenuSelection() {
    return view.printMenuAndGetSelection();
}
private int getSelection() {
    return view.printSelection();
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

            menuSelection = getMenuSelection();

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
                    if (newD==null){
                        view.displayRemoveEmpty();
                        break;
                    }

                    editSelection = getSelection();

                    switch (editSelection) {

    
                        case 1:
                            choice = view.newDtitle();
                            editDVD(newD, editSelection, choice);
                            break;
                        case 2:
                            choice = view.newRdate();
                            editDVD(newD, editSelection, choice);
                            break;
                        case 3:
                            choice =view.newMPAA();
                            editDVD(newD, editSelection, choice);

                            break;
                        case 4:
                            choice =view.newDirector();
                            editDVD(newD, editSelection, choice);
                            break;
                        case 5:
                            choice = view.newStudio();
                            editDVD(newD, editSelection, choice);
                            break;
                        case 6:
                            choice = view.newUser();
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
