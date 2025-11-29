package com.SpringBoot.JPA_H2.service;

import com.SpringBoot.JPA_H2.entity.UserEntity;
import com.SpringBoot.JPA_H2.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public List<UserEntity> getAllUser(){
        return userRepository.findAll();
    }

    public void saveUser(UserEntity userEntity){
        userRepository.save(userEntity);
    }
}
