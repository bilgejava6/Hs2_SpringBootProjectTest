package com.muhammet.springbootprojecttest.controller;

import com.muhammet.springbootprojecttest.dto.request.LoginRequestDto;
import com.muhammet.springbootprojecttest.dto.request.RegisterRequestDto;
import com.muhammet.springbootprojecttest.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<Boolean> register(@RequestBody RegisterRequestDto dto){
        authService.registerUser(dto);
        return ResponseEntity.ok(true);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody LoginRequestDto dto){
        authService.loginUser(dto);
        return ResponseEntity.ok(true);
    }


}
