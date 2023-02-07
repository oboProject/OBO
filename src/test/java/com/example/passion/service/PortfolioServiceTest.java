package com.example.passion.service;

import com.example.passion.repository.PortfolioRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PortfolioServiceTest {

    @Autowired PortfolioService portfolioService;
    @Autowired PortfolioRepository portfolioRepository;

    @BeforeEach
    public void beforeEach() {
    }

    @Test
    public void create() throws Exception {
        //Given
        //When
        //Then
    }

    @Test
    public void delete() throws Exception {
        //Given
        //When
        //Then
    }

    @Test
    public void modify() throws Exception {
        //Given
        //When
        //Then
    }

    @Test
    public void read() throws Exception{
        //Given
        //When
        //Then
    }

    @Test
    public void readAll() throws Exception {
        //Given
        //When
        //Then
    }
}