package com.example.fintrack.controllers;

import com.example.fintrack.dto.LoginRequestDTO;
import com.example.fintrack.dto.RegisterRequestDTO;
import com.example.fintrack.dto.ResponseDTO;
import com.example.fintrack.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@Valid @RequestBody LoginRequestDTO body) {
        ResponseDTO response = authService.login(body);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> register(@Valid  @RequestBody RegisterRequestDTO body) {
        ResponseDTO response = authService.register(body);
        return ResponseEntity.ok(response);
    }
}

