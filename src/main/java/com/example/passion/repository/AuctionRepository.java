package com.example.passion.repository;

import com.example.passion.model.post.AuctionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.beans.JavaBean;

public interface AuctionRepository extends JpaRepository<AuctionEntity,String> {
}
