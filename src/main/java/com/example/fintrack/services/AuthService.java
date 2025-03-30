package com.example.fintrack.services;

import com.example.fintrack.dto.LoginRequestDTO;
import com.example.fintrack.dto.RegisterRequestDTO;
import com.example.fintrack.dto.ResponseDTO;

public interface AuthService {
    ResponseDTO login(LoginRequestDTO body);
    ResponseDTO register(RegisterRequestDTO body);
}
