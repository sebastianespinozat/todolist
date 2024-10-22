package com.todolist.TodolistApp.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {

    private Long id;
    private String username;
    private String password;
    private List<Role> roles;
    private List<ToDoList> todoLists;

    public User() {
        this.roles = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<ToDoList> getTodoLists() {
        return todoLists;
    }

    public void setTodoLists(List<ToDoList> todoLists) {
        this.todoLists = todoLists;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }
}
