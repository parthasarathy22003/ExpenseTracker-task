package com.example.Task_TechLambdas.Dto;

public class TrendDto {
    private String period;
    private Double total;

    public TrendDto(String period, Double total) {
        this.period = period;
        this.total = total;
    }

    public String getPeriod() { return period; }
    public Double getTotal() { return total; }
}

