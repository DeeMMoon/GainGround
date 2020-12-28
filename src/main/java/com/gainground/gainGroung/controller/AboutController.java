package com.gainground.gainGroung.controller;
import com.gainground.gainGroung.RoleRedirecter;
import com.gainground.gainGroung.entity.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {
    @GetMapping("/about")
    public String about(@AuthenticationPrincipal User user) {
        return RoleRedirecter.redirecter(user, "about-emplr", "about-empl");
    }
}
