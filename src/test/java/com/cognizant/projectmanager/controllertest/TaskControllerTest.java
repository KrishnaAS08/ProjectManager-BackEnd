package com.cognizant.projectmanager.controllertest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.projectmanager.controller.TaskController;
import com.cognizant.projectmanager.model.TaskRecord;
import com.cognizant.projectmanager.service.TaskService;
import com.cognizant.projectmanager.utiltest.TaskMockData;

@RunWith(SpringJUnit4ClassRunner.class)
public class TaskControllerTest {
	
	@InjectMocks
	public TaskController taskController;
	
	@Mock
	public TaskService taskService;
	
	@Test
	public void addTaskTest(){
		Mockito.when(taskService.addTask(Mockito.any(TaskRecord.class)))
				.thenReturn(new TaskMockData().getTaskRecord());
		
		TaskRecord output = taskController.addTask(new TaskMockData().getTaskRecord());
		assertEquals(new TaskMockData().getTaskRecord().getUserName(), output.getUserName());
		assertEquals(new TaskMockData().getTaskRecord().getTaskName(), output.getTaskName());
		
	}
	
	@Test
	public void getAllTasksTest(){
		Mockito.when(taskService.getAllTasks())
				.thenReturn(new TaskMockData().getTaskRecordList());
		
		List<TaskRecord> output = taskController.getAllTasks();
		assertEquals(2, output.size());
	}
	
	@Test
	public void updateTask(){
		Mockito.when(taskService.updateTask(Mockito.anyLong(), Mockito.any(TaskRecord.class)))
				.thenReturn(new TaskMockData().getTaskRecord());
		
		TaskRecord output = taskController.updateTask(1l, new TaskMockData().getTaskRecord());
		assertEquals(new TaskMockData().getTaskRecord().getUserName(), output.getUserName());
		assertEquals(new TaskMockData().getTaskRecord().getTaskName(), output.getTaskName());
	}
	
	@Test
	public void endTaskTest(){
		Mockito.when(taskService.endTask(Mockito.anyLong())).thenReturn("Completed");
		
		String output = taskController.endTask(1l);
		assertEquals("Completed", output);		
	}
	
	@Test
	public void searchTaskByIdTest(){
		Mockito.when(taskService.searchTaskById(Mockito.anyLong()))
				.thenReturn(new TaskMockData().getTaskRecordList());
		
		List<TaskRecord> output = taskController.searchTaskById(1l);
		assertEquals(2, output.size());
	}
	
	@Test
	public void getTaskByIdTest(){
		Mockito.when(taskService.getTaskById(Mockito.anyLong()))
		.thenReturn(new TaskMockData().getTaskRecord());
		
		TaskRecord output = taskController.getTaskById(1l);
		assertEquals(new TaskMockData().getTaskRecord().getUserName(), output.getUserName());
		assertEquals(new TaskMockData().getTaskRecord().getTaskName(), output.getTaskName());
	}
	
}
