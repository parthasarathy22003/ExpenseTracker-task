package com.example.Task_TechLambdas.service;

import com.example.Task_TechLambdas.Dto.IncomeExpenseSummaryDto;
import com.example.Task_TechLambdas.Dto.TrendDto;

import java.util.List;


public interface AnalyticsService {

    List<TrendDto> dailyTrend(String userId);

    List<TrendDto> monthlyTrend(String userId);

    IncomeExpenseSummaryDto incomeVsExpense(String userId);
}

