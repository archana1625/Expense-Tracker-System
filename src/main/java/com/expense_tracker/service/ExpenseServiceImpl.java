package com.expense_tracker.service;

import com.expense_tracker.dao.ExpenseRepository;
import com.expense_tracker.entity.Expense;
import com.expense_tracker.exception.ExpenseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public Expense addExpense(Expense expense) {
       return expenseRepository.save(expense);
    }

    @Override
    public Expense updateExpense(Expense expense) {
        Expense existing = expenseRepository.findById(expense.getId())
                .orElseThrow(() -> new ExpenseNotFoundException("Expense not found with id: " + expense.getId()));
        existing.setDescription(expense.getDescription());
        existing.setAmount(expense.getAmount());
        existing.setExpenseDate(expense.getExpenseDate());
        existing.setCategory(expense.getCategory());
        return expenseRepository.save(existing);
    }

    @Override
    public void deleteExpense(Long id) {
        if (!expenseRepository.existsById(id)) {
            throw new ExpenseNotFoundException("Expense not found with id: " + id);
        }
        expenseRepository.deleteById(id);
    }

    @Override
    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id)
                .orElseThrow(() -> new ExpenseNotFoundException("Expense not found with id: " + id));
    }

    @Override
    public List<Expense> getExpensesByUserId(Integer userId) {
        return expenseRepository.findByUserId(userId);
    }
}
