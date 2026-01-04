package com.example.Task_TechLambdas.service.impl;


import java.util.List;
import java.util.stream.Collectors;

import com.example.Task_TechLambdas.Dto.CategorySummaryDto;
import com.example.Task_TechLambdas.Dto.ExpenseSummaryDto;
import com.example.Task_TechLambdas.Dto.PaymentModeSummaryDto;
import com.example.Task_TechLambdas.repository.ExpenseRepository;
import com.example.Task_TechLambdas.service.ReportService;
import org.springframework.stereotype.Service;



@Service
public class ReportServiceImpl implements ReportService {

    private final ExpenseRepository repository;

    public ReportServiceImpl(ExpenseRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ExpenseSummaryDto> monthlySummary(String userId) {
        return repository.findByUserId(userId).stream()
                .collect(Collectors.groupingBy(e -> e.getDate().getMonth().toString(),
                        Collectors.summingDouble(e -> e.getAmount())))
                .entrySet().stream()
                .map(e -> new ExpenseSummaryDto(e.getKey(), e.getValue()))
                .toList();
    }

    @Override
    public List<CategorySummaryDto> categorySummary(String userId) {
        return repository.findByUserId(userId).stream()
                .collect(Collectors.groupingBy(e -> e.getCategory(),
                        Collectors.summingDouble(e -> e.getAmount())))
                .entrySet().stream()
                .map(e -> new CategorySummaryDto(e.getKey(), e.getValue()))
                .toList();
    }

    @Override
    public List<PaymentModeSummaryDto> paymentModeSummary(String userId) {
        return repository.findByUserId(userId).stream()
                .collect(Collectors.groupingBy(e -> e.getPaymentMode(),
                        Collectors.summingDouble(e -> e.getAmount())))
                .entrySet().stream()
                .map(e -> new PaymentModeSummaryDto(e.getKey(), e.getValue()))
                .toList();
    }
}

