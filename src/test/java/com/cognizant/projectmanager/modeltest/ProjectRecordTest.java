package com.cognizant.projectmanager.modeltest;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.projectmanager.model.ProjectRecord;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProjectRecordTest {
	
	@Test
	public void testProjectRecord(){
		ProjectRecord test = new ProjectRecord();
		test.setProjectId(1l);
		assertEquals(Long.valueOf(1l), test.getProjectId());
		test.setProjectName("projectName");
		assertEquals("projectName", test.getProjectName());
		test.setStartDate(new Date());
		assertEquals(new Date(), test.getStartDate());
		test.setEndDate(new Date());
		assertEquals(new Date(), test.getEndDate());
		test.setPriority(1);
		assertEquals(1, test.getPriority());
		test.setStatus("progress");
		assertEquals("progress", test.getStatus());
		test.setUserId(1l);
		assertEquals(Long.valueOf(1l), test.getUserId());
		test.setUserName("userName");
		assertEquals("userName", test.getUserName());
		test.setCompletedTasks(1l);
		assertEquals(Long.valueOf(1l), test.getCompletedTasks());
		test.setNoOfTasks(1l);
		assertEquals(Long.valueOf(1l), test.getNoOfTasks());
		ProjectRecord projectRecord1 = new ProjectRecord("projectName", new Date(), new Date(), 1, "progress", 1l,"userName");
		assertEquals("progress", projectRecord1.getStatus());
		ProjectRecord projectRecord2 = new ProjectRecord(1l, "projectName", new Date(), new Date(), 1, "progress", 1l,"userName");
		assertEquals("projectName", projectRecord2.getProjectName());
	}

}
