package com.example.demo.managers;

import com.example.demo.models.SplitWiseExpense;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager {

    Map<String, Map<String, SplitWiseExpense>> perUserAmount = new HashMap<>();

    public void addNewExpense(List<SplitWiseExpense> expenseAmount){
        expenseAmount.forEach(expense ->{
            if(perUserAmount.containsKey(expense.getFrom())){
                if(perUserAmount.get(expense.getFrom()).containsKey(expense.getTo())){
                    double a = perUserAmount.get(expense.getFrom()).get(expense.getTo()).getAmount()+expense.getAmount();
                    perUserAmount.get(expense.getFrom()).get(expense.getTo()).setAmount(a);
                } else{
                    perUserAmount.get(expense.getFrom()).put(expense.getTo(), expense);
                }

            } else{
                Map<String, SplitWiseExpense> allexpense = new HashMap<>();
                allexpense.put(expense.getTo(), expense);
                perUserAmount.put(expense.getFrom(), allexpense);
            }
        });
    }

    public List<SplitWiseExpense> showPerUserExpense(String userId){
        List<SplitWiseExpense> expenses = new ArrayList<>();

        perUserAmount.forEach((u1,e1)->{
            if(e1!=null){
                e1.forEach((u2,v2)->{
                    if(u2==userId){
                        expenses.add(v2);
                    }
                });
            }
        });
        if(!perUserAmount.containsKey(userId)){
            return new ArrayList<>();
        }
        expenses.addAll(perUserAmount.get(userId).values());
        return expenses;
    }

    public List<SplitWiseExpense> showAllExpense(){
        List<SplitWiseExpense> expenses = new ArrayList<>();
        perUserAmount.forEach((userId, expense)->{
            expenses.addAll(expense.values());
        });
        return expenses;
    }
}
