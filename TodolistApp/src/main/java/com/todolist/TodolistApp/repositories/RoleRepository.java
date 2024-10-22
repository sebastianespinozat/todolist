package com.todolist.TodolistApp.repositories;

import com.todolist.TodolistApp.models.Role;
import com.todolist.TodolistApp.models.User;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
