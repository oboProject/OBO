package com.example.passion.repository;

import com.example.passion.domain.post.AuctionOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionOrderRepository extends JpaRepository<AuctionOrderEntity, String> {
}
