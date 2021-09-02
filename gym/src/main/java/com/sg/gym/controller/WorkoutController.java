/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.gym.controller;

/**
 *
 * @author mawidemess
 */
import com.sg.gym.dao.ClientDao;
import com.sg.gym.dao.TrainerDao;
import com.sg.gym.dao.WorkoutDao;
import com.sg.gym.model.Workout;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author farhanshahbaz
 */
@Controller
public class WorkoutController {
    
    @Autowired
    ClientDao clientDao;
    
    @Autowired
    TrainerDao trainerDao;
    
    @Autowired
    WorkoutDao workoutDao;
    
    @GetMapping("workout")
    public String displayworkouts(Model model) {
        List<Workout> workout = workoutDao.getAllWorkouts();
        model.addAttribute("workout", workout);
        return "workout";
    }
    
    @PostMapping("addWorkout")
    public String addworkout(HttpServletRequest request) {
        String name = request.getParameter("name");
        String target_muscle = request.getParameter("target_muscle");
        String equipment = request.getParameter("equipment");
        
        Workout workout = new Workout();
        
        workout.setName(name);
        workout.setTarget_muscle(target_muscle);
        workout.setEquipment(equipment);
        
        workoutDao.addWorkout(workout);
        
        return "redirect:/workout";
    }
    
    @GetMapping("deleteWorkout")
    public String deleteworkout(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("workout_id"));
        workoutDao.deleteWorkoutById(id);
        
        return "redirect:/workout";
    }
    
    @GetMapping("editWorkout")
    public String editworkout(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("workout_id"));
        Workout workout = workoutDao.getWorkoutById(id);
        
        model.addAttribute("workout", workout);
        return "editworkout";
    }
    @PostMapping("editWorkout")
    public String perfromEditworkout(HttpServletRequest request, Model model) {
         int id = Integer.parseInt(request.getParameter("workout_id"));
        Workout workout = workoutDao.getWorkoutById(id);
        String name = request.getParameter("name");
        String target_muscle = request.getParameter("target_muscle");
        String equipment = request.getParameter("equipment");
        
        workout.setName(name);
        workout.setTarget_muscle(target_muscle);
        workout.setEquipment(equipment);
        workoutDao.updateWorkout(workout);
        return "redirect:/workout";
    }

    
}