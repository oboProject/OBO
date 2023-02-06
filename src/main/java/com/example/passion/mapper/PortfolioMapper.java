package com.example.passion.mapper;

import com.example.passion.dto.PortfolioDTO;
import com.example.passion.model.post.PortfolioEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PortfolioMapper {
    PortfolioEntity portfolioResponseDtoToPortfolioEntity(PortfolioDTO.ResponsePortfolioDTO responsePortfolioDTO);
    PortfolioEntity portfolioRequestDtoToPortfolioEntity(PortfolioDTO.RequestPortfolioDTO portfolioRequestDTO);
    PortfolioDTO.RequestPortfolioDTO portfolioEntityToPortfolioRequestDto(PortfolioEntity portfolioEntity);
    PortfolioDTO.ResponsePortfolioDTO portfolioEntityToPortfolioResponseDto(PortfolioEntity portfolioEntity);
}
