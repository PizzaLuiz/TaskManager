package com.taskManager.Controllers;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.taskManager.Task;
import com.taskManager.TaskRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://127.0.0.1:5500")
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
	
	@PutMapping("/task/{id}")
	public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
	    Task task = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada: " + id));

	    task.setStatus(updatedTask.getStatus());

	    return repository.save(task);
	}

	@DeleteMapping("/task/{id}")
	public void deleteTaskID(@PathVariable Long id){
		repository.deleteById(id);
	}

	@DeleteMapping("/task")
	public void deleteallTask(){
		repository.deleteAll();
	}
}
