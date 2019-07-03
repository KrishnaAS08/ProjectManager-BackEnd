package com.cognizant.projectmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.projectmanager.model.ProjectRecord;
import com.cognizant.projectmanager.service.ProjectService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/projectmanager/projects")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	@PostMapping(value = "/addProject")
	public ProjectRecord addProject(@RequestBody ProjectRecord projectRecord){
		return projectService.addProject(projectRecord);
	}
	
	@GetMapping(value = "/getAllProjects")
	public List<ProjectRecord> getAllProjects(){
		return projectService.getAllProjects();
	}
	
	@PutMapping(value = "/updateProject/{id}")
	public ProjectRecord updateProject(@PathVariable("id") Long projectId, @RequestBody ProjectRecord projectRecord){
		return projectService.updateProject(projectId, projectRecord);
	}
	
	@PutMapping("/suspendProject/{id}")
	public String suspendProject(@PathVariable ("id") Long projectId){
		return projectService.suspendProject(projectId);
	}
	
	@GetMapping(value = "/getAllProjectsRecord")
	public List<ProjectRecord> getAllProjectsRecord(){
		return projectService.getAllProjectsRecord();
	}
}
