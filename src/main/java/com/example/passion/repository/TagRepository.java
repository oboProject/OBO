package com.example.passion.repository;

import com.example.passion.model.etc.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.beans.JavaBean;

public interface TagRepository extends JpaRepository<TagEntity,String> {
}
