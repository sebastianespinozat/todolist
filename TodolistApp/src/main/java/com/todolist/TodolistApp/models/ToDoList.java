package com.todolist.TodolistApp.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ToDoList {

    private Long id;
    private String title;
    private User owner;
    private List<Task> tasks;

    public ToDoList(String title, User owner, List<Task> tasks) {
        this.title = title;
        this.owner = owner;
        this.tasks = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task){
        this.tasks.add(task);
    }

    public void deleteTask(Long taskId){
        this.tasks.removeIf(t -> Objects.equals(t.getId(), taskId));
    }

}
