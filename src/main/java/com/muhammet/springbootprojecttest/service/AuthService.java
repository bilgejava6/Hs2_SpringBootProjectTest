package com.muhammet.springbootprojecttest.service;

import com.muhammet.springbootprojecttest.dto.request.LoginRequestDto;
import com.muhammet.springbootprojecttest.dto.request.RegisterRequestDto;
import com.muhammet.springbootprojecttest.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;

    public void registerUser(RegisterRequestDto dto) {
    }

    public void loginUser(LoginRequestDto dto) {
    }
}
