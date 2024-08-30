package com.example.springsecurity8080.gpt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Getter
@Setter
public class Usergpt{

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
}
