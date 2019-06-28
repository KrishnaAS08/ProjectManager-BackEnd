package com.cognizant.projectmanager.model;

import java.util.Date;

public class ProjectRecord {
	
	private Long projectId;
	private String projectName;
	private Date startDate;
	private Date endDate;
	private int priority;
	private String status;
	private Long userId;
	private String userName;
	private Long completedTasks=0l;
	private Long noOfTasks=0l;
	
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

	public Long getCompletedTasks() {
		return completedTasks;
	}

	public void setCompletedTasks(Long completedTasks) {
		this.completedTasks = completedTasks;
	}

	public Long getNoOfTasks() {
		return noOfTasks;
	}

	public void setNoOfTasks(Long noOfTasks) {
		this.noOfTasks = noOfTasks;
	}

	public ProjectRecord() {

	}

	public ProjectRecord(String projectName, Date startDate, Date endDate, int priority, String status,
			Long userId,String userName) {
		super();
		this.projectName = projectName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.status = status;
		this.userId = userId;
		this.userName = userName;
		this.completedTasks = 0l;
		this.noOfTasks = 0l;		
	}
	
	public ProjectRecord(Long projectId, String projectName, Date startDate, Date endDate, int priority, String status,
			Long userId,String userName) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.status = status;
		this.userId = userId;
		this.userName = userName;
		this.completedTasks = 0l;
		this.noOfTasks = 0l;		
	}
		

}
