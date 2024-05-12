package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Transaction;
import com.example.demo.repository.TransactionRepository;

import org.springframework.web.client.RestTemplate;
import org.springframework.transaction.annotation.Transactional;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Service
public class DatabaseInitializationService {
    
    @Autowired
    private TransactionRepository transactionRepository;

    @Transactional
    public void initializeDatabase() throws URISyntaxException, IOException {
        // Define the URL of the third-party API
        String apiUrl = "https://s3.amazonaws.com/roxiler.com/product_transaction.json";

        // Create a RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Make an HTTP GET request to the API and retrieve the JSON response
        URI uri = new URI(apiUrl);
        String json = restTemplate.getForObject(uri, String.class);

        // Parse the JSON response into an array of Transaction objects
        ObjectMapper objectMapper = new ObjectMapper();
        Transaction[] transactions = objectMapper.readValue(json, Transaction[].class);

        // Save the parsed transactions to the database
        for (Transaction transaction : transactions) {
            transactionRepository.save(transaction);
        }
    }
}

