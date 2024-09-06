package com.example.springsecurity8080.controller;

import com.example.springsecurity8080.dto.UserInfoDTO;
import com.example.springsecurity8080.entity.UserInfo;
import com.example.springsecurity8080.exception.UserNotFoundException;
import com.example.springsecurity8080.service.LoginService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    private LoginService loginService;


    @GetMapping("/login")
    public String login(){
//        System.out.println(mobileNo);
//        Optional<UserInfo> user = loginService.signin(mobileNo);
//        if(!user.isEmpty()) {
////            new UserNotFoundException("Incorrect phone number. We cannot find an account with that mobile number");
////            return "Looks like you are new to Amazon";
//            return "dashboard";
//        }
         return "login";
    }

    @PostMapping("/signup")
    public String signup(@RequestBody String mobileNo) {
        System.out.println("888888888888888888888888888888888");
        Optional<UserInfo> user = loginService.signin(mobileNo);
        if(user.isEmpty()) {
            new UserNotFoundException("Incorrect phone number. We cannot find an account with that mobile number");
            return "Looks like you are new to Amazon";
        }
        return "dashboard";
    }

}


