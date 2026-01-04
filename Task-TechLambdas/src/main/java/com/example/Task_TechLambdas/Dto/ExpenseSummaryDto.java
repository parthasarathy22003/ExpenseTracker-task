package com.example.Task_TechLambdas.Dto;

public class ExpenseSummaryDto {
    private String key;
    private Double total;

    public ExpenseSummaryDto(String key, Double total) {
        this.key = key;
        this.total = total;
    }

    public String getKey() { return key; }
    public Double getTotal() { return total; }
}

