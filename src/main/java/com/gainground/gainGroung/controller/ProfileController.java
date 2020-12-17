package com.gainground.gainGroung.controller;

import com.gainground.gainGroung.entity.Post;
import com.gainground.gainGroung.entity.ProfileEmpl;
import com.gainground.gainGroung.entity.User;
import com.gainground.gainGroung.repository.ProfileRepository;
import com.gainground.gainGroung.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfileController {
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/profile")
    public String profileMain(@AuthenticationPrincipal User user, Model model){
        ProfileEmpl profileEmpl = profileRepository.findProfileEmplById(user.getProfileEmpl().getId());
        if (profileEmpl.getFirst_name()==null) profileEmpl.setFirst_name("undefined");
        if (profileEmpl.getLast_name()==null) profileEmpl.setLast_name("undefined");
        if (profileEmpl.getPhoneNumber()==null) profileEmpl.setFirst_name("undefined");
        if (profileEmpl.getLocale()==null) profileEmpl.setLocale("undefined");
        model.addAttribute("profile",profileEmpl);
        return "profile";
    }
    @GetMapping("/profile/edit")
    public String profileEdit(@AuthenticationPrincipal User user, Model model){
        //model.addAttribute("profile",user.getPr);
        return "profile-edit";
    }
    @PostMapping("/profile/edit")
    public String profileEditForm(
            @AuthenticationPrincipal User user,
            @RequestParam String title,
            @RequestParam String anons,
            @RequestParam String full_text, Model model){
        //ProfileEmpl profileEmpl = profileRepository.
        //postRepository.save(post);
        return "redirect:/profile";
    }
}
