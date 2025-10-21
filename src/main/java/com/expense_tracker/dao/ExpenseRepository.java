package com.expense_tracker.dao;

import com.expense_tracker.entity.Category;
import com.expense_tracker.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    // // Method to find all expenses by user ID
    // List<Expense> findByUserId(Long userId);
    //
    // // Method to find expenses by category
    // List<Expense> findByCategory(Category category);
    //
    // // Method to delete an expense by ID
    // void deleteById(Long id);

}
