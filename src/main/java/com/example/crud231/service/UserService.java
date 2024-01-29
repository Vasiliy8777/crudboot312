package com.example.crud231.service;

import com.example.crud231.dao.UserDao;
import com.example.crud231.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.crud231.repository.UserRepository;

import java.util.List;

@Service
public class UserService implements UserServ {
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }
    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }
    @Override
    public void updateUser(User updatedUser) {
        userDao.updateUser(updatedUser);
    }
}
