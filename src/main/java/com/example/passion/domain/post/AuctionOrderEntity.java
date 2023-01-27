package com.example.passion.domain.post;

import com.example.passion.domain.user.UserEntity;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class AuctionOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String auctionId;

    @OneToOne
    UserEntity userId;
    Date orderAt;
    Date deadline;
    int orderPrice;


}
