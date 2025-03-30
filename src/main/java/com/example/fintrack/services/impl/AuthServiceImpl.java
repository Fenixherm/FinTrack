package com.example.fintrack.services.impl;

import com.example.fintrack.controllers.exceptions.InvalidCredentialsException;
import com.example.fintrack.domain.model.User;
import com.example.fintrack.dto.LoginRequestDTO;
import com.example.fintrack.dto.RegisterRequestDTO;
import com.example.fintrack.dto.ResponseDTO;
import com.example.fintrack.infra.security.TokenService;
import com.example.fintrack.domain.repositories.UserRepository;
import com.example.fintrack.services.AuthService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @Override
    public ResponseDTO login(LoginRequestDTO body) {
        User user = this.repository.findByEmail(body.email()).orElseThrow(() -> new EntityNotFoundException("User not Found"));
        if (passwordEncoder.matches(body.password(), user.getPassword())) {
            String token = this.tokenService.generateToken(user);
            return new ResponseDTO(user.getEmail(), token);
        }
        throw new InvalidCredentialsException("E-mail or Password invalid");
    }

    @Override
    public ResponseDTO register(RegisterRequestDTO body) {
        Optional<User> user = this.repository.findByEmail(body.email());
        if (user.isEmpty() && !body.name().isBlank()) {
            User newUser = new User();
            newUser.setPassword(passwordEncoder.encode(body.password()));
            newUser.setEmail((body.email()));
            newUser.setName((body.name()));
            this.repository.save(newUser);
            String token = this.tokenService.generateToken(newUser);
            return new ResponseDTO(newUser.getEmail(), token);
        } else if (body.name() == null || body.name().isBlank()) {
            throw new IllegalArgumentException("Name is required");
        }
        throw new IllegalArgumentException("Email already registered");
    }
}
