package com.example.demo.repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> 
{
    Page<Transaction> findByTitleContainingOrDescriptionContaining(String title, String description, Pageable pageable);
    
    List<Transaction> findByDateOfSaleBetween(LocalDate startDate, LocalDate endDate);
    
    List<Transaction> findByDateOfSaleYearAndDateOfSaleMonth(int year, int month);
    
    //List<Transaction> findByMonth(String month);
    
    

}
