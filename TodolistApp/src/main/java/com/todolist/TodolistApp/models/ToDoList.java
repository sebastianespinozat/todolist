package com.todolist.TodolistApp.models;

import java.util.List;

public class ToDoList {

    private Long id;
    private String title;
    private User owner;
    private List<String> todoStuff;

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

    public List<String> getTodoStuff() {
        return todoStuff;
    }

    public void setTodoStuff(List<String> todoStuff) {
        this.todoStuff = todoStuff;
    }

    public void addStuff(String stuff){
        todoStuff.add(stuff);
    }

    public void removeStuff(int index){
        todoStuff.remove(index);
    }
}
