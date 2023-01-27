package com.example.passion.mapper;

import com.example.passion.dto.PortfolioRequestDTO;
import com.example.passion.dto.PortfolioResponseDTO;
import com.example.passion.domain.post.PortfolioEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PortfolioMapper {
    PortfolioEntity portfolioResponseDtoToPortfolioEntity(PortfolioResponseDTO portfolioResponseDTO);
    PortfolioEntity portfolioRequestDtoToPortfolioEntity(PortfolioRequestDTO portfolioRequestDTO);
    PortfolioRequestDTO portfolioEntityToPortfolioRequestDto(PortfolioEntity portfolioEntity);
    PortfolioResponseDTO portfolioEntityToPortfolioResponseDto(PortfolioEntity portfolioEntity);
}
