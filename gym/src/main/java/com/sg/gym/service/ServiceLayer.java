/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.gym.service;
import com.sg.gym.model.CategoryAPI;
import com.sg.gym.model.ResultsAPI;
import com.sg.gym.model.Workout;
import java.util.List;

/**
 *
 * @author farhanshahbaz
 */
public interface ServiceLayer {
    //Workout
    Workout getWorkoutById(int id);
    List<Workout> getAllWorkouts();
    Workout addWorkout(Workout workout);
    void updateWorkout(Workout workout);
    void deleteWorkoutById(int id);
    
    List <ResultsAPI> getResultsAPI(int id);
    
    CategoryAPI getCategoryAPI();
}
