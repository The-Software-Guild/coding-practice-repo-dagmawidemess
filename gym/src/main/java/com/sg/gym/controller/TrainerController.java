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
import com.sg.gym.model.Trainer;
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
public class TrainerController {
    
    @Autowired
    ClientDao clientDao;
    
    @Autowired
    TrainerDao trainerDao;
    
    @Autowired
    WorkoutDao workoutDao;
    @GetMapping("trainer")
    public String displaytrainers(Model model) {
        List<Trainer> trainer = trainerDao.getAllTrainers();
        model.addAttribute("trainer", trainer);
        return "trainer";
    }
    
    @PostMapping("addTrainer")
    public String addtrainer(HttpServletRequest request) {
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        int age = Integer.parseInt(request.getParameter("age"));
        int yearsExpiernce = Integer.parseInt(request.getParameter("years_of_experience"));
        boolean isAvaliable = Boolean.parseBoolean(request.getParameter("isAvailable"));
       // int workoutId = Integer.parseInt(request.getParameter("workout_id"));
        
        Trainer trainer = new Trainer();
        trainer.setFirst_name(firstName);
        trainer.setLastName(lastName);
        trainer.setAge(age);
        trainer.setYears_of_experience(yearsExpiernce);
        trainer.setIsAvailable(isAvaliable);
        
        trainerDao.addTrainer(trainer);
        
        
        return "redirect:/trainer";
    }
    
    @GetMapping("deleteTrainer")
    public String deleteworkout(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("trainer_id"));
        trainerDao.deleteTrainerById(id);
        
        return "redirect:/trainer";
    }
    /*
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
*/
}

