package com.example.demo.models;

import java.util.Date;

public class Transaction{
    public Category category;
    public double amount;
    Date createdAt;
    Integer addedBy;

    public Transaction(Category category, int amount, Integer userId) {
        this.category = category;
        this.amount = amount;
        createdAt = new Date();
        addedBy = userId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(Integer addedBy) {
        this.addedBy = addedBy;
    }
}