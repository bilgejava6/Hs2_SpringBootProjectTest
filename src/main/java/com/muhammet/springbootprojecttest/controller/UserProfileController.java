package com.muhammet.springbootprojecttest.controller;

import com.muhammet.springbootprojecttest.entity.UserProfile;
import com.muhammet.springbootprojecttest.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userprofile")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserProfileController {
    private final UserProfileService userProfileService;

    @PostMapping("/update-user-profile")
    public ResponseEntity<Boolean> updateUserProfile(@RequestBody UserProfile userProfile) {
        userProfileService.updateUserProfile(userProfile);
        return ResponseEntity.ok(true);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<UserProfile>> getAllUserProfile() {
        return ResponseEntity.ok(userProfileService.getAll());
    }
}
