package com.example.springsecurity8080.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collection;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@Configuration
public class SecurityConfiguration {

    @Autowired
    private CustomUserDetailsService customUserDetailsServiceGpt;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
               (auth) -> auth
                       .requestMatchers("/").hasRole("user1").anyRequest().permitAll()
                )
                .formLogin(form -> form.loginPage("/login").permitAll())
                .csrf(csrf -> csrf.ignoringRequestMatchers(toH2Console()).disable())
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            CustomUserDetailsService userDetailsService,
            PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        ProviderManager providerManager = new ProviderManager(authenticationProvider);
        providerManager.setEraseCredentialsAfterAuthentication(false);
        return providerManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }


//    @Bean
//    private Collection<? extends GrantedAuthority> getAuthorities(
//            Collection<Role> roles) {
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        for (Role role: roles) {
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//            authorities.addAll(role.getPrivileges()
//                    .stream()
//                    .map(p -> new SimpleGrantedAuthority(p.getName()))
//                    .collect(Collectors.toList()));
//        }
//
//        return authorities;
//    }
}
