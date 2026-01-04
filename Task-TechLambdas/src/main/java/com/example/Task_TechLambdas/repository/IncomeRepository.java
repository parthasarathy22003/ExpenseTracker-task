package com.example.Task_TechLambdas.repository;

import java.util.List;

import com.example.Task_TechLambdas.model.Income;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface IncomeRepository extends MongoRepository<Income, String> {
    List<Income> findByUserId(String userId);
}

