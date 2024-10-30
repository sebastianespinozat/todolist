package com.todolist.TodolistApp.repositories;

import com.todolist.TodolistApp.models.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

    List<Task> findByTodoList_Id(Long todoListId);
}
