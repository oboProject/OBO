package com.example.passion.model.post;

import com.example.passion.model.etc.CategoryEntity;
import com.example.passion.model.etc.TagEntity;
import com.example.passion.model.user.UserEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class AuctionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String portfolioId;// 포트 폴리오 f key
    String title; //제목

    @ManyToOne
    @JoinColumn(name="userId")
    UserEntity userId;

    int view;
    Date deadline;
    @OneToMany
    List<TagEntity> tagEntityList = new ArrayList<>();

    @OneToOne
    @JoinColumn(name="categoryId")
    CategoryEntity categoryId;

    int startPrice;
    int maxPrice;

}