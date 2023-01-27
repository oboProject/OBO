package com.example.passion.repository;

import com.example.passion.domain.post.PortfolioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PortfolioRepository extends JpaRepository<PortfolioEntity, String> {
    PortfolioEntity findByTitle(String title);
    List<PortfolioEntity> findByUserId(String userId);
}
