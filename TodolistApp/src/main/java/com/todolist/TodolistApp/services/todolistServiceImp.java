package com.todolist.TodolistApp.services;

import com.todolist.TodolistApp.models.ToDoList;
import com.todolist.TodolistApp.repositories.TodolistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class todolistServiceImp implements todolistService{

    @Autowired
    TodolistRepository todolistRepository;

    @Transactional(readOnly = true)
    @Override
    public List<ToDoList> findAll() {
        return (List<ToDoList>) todolistRepository.findAll();
    }

    @Override
    public Optional<ToDoList> findById(Long id) {
        return todolistRepository.findById(id);
    }

    @Override
    public ToDoList save(ToDoList todoList) {
        return todolistRepository.save(todoList);
    }

    @Override
    public Optional<ToDoList> delete(Long id) {
        Optional<ToDoList> optionalTDL = todolistRepository.findById(id);
        optionalTDL.ifPresent(todolist ->{
            todolistRepository.delete(todolist);
        });
        return optionalTDL;
    }
}
