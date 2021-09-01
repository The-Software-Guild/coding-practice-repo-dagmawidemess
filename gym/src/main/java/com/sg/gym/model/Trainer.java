/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.gym.model;

/**
 *
 * @author mawidemess
 */
import java.util.List;
import java.util.Objects;

/**
 *
 * @author farhanshahbaz
 */
public class Trainer {
    private int id;
    private String first_name;
    private String lastName;
    private int age;
    private int years_of_experience;
    private boolean isAvailable;
    private Workout workout;
    private List<Client> clients;

    public Trainer() {
    }

    public Trainer(int id, String first_name, String lastName, int age, int years_of_experience, boolean isAvailable, Workout workout, List<Client> clients) {
        this.id = id;
        this.first_name = first_name;
        this.lastName = lastName;
        this.age = age;
        this.years_of_experience = years_of_experience;
        this.isAvailable = isAvailable;
        this.workout = workout;
        this.clients = clients;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getYears_of_experience() {
        return years_of_experience;
    }

    public void setYears_of_experience(int years_of_experience) {
        this.years_of_experience = years_of_experience;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }



    
    

    
}

