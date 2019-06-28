package com.cognizant.projectmanager.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.projectmanager.entity.ParentTask;
import com.cognizant.projectmanager.model.ParentTaskRecord;
import com.cognizant.projectmanager.repository.ParentTaskRepository;


@Service
@Transactional
public class ParentTaskService {
	
private static final Logger logger = Logger.getLogger(ParentTaskService.class.getName());
	
	@Autowired
	ParentTaskRepository repository;
	
	public ParentTaskRecord addParentTask (ParentTaskRecord parentTaskRecord) {
		
		try {
			logger.info("adding data into parent task table");
			ParentTask parentTask = new ParentTask();
			parentTask.setParentName(parentTaskRecord.getParentName());
			repository.save(parentTask);
			
			return parentTaskRecord;
			
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occured while adding data into parent task table", e.getMessage());
			throw e;
		}
	}
	
	public List<ParentTaskRecord> getParentTasks() {
		
		try {
			logger.info("getting data from the parent task table");
			List<ParentTask> parentTasks = new ArrayList<ParentTask>();
			repository.findAll().forEach(parentTasks::add);
			List<ParentTaskRecord> parentlist = new ArrayList<ParentTaskRecord>();
			for(ParentTask p : parentTasks){
				ParentTaskRecord record = new ParentTaskRecord();
				record.setParentId(p.getParentId());
				record.setParentName(p.getParentName());
				parentlist.add(record);
			}
			
			return parentlist;
			
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occured while getting data from parent task table", e.getMessage());
			throw e;
		}
	}
	
	public String getparentTaskData(Long parentId) {
		String parentTaskName = repository.getParentNameById(parentId);
			return parentTaskName;
	}

}
