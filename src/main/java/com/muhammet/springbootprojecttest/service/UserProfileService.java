package com.muhammet.springbootprojecttest.service;

import com.muhammet.springbootprojecttest.entity.UserProfile;
import com.muhammet.springbootprojecttest.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileService {
    private final UserProfileRepository userProfileRepository;

    /**
     * Bu kısım sadece auth tarafında register olan kullanıcının profil bilgilerini işlemek için yeni profil
     * oluşturulmakta kullanılır.
     * @param authId
     */
    public void createUserProfile(Long authId){
        userProfileRepository.save(UserProfile.builder().authId(authId).build());
    }

    public void updateUserProfile(UserProfile userProfile) {
        userProfileRepository.save(userProfile);
    }

    public List<UserProfile> getAll() {
        return userProfileRepository.findAll();
    }
}
