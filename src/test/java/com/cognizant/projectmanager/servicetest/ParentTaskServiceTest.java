package com.cognizant.projectmanager.servicetest;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.projectmanager.entity.ParentTask;
import com.cognizant.projectmanager.model.ParentTaskRecord;
import com.cognizant.projectmanager.repository.ParentTaskRepository;
import com.cognizant.projectmanager.service.ParentTaskService;
import com.cognizant.projectmanager.utiltest.ParentTaskMockData;


@RunWith(SpringJUnit4ClassRunner.class)
public class ParentTaskServiceTest {

    @InjectMocks
    public ParentTaskService parentTaskService;

    @Mock
    public ParentTaskRepository parentTaskRepository;

    @Test
    public void addParentTaskTest(){

        Mockito.when(parentTaskRepository.save(Mockito.any(ParentTask.class))).thenReturn(new ParentTaskMockData().getParentTask());

        ParentTaskRecord output =  parentTaskService.addParentTask(new ParentTaskMockData().getParentTaskRecord());
        Assert.assertEquals(new ParentTaskMockData().getParentTaskRecord().getParentName(), output.getParentName());

    }
    
    @Test(expected = RuntimeException.class)
    public void saveTestNavigativeScenario() {    	
    	Mockito.when(parentTaskRepository.save(Mockito.any(ParentTask.class))).thenThrow( new RuntimeException());
    	
    	ParentTaskRecord output =  parentTaskService.addParentTask(new ParentTaskMockData().getParentTaskRecord());
        Assert.assertEquals(new ParentTaskMockData().getParentTaskRecord().getParentName(), output.getParentName());
    }

    @Test
    public void getParentTasksTest(){

        Mockito.when(parentTaskRepository.findAll()).thenReturn(new ParentTaskMockData().getParentTaskList());
        List<ParentTaskRecord> output = parentTaskService.getParentTasks();

        Assert.assertEquals(2, output.size());

    }
    
    @Test(expected = RuntimeException.class)
    public void getParentTasksTestNavigativeScenario() {    	
    	 Mockito.when(parentTaskRepository.findAll()).thenThrow(RuntimeException.class);
         List<ParentTaskRecord> output = parentTaskService.getParentTasks();

         Assert.assertEquals(2, output.size());
    }
    
    @Test
    public void getparentTaskDataTest() {
    	Mockito.when(parentTaskRepository.getParentNameById(Mockito.anyLong()))
		.thenReturn(new ParentTaskMockData().getParentTaskName());
    	String output = parentTaskService.getparentTaskData(1l);
    	Assert.assertEquals("DummyParentTask", output);
    }
    
}

