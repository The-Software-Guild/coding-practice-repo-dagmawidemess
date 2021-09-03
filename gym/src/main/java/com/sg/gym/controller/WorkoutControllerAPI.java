/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.gym.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author farhanshahbaz
 */
@Controller
public class WorkoutControllerAPI {
    

    
    @GetMapping("workoutInfoAPI")
    public String displayworkouts(Model model) {
        

       
       return "workoutInfoAPI";
    }
    
    //        List <ResultsAPI> workouts = service.getResultsAPI(11);
//        
//        model.addAttribute("workoutInfo", workouts);
//        
//        CategoryAPI category = service.getCategoryAPI();
//        System.out.println("Category: " + category);
    
    //Youtube Video
//    @GetMapping("workouts")
//    public List<Object> getWorkouts(){
//        Object[] workouts = restTemplate.getForObject(url, Object[].class);
//        return Arrays.asList(workouts);
//    }
    
    //Has to be same in DAO
//    @RequestMapping("/{id}")
//    public ExcerciseInfoAPI getMovieInfo(@PathVariable("id") String id) {
//        String url = "https://wger.de/api/v2/exerciseinfo/" + id + "/" + apiKey;
//        ExcerciseInfoAPI eIAPI = restTemplate.getForObject(url, ExcerciseInfoAPI.class);
//        return new ExcerciseInfoAPI(eIAPI.getResults());
//
//    }
    
    
   
    
    
//    @PostMapping("addWorkout")
//    public String addworkout(HttpServletRequest request) {
//        String name = request.getParameter("name");
//        String target_muscle = request.getParameter("target_muscle");
//        String equipment = request.getParameter("equipment");
//        
//        Workout workout = new Workout();
//        workout.setName(name);
//        workout.setTarget_muscle(target_muscle);
//        workout.setEquipment(equipment);
//        
//        workoutDao.addWorkout(workout);
//        
//        return "redirect:/workouts";
//    }
    
}
