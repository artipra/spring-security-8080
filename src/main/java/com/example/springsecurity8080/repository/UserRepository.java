package com.example.springsecurity8080.repository;

import com.example.springsecurity8080.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@Repository
public interface UserRepository extends JpaRepository<UserInfo,Long> {
    public Optional<UserInfo> findByUsername(String username);

}
