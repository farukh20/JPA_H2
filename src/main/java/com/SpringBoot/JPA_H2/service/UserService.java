package com.SpringBoot.JPA_H2.service;

import com.SpringBoot.JPA_H2.entity.UserEntity;
import com.SpringBoot.JPA_H2.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public List<UserEntity> getAllUser(){
        return userRepository.findAll();
    }

    public UserEntity saveUser(UserEntity userEntity){
        return userRepository.save(userEntity);
    }

    public Optional<UserEntity> getUserById(int id) {
        Optional<UserEntity> optional = userRepository.findUserById(id);
        return optional;
    }

    public UserEntity saveUserAtId(UserEntity userEntity, int id) {
        UserEntity optional = userRepository.findById(id);
        optional.setName(userEntity.getName());
        optional.setEmail(userEntity.getEmail());
        optional.setNumber(userEntity.getNumber());
        return userRepository.save(optional);
    }
}
