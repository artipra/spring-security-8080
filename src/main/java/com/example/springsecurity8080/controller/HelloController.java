package com.example.springsecurity8080.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.DelegatingFilterProxy;

@RestController
public class HelloController {

    @RequestMapping("/")
    @GetMapping
    public ResponseEntity<String> helloworld(){
        return ResponseEntity.ok("hello world welcome to app!!!!");
    }

//    @RequestMapping("/signup")
//    @GetMapping
//    public ResponseEntity<String> signup(){
//        return ResponseEntity.ok("hello world !!!!");
//    }

}


