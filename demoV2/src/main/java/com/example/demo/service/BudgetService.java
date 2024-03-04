package com.example.demo.service;

import com.example.demo.models.*;
import com.example.demo.repo.BudgetRepo;
import com.example.demo.repo.TransactionRepo;
import com.example.demo.repo.UserIdBudgetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BudgetService {
    @Autowired
    BudgetRepo budgetRepo;

    @Autowired
    TransactionRepo transactionRepo;

    @Autowired
    UserIdBudgetRepo userIdBudgetRepo;

    @Autowired
    NotificationService notificationService;
    public void addBudget(Budget budget) throws Exception{
        for(int i=0; i<budget.getUsers().size(); i++) {
            List<Integer> userBudgetIds = userIdBudgetRepo.get(budget.getUsers().get(i));
            Date currentDate = new Date();

            for(int budgetId : userBudgetIds) {
                Budget userBudget = budgetRepo.get(budgetId);
                if(userBudget != null) {
                    if (userBudget.getEndDate().after(currentDate)) {
                        throw new Exception("Already one budget has been created");
                    }
                }
            }
        }

        for(int i=0; i<budget.getUsers().size(); i++) {
            int userId = budget.getUsers().get(i);
            List<Integer> userBudgetIds = userIdBudgetRepo.get(userId);

            if(userBudgetIds == null) {
                userBudgetIds = new ArrayList<>();
            }
            userBudgetIds.add(budget.budgetId);
            userIdBudgetRepo.put(userId, userBudgetIds);
        }
        budgetRepo.put(budget.budgetId, budget);
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

       Double totalExpenditure = getTotalExpenditure(budgetId, null);
       notificationService.onAddingTransaction(budgetId, totalExpenditure, transaction);
    }

    public Budget getBudget(int userId) {
        List<Integer> budgetIds = userIdBudgetRepo.get(userId);
        int budgetId = budgetIds.get(budgetIds.size() - 1);
        return budgetRepo.get(budgetId);
    }

    public int getCurrentExpenditureByUserId(int userId) {
        List<Integer> budgetIds = userIdBudgetRepo.get(userId);
        int budgetId = budgetIds.get(budgetIds.size() - 1);

       List<Transaction> transactions = transactionRepo.get(budgetId);
       int totalExpenditure = 0;
       for(Transaction transaction : transactions) {
           if(transaction.getAddedBy() == userId)
               totalExpenditure += transaction.amount;
       }

       return totalExpenditure;
    }

    public double getCurrentTotalExpenditure(int userId) {
        List<Integer> budgetIds = userIdBudgetRepo.get(userId);
        int budgetId = budgetIds.get(budgetIds.size() - 1);

        List<Transaction> transactions = transactionRepo.get(budgetId);
        double totalExpenditure = 0;
        for(Transaction transaction : transactions) {
            totalExpenditure += transaction.amount;
        }

        return totalExpenditure;
    }


    public double getTotalExpenditure(Integer budgetId, Integer userId) {
        List<Transaction> transactions = transactionRepo.get(budgetId);
        double totalExpenditure = 0;
        for(Transaction transaction : transactions) {
            if(userId == null) {
                totalExpenditure += transaction.amount;
            } else if(transaction.getAddedBy() == userId){
                totalExpenditure += transaction.amount;
            }
        }

        return totalExpenditure;
    }

    public Map<Category, Double> getCurrentTotalExpenditureByCategory(Integer userId) {
        List<Integer> budgetIds = userIdBudgetRepo.get(userId);
        int budgetId = budgetIds.get(budgetIds.size() - 1);
        return getTotalExpenditureByCategory(budgetId, userId);
    }

    public Map<Category, Double> getTotalExpenditureByCategory(Integer budgetId, Integer userId) {
        List<Transaction> transactions = transactionRepo.get(budgetId);
        Map<Category, Double> categoryTransactionMap = new HashMap<>();
        double totalExpenditure = 0;
        for(Transaction transaction : transactions) {
            if(categoryTransactionMap.get(transaction.getCategory()) == null) {
                categoryTransactionMap.put(transaction.getCategory(), 0.0);
            }
            if(userId == null) {
                categoryTransactionMap.put(transaction.getCategory(),  categoryTransactionMap.get(transaction.getCategory()) + transaction.getAmount());
            } else if(transaction.getAddedBy() == userId){
                categoryTransactionMap.put(transaction.getCategory(),  categoryTransactionMap.get(transaction.getCategory()) + transaction.getAmount());
            }
        }

        return categoryTransactionMap;
    }

}