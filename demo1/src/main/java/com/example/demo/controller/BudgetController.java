package com.example.demo.controller;


import com.example.demo.models.Budget;
import com.example.demo.models.Transaction;
import com.example.demo.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
class BudgetController{

    @Autowired
    BudgetService budgetService;
    @PostMapping("/budget")
    public Budget createBudget(@RequestBody Budget request) {
        budgetService.addBudget(request);
        return request;
    }

    @GetMapping("/user/budget/{userId}")
    public Budget getUserBudget(@PathVariable int userId) {
        return budgetService.getBudget(userId);
    }

    @GetMapping("/budget/{budgetId}")
    public Budget getBudget(@PathVariable int userId) {
        return budgetService.getBudget(userId);
    }

    @PostMapping("/transaction/{budgetId}")
    public Transaction addTransaction(@PathVariable int budgetId, @RequestBody Transaction transaction) {
         budgetService.addTransaction(budgetId, transaction);
         return transaction;
    }

    @GetMapping("/user/expenditure/{userId}")
    public int getTotalExpenditure(@PathVariable int userId) {
        return budgetService.getCurrentExpenditure(userId);
    }


}