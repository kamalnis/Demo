package com.example.demo.repo;

import com.example.demo.models.Budget;
import com.example.demo.models.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserRepo {
    Map<Integer, User> userMap;
    public UserRepo() {
        userMap = new HashMap<>();
    }

    public User get(Integer userId) {
       return userMap.get(userId);
    }

    public void put(Integer userId, User user) {
        userMap.put(userId, user);
    }
}
