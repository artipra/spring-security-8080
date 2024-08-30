package com.example.springsecurity8080.gpt.config;

import com.example.springsecurity8080.gpt.entity.Usergpt;
import com.example.springsecurity8080.gpt.exception.UserNotFoundException;
import com.example.springsecurity8080.gpt.repository.UserRepositoryGpt;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class CustomUserDetailsServiceGpt implements UserDetailsService {

    private UserRepositoryGpt userRepositoryGpt;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Usergpt usergpt =  userRepositoryGpt.findByUsername(username).
                orElseThrow(() -> new UserNotFoundException("user not found exception !!!!"));

       return new User(
               usergpt.getUsername(),
               usergpt.getPassword(),
               new ArrayList<>()
       );
    }
}
