package com.analistas.democotillon.web.controller;

import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author M20
 */

@Controller
public class LoginController {
    
    @GetMapping({"/", "/login"})
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "loguot", required = false) String loguot,
                        Model model,
                        Principal principal ) {
        
        if(principal != null)
            return "redirect:/home";
    
        return "login";
    }
    
}
