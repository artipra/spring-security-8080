package com.example.springsecurity8080.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;


public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(auth ->
                       auth
                            .anyRequest().permitAll()
//                          .requestMatchers("/").permitAll()
//                          .requestMatchers("/dashboard").hasRole("ADMIN")
//                          .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
       return httpSecurity.build();
    }

  @Bean
  public UserDetailsManager userDetailsService(DataSource dataSource){
      UserDetails userDetails = User.builder()
              .username("user")
              .password("{noop}password")
              .roles("ADMIN")
              .build();
      return new InMemoryUserDetailsManager(userDetails);
//      JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
//      users.createUser(userDetails);
//      return users;
  }

}
