package com.example.demo.service;

import com.example.demo.models.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class BudgetService {
    HashMap<Integer, Budget> budgetRepo;
    HashMap<Integer, List<Transaction>> transactionRepo;
    HashMap<Integer, Integer> userIdBudgetRepo;

   public  BudgetService() {
        budgetRepo = new HashMap<Integer, Budget>();
        transactionRepo = new HashMap<Integer, List<Transaction>>();
        userIdBudgetRepo =  new HashMap<Integer, Integer>() ;
   }
    public void addBudget(Budget budget) {
        budgetRepo.put(budget.budgetId, budget);
        userIdBudgetRepo.put(budget.getUsers().get(0), budget.budgetId);
        userIdBudgetRepo.put(budget.getUsers().get(1), budget.budgetId);
    }

    public void addTransaction(int budgetId, Transaction transaction) {
        List<Transaction> transactions = transactionRepo.get(budgetId);
       if(transactions == null) {
           transactions = new ArrayList<Transaction>();
           transactionRepo.put(budgetId, transactions);
       } else {
           transactions.add(transaction);
           transactionRepo.put(budgetId,transactions);
       }
    }

    public int getBudgetId(User user) {
       int budgetId = userIdBudgetRepo.get(user.getId());
       return budgetId;
    }

    public Budget getBudget(int userId) {
        int budgetId = userIdBudgetRepo.get(userId);
        return budgetRepo.get(budgetId);
    }

    public int getCurrentExpenditure(int userId) {
       int budgetId =  userIdBudgetRepo.get(userId);

       List<Transaction> transactions = transactionRepo.get(budgetId);
       int totalExpenditure = 0;
       for(int i=0; i < transactions.size(); i++) {
           totalExpenditure += transactions.get(i).amount;
       }

       return totalExpenditure;
    }
}