package com.example.demo.repo;

import com.example.demo.models.Budget;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserIdBudgetRepo {
    HashMap<Integer, List<Integer>> userIdBudgetMap;
    public UserIdBudgetRepo() {
        userIdBudgetMap = new HashMap<>();
    }

    public List<Integer> get(Integer userId) {
       return userIdBudgetMap.get(userId);
    }

    public void put(Integer userId, List<Integer> budgetIds) {
        userIdBudgetMap.put(userId, budgetIds);
    }
}
