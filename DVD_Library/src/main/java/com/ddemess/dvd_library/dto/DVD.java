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
    private String MPAArating;
    // Programming Language + cohort month/year
    private String directorName;
    private String studio;
    private String userRating;

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

    public void setMPAArating(String MPAArating) {
        this.MPAArating = MPAArating;
    }

    public String MPAArating() {
        return MPAArating;
    }

    public void addStudio(String studio) {
        this.studio = studio;
    }

    public String studio() {
        return studio;
    }

    public void add_userRating(String userRating) {
        this.userRating = userRating;
    }

    public String userRating() {
        return userRating;
    }

    public void addDirector(String directorName) {
        this.directorName = directorName;
    }

    public String directorName() {
        return directorName;
    }

}
