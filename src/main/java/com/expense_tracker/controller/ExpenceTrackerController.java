package com.expense_tracker.controller;

import com.expense_tracker.entity.User;
import com.expense_tracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/expenses")
public class ExpenceTrackerController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public String ListAllUser() {
        User user = userService.findUserByUsername("arch123");
        return user.getUsername();
    }

    // Register a new user
    @PostMapping("/user/register")
    public User registerUser(@Valid @RequestBody User user) {

        return userService.registerUser(user);
    }

    // Get user by username
    @GetMapping("/user/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.findUserByUsername(username);
    }

    // Update user
    @PutMapping("/user")
    public void updateUser(@Valid @RequestBody User user) {
        userService.updateUser(user);
    }

    // Delete user
    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    // Authenticate user (returns true/false)
    @PostMapping("/user/authenticate")
    public boolean authenticate(@Valid @RequestBody AuthRequest authRequest) {
        return userService.authenticateUser(authRequest.getUsername(), authRequest.getPassword());
    }
}

// Simple DTO for authentication request
class AuthRequest {
    @jakarta.validation.constraints.NotBlank(message = "username is required")
    private String username;

    @jakarta.validation.constraints.NotBlank(message = "password is required")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
