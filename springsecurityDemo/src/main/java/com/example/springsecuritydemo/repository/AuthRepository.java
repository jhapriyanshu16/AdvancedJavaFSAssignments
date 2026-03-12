package com.example.springsecuritydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springsecuritydemo.enitity.User;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String userName);
}
