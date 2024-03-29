package com.cognizant.projectmanager.modeltest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.projectmanager.model.UserRecord;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserRecordTest {
	
	@Test
	public void testUserRecord(){
		UserRecord userRecord = new UserRecord();
		userRecord.setUserId(1l);
		assertEquals(Long.valueOf(1l), userRecord.getUserId());
		userRecord.setFirstName("firstName");
		assertEquals("firstName", userRecord.getFirstName());
		userRecord.setLastName("lastName");
		assertEquals("lastName", userRecord.getLastName());
		userRecord.setEmpId(1l);
		assertEquals(Long.valueOf(1l), userRecord.getEmpId());
		userRecord.setUserName("userName");
		assertEquals("userName", userRecord.getUserName());
		UserRecord test = new UserRecord(1l,"firstName","lastName", 1l);
		assertEquals("lastName", test.getLastName());
		UserRecord test2 = new UserRecord(1l,"firstName","lastName","userName", 1l);
		assertEquals("userName", test2.getUserName());
	}

}
