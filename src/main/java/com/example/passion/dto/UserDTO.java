package com.example.passion.dto;

import com.example.passion.constant.Withdrawal;
import com.example.passion.model.post.PortfolioEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RequestUserDto{

        String userId;

        String displayName;

        String email;

        String password;

        String state;

        String city;

        String userInfo;

        String career;

        String education;

        String company;

    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResponseUserDto{

        String userId;

        String displayName;

        @Email
        String email;

        String password;

        String state;

        String city;

        String userInfo;

        String career;

        String education;

        String company;

        List<PortfolioEntity> portfolioEntities = new ArrayList<>();
    }


}
