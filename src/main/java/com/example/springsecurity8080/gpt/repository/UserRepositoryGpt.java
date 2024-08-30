package com.example.springsecurity8080.gpt.repository;

import com.example.springsecurity8080.gpt.entity.Usergpt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepositoryGpt extends JpaRepository<Usergpt, Long> {
    Optional<Usergpt> findByUsername(String name);
}
