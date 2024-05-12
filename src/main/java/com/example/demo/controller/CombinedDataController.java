package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.BarChartDataDTO;
import com.example.demo.dto.CombinedDataDTO;
import com.example.demo.dto.PieChartDataDTO;
import com.example.demo.dto.StatisticsDTO;
import com.example.demo.dto.TransactionDTO;


@RestController
public class CombinedDataController {

    @GetMapping("/api/combined-data")
    public ResponseEntity<CombinedDataDTO> getCombinedData() {
        try {
            // Fetch data from all required APIs
            RestTemplate restTemplate = new RestTemplate();
            TransactionDTO transactions = restTemplate.getForObject("http://localhost:8080/api/transactions", TransactionDTO.class);
            StatisticsDTO statistics = restTemplate.getForObject("http://localhost:8080/api/statistics", StatisticsDTO.class);
            BarChartDataDTO barChartData = restTemplate.getForObject("http://localhost:8080/api/bar-chart", BarChartDataDTO.class);
            PieChartDataDTO pieChartData = restTemplate.getForObject("http://localhost:8080/api/pie-chart", PieChartDataDTO.class);

            // Combine the responses into a single DTO
            CombinedDataDTO combinedData = new CombinedDataDTO(transactions, statistics, barChartData, pieChartData);

            // Return ResponseEntity with the combined data and OK status code
            return ResponseEntity.ok(combinedData);
        } catch (Exception e) {
            // Handle exceptions and return 500 Internal Server Error status code
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}

