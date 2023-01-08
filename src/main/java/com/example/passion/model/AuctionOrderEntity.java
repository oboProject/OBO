package com.example.passion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class AuctionOrderEntity {
    @Id
    String auctionId;
    String userId;
    Date orderAt;
    Date deadline;
    int orderPrice;


}
