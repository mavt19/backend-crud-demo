package com.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.backend.entity.Todo;
import com.backend.service.TodoService;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class BackendCrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendCrudDemoApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(TodoService todoService) {
		return args ->{
			todoService.create(new Todo(null, "test1", false, null, null));
			todoService.create(new Todo(null, "test2", true, null, null));
			todoService.create(new Todo(null, "test3", true, null, null));
		};
	}
}
