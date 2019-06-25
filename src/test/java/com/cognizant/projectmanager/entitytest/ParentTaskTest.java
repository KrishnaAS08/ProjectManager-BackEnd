package com.cognizant.projectmanager.entitytest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.projectmanager.entity.ParentTask;

@RunWith(SpringJUnit4ClassRunner.class)
public class ParentTaskTest {
	
	@Test
	public void testParentTask(){
		ParentTask test = new ParentTask();
		test.setParentId(1l);
		assertEquals(Long.valueOf(1l),test.getParentId());
		String parentName = "parentName";
		test.setParentName(parentName);
		assertEquals("parentName", test.getParentName());
		ParentTask task = new ParentTask("parentName");
		assertEquals("parentName", task.getParentName());
	}

}
