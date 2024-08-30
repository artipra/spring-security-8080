package com.example.springsecurity8080.repository;

import com.example.springsecurity8080.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserInfo,Long> {
    public Optional<UserInfo> findByMobileNo(String mobileNo);
}
