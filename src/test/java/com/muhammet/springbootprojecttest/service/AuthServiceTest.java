package com.muhammet.springbootprojecttest.service;

import com.muhammet.springbootprojecttest.dto.request.RegisterRequestDto;
import com.muhammet.springbootprojecttest.entity.Auth;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Sprinng boot integration testler için mutlaka projenin ayağa kalaması gerekli. Diğer türlü
 * Temel java moutları gibi test yapamazsınız.
 */
@SpringBootTest
class AuthServiceTest {
    /**
     * Test i yapılacak sınıfın nesnesine ihtiyacınız vardır. Bu nedenle otomatik olarak spring framework
     * tarafından nesnenin oluşması için gerekli parametreleri eklemelisiniz.
     */
    @Autowired
    private AuthService authService;

    @Test
    void registerUser() {
        RegisterRequestDto dto = new RegisterRequestDto("muhammet","12345");
        Auth auth = authService.registerUser(dto);
        assertNotNull(auth);
        assertTrue(auth.getId()>0);
    }

    @Test
    void loginUser() {

    }
}