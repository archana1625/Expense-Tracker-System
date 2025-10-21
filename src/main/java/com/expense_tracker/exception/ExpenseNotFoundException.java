package com.expense_tracker.exception;

public class ExpenseNotFoundException extends RuntimeException {
    public ExpenseNotFoundException() {
        super();
    }

    public ExpenseNotFoundException(String message) {
        super(message);
    }
}
