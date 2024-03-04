package com.example.demo.models;

import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Budget {
    public int budgetId;
    double budgetAmount;

    Currency currency;
    List<Integer> users;
    Date startDate;
    Date endDate;

    public int getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(int budgetId) {
        this.budgetId = budgetId;
    }

    public void setBudgetAmount(double budgetAmount) {
        this.budgetAmount = budgetAmount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getBudgetAmount() {
        return budgetAmount;
    }

    public void setBudgetAmount(int budgetAmount) {
        this.budgetAmount = budgetAmount;
    }

    public List<Integer> getUsers() {
        return users;
    }

    public void setUsers(List<Integer> users) {
        this.users = users;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Budget() {
        int minId = 1000;
        int maxId = Integer.MAX_VALUE;
        // Create a Random object
        Random random = new Random();
        // Generate a random ID within the specified range
        int randomId = random.nextInt(maxId - minId + 1) + minId;
        budgetId = randomId;
    }

//    public List<User> getUserList() {
//        return users;
//    }
}
