package com.example.passion.constant;

public enum Withdrawal {
    WITHDRAWAL("withdrawal"),
    DORMANT("dormant"),
    ;

    private String with;

    Withdrawal(String with){
        this.with = with;
    }

    public String getWith() {
        return with;
    }
}
