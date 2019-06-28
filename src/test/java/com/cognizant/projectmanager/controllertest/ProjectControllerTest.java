package com.cognizant.projectmanager.controllertest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.projectmanager.controller.ProjectController;
import com.cognizant.projectmanager.model.ProjectRecord;
import com.cognizant.projectmanager.service.ProjectService;
import com.cognizant.projectmanager.utiltest.ProjectMockData;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProjectControllerTest {
	
	@InjectMocks
	public ProjectController projectController;
	
	@Mock
	public ProjectService projectService;
	
	@Test
	public void addProjectTest(){
		Mockito.when(projectService.addProject(Mockito.any(ProjectRecord.class)))
				.thenReturn(new ProjectMockData().getProjectRecord());
		
		ProjectRecord output = projectController.addProject(new ProjectMockData().getProjectRecord());
		assertEquals(new ProjectMockData().getProjectRecord().getPriority(), output.getPriority());
		assertEquals(new ProjectMockData().getProjectRecord().getStatus(), output.getStatus());
	}
	
	@Test
	public void getAllProjectsTest(){
		Mockito.when(projectService.getAllProjects())
				.thenReturn(new ProjectMockData().getProjectRecordList());
		
		List<ProjectRecord> output = projectController.getAllProjects();
		assertEquals(2, output.size());
	}
	
	@Test
	public void updateProjectTest(){
		Mockito.when(projectService.updateProject(Mockito.anyLong(), Mockito.any(ProjectRecord.class)))
				.thenReturn(new ProjectMockData().getProjectRecord());
		
		ProjectRecord output = projectController.updateProject(1l,new ProjectMockData().getProjectRecord());
		assertEquals(new ProjectMockData().getProjectRecord().getPriority(), output.getPriority());
		assertEquals(new ProjectMockData().getProjectRecord().getStatus(), output.getStatus());
	}
	
	@Test
	public void getAllProjectsRecordTest(){
		Mockito.when(projectService.getAllProjectsRecord())
				.thenReturn(new ProjectMockData().getProjectRecordList());
		
		List<ProjectRecord> output = projectController.getAllProjectsRecord();
		assertEquals(2, output.size());
	}


}
