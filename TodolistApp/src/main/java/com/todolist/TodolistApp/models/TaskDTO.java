package com.todolist.TodolistApp.models;

import jakarta.persistence.Column;

public class TaskDTO {

    private Long id;
    private String description;
    private boolean isCompleted;
}
