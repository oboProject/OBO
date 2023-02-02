package com.example.passion.dto;

import com.example.passion.model.user.UserEntity;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

public class PortfolioDTO {
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RequestPortfolioDTO {

        private String portfolioId;
        private String title;
        private UserEntity userId;//객체로 대체할것
        private String description;//내용 간단하게 요약
        private int views;
        private int pick; // 좋아요
        List<ImageDTO.RequestImageDTO> requestImageDTOS = new ArrayList<>();
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResponsePortfolioDTO {
        private String title;
        private UserEntity userId;//객체로 대체할것
        private String description;//내용 간단하게 요약
        private int views;
        private int pick; // 좋아요
        List<ImageDTO.ResponseImageDTO> responseImageDTOS;
    }
}
