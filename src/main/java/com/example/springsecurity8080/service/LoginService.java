package com.example.springsecurity8080.service;



import com.example.springsecurity8080.entity.UserInfo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface LoginService {

    public Optional<UserInfo> signup(String mobileNumber);

}
