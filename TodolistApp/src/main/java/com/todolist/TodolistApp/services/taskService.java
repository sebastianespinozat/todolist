package com.todolist.TodolistApp.services;

import com.todolist.TodolistApp.models.Task;

import java.util.List;
import java.util.Optional;

public interface taskService {

    Task save(Task task);
    List<Task> findAll();
    void delete(Long id);
    Optional<Task> findById(Long id);
}
