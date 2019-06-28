package com.cognizant.projectmanager.model;

import java.util.Date;

public class TaskRecord {
	
	private Long taskId;
	private String taskName;
	private Date startDate;
	private Date endDate;
	private int priority;
	private String status;
	private Long parentId;
	private String parentName;
	private Long projectId;
	private String projectName;
	private Long userId;
	private String userName;
	
	
	public Long getTaskId() {
		return taskId;
	}
	
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	
	public String getTaskName() {
		return taskName;
	}
	
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Long getParentId() {
		return parentId;
	}
	
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	
	public String getParentName() {
		return parentName;
	}
	
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	
	public Long getProjectId() {
		return projectId;
	}
	
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	
	public String getProjectName() {
		return projectName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public TaskRecord() {

	}

	public TaskRecord(String taskName, Date startDate, Date endDate, int priority, String status, String parentName,
			String projectName, String userName) {
		super();
		this.taskName = taskName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.status = status;
		this.parentName = parentName;
		this.projectName = projectName;
		this.userName = userName;
	}

	public TaskRecord(String taskName, Date startDate, Date endDate, int priority, String status, Long parentId,
			String parentName, Long projectId, String projectName, Long userId, String userName) {
		super();
		this.taskName = taskName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.status = status;
		this.parentId = parentId;
		this.parentName = parentName;
		this.projectId = projectId;
		this.projectName = projectName;
		this.userId = userId;
		this.userName = userName;
	}
	
	

}
