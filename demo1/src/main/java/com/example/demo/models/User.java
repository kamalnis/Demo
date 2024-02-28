package com.example.demo.models;

import java.util.Random;


public class User {
    private int uId;
    private String name;
    public User() {
        int minId = 1000;
        int maxId = Integer.MAX_VALUE;

        // Create a Random object
        Random random = new Random();

        // Generate a random ID within the specified range
         uId = random.nextInt(maxId - minId + 1) + minId;
    }

    public int getId() {
        return uId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }
}