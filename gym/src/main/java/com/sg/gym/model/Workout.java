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
public class Workout {
    public int workout_id;
    public String name;
    public String target_muscle;
    public String equipment;

    public Workout() {
    }

    public Workout(int workout_id, String name, String target_muscle, String equipment) {
        this.workout_id = workout_id;
        this.name = name;
        this.target_muscle = target_muscle;
        this.equipment = equipment;
    }

    
    public int getId() {
        return workout_id;
    }

    public void setId(int workout_id) {
        this.workout_id = workout_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTarget_muscle() {
        return target_muscle;
    }

    public void setTarget_muscle(String target_muscle) {
        this.target_muscle = target_muscle;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }


    
    
}