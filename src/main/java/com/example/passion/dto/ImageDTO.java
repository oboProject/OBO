package com.example.passion.dto;

import org.springframework.web.multipart.MultipartFile;

public class ImageDTO {

    public static class RequestImageDTO{
        MultipartFile multipartFile;
    }

    public static class ResponseImageDTO{
        String imageEntityId;
        String fileName;
        String fileURI;
    }
    //todo AMAZON S3 bucket 과 통신하기 위해서 사용할 DTO 이고 S3SERVICE 를 이용해서 사용할 것
    public static class BuffImageDTO{
        String fileName;
        String fileURI;
    }


}
