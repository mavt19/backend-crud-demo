package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{

}
