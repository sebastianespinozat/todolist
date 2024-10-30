package com.todolist.TodolistApp.services;

import com.todolist.TodolistApp.models.TodoList;
import com.todolist.TodolistApp.repositories.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TodoListService {


    List<TodoList> findAll();
    Optional<TodoList> findById(Long id);
    TodoList createTodoList(TodoList todoList);
    List<TodoList> getAllTodoLists();
    Optional<TodoList> deleteTodoList(Long id);
    Optional<TodoList> updateTodoList(Long id, TodoList todoList);
    
}
