package com.cognizant.projectmanager.entitytest;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.projectmanager.entity.Project;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProjectTest {
	
	@Test
	public void testProject(){
		Project project = new Project();
		project.setProjectId(1l);
		assertEquals(Long.valueOf(1l),project.getProjectId());
		String projectName = "projectName";
		project.setProjectName(projectName);
		assertEquals("projectName", project.getProjectName());
		Date startDate = new Date();
		project.setStartDate(startDate);
		assertEquals(new Date(),project.getStartDate());
		Date endDate = new Date();
		project.setEndDate(endDate);
		assertEquals(new Date(),project.getEndDate());
		int priority = 1;
		project.setPriority(priority);
		assertEquals(1,project.getPriority());
		String status = "progress";
		project.setStatus(status);
		assertEquals("progress",project.getStatus());
		Long userId = 1l;
		project.setUserId(userId);
		assertEquals(Long.valueOf(1l),project.getUserId());
		Project test = new Project("projectName", new Date(), new Date(), 1, 1l, "progress");
		assertEquals("projectName", test.getProjectName());
	}

}
