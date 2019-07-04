package com.cognizant.projectmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "parentTask")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
allowGetters = true)
public class ParentTask {
	
	@Id
	@Column(name = "parent_Id")
	@GeneratedValue(generator="parent_task_seq")
	@SequenceGenerator(name="parent_task_seq",sequenceName="PARENT_TASK_SEQ", allocationSize=1)
	private Long parentId;
	
	@Column(name = "parent_Name")
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

	public ParentTask() {

	}

	public ParentTask(String parentName) {
		super();
		this.parentName = parentName;
	}
	
	

}
