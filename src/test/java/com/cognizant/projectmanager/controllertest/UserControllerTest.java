package com.cognizant.projectmanager.controllertest;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.projectmanager.controller.UserController;
import com.cognizant.projectmanager.model.UserRecord;
import com.cognizant.projectmanager.service.UserService;
import com.cognizant.projectmanager.utiltest.UserMockData;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {
	
	@InjectMocks
	public UserController userController;
	
	@Mock
	public UserService userService;
	
	@Test
	public void addUserTest(){
		Mockito.when(userService.addUser(Mockito.any(UserRecord.class)))
				.thenReturn(new UserMockData().getUserRecord());
		UserRecord output = userController.addUser(new UserMockData().getUserRecord());
		Assert.assertEquals(new UserMockData().getUserRecord().getFirstName(), output.getFirstName());
		Assert.assertEquals(new UserMockData().getUserRecord().getLastName(), output.getLastName());
	}
	
	@Test
	public void getAllUsersTest(){
		Mockito.when(userService.getAllUsers()).thenReturn(new UserMockData().getUserRecordList());
		List<UserRecord> output = userController.getAllUsers();
		Assert.assertEquals(2, output.size());
	}
	
	@Test
	public void updateUserTest(){
		Mockito.when(userService.updateUser(Mockito.anyLong(), Mockito.any(UserRecord.class)))
				.thenReturn(new UserMockData().getUserRecord());
		UserRecord output = userController.updateUser(1l,new UserMockData().getUserRecord());
		Assert.assertEquals(new UserMockData().getUserRecord().getFirstName(), output.getFirstName());
		Assert.assertEquals(new UserMockData().getUserRecord().getLastName(), output.getLastName());
	}
	
	@Test
	public void deleteUserTest(){
		Mockito.when(userService.deleteUser(Mockito.anyLong()))
		.thenReturn("Deleted");
		String output = userController.deleteUser(1l);
		Assert.assertEquals("Deleted", output);
	}

}
