package com.example.passion.controller;

import com.example.passion.dto.AwsS3DTO;
import com.example.passion.service.AwsS3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/s3")
@RequiredArgsConstructor
public class AwsS3Controller {

    private final AwsS3Service awsS3Service;

    @PostMapping("/resource")
    public AwsS3DTO upload(@RequestPart("file") MultipartFile multipartFile) throws IOException {
        return awsS3Service.upload(multipartFile, "upload");
    }

    @DeleteMapping("/resource")
    public void remove(AwsS3DTO awsS3DTO) {
        awsS3Service.remove(awsS3DTO);
    }
}
