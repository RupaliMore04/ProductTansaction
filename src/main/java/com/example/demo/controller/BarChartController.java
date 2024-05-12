package com.example.demo.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Transaction;
import com.example.demo.repository.TransactionRepository;

import org.springframework.http.HttpStatus;
import java.util.HashMap;
import java.util.List;

@RestController
public class BarChartController {

    private final TransactionRepository transactionRepository;

    public BarChartController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("/api/bar-chart")
    public ResponseEntity<Map<String, Integer>> getBarChartData(@RequestParam int year, @RequestParam int month) {
        try {
            // Fetch transactions for the specified year and month
            List<Transaction> transactions = transactionRepository.findByDateOfSaleYearAndDateOfSaleMonth(year, month);


            // Initialize price ranges and counts
            Map<String, Integer> priceRanges = initializePriceRanges();
            
            // Calculate number of items in each price range
            for (Transaction transaction : transactions) {
                double price = transaction.getPrice();
                String range = getPriceRange(price);
                priceRanges.put(range, priceRanges.getOrDefault(range, 0) + 1);
            }

            // Return price ranges and counts with OK status code
            return ResponseEntity.ok(priceRanges);
        } catch (Exception e) {
            // Handle exceptions and return 500 Internal Server Error status code
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Initialize price ranges
    private Map<String, Integer> initializePriceRanges() {
        Map<String, Integer> priceRanges = new HashMap<>();
        priceRanges.put("0-100", 0);
        priceRanges.put("101-200", 0);
        priceRanges.put("201-300", 0);
        // Add more price ranges as needed
        return priceRanges;
    }

    // Determine price range based on the price
    private String getPriceRange(double price) {
        if (price >= 0 && price <= 100) {
            return "0-100";
        } else if (price > 100 && price <= 200) {
            return "101-200";
        } else if (price > 200 && price <= 300) {
            return "201-300";
        } 
        // Add more conditions for other price ranges
        else {
            return "301-above";
        }
    }
}

