package com.muhammet.springbootprojecttest.service;

import com.muhammet.springbootprojecttest.entity.UserProfile;
import com.muhammet.springbootprojecttest.repository.UserProfileRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserProfileMockTest {

    @InjectMocks
    private UserProfileService userProfileService;
    @Mock
    private UserProfileRepository repository;
    @Test
    void getUserProfileNullAuthId(){
        RuntimeException result = Assertions.assertThrows(RuntimeException.class,
                ()-> userProfileService.getUserProfile(null));
        Assertions.assertEquals("authId is null",result.getMessage());
    }
    @Test
    void getUserProfileNonUserId(){
       RuntimeException result = Assertions.assertThrows(RuntimeException.class,
               ()-> userProfileService.getUserProfile(1L));
       Assertions.assertEquals("user profile not found", result.getMessage());
    }
    @Test
    void getUserProfileExistUserId(){
        Mockito.when(repository.findOptionalByAuthId(Mockito.anyLong())).thenReturn(
                Optional.of(UserProfile.builder()
                                .id(123L)
                                .authId(543531L)
                                .address("Ankara")
                                .age(32)
                                .name("Demet TAŞ")
                        .build())
        );
      Optional<UserProfile> result =   userProfileService.getUserProfile(543531L);
      Assertions.assertEquals(result.get().getId(),123L);
    }
}
