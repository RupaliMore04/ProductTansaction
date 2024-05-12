package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Transaction;
import com.example.demo.repository.TransactionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

@RestController
public class TransactionController {

    private final TransactionRepository transactionRepository;

    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("/api/transactions")
    public ResponseEntity<List<Transaction>> getAllTransactions(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int perPage,
            @RequestParam(required = false) String searchText) {

        try {
            // Create Pageable object for pagination
            Pageable pageable = PageRequest.of(page - 1, perPage);

            // Fetch transactions based on search text if provided
            Page<Transaction> transactionPage;
            if (searchText != null && !searchText.isEmpty()) {
                transactionPage = transactionRepository.findByTitleContainingOrDescriptionContaining(searchText, searchText, pageable);
            } else {
                transactionPage = transactionRepository.findAll(pageable);
            }

            // Extract transactions from Page object
            List<Transaction> transactions = transactionPage.getContent();

            // Return transactions with appropriate status code
            return ResponseEntity.ok(transactions);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
