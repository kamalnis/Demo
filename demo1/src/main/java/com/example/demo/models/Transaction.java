package com.example.demo.models;

import java.util.Date;

public class Transaction{
    public Category category;
    public int amount;
    Date createdAt;
    Integer addedBy;

    public Transaction(Category category, int amount, Integer userId) {
        this.category = category;
        this.amount = amount;
        createdAt = new Date();
        addedBy = userId;
    }
}
