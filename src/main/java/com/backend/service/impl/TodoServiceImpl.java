package com.backend.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.backend.entity.Todo;
import com.backend.repository.TodoRepository;
import com.backend.service.TodoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TodoServiceImpl implements TodoService{

	private final TodoRepository todoRepository;
	@Override
	public Todo create(Todo todo) {
		// TODO Auto-generated method stub
		return todoRepository.save(todo);
	}

	@Override
	public Todo update(Todo todo) {
		// TODO Auto-generated method stub
		return todoRepository.save(todo);
	}

	@Override
	public Todo get(Long id) {
		// TODO Auto-generated method stub
		return todoRepository.findById(id).orElse(null);
	}

	@Override
	public String delete(Long id) {
		// TODO Auto-generated method stub
		todoRepository.deleteById(id);
		return "deteted successsfuly";
	}

	@Override
	public List<Todo> getAll() {
		// TODO Auto-generated method stub
		return todoRepository.findAll();
	}

}
