package com.example.passion.dto;

import com.example.passion.model.comment.CommentEntity;
import com.example.passion.model.etc.CategoryEntity;
import com.example.passion.model.post.AuctionEntity;
import com.example.passion.model.user.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

public class PortfolioDTO {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RequestPortfolioDto{

        String title;

        UserEntity userId;//객체로 대체할것

        String description;//내용 간단하게 요약

        int views;

        int pick; // 좋아요

    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResponsePortfolioDto{

        String title;

        UserEntity userId;//객체로 대체할것

        String description;//내용 간단하게 요약

        int views;

        int pick; // 좋아요

    }



}
