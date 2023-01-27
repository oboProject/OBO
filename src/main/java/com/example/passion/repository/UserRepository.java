package com.example.passion.repository;

import com.example.passion.domain.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    UserEntity findUserEntityByEmail(String email);
    UserEntity findUserEntityByUserId(String userId);
}
