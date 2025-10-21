package com.expense_tracker.service;

import com.expense_tracker.entity.User;
import org.springframework.stereotype.Service;


public interface UserService {

    User registerUser(User user);
    User findUserByUsername(String username);
    void updateUser(User user);
    void deleteUser(Long userId);
    boolean authenticateUser(String username, String password);
}
