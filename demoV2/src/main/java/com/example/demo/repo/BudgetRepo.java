package com.example.demo.repo;

import com.example.demo.models.Budget;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class BudgetRepo {
    Map<Integer, Budget> budgetMap;
    public BudgetRepo() {
        budgetMap = new HashMap<>();
    }

    public Budget get(Integer budgetId) {
       return budgetMap.get(budgetId);
    }

    public void put(Integer budgetId, Budget budget) {
        budgetMap.put(budgetId, budget);
    }
}
