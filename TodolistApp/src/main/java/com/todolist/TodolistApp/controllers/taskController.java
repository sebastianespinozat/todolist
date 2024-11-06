package com.todolist.TodolistApp.controllers;

import com.todolist.TodolistApp.models.Task;
import com.todolist.TodolistApp.models.TodoList;
import com.todolist.TodolistApp.services.TaskServiceImplementation;
import com.todolist.TodolistApp.services.TodoListServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/lists/{listId}/tasks")
public class taskController {

    @Autowired
    private TaskServiceImplementation taskServiceImplementation;
    @Autowired
    private TodoListServiceImplementation todoListServiceImplementation;

    @GetMapping("")
    public ResponseEntity<?> getAllTasksByTodoListId(@PathVariable Long listId){
        Optional<TodoList> todoListOptional = todoListServiceImplementation.findById(listId);
        if(todoListOptional.isPresent()){
            return ResponseEntity.ok(taskServiceImplementation.getTasksByTodoList_Id(listId));
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping("")
    public ResponseEntity<?> postTaskByTodoListId(@PathVariable Long listId, @RequestBody Task task){
        Optional<TodoList> todoListOptional = todoListServiceImplementation.findById(listId);
        if(todoListOptional.isPresent()){
            TodoList todoList = todoListOptional.get();
            task.setTodo_list_id(todoList);
            Task createdTask = taskServiceImplementation.createTask(task);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<?> postTaskByTodoListId(@PathVariable Long listId, @PathVariable Long taskId, @RequestBody Task task){
        Optional<TodoList> todoListOptional = todoListServiceImplementation.findById(listId);
        if(todoListOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(taskServiceImplementation.updateTask(taskId, task));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<?> deleteTaskByTodoListId(@PathVariable Long listId, @PathVariable Long taskId){
        Optional<TodoList> todoListOptional = todoListServiceImplementation.findById(listId);
        if(todoListOptional.isPresent()){
            taskServiceImplementation.deleteTask(taskId);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
