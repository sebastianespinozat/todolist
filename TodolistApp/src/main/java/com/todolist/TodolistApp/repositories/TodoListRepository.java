package com.todolist.TodolistApp.repositories;

import com.todolist.TodolistApp.models.TodoList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListRepository extends CrudRepository<TodoList, Long> {
}
