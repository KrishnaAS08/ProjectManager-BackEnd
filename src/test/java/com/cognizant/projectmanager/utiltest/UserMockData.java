package com.cognizant.projectmanager.utiltest;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.projectmanager.entity.User;
import com.cognizant.projectmanager.model.UserRecord;

public class UserMockData {
	
	public UserRecord getUserRecord(){
		
		UserRecord userRecord = new UserRecord();
		userRecord.setUserId(1l);
		userRecord.setFirstName("firstName");
		userRecord.setEmpId(1l);
		return userRecord;
	}
	
	public List<UserRecord> getUserRecordList(){
		
		List<UserRecord> userList = new ArrayList<UserRecord>();
		userList.add(new UserRecord(1l, "firstName1", "lastName1", 1l));
		userList.add(new UserRecord(2l, "firstName2", "lastName2", 2l));
		return userList;
	}
	
	public User getUser(){
		return new User("firstName1", "lastName1", 1l);
	}
	
public List<User> getUserList(){
		
		List<User> userList = new ArrayList<User>();
		userList.add(new User("firstName1", "lastName1", 1l));
		userList.add(new User("firstName2", "lastName2", 2l));
		return userList;
	}

}
