package com.SpringBoot.JPA_H2.controller;

import com.SpringBoot.JPA_H2.entity.UserEntity;
import com.SpringBoot.JPA_H2.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/")
    public ResponseEntity<List<UserEntity>> getAllUser(){
        return ResponseEntity.ok(userService.getAllUser());
    }

    @PostMapping("/")
    public ResponseEntity<UserEntity> saveUser(@Valid @RequestBody UserEntity userEntity){
        return ResponseEntity.ok(userService.saveUser(userEntity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserEntity>> getAllUser(@PathVariable int id){
        Optional<UserEntity> optional = userService.getUserById(id);
        return ResponseEntity.ok(optional);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> saveUserAtId(@Valid @RequestBody UserEntity userEntity,@PathVariable int id){
        return ResponseEntity.ok(userService.saveUserAtId(userEntity,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserEntity> deleteUserById(@PathVariable int id){
        return ResponseEntity.ok(userService.deleteUserById(id));
    }

}
