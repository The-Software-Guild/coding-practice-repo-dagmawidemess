/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddemess.dvd_library.dto;

/**
 *
 * @author mawidemess
 */
public class DVD {

    public String dvdTitle;
    private String releaseDate;
    private int MPAArating;
    // Programming Language + cohort month/year
    private String directorName;
    private String studio;
    private int userRating;

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String releaseDate() {
        return releaseDate;
    }

    public String getDvdTitle() {
        return dvdTitle;
    }

    public void addDvdTitle(String dvdTitle) {
        this.dvdTitle = dvdTitle;
    }

    public void setMPAArating(int MPAArating) {
        this.MPAArating = MPAArating;
    }

    public int MPAArating() {
        return MPAArating;
    }

    public void addStudio(String studio) {
        this.studio = studio;
    }

    public String studio() {
        return studio;
    }

    public void add_userRating(int userRating) {
        this.userRating = userRating;
    }

    public int userRating() {
        return userRating;
    }

    public void addDirector(String directorName) {
        this.directorName = directorName;
    }

    public String directorName() {
        return directorName;
    }

}
