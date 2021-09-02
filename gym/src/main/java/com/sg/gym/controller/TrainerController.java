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
import com.sg.gym.model.Client;
import com.sg.gym.model.Trainer;
import com.sg.gym.model.Workout;
import java.util.ArrayList;
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
        List<Client> client = clientDao.getAllClients();
        List<Workout> workout = workoutDao.getAllWorkouts();
        model.addAttribute("trainer", trainer);
        model.addAttribute("workout",workout);
        model.addAttribute("client",client);
        
        return "trainer";
    }
    
    @PostMapping("addTrainer")
    public String addtrainer(Trainer train,HttpServletRequest request) {
        String workoutId = request.getParameter("workout_id");
        String[] clientIds =  request.getParameterValues("client_id");
        train.setWorkout(workoutDao.getWorkoutById(Integer.parseInt(workoutId)));
        List <Client> clients = new ArrayList<>();
        for(String clientId : clientIds){
            clients.add(clientDao.getClientById(Integer.parseInt(clientId)));
        }
        train.setClients(clients);
        trainerDao.addTrainer(train);
        return "redirect:/trainer";
    }
    
    @GetMapping("deleteTrainer")
    public String deleteworkout(Integer id) {
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

