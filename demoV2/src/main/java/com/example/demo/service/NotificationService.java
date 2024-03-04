package com.example.demo.service;

import com.example.demo.models.Budget;
import com.example.demo.models.Transaction;
import com.example.demo.models.User;
import com.example.demo.repo.BudgetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotificationService {
    @Autowired
    BudgetRepo budgetRepo;

    @Autowired
    UserService userService;
    public void onAddingTransaction(int budgetId, double totalExpenditure, Transaction transaction) {
        Budget budget = budgetRepo.get(budgetId);

        if(budget.getBudgetAmount() < totalExpenditure) {
            sendNotificationOnExceedingBudget(budget.getUsers());
        } else {
            sendNotificationToUsers(budget.getUsers(), transaction);
        }
    }

    private void sendNotificationOnExceedingBudget(List<Integer> userIds) {
        // Send exceeded budget notification to all user
        for(int userId : userIds) {
            System.out.println("Your budget has been exceeded");
        }
    }

    private void sendNotificationToUsers(List<Integer> userIds, Transaction transaction) {
        for(int userId : userIds) {
            // Will send notification to all user
            User user = userService.getUser(userId);
            System.out.println("User "+ user.getName() + " has expended "+ transaction.getAmount() +" on " + transaction.getCategory().name());
        }
    }
}
