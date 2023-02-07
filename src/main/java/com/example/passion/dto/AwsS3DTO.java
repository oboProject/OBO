package com.example.passion.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AwsS3DTO {
    private String key;
    private String path;

    public AwsS3DTO() {}

    @Builder
    public AwsS3DTO(String key, String path) {
        this.key = key;
        this.path = path;
    }
}
