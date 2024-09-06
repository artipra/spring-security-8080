package com.example.springsecurity8080.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {


    @GetMapping("/dashboard")
    public String dashboard(){
        return "welcome Arti on amazon!!!!";
    }
}
