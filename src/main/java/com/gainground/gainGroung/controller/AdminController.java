package com.gainground.gainGroung.controller;

import com.gainground.gainGroung.service.ProfileService;
import com.gainground.gainGroung.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private ProfileService profileService;

    @GetMapping("/admin")
    public String userList(Model model) {
        model.addAttribute("allUsers", userService.allUsers());
        model.addAttribute("allProfiles", profileService.allProfiles());
        return "admin-home";
    }

    @PostMapping("/admin")
    public String deleteUser(@RequestParam(required = true, defaultValue = "") Long userId,
                             @RequestParam(required = true, defaultValue = "") String action,
                             @RequestParam(required = true, defaultValue = "") Integer leafs,
                             @RequestParam(required = true, defaultValue = "") Long profId,
                             Model model) {
        if (action.equals("delete")) {
            userService.deleteUser(userId);
        }
        if (action.equals("install")) {
            profileService.setProfileLeafsById(profId, leafs);
        }
            return "redirect:/admin";
        }
}
