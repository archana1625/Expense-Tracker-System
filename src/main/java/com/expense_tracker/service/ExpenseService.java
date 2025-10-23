package com.expense_tracker.service;

import com.expense_tracker.entity.Expense;

import java.util.List;

public interface ExpenseService {
    Expense addExpense(Expense expense);

    Expense updateExpense(Expense expense);

    void deleteExpense(Long id);

    Expense getExpenseById(Long id);

    List<Expense> getExpensesByUserId(Integer userId);
}
