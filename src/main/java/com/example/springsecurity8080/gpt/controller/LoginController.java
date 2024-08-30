package com.example.springsecurity8080.gpt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class LoginController {

    @GetMapping("/about")
    public String login(){
        return "about";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }
}
