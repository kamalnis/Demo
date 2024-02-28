package com.example.demo.service;

import com.example.demo.models.Budget;
import com.example.demo.models.Transaction;
import com.example.demo.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class UserService {
    HashMap<Integer, User> userRepo;

   public UserService() {
       userRepo = new HashMap<Integer, User>();
   }
    public User addUser(User user) {
        userRepo.put(user.getId(), user);
        return user;
    }


    public User getUser(int userId) {
        return userRepo.get(userId);
    }
}