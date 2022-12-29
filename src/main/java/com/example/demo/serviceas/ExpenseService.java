package com.example.demo.serviceas;

import com.example.demo.managers.ExpenseManager;
import com.example.demo.models.Expense;
import com.example.demo.models.SplitWiseExpense;

import java.util.List;

public class ExpenseService {

    ExpenseManager expenseManager;
    public final String NO_BALANCE = "No balance";

    public ExpenseService(ExpenseManager expenseManager){
        this.expenseManager=expenseManager;
    }

    public void addNewExpense(Expense expense){
        List<SplitWiseExpense> list = expense.splitExpence(expense);
        expenseManager.addNewExpense(list);
    }

    public void showPerUserExpense(String userId){
        List<SplitWiseExpense> list = expenseManager.showPerUserExpense(userId);
        if(list.size()==0){
            System.out.println(NO_BALANCE);
        }
        list.forEach(expense-> System.out.println(expense.toString()));
    }

    public void showAllExpense(){
        List<SplitWiseExpense> list = expenseManager.showAllExpense();
        if(list.size()==0){
            System.out.println(NO_BALANCE);
        }
        list.forEach(expense-> System.out.println(expense.toString()));
    }
}
