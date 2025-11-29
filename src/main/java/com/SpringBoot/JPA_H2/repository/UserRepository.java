package com.SpringBoot.JPA_H2.repository;

import com.SpringBoot.JPA_H2.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
   Optional<UserEntity> findUserById(int id);
}
