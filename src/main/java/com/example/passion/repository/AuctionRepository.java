package com.example.passion.repository;

import com.example.passion.domain.post.AuctionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionRepository extends JpaRepository<AuctionEntity,String> {
}
