package com.muhammet.springbootprojecttest.controller;

import com.muhammet.springbootprojecttest.dto.request.LoginRequestDto;
import com.muhammet.springbootprojecttest.dto.request.RegisterRequestDto;
import com.muhammet.springbootprojecttest.entity.Auth;
import com.muhammet.springbootprojecttest.service.AuthService;
import com.muhammet.springbootprojecttest.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {
    private final AuthService authService;
    private final UserProfileService userProfileService;
    @PostMapping("/register")
    public ResponseEntity<Boolean> register(@RequestBody RegisterRequestDto dto){
        // burada auth bilgiri kayıt edilir.
        Auth auth = authService.registerUser(dto);
        // ilgili auth a ait profil oluşturulur.
        userProfileService.createUserProfile(auth.getId());
      return ResponseEntity.ok(true);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody LoginRequestDto dto){
       Optional<Auth> auth =  authService.loginUser(dto);
       if (auth.isEmpty()) throw new RuntimeException("Kullanıcı adı ya da şifre hatalıdır.");
       return ResponseEntity.ok(true);
    }


}
