package com.gainground.gainGroung.controller;

import com.gainground.gainGroung.RoleRedirecter;
import com.gainground.gainGroung.entity.User;
import com.gainground.gainGroung.repository.RoleRepository;
import com.gainground.gainGroung.repository.UserRepository;
import com.gainground.gainGroung.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Iterator;

@Controller
public class MainController {
    @Autowired
    private UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @GetMapping("/home")
    public String mainPageEmpl(@AuthenticationPrincipal User user) {
        Iterator iterator = user.getRoles().iterator();
        String role = null;
        while(iterator.hasNext()){
            role = iterator.next().toString();
        }
        if(role.equals("ROLE_EMPLR")) return "redirect:/homeEmplr";
        if(role.equals("ROLE_EMPL")) return "redirect:/homeEmpl";
        else return "redirect:/err400";
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