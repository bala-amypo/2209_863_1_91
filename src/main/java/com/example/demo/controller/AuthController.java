package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.model.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth", description = "Authentication endpoints")
public class AuthController {
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserService userService, JwtTokenProvider jwtTokenProvider, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody User user) {
        User savedUser = userService.register(user);
        
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", savedUser.getRole());
        String token = jwtTokenProvider.generateToken(claims, savedUser.getEmail());
        
        AuthResponse response = new AuthResponse(token, savedUser.getId(), savedUser.getEmail(), savedUser.getRole());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        User user = userService.findByEmail(request.getEmail());
        
        if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("role", user.getRole());
            String token = jwtTokenProvider.generateToken(claims, user.getEmail());
            
            AuthResponse response = new AuthResponse(token, user.getId(), user.getEmail(), user.getRole());
            return ResponseEntity.ok(response);
        }
        
        return ResponseEntity.badRequest().build();
    }
}