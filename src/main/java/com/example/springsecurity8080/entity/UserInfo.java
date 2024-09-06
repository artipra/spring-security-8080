package com.example.springsecurity8080.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Entity
@Table(name="userinfo")
@Getter
@Setter
public class UserInfo{
    @Id
    @GeneratedValue
    private Long id;
    private String mobileNo;
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name ="user_roles",
               joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name ="role_id"))
    private Collection<Role> roles;
}
