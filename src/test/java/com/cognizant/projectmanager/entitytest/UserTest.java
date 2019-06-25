package com.cognizant.projectmanager.entitytest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.projectmanager.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest {
	
	@Test
	public void testUser(){
		User user = new User();
		user.setUserId(1l);
		assertEquals(Long.valueOf(1l), user.getUserId());
		String firstName = "firstName";
		user.setFirstName(firstName);
		assertEquals("firstName", user.getFirstName());
		String lastName = "lastName";
		user.setLastName(lastName);
		assertEquals("lastName", user.getLastName());
		Long empId = 1l;
		user.setEmpId(empId);
		assertEquals(Long.valueOf(1l), user.getEmpId());
		User test = new User("firstName","lastName",1l);
		assertEquals("firstName", test.getFirstName());
	}

}
