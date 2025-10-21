package com.expense_tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class ExpenseTrackerSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerSystemApplication.class, args);
	}

}
