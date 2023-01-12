package com.example.passion.repository;

import com.example.passion.model.post.PortfolioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository<PortfolioEntity, String> {
}
