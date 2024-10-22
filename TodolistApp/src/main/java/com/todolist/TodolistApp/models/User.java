package com.todolist.TodolistApp.models;

import java.util.List;

public class User {

    private Long id;
    private String username;
    private String password;
    private String role;
    private List<ToDoList> todoLists;
}
