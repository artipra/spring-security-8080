package com.example.springsecurity8080.config;

import com.example.springsecurity8080.entity.Role;
import com.example.springsecurity8080.entity.UserInfo;
import com.example.springsecurity8080.exception.UserNotFoundException;
import com.example.springsecurity8080.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<UserInfo> user =  userRepository.findByUsername(username);
       if(user.isEmpty()) return null;
       UserInfo u1 = user.get();
       return new User(u1.getUsername(), u1.getPassword(),new ArrayList<>());
    }

    private List<GrantedAuthority> getAuthorities(List<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRole()))
                .collect(Collectors.toList());
    }
}
