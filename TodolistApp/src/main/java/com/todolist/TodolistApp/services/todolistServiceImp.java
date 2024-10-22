package com.todolist.TodolistApp.services;

import com.todolist.TodolistApp.models.ToDoList;
import com.todolist.TodolistApp.repositories.TodolistRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class todolistServiceImp implements todolistService{

    @Autowired
    TodolistRepository todolistRepository;

    @Override
    public List<ToDoList> findAll() {
        return (List<ToDoList>) todolistRepository.findAll();
    }

    @Override
    public Optional<ToDoList> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public ToDoList save(ToDoList ToDoList) {
        return null;
    }

    @Override
    public Optional<ToDoList> update(Long id, ToDoList ToDoList) {
        return Optional.empty();
    }

    @Override
    public Optional<ToDoList> delete(Long id) {
        return Optional.empty();
    }
}
