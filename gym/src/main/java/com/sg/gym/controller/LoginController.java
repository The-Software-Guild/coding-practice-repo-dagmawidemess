/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.gym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
/*
 *
 * @author mawidemess
 */
@Controller
public class LoginController {
    @GetMapping("/login")
    public String displayworkouts(Model model) {
        
        return "/login";
    }
    
 
}
