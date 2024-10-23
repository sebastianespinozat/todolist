package com.todolist.TodolistApp.controllers;


import com.todolist.TodolistApp.models.ToDoList;
import com.todolist.TodolistApp.services.taskService;
import com.todolist.TodolistApp.services.todolistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/lists")
public class todolistController {

    @Autowired
    private todolistService todoListService;
    @Autowired taskService TaskService;

    @GetMapping("")
    public List<ToDoList> lists(){
        return todoListService.findAll();
    }





}
