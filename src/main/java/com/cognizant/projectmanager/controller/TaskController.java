package com.cognizant.projectmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.projectmanager.model.TaskRecord;
import com.cognizant.projectmanager.service.TaskService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/projectmanager/tasks")
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@PostMapping(value = "/addTask")
	public TaskRecord addTask(@RequestBody TaskRecord taskRecord){
		return taskService.addTask(taskRecord);
	}
	
	@GetMapping(value = "/getAllTasks")
	public List<TaskRecord> getAllTasks(){
		return taskService.getAllTasks();
	}
	
	@PutMapping(value = "/updateTask/{id}")
	public TaskRecord updateTask(@PathVariable("id") Long taskId, @RequestBody TaskRecord taskRecord){
		return taskService.updateTask(taskId, taskRecord);
	}
	
	@DeleteMapping(value = "/endTask/{id}")
	public String endTask(@PathVariable("id") Long taskId){
		return taskService.endTask(taskId);
	}
	
	@GetMapping(value = "/searchTaskById/{id}")
	public List<TaskRecord> searchTaskById(@PathVariable("id") Long projectId){
		return taskService.searchTaskById(projectId);
	}
	
	@GetMapping(value = "/getTaskById/{id}")
	public TaskRecord getTaskById(@PathVariable("id") Long id) {
		return taskService.getTaskById(id);
	}
}
