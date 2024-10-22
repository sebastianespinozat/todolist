package com.todolist.TodolistApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TodolistAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistAppApplication.class, args);
	}

}
