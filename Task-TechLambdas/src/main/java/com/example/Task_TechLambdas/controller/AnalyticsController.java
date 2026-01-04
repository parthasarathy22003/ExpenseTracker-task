package com.example.Task_TechLambdas.controller;

import com.example.Task_TechLambdas.service.AnalyticsService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    private final AnalyticsService service;

    public AnalyticsController(AnalyticsService service) {
        this.service = service;
    }

    @GetMapping("/daily-trend")
    public Object daily(@RequestParam String userId) {
        return service.dailyTrend(userId);
    }

    @GetMapping("/monthly-trend")
    public Object monthly(@RequestParam String userId) {
        return service.monthlyTrend(userId);
    }

    @GetMapping("/income-vs-expense")
    public Object summary(@RequestParam String userId) {
        return service.incomeVsExpense(userId);
    }
}

