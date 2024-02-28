package com.example.demo.models;

import java.util.Date;

public class Transaction{
    public Category category;
    public int amount;
    Date createdAt;
    User addedBy;

    public Transaction(Category category, int amount, User user) {
        this.category = category;
        this.amount = amount;
        createdAt = new Date();
        addedBy = user;
    }
}