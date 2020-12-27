package com.gainground.gainGroung.controller;

import com.gainground.gainGroung.RoleRedirecter;
import com.gainground.gainGroung.entity.ProfileEmpl;
import com.gainground.gainGroung.entity.User;
import com.gainground.gainGroung.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
public class ProfileController {
    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping("/profile")
    public String profileMain(@AuthenticationPrincipal User user, Model model){
        ProfileEmpl profileEmpl = profileRepository.findProfileEmplById(user.getProfileEmpl().getId());
        model.addAttribute("profile",profileEmpl);
        return RoleRedirecter.redirecter(user, "profile-emplr", "profile-empl");
    }
    @GetMapping("/profile/edit")
    public String profileEdit(@AuthenticationPrincipal User user, Model model){
        model.addAttribute("profile",user.getProfileEmpl());
        return RoleRedirecter.redirecter(user,"profile-edit-emplr","profile-edit-empl");
    }
    @PostMapping("/profile/edit")
    public String profileEditForm(
            @AuthenticationPrincipal User user,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam Date year,
            @RequestParam String country,
            @RequestParam String phoneNumber,Model model){
        ProfileEmpl profileEmpl = profileRepository.findProfileEmplById(user.getProfileEmpl().getId());
        profileEmpl.setFirst_name(firstName);
        profileEmpl.setLast_name(lastName);
        profileEmpl.setAge(year.toString());
        profileEmpl.setLocale(country);
        profileEmpl.setPhoneNumber(phoneNumber);
        profileRepository.save(profileEmpl);
        return "redirect:/profile";
    }
}
