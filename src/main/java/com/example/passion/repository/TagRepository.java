package com.example.passion.repository;

import com.example.passion.model.etc.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<TagEntity,String> {
}
