package com.cognizant.projectmanager.modeltest;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.projectmanager.model.TaskRecord;

@RunWith(SpringJUnit4ClassRunner.class)
public class TaskRecordTest {
	
	@Test
	public void testTaskRecord(){
		TaskRecord test = new TaskRecord();
		test.setTaskId(1l);
		assertEquals(Long.valueOf(1l), test.getTaskId());
		test.setTaskName("taskName");
		assertEquals("taskName", test.getTaskName());
		test.setStartDate(new Date());
		assertEquals(new Date(), test.getStartDate());
		test.setEndDate(new Date());
		assertEquals(new Date(), test.getEndDate());
		test.setPriority(1);
		assertEquals(1, test.getPriority());
		test.setStatus("status");
		assertEquals("status", test.getStatus());
		test.setParentId(1l);
		assertEquals(Long.valueOf(1l), test.getParentId());
		test.setParentName("parentName");
		assertEquals("parentName", test.getParentName());
		test.setProjectId(1l);
		assertEquals(Long.valueOf(1l), test.getProjectId());
		test.setProjectName("projectName");
		assertEquals("projectName", test.getProjectName());
		test.setUserId(1l);
		assertEquals(Long.valueOf(1l), test.getUserId());
		test.setUserName("userName");
		assertEquals("userName", test.getUserName());
		TaskRecord taskRecord = new TaskRecord("taskName", new Date(), new Date(), 1, "status", "parentName", "projectName", "userName");
		assertEquals("userName", taskRecord.getUserName());
	}

}
