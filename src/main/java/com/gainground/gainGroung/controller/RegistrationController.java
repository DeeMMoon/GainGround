package com.gainground.gainGroung.controller;

import com.gainground.gainGroung.entity.ProfileEmpl;
import com.gainground.gainGroung.service.UserService;
import com.gainground.gainGroung.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;


    @GetMapping("/registration")
    public String registrationEmpl() {
        return "registration";
    }

    @GetMapping("/employee")
    public String greetingForm(Model model) {
        model.addAttribute("userForm", new User());
        return "employee-registration";
    }



    @PostMapping("/employee")
    public String addEmpl(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "employee-registration";
        }
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())){
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "employee-registration";
        }
        if (!userService.saveEmpl(userForm)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "employee-registration";
        }

       return "redirect:/login";
    }
    @GetMapping("/employer")
    public String registrationEmplr(Model model) {
        model.addAttribute("userForm", new User());
        return "employer-registration";
    }


    @PostMapping("/employer")
    public String addEmplr(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "employer-registration";
        }
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())){
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "employer-registration";
        }
        if (!userService.saveEmplr(userForm)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "employer-registration";
        }
        return "redirect:/login";
    }
}
