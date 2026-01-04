package com.example.Task_TechLambdas.controller;


import java.time.LocalDate;

import com.example.Task_TechLambdas.model.Expense;
import com.example.Task_TechLambdas.service.ExpenseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @PostMapping
    public Expense create(@RequestBody Expense expense) {
        return service.createExpense(expense);
    }

    @GetMapping("/{id}")
    public Expense getById(@PathVariable String id) {
        return service.getExpenseById(id);
    }

    @PutMapping("/{id}")
    public Expense update(@PathVariable String id, @RequestBody Expense expense) {
        return service.updateExpense(id, expense);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.deleteExpense(id);
    }

    @GetMapping
    public Page<Expense> list(
            @RequestParam String userId,
            @RequestParam String category,
            @RequestParam String paymentMode,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate,
            Pageable pageable) {

        return service.listExpenses(userId, category, paymentMode, startDate, endDate, pageable);
    }
}
