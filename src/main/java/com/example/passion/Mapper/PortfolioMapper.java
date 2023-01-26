package com.example.passion.Mapper;

import com.example.passion.dto.PortfolioDTO;
import com.example.passion.model.post.PortfolioEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PortfolioMapper {

    PortfolioEntity responsePortfolioDtoToPortfolioEntity(PortfolioDTO.ResponsePortfolioDto responsePortfolioDto);
    PortfolioEntity requestPortfolioDtoToPortfolioEntity(PortfolioDTO.RequestPortfolioDto requestPortfolioDto);
    PortfolioDTO.RequestPortfolioDto responsePortfolioToRequestPortfolio(PortfolioDTO.ResponsePortfolioDto responsePortfolioDto);
    PortfolioDTO.ResponsePortfolioDto requestPortfolioToResponsePortfolio(PortfolioDTO.RequestPortfolioDto requestPortfolioDto);

}
