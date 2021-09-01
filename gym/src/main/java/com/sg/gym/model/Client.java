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
import java.util.Objects;

/**
 *
 * @author farhanshahbaz
 */
public class Client {
    public int client_id;
    public String firstName;
    public String lastName;
    public int age;
    public int height;
    public int weight;

    public Client() {
    }

    public Client(int client_id, String firstName, String lastName, int age, int height, int weight) {
        this.client_id = client_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    
    public int getId() {
        return client_id;
    }

    public void setId(int id) {
        this.client_id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

 

    
    
}
