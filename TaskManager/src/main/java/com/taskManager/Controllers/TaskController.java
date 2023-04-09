package com.taskManager.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taskManager.Task;
import com.taskManager.TaskRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class TaskController {
	
	TaskRepository repository;
	
	@GetMapping("/task")
	public List<Task> getAllTasks() {
		return repository.findAll();
	}
	
	@PostMapping("/task")
	public Task saveTask(@RequestBody Task task) {
		return repository.save(task);
	}
	
}
