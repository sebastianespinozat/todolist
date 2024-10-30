package com.todolist.TodolistApp.controllers;

import com.todolist.TodolistApp.models.Task;
import com.todolist.TodolistApp.models.TodoList;
import com.todolist.TodolistApp.repositories.TaskRepository;
import com.todolist.TodolistApp.repositories.TodoListRepository;
import com.todolist.TodolistApp.services.TaskServiceImplementation;
import com.todolist.TodolistApp.services.TodoListServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lists")
public class todolistController {

    @Autowired
    private TodoListServiceImplementation todoListServiceImplementation;
    @Autowired
    private TaskServiceImplementation taskServiceImplementation;

    @GetMapping("")
    public List<TodoList> getAllTodoLists(){
        return todoListServiceImplementation.getAllTodoLists();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> viewList(@PathVariable Long id){
        Optional<TodoList> todoListOptional = todoListServiceImplementation.findById(id);
        if(todoListOptional.isPresent()){
            return ResponseEntity.ok(todoListOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("")
    public ResponseEntity<?> createList(@RequestBody TodoList todoList){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(todoListServiceImplementation.createTodoList(todoList));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateList(@RequestBody TodoList todoList, @PathVariable Long id){
        Optional<TodoList> todoListOptional = todoListServiceImplementation.updateTodoList(id,todoList);
        if(todoListOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(todoListOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteList(@PathVariable Long id){
        Optional<TodoList> todoListOptional = todoListServiceImplementation.deleteTodoList(id);
        if(todoListOptional.isPresent()){
            return ResponseEntity.ok(todoListOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
