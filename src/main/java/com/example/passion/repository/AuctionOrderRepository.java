package com.example.passion.repository;

import com.example.passion.model.post.AuctionOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionOrderRepository extends JpaRepository<AuctionOrderEntity, String> {
}
