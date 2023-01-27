package com.example.passion.repository;

import com.example.passion.domain.etc.MypickEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyPickRepository extends JpaRepository<MypickEntity,String> {
}
