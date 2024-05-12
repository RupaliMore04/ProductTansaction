package com.example.demo.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Transaction;
import com.example.demo.repository.TransactionRepository;

import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PieChartController {

    private final TransactionRepository transactionRepository;

    public PieChartController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("/api/pie-chart")
    public ResponseEntity<Map<String, Integer>> getPieChartData(@RequestParam int year, @RequestParam int month) {
        try {
            // Fetch transactions for the specified year and month
            List<Transaction> transactions = transactionRepository.findByDateOfSaleYearAndDateOfSaleMonth(year, month);

            // Collect unique categories and count occurrences of each category
            Map<String, Integer> categoryCounts = transactions.stream()
            		.collect(Collectors.groupingBy(Transaction:: getTitle, Collectors.summingInt(e -> 1)));
                  
            // Return category counts with OK status code
            return ResponseEntity.ok(categoryCounts);
        } catch (Exception e) {
            // Handle exceptions and return 500 Internal Server Error status code
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
