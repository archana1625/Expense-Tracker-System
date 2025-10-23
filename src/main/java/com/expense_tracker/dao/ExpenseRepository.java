package com.expense_tracker.dao;

import com.expense_tracker.entity.Category;
import com.expense_tracker.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    // Method to find all expenses by user ID
    List<Expense> findByUserId(Integer userId);

    // Method to find expenses by category
    List<Expense> findByCategory(Category category);

    // Method to delete an expense by ID
    void deleteById(Long id);

}
