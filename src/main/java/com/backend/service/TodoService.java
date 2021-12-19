package com.backend.service;

import java.util.List;

import com.backend.entity.Todo;

public interface TodoService{

	Todo create(Todo todo);
	Todo update(Todo todo);
	Todo get(Long id);
	String delete(Long id);
	List<Todo> getAll();
}
