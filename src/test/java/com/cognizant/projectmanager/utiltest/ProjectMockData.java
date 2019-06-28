package com.cognizant.projectmanager.utiltest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.projectmanager.entity.Project;
import com.cognizant.projectmanager.model.ProjectRecord;

public class ProjectMockData {
	
	public ProjectRecord getProjectRecord(){
		return new ProjectRecord("projectName", new Date(), new Date(), 1, "progress", 1l,"userName");
	}
	
	public List<ProjectRecord> getProjectRecordList(){
		List<ProjectRecord> list = new ArrayList<ProjectRecord>();
		list.add(new ProjectRecord(1l,"projectName1", new Date(), new Date(), 1, "progress", 1l,"userName1"));
		list.add(new ProjectRecord(2l,"projectName2", new Date(), new Date(), 2, "progress", 2l,"userName2"));
		return list;
	}
	
	public Project getProject(){
		return new Project("projectName", new Date(), new Date(), 1, 1l, "progress");
	}
	
	public List<Project> getProjectList(){
		List<Project> list = new ArrayList<Project>();
		list.add(new Project("projectName1", new Date(), new Date(), 1, 1l, "progress"));
		list.add(new Project("projectName2", new Date(), new Date(), 2, 2l, "progress"));
		return list;
	}
	
	public Long getNoOfTasks(){
		return 1l;
	}
	
	public Long getCompletedTasks(){
		return 1l;
	}
	
	public String getProjectName(){
	    return "DummyProject";
	}
}
