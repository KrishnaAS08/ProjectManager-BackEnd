package com.cognizant.projectmanager.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.projectmanager.entity.Task;
import com.cognizant.projectmanager.model.TaskRecord;
import com.cognizant.projectmanager.repository.TaskRepository;

@Service
@Transactional
public class TaskService {
	
	private static final Logger logger = Logger.getLogger(TaskService.class.getName());
	
	@Autowired
	TaskRepository taskRepository;
	
	@Autowired
	ParentTaskService parentTaskService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ProjectService projectService;
	
	public TaskRecord addTask(TaskRecord taskRecord){
		try {
			logger.info("adding data to data table");
			Task task = new Task();
			task.setTaskName(taskRecord.getTaskName());
			task.setPriority(taskRecord.getPriority());
			task.setStartDate(taskRecord.getStartDate());
			task.setEndDate(taskRecord.getEndDate());
			task.setProjectId(taskRecord.getProjectId());
			task.setParentId(taskRecord.getParentId());
			task.setUserId(taskRecord.getUserId());
			task.setStatus("progress");
			taskRepository.save(task);
			return taskRecord;
			
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occurred while saving all data to task table", e.getMessage());
			throw e;
		}
		
	}
	
	public List<TaskRecord> getAllTasks(){
		try {
			logger.info("getting all data from data table");
			List<Task> tasks = new ArrayList<Task>();
			taskRepository.findAll().forEach(tasks::add);
			List<TaskRecord> tlist = new ArrayList<TaskRecord>();
			for(Task t : tasks) {
				TaskRecord taskRecord = new TaskRecord();
				taskRecord.setTaskId(t.getTaskId());
				taskRecord.setTaskName(t.getTaskName());
				taskRecord.setStartDate(t.getStartDate());
				taskRecord.setEndDate(t.getEndDate());
				taskRecord.setPriority(t.getPriority());
				taskRecord.setStatus(t.getStatus());
				taskRecord.setParentId(t.getParentId());
				tlist.add(taskRecord);
			}
			return tlist;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occured while getting all data from data table", e.getMessage());
			throw e;
		}
	}
	
	public TaskRecord updateTask(Long taskId, TaskRecord taskRecord){
		try {
			logger.info("updating data in task table");
			Task task = new Task();
			task.setTaskId(taskId);
			task.setTaskName(taskRecord.getTaskName());
			task.setPriority(taskRecord.getPriority());
			task.setStartDate(taskRecord.getStartDate());
			task.setEndDate(taskRecord.getEndDate());
			task.setProjectId(taskRecord.getProjectId());
			task.setParentId(taskRecord.getParentId());
			task.setUserId(taskRecord.getUserId());
			task.setStatus(taskRecord.getStatus());
			taskRepository.save(task);
			
			return taskRecord;
			
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occurred while updating data into task table", e.getMessage());
			throw e;
		}				
	}
	
	public List<TaskRecord> searchTaskById(Long projectId){
		try {
			logger.info("getting data by projectId from task table");
			List<Task> tasks = new ArrayList<Task>();
			taskRepository.getTaskById(projectId).forEach(tasks::add);
			
			List<TaskRecord> tlist = new ArrayList<TaskRecord>();
			for(Task t : tasks) {
				TaskRecord taskRecord = new TaskRecord();
				taskRecord.setTaskId(t.getTaskId());
				taskRecord.setTaskName(t.getTaskName());
				taskRecord.setStartDate(t.getStartDate());
				taskRecord.setEndDate(t.getEndDate());
				taskRecord.setPriority(t.getPriority());
				taskRecord.setStatus(t.getStatus());
				taskRecord.setParentId(t.getParentId());
				String parentName = parentTaskService.getparentTaskData(t.getParentId());
				taskRecord.setParentName(parentName);
				taskRecord.setUserId(t.getUserId());
				String userName = userService.getUserData(t.getUserId());
				taskRecord.setUserName(userName);
				taskRecord.setProjectId(t.getProjectId());
				String projectName = projectService.getProjectData(t.getProjectId());
				taskRecord.setProjectName(projectName);
				tlist.add(taskRecord);
			}
			
			return tlist;
			
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occurred while getting data by projectId from task table", e.getMessage());
			throw e;
		}
	}
	
	public String endTask(Long taskId){
		try {
			logger.info("end the task in task table");
			taskRepository.suspendById(taskId);
			return "Completed";
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occurred while end the task in task table", e.getMessage());
			throw e;
		}
	}
	
	public Long getNoOfTasks(Long projectId) {
		Long result = 0l;
		logger.info("getting no of tasks by projectId");
		result = taskRepository.getTaskCount(projectId);
		if (result == null) {
			result = 0l;
		}
		return result;
	}

	public Long getCompletedTasks(Long projectId) {
		Long result = 0l;
		logger.info("getting completed tasks by projectId");
		result = taskRepository.getCompletedTaskCount(projectId);
		if (result == null) {
			result = 0l;
		}
		return result;
	}
	
}
