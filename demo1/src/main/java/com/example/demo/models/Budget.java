package com.example.demo.models;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class Budget {
    public int budgetId;
    int budgetAmount;
    List<Integer> users;
    Date startDate;

    public int getBudgetAmount() {
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

    Date endDate;

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