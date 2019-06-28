package com.cognizant.projectmanager.utiltest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.projectmanager.entity.Task;
import com.cognizant.projectmanager.model.TaskRecord;

public class TaskMockData {
	
	public TaskRecord getTaskRecord(){
		return new TaskRecord("taskName", new Date(), new Date(),
				1, "progress", 1l, "parentName", 1l, "projectName", 1l, "userName");
	}
	
	public List<TaskRecord> getTaskRecordList(){
		List<TaskRecord> list = new ArrayList<TaskRecord>();
		list.add(new TaskRecord("taskName1", new Date(), new Date(),
				1, "progress", 1l, "parentName1", 1l, "projectName1", 1l, "userName1"));
		list.add(new TaskRecord("taskName2", new Date(), new Date(),
				2, "progress", 2l, "parentName2", 2l, "projectName2", 2l, "userName2"));
		return list;
	}
	
	public Task getTask(){
		return new Task("taskName", new Date(), new Date(), 1, 1l, 1l, 1l, "progress");
	}
	public List<Task> getTaskList(){
		List<Task> list = new ArrayList<Task>();
		list.add(new Task("taskName1", new Date(), new Date(), 1, 1l, 1l, 1l, "progress"));
		list.add(new Task("taskName2", new Date(), new Date(), 2, 2l, 2l, 2l, "progress"));
		return list;
	}
	
	public Long getNoOfTasks() {
		return 1L;
	}

	public Long getCompletedTasks() {
		return 1L;
	}

}
