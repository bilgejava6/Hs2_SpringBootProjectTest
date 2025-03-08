package com.muhammet.springbootprojecttest.service;

import com.muhammet.springbootprojecttest.entity.Auth;
import com.muhammet.springbootprojecttest.entity.UserProfile;
import com.muhammet.springbootprojecttest.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        if (authId != null)
            throw new RuntimeException("Hata");
        userProfileRepository.save(UserProfile.builder().authId(authId).build());
    }

    public void updateUserProfile(UserProfile userProfile) {
        userProfileRepository.save(userProfile);
    }

    public List<UserProfile> getAll() {
        return userProfileRepository.findAll();
    }

    public Boolean existUserProfile(Long authId) {
        return userProfileRepository.existsByAuthId(authId);
    }

    public Optional<UserProfile> getUserProfile(Long authId) {
        // authId null gelebilir.
        if(authId == null) throw new RuntimeException("authId is null");
        // 2 durum var bu id ye ait bilgi vardır - yoktur
        // Eğer authId bilgisi tekrar ediyor ise bu method çalışır mı?
        Optional<UserProfile> result = userProfileRepository.findOptionalByAuthId(authId);
        if(result.isEmpty()) throw new RuntimeException("user profile not found");
        return  result;
    }

}
