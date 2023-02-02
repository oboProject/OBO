package com.example.passion.mapper;

import com.example.passion.dto.ImageDTO;
import com.example.passion.model.post.ImageEntity;

public interface ImageMapper {
    ImageEntity buffImageDtoToImageEntity(ImageDTO.BuffImageDTO buffImageDTO);
}
