package com.example.Task_TechLambdas.Dto;

public class IncomeExpenseSummaryDto {
    private Double totalIncome;
    private Double totalExpense;
    private Double balance;

    public IncomeExpenseSummaryDto(Double totalIncome, Double totalExpense) {
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
        this.balance = totalIncome - totalExpense;
    }

    public Double getTotalIncome() { return totalIncome; }
    public Double getTotalExpense() { return totalExpense; }
    public Double getBalance() { return balance; }
}
