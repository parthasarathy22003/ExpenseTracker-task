package com.example.Task_TechLambdas.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.example.Task_TechLambdas.Dto.IncomeExpenseSummaryDto;
import com.example.Task_TechLambdas.Dto.TrendDto;
import com.example.Task_TechLambdas.repository.ExpenseRepository;
import com.example.Task_TechLambdas.repository.IncomeRepository;
import com.example.Task_TechLambdas.service.AnalyticsService;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsServiceImpl implements AnalyticsService {

    private final ExpenseRepository expenseRepository;
    private final IncomeRepository incomeRepository;

    public AnalyticsServiceImpl(ExpenseRepository expenseRepository,
                                IncomeRepository incomeRepository) {
        this.expenseRepository = expenseRepository;
        this.incomeRepository = incomeRepository;
    }

    @Override
    public List<TrendDto> dailyTrend(String userId) {
        return expenseRepository.findByUserId(userId).stream()
                .collect(Collectors.groupingBy(e -> e.getDate().toString(),
                        Collectors.summingDouble(e -> e.getAmount())))
                .entrySet().stream()
                .map(e -> new TrendDto(e.getKey(), e.getValue()))
                .toList();
    }

    @Override
    public List<TrendDto> monthlyTrend(String userId) {
        return expenseRepository.findByUserId(userId).stream()
                .collect(Collectors.groupingBy(e -> e.getDate().getMonth().toString(),
                        Collectors.summingDouble(e -> e.getAmount())))
                .entrySet().stream()
                .map(e -> new TrendDto(e.getKey(), e.getValue()))
                .toList();
    }

    @Override
    public IncomeExpenseSummaryDto incomeVsExpense(String userId) {
        double income = incomeRepository.findByUserId(userId)
                .stream().mapToDouble(i -> i.getAmount()).sum();

        double expense = expenseRepository.findByUserId(userId)
                .stream().mapToDouble(e -> e.getAmount()).sum();

        return new IncomeExpenseSummaryDto(income, expense);
    }
}

