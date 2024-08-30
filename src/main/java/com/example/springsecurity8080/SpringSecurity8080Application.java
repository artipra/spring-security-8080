package com.example.springsecurity8080;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication

public class SpringSecurity8080Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurity8080Application.class, args);

    }

}
