package com.example.demo.models;

import lombok.Getter;

import java.util.List;
import java.util.Map;

public interface Expense {
    List<SplitWiseExpense> splitExpence(Expense expense);
}
