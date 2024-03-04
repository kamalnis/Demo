package com.example.demo.repo;

import com.example.demo.models.Budget;
import com.example.demo.models.Transaction;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TransactionRepo {
    HashMap<Integer, List<Transaction>> transactionMap;
    public TransactionRepo() {
        transactionMap = new HashMap<>();
    }

    public List<Transaction> get(Integer transactionId) {
       return transactionMap.get(transactionId);
    }

    public void put(Integer transactionId,  List<Transaction> transactionList) {
        transactionMap.put(transactionId, transactionList);
    }
}
