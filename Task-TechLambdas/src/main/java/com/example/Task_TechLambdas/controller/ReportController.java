package com.example.Task_TechLambdas.controller;

import com.example.Task_TechLambdas.service.ReportService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final ReportService service;

    public ReportController(ReportService service) {
        this.service = service;
    }

    @GetMapping("/monthly")
    public Object monthly(@RequestParam String userId) {
        return service.monthlySummary(userId);
    }

    @GetMapping("/category")
    public Object category(@RequestParam String userId) {
        return service.categorySummary(userId);
    }

    @GetMapping("/payment-mode")
    public Object paymentMode(@RequestParam String userId) {
        return service.paymentModeSummary(userId);
    }
}

