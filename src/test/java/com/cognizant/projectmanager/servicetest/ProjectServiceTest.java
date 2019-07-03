package com.cognizant.projectmanager.servicetest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.projectmanager.entity.Project;
import com.cognizant.projectmanager.model.ProjectRecord;

import com.cognizant.projectmanager.repository.ProjectRepository;
import com.cognizant.projectmanager.repository.TaskRepository;
import com.cognizant.projectmanager.repository.UserRepository;
import com.cognizant.projectmanager.service.ProjectService;
import com.cognizant.projectmanager.service.TaskService;
import com.cognizant.projectmanager.service.UserService;
import com.cognizant.projectmanager.utiltest.ProjectMockData;
import com.cognizant.projectmanager.utiltest.UserMockData;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProjectServiceTest {
	
	@InjectMocks
	public ProjectService projectService;
	
	@Mock
	public ProjectRepository projectRepository;
	
	@Mock
	public TaskRepository taskRepository;
	
	@Mock
	public UserRepository userRepository;
	
	@Mock
	TaskService taskService;
	
	@Mock
	UserService userService;
	
	@Test
	public void addProjectTest(){
		Mockito.when(projectRepository.save(new ProjectMockData().getProject()))
				.thenReturn(new ProjectMockData().getProject());
		
		ProjectRecord output = projectService.addProject(new ProjectMockData().getProjectRecord());
		assertEquals(new ProjectMockData().getProjectRecord().getPriority(), output.getPriority());
		assertEquals(new ProjectMockData().getProjectRecord().getStatus(), output.getStatus());
	}
	
	@Test(expected = RuntimeException.class)
	public void addProjectNavigativeScenario(){
		Mockito.when(projectRepository.save(Mockito.any(Project.class)))
				.thenThrow(new RuntimeException());
		
		ProjectRecord output = projectService.addProject(new ProjectMockData().getProjectRecord());
		assertEquals(new ProjectMockData().getProjectRecord().getPriority(), output.getPriority());
		assertEquals(new ProjectMockData().getProjectRecord().getStatus(), output.getStatus());
	}
	
	@Test
	public void getAllProjectsTest(){
		Mockito.when(projectRepository.findAll())
				.thenReturn(new ProjectMockData().getProjectList());
		
		List<ProjectRecord> output = projectService.getAllProjects();
		assertEquals(2, output.size());
	}
	
	@Test(expected = RuntimeException.class)
	public void getAllProjectsNavigativeScenario(){
		Mockito.when(projectRepository.findAll())
				.thenThrow(new RuntimeException());
		
		List<ProjectRecord> output = projectService.getAllProjects();
		assertEquals(2, output.size());
	}
	
	@Test
	public void updateProjectTest(){
		Mockito.when(projectRepository.save(new ProjectMockData().getProject()))
				.thenReturn(new ProjectMockData().getProject());
		
		ProjectRecord output = projectService.updateProject(1l,new ProjectMockData().getProjectRecord());
		assertEquals(new ProjectMockData().getProjectRecord().getPriority(), output.getPriority());
		assertEquals(new ProjectMockData().getProjectRecord().getStatus(), output.getStatus());
	}
	
	@Test(expected = RuntimeException.class)
	public void updateProjectNavigativeScenario(){
		Mockito.when(projectRepository.save(Mockito.any(Project.class)))
				.thenThrow(new RuntimeException());
		
		ProjectRecord output = projectService.updateProject(1l,new ProjectMockData().getProjectRecord());
		assertEquals(new ProjectMockData().getProjectRecord().getPriority(), output.getPriority());
		assertEquals(new ProjectMockData().getProjectRecord().getStatus(), output.getStatus());
	}
	
	@Test
	public void suspendProjectTest(){
		projectRepository.suspendById(Mockito.anyLong());
		taskRepository.suspendtaskById(Mockito.anyLong());
		String output = projectService.suspendProject(1l);
		Assert.assertEquals("Suspended", output);
	}
	
	@Test(expected = RuntimeException.class)
	public void suspendProjectNavigativeScenario(){
		Mockito.doThrow(EmptyResultDataAccessException.class).when(projectRepository).suspendById(Mockito.anyLong());
		
		String output = projectService.suspendProject(1l);
		Assert.assertEquals("Suspended", output);
	}
	
	@Test
	public void getAllProjectsRecordTest(){
		Mockito.when(projectRepository.findAllProjects())
				.thenReturn(new ProjectMockData().getProjectList());
		Mockito.when(taskService.getNoOfTasks(Mockito.anyLong()))
				.thenReturn(new ProjectMockData().getNoOfTasks());
		Mockito.when(taskService.getCompletedTasks(Mockito.anyLong()))
				.thenReturn(new ProjectMockData().getCompletedTasks());
		Mockito.when(userService.getUserData(Mockito.anyLong())).thenReturn(new UserMockData().getUserName());

		
		List<ProjectRecord> output = projectService.getAllProjectsRecord();
		assertEquals(2, output.size());
	}
	
	@Test(expected = RuntimeException.class)
	public void getAllProjectsRecordNavigativeScenario(){
		Mockito.when(projectRepository.findAllProjects())
				.thenThrow(new RuntimeException());
		Mockito.when(taskService.getNoOfTasks(Mockito.anyLong()))
				.thenThrow(new RuntimeException());
		Mockito.when(taskService.getCompletedTasks(Mockito.anyLong()))
				.thenThrow(new RuntimeException());
		Mockito.when(userService.getUserData(Mockito.anyLong()))
				.thenThrow(new RuntimeException());

		
		List<ProjectRecord> output = projectService.getAllProjectsRecord();
		assertEquals(2, output.size());
	}
	
	@Test
    public void getProjectDataTest() {
    	Mockito.when(projectRepository.getProjectNameById(Mockito.anyLong()))
		.thenReturn(new ProjectMockData().getProjectName());
    	String output = projectService.getProjectData(1l);
    	Assert.assertEquals("DummyProject", output);
    }
	
	
	
	
	
	
}
