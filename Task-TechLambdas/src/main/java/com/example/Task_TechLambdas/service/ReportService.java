package com.example.Task_TechLambdas.service;


import com.example.Task_TechLambdas.Dto.CategorySummaryDto;
import com.example.Task_TechLambdas.Dto.ExpenseSummaryDto;
import com.example.Task_TechLambdas.Dto.PaymentModeSummaryDto;

import java.util.List;

public interface ReportService {

    List<ExpenseSummaryDto> monthlySummary(String userId);

    List<CategorySummaryDto> categorySummary(String userId);

    List<PaymentModeSummaryDto> paymentModeSummary(String userId);
}

