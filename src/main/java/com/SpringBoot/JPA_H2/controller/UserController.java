package com.SpringBoot.JPA_H2.controller;

import com.SpringBoot.JPA_H2.entity.UserEntity;
import com.SpringBoot.JPA_H2.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUser(){
        return ResponseEntity.ok(userService.getAllUser());
    }

    @PostMapping
    public void saveUser(@Valid @RequestBody UserEntity userEntity){
        userService.saveUser(userEntity);
    }
}
