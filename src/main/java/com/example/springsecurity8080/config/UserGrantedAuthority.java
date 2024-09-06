package com.example.springsecurity8080.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;

@Configuration
public class UserGrantedAuthority implements GrantedAuthority {

    @Override
    public String getAuthority() {
        return "user1";
    }
}

