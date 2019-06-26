package com.cognizant.projectmanager.model;

public class ParentTaskRecord {
	
	private Long parentId;
	private String parentName;
	
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

	public ParentTaskRecord() {

	}

	public ParentTaskRecord(String parentName) {
		super();
		this.parentName = parentName;
	}

}
