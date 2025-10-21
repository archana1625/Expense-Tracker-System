package com.expense_tracker.dao;

import com.expense_tracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Long> {

    // Method to find a user by username
    User findByUsername(String username);

    // Method to check if a user exists by username
    boolean existsByUsername(String username);

    // Method to check if a user exists by email
    boolean existsByEmail(String email);
}
