package com.example.passion.model.post;

import jakarta.persistence.*;

@Entity
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String imageEntityId;

    @Column
    String fileName;

    @Column
    String fileURI;

    @ManyToOne
    PortfolioEntity portfolioEntity;
}
