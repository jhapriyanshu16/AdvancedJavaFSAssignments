package com.example.springsecuritydemo.controller.auth;
import com.example.springsecuritydemo.dto.LoginRequestDTO;
import com.example.springsecuritydemo.dto.LoginResponseDTO;
import com.example.springsecuritydemo.dto.RegisterDTO;
import com.example.springsecuritydemo.enitity.User;
import com.example.springsecuritydemo.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        return ResponseEntity.ok(authService.login(loginRequestDTO));
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterDTO> register(@RequestBody LoginRequestDTO loginRequestDTO) {
        return ResponseEntity.ok(authService.register(loginRequestDTO));
    }
}