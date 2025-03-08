package com.muhammet.springbootprojecttest.service;

import com.muhammet.springbootprojecttest.dto.request.LoginRequestDto;
import com.muhammet.springbootprojecttest.dto.request.RegisterRequestDto;
import com.muhammet.springbootprojecttest.entity.Auth;
import com.muhammet.springbootprojecttest.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;

    public Auth registerUser(RegisterRequestDto dto) {
      return  authRepository.save(Auth.builder()
                        .userName(dto.userName())
                        .password(dto.password())
                .build());
    }

    public Optional<Auth> loginUser(LoginRequestDto dto) {
      return authRepository.findOptionalByUserNameAndPassword(dto.userName(),dto.password());
    }

    public Boolean isExistUser(String userName,String password) {
        return authRepository.existsByUserNameAndPassword(userName,password);
    }

    public Optional<Auth> getAuthUserNameAndPassword(String userName,String password) {
        return authRepository.findOptionalByUserNameAndPassword(userName,password);
    }
}
