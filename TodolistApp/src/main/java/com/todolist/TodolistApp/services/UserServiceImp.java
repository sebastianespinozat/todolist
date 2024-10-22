package com.todolist.TodolistApp.services;

import com.todolist.TodolistApp.models.User;
import com.todolist.TodolistApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public boolean existsByUsername(String username) {
        return false;
    }
}
