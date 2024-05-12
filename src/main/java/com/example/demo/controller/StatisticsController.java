package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StatisticsDTO;
import com.example.demo.entity.Transaction;
import com.example.demo.repository.TransactionRepository;

import org.springframework.http.HttpStatus;
import java.time.LocalDate;
import java.util.List;

@RestController
public class StatisticsController {

    private final TransactionRepository transactionRepository;

    public StatisticsController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("/api/statistics")
    public ResponseEntity<StatisticsDTO> getStatistics(@RequestParam String month) {
        try {
            // Parse the month string to get the month and year
            LocalDate selectedMonth = LocalDate.parse(month + "-01");

            // Fetch transactions for the selected month
            List<Transaction> transactions = transactionRepository.findByDateOfSaleBetween(
                    selectedMonth.withDayOfMonth(1),
                    selectedMonth.withDayOfMonth(selectedMonth.lengthOfMonth())
            );

            // Calculate statistics
            double totalSaleAmount = 0;
            int totalSoldItems = 0;
            int totalNotSoldItems = 0;

            for (Transaction transaction : transactions) {
                totalSaleAmount += transaction.getPrice();
                if (transaction.getPrice() > 0) {
                    totalSoldItems++;
                } else {
                    totalNotSoldItems++;
                }
            }

            // Create StatisticsDTO object
            StatisticsDTO statisticsDTO = new StatisticsDTO(totalSaleAmount, totalSoldItems, totalNotSoldItems);

            // Return StatisticsDTO with OK status code
            return ResponseEntity.ok(statisticsDTO);
        } catch (Exception e) {
            // Handle exceptions and return 500 Internal Server Error status code
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}

