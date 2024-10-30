package com.todolist.TodolistApp.services;

import com.todolist.TodolistApp.models.Task;
import com.todolist.TodolistApp.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImplementation implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getTasksByTodoList_Id(Long todoListId) {
        return taskRepository.findByTodoList_Id(todoListId);
    }

    @Override
    public Task updateTask(Long id, Task updatedTask) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Task not found"));
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setCompleted(updatedTask.isCompleted());
        return taskRepository.save(existingTask);
    }

    @Override
    public Task completeTask(Long id) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Task not found"));
        existingTask.setCompleted(true);
        return taskRepository.save(existingTask);
    }

    @Override
    public void deleteTask(Long id) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Task not found"));
        taskRepository.deleteById(id);
    }
}
