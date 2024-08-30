package com.example.springsecurity8080.controller;

import com.example.springsecurity8080.dto.UserInfoDTO;
import com.example.springsecurity8080.entity.UserInfo;
import com.example.springsecurity8080.exception.UserNotFoundException;
import com.example.springsecurity8080.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    private LoginService loginService;


    @PostMapping("/home")
    public String home(@RequestBody String mobileNoOrEmailId){
        Optional<UserInfo> user = loginService.signup(mobileNoOrEmailId);
        if(user.isEmpty()) {
            new UserNotFoundException("Incorrect phone number. We cannot find an account with that mobile number");
        }
        return "home";
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody UserInfoDTO user){
        return ResponseEntity.ok("Solve this puzzle!!!!");
    }

}


