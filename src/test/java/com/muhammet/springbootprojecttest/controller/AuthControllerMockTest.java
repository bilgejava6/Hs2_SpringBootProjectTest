package com.muhammet.springbootprojecttest.controller;

import com.muhammet.springbootprojecttest.dto.request.RegisterRequestDto;
import com.muhammet.springbootprojecttest.entity.Auth;
import com.muhammet.springbootprojecttest.service.AuthService;
import com.muhammet.springbootprojecttest.service.UserProfileService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
/**
 * JUnit ile Spring Boot Test yaparken mutlaka sistem ayakta olmak zorunda.
 * Mockito ile test yaparken sadece kod test edilir. bu nedenle spring boot
 * test e gerek yoktur
 */
@ExtendWith(MockitoExtension.class)
public class AuthControllerMockTest {

    // burada nesneler mock lanacak ancak bu nesnelerin oluşması için injection gerekli.
    @InjectMocks
    private AuthController authController;
    @Mock
    private AuthService authService;
    @Mock
    private UserProfileService userProfileService;

    @Test
    void registerTest(){
        RegisterRequestDto dto = new RegisterRequestDto("muhammet","123456");
        Mockito.when(authService.registerUser(Mockito.any())).thenReturn(Auth.builder()
                        .id(987L).userName("muhammet").password("123456")
                .build());
        Mockito.doNothing().when(userProfileService).createUserProfile(Mockito.anyLong());
        //Mockito.doThrow(RuntimeException.class).when(userProfileService).createUserProfile(Mockito.anyLong());
        Mockito.when(authController.register(Mockito.any())).thenReturn(ResponseEntity.ok(true));

        ResponseEntity<Boolean> result =  authController.register(dto);
        assertTrue(result.getBody());

    }
}
