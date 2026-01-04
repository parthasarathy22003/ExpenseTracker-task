package com.example.Task_TechLambdas.Dto;

public class PaymentModeSummaryDto {
    private String paymentMode;
    private Double total;

    public PaymentModeSummaryDto(String paymentMode, Double total) {
        this.paymentMode = paymentMode;
        this.total = total;
    }

    public String getPaymentMode() { return paymentMode; }
    public Double getTotal() { return total; }
}

