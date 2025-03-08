package com.muhammet.springbootprojecttest.repository;

import com.muhammet.springbootprojecttest.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<Auth,Long> {
    Optional<Auth> findOptionalByUserNameAndPassword(String s, String password);
}
