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

import com.cognizant.projectmanager.entity.Task;
import com.cognizant.projectmanager.model.TaskRecord;
import com.cognizant.projectmanager.repository.TaskRepository;
import com.cognizant.projectmanager.service.ParentTaskService;
import com.cognizant.projectmanager.service.ProjectService;
import com.cognizant.projectmanager.service.TaskService;
import com.cognizant.projectmanager.service.UserService;
import com.cognizant.projectmanager.utiltest.ParentTaskMockData;
import com.cognizant.projectmanager.utiltest.ProjectMockData;
import com.cognizant.projectmanager.utiltest.TaskMockData;
import com.cognizant.projectmanager.utiltest.UserMockData;

@RunWith(SpringJUnit4ClassRunner.class)
public class TaskServiceTest {
	
	@InjectMocks
	public TaskService taskService;
	
	@Mock
	public TaskRepository taskRepository;
	
	@Mock
	ParentTaskService parentTaskService;
	
	@Mock
	UserService userService;
	
	@Mock
	ProjectService projectService;
	
	@Test
	public void addTaskTest(){
		Mockito.when(taskRepository.save(new TaskMockData().getTask()))
				.thenReturn(new TaskMockData().getTask());
		
		TaskRecord output = taskService.addTask(new TaskMockData().getTaskRecord());
		assertEquals(new TaskMockData().getTask().getPriority(), output.getPriority());
		assertEquals(new TaskMockData().getTask().getTaskName(), output.getTaskName());
		
	}
	
	@Test(expected = RuntimeException.class)
	public void addTaskNavigativeScenario(){
		Mockito.when(taskRepository.save(Mockito.any(Task.class)))
				.thenThrow(new RuntimeException());
		
		TaskRecord output = taskService.addTask(new TaskMockData().getTaskRecord());
		assertEquals(new TaskMockData().getTask().getPriority(), output.getPriority());
		assertEquals(new TaskMockData().getTask().getTaskName(), output.getTaskName());
		
	}
	
	@Test
	public void getAllTasksTest(){
		Mockito.when(taskRepository.findAll())
				.thenReturn(new TaskMockData().getTaskList());
		
		List<TaskRecord> output = taskService.getAllTasks();
		assertEquals(2, output.size());
	}
	
	@Test(expected = RuntimeException.class)
	public void getAllTasksNavigativeScenario(){
		Mockito.when(taskRepository.findAll())
				.thenThrow(new RuntimeException());
		
		List<TaskRecord> output = taskService.getAllTasks();
		assertEquals(2, output.size());
	}
	
	@Test
	public void updateTaskTest(){
		Mockito.when(taskRepository.save(new TaskMockData().getTask()))
				.thenReturn(new TaskMockData().getTask());
		
		TaskRecord output = taskService.updateTask(1l, new TaskMockData().getTaskRecord());
		assertEquals(new TaskMockData().getTask().getPriority(), output.getPriority());
		assertEquals(new TaskMockData().getTaskRecord().getTaskName(), output.getTaskName());
	}
	
	@Test(expected = RuntimeException.class)
	public void updateTaskNavigativeScenario(){
		Mockito.when(taskRepository.save(Mockito.any(Task.class)))
				.thenThrow(new RuntimeException());
		
		TaskRecord output = taskService.updateTask(1l, new TaskMockData().getTaskRecord());
		assertEquals(new TaskMockData().getTask().getPriority(), output.getPriority());
		assertEquals(new TaskMockData().getTaskRecord().getTaskName(), output.getTaskName());
	}
	
	@Test
	public void searchTaskByIdTest(){
		Mockito.when(taskRepository.getTaskById(Mockito.anyLong()))
				.thenReturn(new TaskMockData().getTaskList());
		Mockito.when(parentTaskService.getparentTaskData(Mockito.anyLong()))
				.thenReturn(new ParentTaskMockData().getParentTaskName());

		Mockito.when(userService.getUserData(Mockito.anyLong())).thenReturn(new UserMockData().getUserName());

		Mockito.when(projectService.getProjectData(Mockito.anyLong()))
				.thenReturn(new ProjectMockData().getProjectName());
		
		List<TaskRecord> output = taskService.searchTaskById(1l);
		assertEquals(2, output.size());
	}
	
	@Test(expected = RuntimeException.class)
	public void searchTaskByIdNavigativeScenario(){
		Mockito.when(taskRepository.getTaskById(Mockito.anyLong()))
				.thenThrow(new RuntimeException());
		
		List<TaskRecord> output = taskService.searchTaskById(1l);
		assertEquals(2, output.size());
	}
	
	@Test
	public void getTaskByIdTest(){
		Mockito.when(taskRepository.getTask(Mockito.anyLong()))
				.thenReturn(new TaskMockData().getTask());
		Mockito.when(parentTaskService.getparentTaskData(Mockito.anyLong()))
				.thenReturn(new ParentTaskMockData().getParentTaskName());

		Mockito.when(userService.getUserData(Mockito.anyLong())).thenReturn(new UserMockData().getUserName());

		Mockito.when(projectService.getProjectData(Mockito.anyLong()))
				.thenReturn(new ProjectMockData().getProjectName());
		
		TaskRecord output = taskService.getTaskById(1l);
		assertEquals(new TaskMockData().getTaskRecord().getUserName(), output.getUserName());
		assertEquals(new TaskMockData().getTaskRecord().getTaskName(), output.getTaskName());
	}
	
	@Test(expected = RuntimeException.class)
	public void getTaskByIdNavigativeScenario(){
		Mockito.when(taskRepository.getTask(Mockito.anyLong()))
				.thenThrow(new RuntimeException());
		
		TaskRecord output = taskService.getTaskById(1l);
		assertEquals(new TaskMockData().getTaskRecord().getUserName(), output.getUserName());
		assertEquals(new TaskMockData().getTaskRecord().getTaskName(), output.getTaskName());
	}
	
	
	@Test
	public void endTaskTest(){
		assertEquals("Completed", taskService.endTask(1l));
	}
	
	@Test(expected = RuntimeException.class)
	public void endTaskTestNavigativeScenario() {
		Mockito.doThrow(EmptyResultDataAccessException.class).when(taskRepository).completeById(Mockito.anyLong());

		String output = taskService.endTask(1l);

		Assert.assertEquals("Deleted", output);
	}
	
	@Test
	public void getNoOfTasksTest() {

		Mockito.when(taskRepository.getTaskCount(Mockito.anyLong())).thenReturn(new TaskMockData().getNoOfTasks());
		Mockito.when(taskRepository.getTaskCount(Mockito.anyLong())).thenReturn(null);

		Long output = taskService.getNoOfTasks(Mockito.anyLong());

		Assert.assertEquals(Long.valueOf(0), output);

	}

	@Test
	public void getCompletedTasksTest() {

		Mockito.when(taskRepository.getCompletedTaskCount(Mockito.anyLong()))
				.thenReturn(new TaskMockData().getCompletedTasks());
		Mockito.when(taskRepository.getCompletedTaskCount(Mockito.anyLong()))
		.thenReturn(null);

		Long output = taskService.getCompletedTasks(Mockito.anyLong());

		Assert.assertEquals(Long.valueOf(0), output);

	}
}
