package com.example.springsecurity8080.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="userInfo")
@Getter
@Setter
public class UserInfo{

    @Id
    @GeneratedValue
    private Long id;
    private String mobileNo;
    private String username;
    private String password;

}
