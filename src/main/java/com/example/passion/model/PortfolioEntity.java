package com.example.passion.model;

public class PortfolioEntity {
    String portfolioId;
    String title;
    String userId;//객체로 대체할것
    String description;//내용 간단하게 요약
    int views;
    int pick; // 좋아요
    String comment;//객체로 대체될것
    String categoryId;//객체로 대체될것 아니면 tag로 대체될 예정
    String auctionId;//겅매로 대체될것
    boolean public_flag;//공개로 설정하는 것을 확인하는 비트;

}
