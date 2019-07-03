package com.cognizant.projectmanager.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.projectmanager.entity.Project;
import com.cognizant.projectmanager.model.ProjectRecord;
import com.cognizant.projectmanager.repository.ProjectRepository;
import com.cognizant.projectmanager.repository.TaskRepository;
import com.cognizant.projectmanager.repository.UserRepository;

@Service
@Transactional
public class ProjectService {
	
	private static final Logger logger = Logger.getLogger(ProjectService.class.getName());
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	TaskRepository taskRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@Autowired
	TaskService taskService;
	
	public ProjectRecord addProject(ProjectRecord projectRecord){
		try {
			logger.info("adding data in project table");
			Project project = new Project();
			project.setProjectName(projectRecord.getProjectName());
			project.setStartDate(projectRecord.getStartDate());
			project.setEndDate(projectRecord.getEndDate());
			project.setPriority(projectRecord.getPriority());
			project.setUserId(projectRecord.getUserId());
			project.setStatus("progress");
			projectRepository.save(project);
			
			return projectRecord;
			
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occured while adding data in project table",e.getMessage());
			throw e;
		}
	}
	
	public List<ProjectRecord> getAllProjects(){
		try {
			logger.info("getting data from project table");
			List<Project> projects = new ArrayList<Project>();
			projectRepository.findAll().forEach(projects::add);
			List<ProjectRecord> projectList = new ArrayList<ProjectRecord>();
			for(Project p : projects){
				ProjectRecord projectRecord = new ProjectRecord();
				projectRecord.setProjectId(p.getProjectId());
				projectRecord.setProjectName(p.getProjectName());
				projectRecord.setStartDate(p.getStartDate());
				projectRecord.setEndDate(p.getEndDate());
				projectRecord.setPriority(p.getPriority());
				projectRecord.setUserId(p.getUserId());
				projectRecord.setStatus(p.getStatus());
				projectList.add(projectRecord);				
			}
			
			return projectList;
			
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occured while getting data from project table",e.getMessage());
			throw e;
		}
	}

	public ProjectRecord updateProject(Long projectId, ProjectRecord projectRecord){
		try {
			logger.info("updating data in project table");
			Project project = new Project();
			project.setProjectId(projectId);
			project.setProjectName(projectRecord.getProjectName());
			project.setStartDate(projectRecord.getStartDate());
			project.setEndDate(projectRecord.getEndDate());
			project.setPriority(projectRecord.getPriority());
			project.setUserId(projectRecord.getUserId());
			project.setStatus(projectRecord.getStatus());
			projectRepository.save(project);
			
			return projectRecord;
			
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occured while updating data in project table",e.getMessage());
			throw e;
		}
	}
	
	public String suspendProject(Long projectId) {
		try {
			logger.info("Suspend project from project table of id: "+ projectId);
			projectRepository.suspendById(projectId);
			taskRepository.suspendtaskById(projectId);
			return "Suspended";
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occurred while suspending project from project table", e.getMessage());
			throw e;
		}
	}
	
	public List<ProjectRecord> getAllProjectsRecord() {
		try {
			logger.info("getting data from project table");
			List<Project> projects = projectRepository.findAllProjects();
			List<ProjectRecord> ptlist = new ArrayList<ProjectRecord>();
			for (Project p : projects) {
				ProjectRecord projectRecord = new ProjectRecord();
				projectRecord.setProjectId(p.getProjectId());
				projectRecord.setEndDate(p.getEndDate());
				projectRecord.setPriority(p.getPriority());
				projectRecord.setProjectName(p.getProjectName());
				projectRecord.setStartDate(p.getStartDate());
				projectRecord.setUserId(p.getUserId());
				String userName = userService.getUserData(p.getUserId());
				projectRecord.setUserName(userName);
				Long noOfTask = taskService.getNoOfTasks(p.getProjectId());
				projectRecord.setNoOfTasks(noOfTask);
				Long completedTask = taskService.getCompletedTasks(p.getProjectId());
				projectRecord.setCompletedTasks(completedTask);
				ptlist.add(projectRecord);
			}
			return ptlist;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occurred while getting all data into project table", e.getMessage());
			throw e;
		}
	}
	
	public String getProjectData(Long projectId) {
		String projectName = projectRepository.getProjectNameById(projectId);
			return projectName;
	}
}
