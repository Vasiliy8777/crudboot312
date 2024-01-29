package com.example.crud231.service;

import com.example.crud231.model.User;

import java.util.List;

public interface UserServ {
    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(User updatedUser);

    User getUserById(Long id);

    void deleteUser(Long id);
}

