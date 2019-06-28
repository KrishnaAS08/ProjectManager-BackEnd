package com.cognizant.projectmanager.controllertest;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.projectmanager.controller.ParentTaskController;
import com.cognizant.projectmanager.model.ParentTaskRecord;
import com.cognizant.projectmanager.service.ParentTaskService;
import com.cognizant.projectmanager.utiltest.ParentTaskMockData;

@RunWith(SpringJUnit4ClassRunner.class)
public class ParentTaskControllerTest {
	
	@InjectMocks
	public ParentTaskController parentTaskController;
	
	@Mock
	public ParentTaskService parentTaskService;
	
	@Test
    public void addParentTaskTest(){

        Mockito.when(parentTaskService.addParentTask(Mockito.any(ParentTaskRecord.class)))
        		.thenReturn(new ParentTaskMockData().getParentTaskRecord());
        ParentTaskRecord output = parentTaskController.addParentTask(new ParentTaskMockData().getParentTaskRecord());

        Assert.assertEquals(new ParentTaskMockData().getParentTaskRecord().getParentName(), output.getParentName());
    }

    @Test
    public void getParentTasksTest(){

        Mockito.when(parentTaskService.getParentTasks()).thenReturn(new ParentTaskMockData().getParentTaskRecordList());
        List<ParentTaskRecord> output = parentTaskController.getParentTasks();

        Assert.assertEquals(2, output.size());
    }
	
}
