package com.gainground.gainGroung.controller;

import com.gainground.gainGroung.repository.RoleRepository;
import com.gainground.gainGroung.repository.UserRepository;
import com.gainground.gainGroung.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    private UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @GetMapping("/home/")
    public String mainPageEmpl() {
       return "home";
    }
    @GetMapping("/homeEmpl")
    public String mainPageEmplr(Model model) {
        model.addAttribute("title", "Новости GainGround");
        return "employee-home";
    }
    @GetMapping("/homeEmplr")
    public String mainPageAdmin(Model model) {
        model.addAttribute("title", "Новости GainGround");
        return "employer-home";
    }
}