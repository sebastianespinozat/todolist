package com.todolist.TodolistApp.services;

import com.todolist.TodolistApp.models.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User save(User user);

    boolean existsByUsername(String username);

    void delete(User user);
}
