package com.muhammet.springbootprojecttest.repository;

import com.muhammet.springbootprojecttest.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    Boolean existsByAuthId(Long authId);

    Optional<UserProfile> findOptionalByAuthId(Long authId);
}
