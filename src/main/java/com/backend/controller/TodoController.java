package com.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.entity.Todo;
import com.backend.service.TodoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class TodoController {

	private final TodoService todoService;
	
	@GetMapping("/all")
	private ResponseEntity<?> getAll(){
		List<Todo> todos = todoService.getAll();
		return  ResponseEntity.ok(todos);
	}
	@PostMapping("/save")
	private ResponseEntity<?> save(@RequestBody Todo todo){
		Todo todoSave = todoService.create(todo);
		return  ResponseEntity.ok(todoSave);
	}
	@PutMapping("/update/{id}")
	private ResponseEntity<?> update(@RequestBody Todo todo, @PathVariable("id") Long id){
		Todo todoUpdate = todoService.get(id);
		if(todoUpdate == null) {
			return ResponseEntity.notFound().build();
		}
		todo.setId(id);
		Todo todoSave = todoService.create(todo);
		return  ResponseEntity.ok(todoSave);
	}
	@DeleteMapping("/delete/{id}")
	private ResponseEntity<?> delete(@PathVariable("id") Long id){
		Todo todoDelete = todoService.get(id);
		if(todoDelete == null) {
			return ResponseEntity.notFound().build();
		}
		return  ResponseEntity.ok(todoService.delete(id));
	}
}
