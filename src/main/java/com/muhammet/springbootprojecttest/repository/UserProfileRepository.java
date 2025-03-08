package com.muhammet.springbootprojecttest.repository;

import com.muhammet.springbootprojecttest.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}
