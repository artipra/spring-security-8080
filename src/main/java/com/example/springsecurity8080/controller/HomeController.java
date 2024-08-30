package com.example.springsecurity8080.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public ResponseEntity<String> signup(){
        return ResponseEntity.ok("Hello welcome to amazon !!!!");
    }

}
