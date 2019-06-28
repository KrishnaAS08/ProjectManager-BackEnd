package com.cognizant.projectmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.projectmanager.model.ParentTaskRecord;
import com.cognizant.projectmanager.service.ParentTaskService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/projectmanager/parentTasks")
public class ParentTaskController {
	
	
	@Autowired
	ParentTaskService parentService;
	
	@PostMapping(value = "/addParentTask")
	public ParentTaskRecord addParentTask (@RequestBody ParentTaskRecord parentTaskRecord) {
		return parentService.addParentTask(parentTaskRecord);
	}
	
	@GetMapping(value = "/getParentTasks")
	public List<ParentTaskRecord> getParentTasks() {
		return parentService.getParentTasks();
	}
	
	
}
