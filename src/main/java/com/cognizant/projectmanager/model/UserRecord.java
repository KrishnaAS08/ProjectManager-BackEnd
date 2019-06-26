package com.cognizant.projectmanager.model;

public class UserRecord {
	
	private Long userId;
	private String firstName;
	private String lastName;
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
	
	public UserRecord() {

	}
	
	public UserRecord(String firstName, String lastName, Long empId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.empId = empId;
	}
	

}
