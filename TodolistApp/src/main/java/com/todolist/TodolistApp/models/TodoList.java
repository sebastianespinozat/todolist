package com.todolist.TodolistApp.models;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="todolist")
public class TodoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @OneToMany(mappedBy = "todo_list_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks = new ArrayList<>();;

    public TodoList() {

    }

    public TodoList(String title, List<Task> tasks) {
        this.title = title;
        this.tasks = tasks;
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

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
        for(Task task : tasks){
            task.setTodo_list_id(this);
        }
    }

    @Override
    public String toString() {
        return "TodoList{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", tasks=" + tasks +
                '}';
    }


}
