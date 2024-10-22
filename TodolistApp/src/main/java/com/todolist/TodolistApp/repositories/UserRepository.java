package com.todolist.TodolistApp.repositories;

import com.todolist.TodolistApp.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByUsername(String username);
}
