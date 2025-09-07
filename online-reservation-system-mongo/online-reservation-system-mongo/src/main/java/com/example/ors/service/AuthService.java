package com.example.ors.service;

import com.example.ors.dto.AuthRequest;
import com.example.ors.dto.AuthResponse;
import com.example.ors.dto.RegisterRequest;
import com.example.ors.exception.ApiException;
import com.example.ors.model.User;
import com.example.ors.repository.UserRepository;
import com.example.ors.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public void register(RegisterRequest req) {
        if (userRepository.existsByUsername(req.getUsername())) {
            throw new ApiException("Username already exists");
        }
        User user = new User(req.getUsername(), passwordEncoder.encode(req.getPassword()), Set.of("ROLE_USER"));
        userRepository.save(user);
    }

    public AuthResponse login(AuthRequest req) {
        User user = userRepository.findByUsername(req.getUsername())
                .orElseThrow(() -> new ApiException("Invalid credentials"));
        if (!passwordEncoder.matches(req.getPassword(), user.getPassword())) {
            throw new ApiException("Invalid credentials");
        }
        String token = jwtUtil.generateToken(user.getUsername());
        return new AuthResponse(token);
    }
}
