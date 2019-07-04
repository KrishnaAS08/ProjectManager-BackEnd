package com.cognizant.projectmanager.servicetest;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.projectmanager.entity.User;
import com.cognizant.projectmanager.model.UserRecord;
import com.cognizant.projectmanager.repository.UserRepository;
import com.cognizant.projectmanager.service.UserService;
import com.cognizant.projectmanager.utiltest.UserMockData;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {
	
	@InjectMocks
	public UserService userService;
	
	@Mock
	public UserRepository userRepository;
	
	@Test
	public void addUserTest(){
		Mockito.when(userRepository.save(new UserMockData().getUser()))
				.thenReturn(new UserMockData().getUser());
		UserRecord output = userService.addUser(new UserMockData().getUserRecord());
		Assert.assertEquals(new UserMockData().getUserRecord().getFirstName(), output.getFirstName());
		Assert.assertEquals(new UserMockData().getUserRecord().getLastName(), output.getLastName());
	}
	
	@Test(expected = RuntimeException.class)
	public void addUserNavigativeScenario(){
		Mockito.when(userRepository.save(Mockito.any(User.class)))
				.thenThrow(new RuntimeException());
		
		UserRecord output = userService.addUser(new UserMockData().getUserRecord());
		Assert.assertEquals(new UserMockData().getUserRecord().getFirstName(), output.getFirstName());
		Assert.assertEquals(new UserMockData().getUserRecord().getLastName(), output.getLastName());
		
	}
	
	@Test
	public void getAllUsersTest(){
		Mockito.when(userRepository.findAll()).thenReturn(new UserMockData().getUserList());
		List<UserRecord> output = userService.getAllUsers();
		Assert.assertEquals(2, output.size());
	}
	
	@Test(expected = RuntimeException.class)
	public void getAllUsersNavigativeScenario(){
		Mockito.when(userRepository.findAll()).thenThrow(RuntimeException.class);
		
		List<UserRecord> output = userService.getAllUsers();
		Assert.assertEquals(2, output.size());
	}
	
	@Test
	public void updateUserTest(){
		Mockito.when(userRepository.save(new UserMockData().getUser()))
				.thenReturn(new UserMockData().getUser());
		UserRecord output = userService.updateUser(1l,new UserMockData().getUserRecord());
		Assert.assertEquals(new UserMockData().getUserRecord().getFirstName(), output.getFirstName());
		Assert.assertEquals(new UserMockData().getUserRecord().getLastName(), output.getLastName());
	} 
	
	@Test(expected = RuntimeException.class)
	public void updateUserNavigativeScenario(){
		Mockito.when(userRepository.save(Mockito.any(User.class)))
				.thenThrow(RuntimeException.class);
		
		UserRecord output = userService.updateUser(1l,new UserMockData().getUserRecord());
		Assert.assertEquals(new UserMockData().getUserRecord().getFirstName(), output.getFirstName());
		Assert.assertEquals(new UserMockData().getUserRecord().getLastName(), output.getLastName());
	}
	
	@Test
	public void deleteUserTest(){
		String output = userService.deleteUser(1l);
		Assert.assertEquals("Deleted", output);
	}
	
	@Test(expected = RuntimeException.class)
	public void deleteUserNavigativeScenario(){
		Mockito.doThrow(EmptyResultDataAccessException.class).when(userRepository).deleteById(Mockito.anyLong());
		
		String output = userService.deleteUser(1l);
		Assert.assertEquals("Deleted", output);
	}
	
	@Test
    public void getUserDataTest() {
    	Mockito.when(userRepository.getUserNameById(Mockito.anyLong()))
		.thenReturn(new UserMockData().getUserName());
    	String output = userService.getUserData(1l);
    	Assert.assertEquals("userName", output);
    }

}
