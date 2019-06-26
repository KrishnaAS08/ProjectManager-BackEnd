package com.cognizant.projectmanager.modeltest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.projectmanager.model.ParentTaskRecord;

@RunWith(SpringJUnit4ClassRunner.class)
public class ParentTaskRecordTest {
	
	@Test
	public void testParentTaskRecord(){
		ParentTaskRecord test = new ParentTaskRecord();
		test.setParentId(1l);
		assertEquals(Long.valueOf(1l), test.getParentId());
		test.setParentName("parentName");
		assertEquals("parentName", test.getParentName());
		ParentTaskRecord parent = new ParentTaskRecord("parentName");
		assertEquals("parentName", parent.getParentName());
	}

}
