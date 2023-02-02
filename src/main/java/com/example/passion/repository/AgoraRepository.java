package com.example.passion.repository;

import com.example.passion.model.post.AgoraEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgoraRepository extends JpaRepository<AgoraEntity,String> {
}
