package com.cognizant.projectmanager.entitytest;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.projectmanager.entity.Task;

@RunWith(SpringJUnit4ClassRunner.class)
public class TaskTest {
	
	@Test
	public void testTask(){
		Task test = new Task();
		test.setTaskId(1l);
		assertEquals(Long.valueOf(1l),test.getTaskId());
		String taskName = "taskName";
		test.setTaskName(taskName);
		assertEquals("taskName", test.getTaskName());
		Date startDate = new Date();
		test.setStartDate(startDate);
		assertEquals(startDate, test.getStartDate());
		Date endDate = new Date();
		test.setEndDate(endDate);
		assertEquals(endDate, test.getEndDate());
		test.setPriority(1);
		assertEquals(1, test.getPriority());
		test.setStatus("progress");
		assertEquals("progress", test.getStatus());
		test.setParentId(1l);
		assertEquals(Long.valueOf(1l),test.getParentId());
		test.setProjectId(1l);
		assertEquals(Long.valueOf(1l),test.getProjectId());
		test.setUserId(1l);
		assertEquals(Long.valueOf(1l),test.getUserId());
		Task task = new Task("taskName", new Date(), new Date(), 1, 1l, 1l, 1l, "progress" );
		assertEquals("taskName", task.getTaskName());
	}
}
