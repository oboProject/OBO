package com.example.passion.model.post;

import com.example.passion.model.user.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
public class PortfolioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String portfolioId;

    @Column
    private String title;

    @ManyToOne
    @JoinColumn(name="userId")
    private UserEntity userId;//객체로 대체할것

    @Column
    private String description;//내용 간단하게 요약

    @Column
    private int views;

    @Column
    private int pick; // 좋아요

    @ManyToOne
    private UserEntity userEntity;

    public PortfolioEntity update(String title, String description, int views, int pick){
        this.title = title;
        this.description = description;
        this.views = views;
        this.pick = pick;

        return this;
    }

    @OneToMany
    @JoinColumn(name = "imageEntityId")
    List<ImageEntity> imageEntities = new ArrayList<>();

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