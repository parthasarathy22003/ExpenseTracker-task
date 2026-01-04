package com.example.Task_TechLambdas.service;
import com.example.Task_TechLambdas.model.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.time.LocalDate;

public interface ExpenseService {

    Expense createExpense(Expense expense);

    Expense getExpenseById(String id);

    Expense updateExpense(String id, Expense expense);

    void deleteExpense(String id);

    Page<Expense> listExpenses(
            String userId,
            String category,
            String paymentMode,
            LocalDate startDate,
            LocalDate endDate,
            Pageable pageable
    );
}

