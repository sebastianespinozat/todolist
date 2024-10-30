package com.todolist.TodolistApp.services;

import com.todolist.TodolistApp.models.Task;
import com.todolist.TodolistApp.models.TodoList;
import com.todolist.TodolistApp.repositories.TaskRepository;
import com.todolist.TodolistApp.repositories.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoListServiceImplementation implements TodoListService{

    @Autowired
    private TodoListRepository todoListRepository;

    @Override
    public List<TodoList> findAll() {
        return (List<TodoList>) todoListRepository.findAll();
    }

    @Override
    public Optional<TodoList> findById(Long id) {
        return todoListRepository.findById(id);
    }

    @Override
    public TodoList createTodoList(TodoList todoList) {
        todoList.setTasks(todoList.getTasks());
        return todoListRepository.save(todoList);
    }

    @Override
    public List<TodoList> getAllTodoLists() {
        return (List<TodoList>) todoListRepository.findAll();
    }

    @Override
    public Optional<TodoList> deleteTodoList(Long id) {
        Optional<TodoList> optionalTodoList = todoListRepository.findById(id);
        if(optionalTodoList.isPresent()){
            todoListRepository.deleteById(id);
        }
        return optionalTodoList;
    }

    @Override
    public Optional<TodoList> updateTodoList(Long id, TodoList todoList) {
        Optional<TodoList> optionalTodoList = todoListRepository.findById(id);
        if(optionalTodoList.isPresent()){
            TodoList newTDL = optionalTodoList.orElseThrow();
            newTDL.setTitle(todoList.getTitle());
            newTDL.getTasks().clear();
            //newTDL.setTasks(todoList.getTasks());
            for (Task task : todoList.getTasks()) {
                task.setTodo_list_id(newTDL); // Asegúrate de que cada tarea conozca su lista
                newTDL.getTasks().add(task); // Agregar tarea a la lista
            }

            return Optional.of(todoListRepository.save(newTDL));
        }
        return optionalTodoList;
    }
}
