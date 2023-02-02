package com.example.passion.service;

import com.example.passion.dto.ImageDTO;

public interface ImageHandler {
    ImageDTO.BuffImageDTO uploadImage(ImageDTO.RequestImageDTO requestImageDTO);
    ImageDTO.BuffImageDTO readImage(ImageDTO.RequestImageDTO requestImageDTO);
    ImageDTO.BuffImageDTO updateImage(ImageDTO.RequestImageDTO requestImageDTO);
    ImageDTO.BuffImageDTO deleteImage(ImageDTO.RequestImageDTO requestImageDTO);
}
