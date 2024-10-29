package com.todolist.TodolistApp.controllers;

import com.todolist.TodolistApp.models.Task;
import com.todolist.TodolistApp.models.TodoList;
import com.todolist.TodolistApp.repositories.TaskRepository;
import com.todolist.TodolistApp.repositories.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TodoListRepository todoListRepository;

    @PostMapping("")
    public TodoList createToDoList(@RequestBody TodoList todoList){

        todoList.setTasks(todoList.getTasks());
        return todoListRepository.save(todoList);
    }

    @GetMapping("")
    public List<TodoList> getAllLists(){
        return (List<TodoList>) todoListRepository.findAll();
    }
}
