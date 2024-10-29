package com.todolist.TodolistApp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Column(name="is_completed")
    private boolean isCompleted;

    @ManyToOne
    @JoinColumn(name="todo_list_id", nullable = false)
    @JsonIgnore
    private TodoList todo_list_id;

    public Task() {
    }

    public Task(String description, boolean isCompleted) {
        this.description = description;
        this.isCompleted = isCompleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public TodoList getTodo_list_id() {
        return todo_list_id;
    }

    public void setTodo_list_id(TodoList todo_list_id) {
        this.todo_list_id = todo_list_id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
