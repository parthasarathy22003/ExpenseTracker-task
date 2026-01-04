package com.example.Task_TechLambdas.service.impl;


import java.time.LocalDate;

import com.example.Task_TechLambdas.exception.ResourceNotFoundException;
import com.example.Task_TechLambdas.model.Expense;
import com.example.Task_TechLambdas.repository.ExpenseRepository;
import com.example.Task_TechLambdas.service.ExpenseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository repository;

    public ExpenseServiceImpl(ExpenseRepository repository) {
        this.repository = repository;
    }

    @Override
    public Expense createExpense(Expense expense) {
        return repository.save(expense);
    }

    @Override
    public Expense getExpenseById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found"));
    }

    @Override
    public Expense updateExpense(String id, Expense expense) {
        Expense existing = getExpenseById(id);
        expense.setId(existing.getId());
        return repository.save(expense);
    }

    @Override
    public void deleteExpense(String id) {
        repository.delete(getExpenseById(id));
    }

    @Override
    public Page<Expense> listExpenses(String userId, String category, String paymentMode,
                                      LocalDate startDate, LocalDate endDate, Pageable pageable) {
        return repository.findByUserIdAndCategoryAndPaymentModeAndDateBetween(
                userId, category, paymentMode, startDate, endDate, pageable);
    }
}

