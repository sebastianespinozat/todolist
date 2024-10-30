package com.todolist.TodolistApp.services;

import com.todolist.TodolistApp.models.Task;

import java.util.List;

public interface TaskService{

    Task createTask(Task task);
    List<Task> getTasksByTodoList_Id(Long todoListId);
    Task updateTask(Long id, Task updatedTask);
    Task completeTask(Long id);
    void deleteTask(Long id);

}
