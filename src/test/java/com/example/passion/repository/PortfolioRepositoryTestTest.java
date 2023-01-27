package com.example.passion.repository;

import com.example.passion.domain.post.PortfolioEntity;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PortfolioRepositoryTestTest {

    @Autowired
    private PortfolioRepository portfolioRepository;

    private PortfolioEntity portfolioEntity;
}