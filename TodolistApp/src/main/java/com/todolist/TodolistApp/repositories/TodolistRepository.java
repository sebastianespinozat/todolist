package com.todolist.TodolistApp.repositories;

import com.todolist.TodolistApp.models.ToDoList;
import com.todolist.TodolistApp.models.User;
import org.springframework.data.repository.CrudRepository;

public interface TodolistRepository extends CrudRepository<ToDoList, Long> {
}
