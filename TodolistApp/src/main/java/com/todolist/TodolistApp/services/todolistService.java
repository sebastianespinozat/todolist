package com.todolist.TodolistApp.services;

import com.todolist.TodolistApp.models.ToDoList;

import java.util.List;
import java.util.Optional;

public interface todolistService {

    List<ToDoList> findAll();

    Optional<ToDoList> findById(Long id);

    ToDoList save(ToDoList ToDoList);

    //Optional<ToDoList> update(Long id, ToDoList ToDoList);

    Optional<ToDoList> delete(Long id);
}
