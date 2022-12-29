package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class EqualExpense implements Expense{

    private String paidUser;
    private Double amount;
    private List<String> users;

    @Override
    public List<SplitWiseExpense> splitExpence(Expense expense) {
        List<SplitWiseExpense>  splitedAmount = new ArrayList<>();
        int totalUser = users.size();
        double perUserAmount = (double) amount/(double)totalUser;
        for(String userId : users){
            if(userId!=paidUser) {
                splitedAmount.add(new SplitWiseExpense(userId, paidUser, Double.valueOf(String.format("%.2f", perUserAmount))));
            }
        }
        return splitedAmount;
    }
}
