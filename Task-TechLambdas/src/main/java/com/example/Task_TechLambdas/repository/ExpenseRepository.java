package com.example.Task_TechLambdas.repository;

import java.time.LocalDate;
import java.util.List;

import com.example.Task_TechLambdas.model.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface ExpenseRepository extends MongoRepository<Expense, String> {

    Page<Expense> findByUserIdAndCategoryAndPaymentModeAndDateBetween(
            String userId,
            String category,
            String paymentMode,
            LocalDate startDate,
            LocalDate endDate,
            Pageable pageable
    );

    List<Expense> findByUserId(String userId);
}
