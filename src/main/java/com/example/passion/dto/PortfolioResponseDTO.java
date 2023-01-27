package com.example.passion.dto;

import com.example.passion.domain.user.UserEntity;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioResponseDTO {
    private String title;
    private UserEntity userId;//객체로 대체할것
    private String description;//내용 간단하게 요약

    private int views;
    private int pick; // 좋아요
}
