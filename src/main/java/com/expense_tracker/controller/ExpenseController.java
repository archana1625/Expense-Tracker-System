package com.expense_tracker.controller;

import com.expense_tracker.entity.Expense;
import com.expense_tracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public Expense addExpense(@Valid @RequestBody Expense expense) {
        return expenseService.addExpense(expense);
    }

    @PutMapping
    public Expense updateExpense(@Valid @RequestBody Expense expense) {
        return expenseService.updateExpense(expense);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Integer id) {
        expenseService.deleteExpense(id);
    }

    @GetMapping("/{id}")
    public Expense getExpense(@PathVariable Integer id) {
        return expenseService.getExpenseById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Expense> getExpensesByUser(@PathVariable Integer userId) {
        return expenseService.getExpensesByUserId(userId);
    }
}
