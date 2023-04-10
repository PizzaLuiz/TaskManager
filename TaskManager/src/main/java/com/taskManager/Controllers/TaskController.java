package com.taskManager.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

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

	@GetMapping("/task/{id}")
	public Task getTaskID(@PathVariable Long id){
		return repository.findById(id).get();
	}

	@PostMapping("/task")
	public Task saveTask(@RequestBody Task task) {
		return repository.save(task);
	}

	@DeleteMapping("/task/{id}")
	public void deleteTask(@PathVariable Long id){
		repository.deleteById(id);
	}
}
