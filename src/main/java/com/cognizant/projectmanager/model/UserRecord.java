package com.cognizant.projectmanager.model;

public class UserRecord {
	
	private Long userId;
	private String firstName;
	private String lastName;
	private String userName;
	private Long empId;
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Long getEmpId() {
		return empId;
	}
	
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public UserRecord() {

	}
	
	public UserRecord(Long userId, String firstName, String lastName, String userName, Long empId) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.empId = empId;
	}

	public UserRecord(Long userId,String firstName, String lastName, Long empId) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.empId = empId;
	}
	

}
