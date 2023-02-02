package com.example.passion.repository;

import com.example.passion.model.post.PortfolioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class PortfolioRepositoryTestTest {

    @Autowired
    private PortfolioRepository portfolioRepository;

    private PortfolioEntity portfolioEntity;
}