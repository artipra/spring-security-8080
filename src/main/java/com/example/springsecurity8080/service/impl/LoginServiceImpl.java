package com.example.springsecurity8080.service.impl;


import com.example.springsecurity8080.entity.UserInfo;
import com.example.springsecurity8080.repository.UserRepository;
import com.example.springsecurity8080.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    public Optional<UserInfo> signup(String mobileNumber){
        return userRepository.findByMobileNo(mobileNumber);
    }
}
