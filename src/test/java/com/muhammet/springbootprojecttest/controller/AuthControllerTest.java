package com.muhammet.springbootprojecttest.controller;

import com.muhammet.springbootprojecttest.dto.request.LoginRequestDto;
import com.muhammet.springbootprojecttest.dto.request.RegisterRequestDto;
import com.muhammet.springbootprojecttest.entity.Auth;
import com.muhammet.springbootprojecttest.entity.UserProfile;
import com.muhammet.springbootprojecttest.service.AuthService;
import com.muhammet.springbootprojecttest.service.UserProfileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AuthControllerTest {
    private static final String userName = "demet";
    private static final String password = "123456";
    private static final String wrongPassword = "1234567";

    @Autowired
    private AuthController authController;
    @Autowired
    private AuthService authService;
    @Autowired
    private UserProfileService userProfileService;
    @Test
    void register() {
        RegisterRequestDto dto = new RegisterRequestDto(userName,password);
        authController.register(dto);
        /**
         * 1. Kullanıcı için auth oluştu mu?
         * 2. auth için profile oluştu mu?
         */
        assertTrue(authService.isExistUser(userName,password));

        Optional<Auth> auth = authService.getAuthUserNameAndPassword(userName,password);
        assertTrue(userProfileService.existUserProfile(auth.get().getId()));

    }

    @Test
    void loginSuccess() {
        LoginRequestDto dtoLogin = new LoginRequestDto(userName,password);
        ResponseEntity<Boolean> result = authController.login(dtoLogin);
        assertTrue(result.getBody());
    }

    @Test
    void loginFail() {
        LoginRequestDto dtoLogin = new LoginRequestDto(userName,wrongPassword);
        // hata oluşumunun kontrol etmeliyiz
        RuntimeException result =  assertThrows(RuntimeException.class,()-> authController.login(dtoLogin));
        assertEquals("Kullanıcı adı ya da şifre hatalıdır.",result.getMessage());
    }


}