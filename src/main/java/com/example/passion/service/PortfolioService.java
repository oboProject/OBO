package com.example.passion.service;

import com.example.passion.Mapper.PortfolioMapper;
import com.example.passion.dto.PortfolioDTO;
import com.example.passion.repository.PortfolioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PortfolioService implements PostCRUD<PortfolioDTO.RequestPortfolioDto, PortfolioDTO.ResponsePortfolioDto> {

    PortfolioRepository portfolioRepository;
    PortfolioMapper mapper;



    @Override
    public PortfolioDTO.RequestPortfolioDto createPost(PortfolioDTO.ResponsePortfolioDto responsePortfolioDto) {


        return null;
    }

    @Override
    public PortfolioDTO.RequestPortfolioDto deletePost(PortfolioDTO.ResponsePortfolioDto responsePortfolioDto) {

        return null;
    }

    @Override
    public PortfolioDTO.RequestPortfolioDto modifyPost(PortfolioDTO.ResponsePortfolioDto responsePortfolioDto) {

        return null;
    }

    @Override
    public List<PortfolioDTO.RequestPortfolioDto> getPost(PortfolioDTO.ResponsePortfolioDto responsePortfolioDto) {

        return null;
    }


}
