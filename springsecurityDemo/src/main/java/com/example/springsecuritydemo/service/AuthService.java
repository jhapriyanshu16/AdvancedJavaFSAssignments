package com.example.springsecuritydemo.service;

import com.example.springsecuritydemo.dto.LoginRequestDTO;
import com.example.springsecuritydemo.dto.LoginResponseDTO;
import com.example.springsecuritydemo.dto.RegisterDTO;
import com.example.springsecuritydemo.enitity.User;
import com.example.springsecuritydemo.repository.AuthRepository;
import com.example.springsecuritydemo.util.AuthUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;

    public RegisterDTO register(LoginRequestDTO loginRequestDTO) {
        if(authRepository.findByUsername(loginRequestDTO.getUsername()).isPresent()) {
            throw new IllegalArgumentException("User already exists");
        }
        User newUser = new User();
        newUser.setUsername(loginRequestDTO.getUsername());
        newUser.setPassword(passwordEncoder.encode(loginRequestDTO.getPassword()));
        newUser.setRole("USER");

        User savedUser = authRepository.save(newUser);

        return new RegisterDTO(savedUser.getId(), savedUser.getUsername());
    }

    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(),loginRequestDTO.getPassword())
        );
        User user = (User) authentication.getPrincipal();
        String token = authUtil.generateAccessToken(user);
        return new LoginResponseDTO(token,user.getId());
    }
}