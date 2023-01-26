package com.example.passion.model.post;

import com.example.passion.model.etc.CategoryEntity;
import com.example.passion.model.user.UserEntity;
import com.example.passion.model.comment.CommentEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class PortfolioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String portfolioId;

    @Column
    String title;

    @ManyToOne
    @JoinColumn(name="userId")
    UserEntity userId;//객체로 대체할것

    @Column
    String description;//내용 간단하게 요약

    @Column
    int views;

    @Column
    int pick; // 좋아요

    @ManyToOne
    UserEntity userEntity;

//
//    @OneToMany(mappedBy = "portfolioEntity")
//    List<CommentEntity> commentEntityList =  new ArrayList<>();//객체로 대체될것
//
//    @OneToOne
//    @JoinColumn(name="categoryId")
//    CategoryEntity categoryId;//객체로 대체될것 아니면 tag로 대체될 예정
//
//    @OneToOne
//    @JoinColumn(name="auctionId")
//    AuctionEntity auctionId;//겅매로 대체될것
//
//    boolean public_flag;//공개로 설정하는 것을 확인하는 비트;

}
