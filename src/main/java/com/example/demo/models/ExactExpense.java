package com.example.demo.models;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class ExactExpense implements Expense{

    private String paidUser;
    private Double amount;
    private List<String> users;
    private List<Double> perUseramount;

    @Override
    public List<SplitWiseExpense> splitExpence(Expense expense) {
        List<SplitWiseExpense>  splitedAmount = new ArrayList<>();
        for(int i=0;i<users.size();i++){
            splitedAmount.add(new SplitWiseExpense(users.get(i), paidUser, Double.valueOf(String.format("%.2f",perUseramount.get(i)))));
        }
        return splitedAmount;
    }
}
