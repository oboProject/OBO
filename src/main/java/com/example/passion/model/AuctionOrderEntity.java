package com.example.passion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class AuctionOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String auctionId;
    String userId;
    Date orderAt;
    Date deadline;
    int orderPrice;


}
