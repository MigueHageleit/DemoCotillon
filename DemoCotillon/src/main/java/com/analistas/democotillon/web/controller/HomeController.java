package com.analistas.democotillon.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author migue
 */
@Controller
public class HomeController {
       
    @GetMapping("/home")
    public String verHome(Model model) {
    
        model.addAttribute("titulo", "Cotillon Celeste");
        return "home";
    }
}
