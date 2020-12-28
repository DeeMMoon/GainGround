package com.gainground.gainGroung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
    @GetMapping("/err404")
    public String err404(){
        return "err404";
    }
    @GetMapping("/err400")
    public String err400(){
        return "err400";
    }
}
