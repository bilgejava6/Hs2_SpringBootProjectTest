package com.muhammet.springbootprojecttest.repository;

import com.muhammet.springbootprojecttest.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<Auth,Long> {
}
