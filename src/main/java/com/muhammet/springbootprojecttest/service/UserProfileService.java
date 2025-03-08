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

    public void updateUserProfile(UserProfile userProfile) {
    }

    public List<UserProfile> getAll() {
        return null;
    }
}
