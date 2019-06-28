package com.cognizant.projectmanager.utiltest;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.projectmanager.entity.ParentTask;
import com.cognizant.projectmanager.model.ParentTaskRecord;

public class ParentTaskMockData {
	
	public ParentTaskRecord getParentTaskRecord(){
		return new ParentTaskRecord("parentName");
	}
	
	public List<ParentTaskRecord> getParentTaskRecordList(){
		List<ParentTaskRecord> list = new ArrayList<ParentTaskRecord>();
		list.add(new ParentTaskRecord("parentName1"));
		list.add(new ParentTaskRecord("parentName2"));
		return list;
	}
	
	public ParentTask getParentTask(){
		return new ParentTask("parentName");
	}
	
	public List<ParentTask> getParentTaskList(){
		List<ParentTask> list = new ArrayList<ParentTask>();
		list.add(new ParentTask("parentName1"));
		list.add(new ParentTask("parentName2"));
		return list;
	}
	
	public String getParentTaskName(){
	    return "DummyParentTask";
	}
}
