package com.example.springsecuritydemo.controller.api;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @GetMapping("/profile")
    public String profile(Authentication authentication){
        String username = authentication.getName();
        return "Welcome " + username + " to your profile";
    }
}
