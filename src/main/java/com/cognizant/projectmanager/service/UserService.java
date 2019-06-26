package com.cognizant.projectmanager.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.projectmanager.entity.User;
import com.cognizant.projectmanager.model.UserRecord;
import com.cognizant.projectmanager.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	private static final Logger logger = Logger.getLogger(UserService.class.getName());
	
	@Autowired
	UserRepository userRepository;
	
	public UserRecord addUser(UserRecord userRecord){
		try {
			logger.info("adding data in user table");
			User user = new User();
			user.setFirstName(userRecord.getFirstName());
			user.setLastName(userRecord.getLastName());
			user.setEmpId(userRecord.getEmpId());
			userRepository.save(user);
			
			return userRecord;
			
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occured while adding data in user table",e.getMessage());
			throw e;
		}
	}
	
	public List<UserRecord> getAllUsers(){
		try {
			logger.info("getting data from user table");
			List<User> users = new ArrayList<User>();
			userRepository.findAll().forEach(users::add);
			List<UserRecord> userList = new ArrayList<UserRecord>();
			for(User u: users){
				UserRecord userRecord = new UserRecord();
				userRecord.setUserId(u.getUserId());
				userRecord.setFirstName(u.getFirstName());
				userRecord.setEmpId(u.getEmpId());				
				userList.add(userRecord);
			}
			
			return userList;
			
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occured while getting data from user table",e.getMessage());
			throw e;
		}
	}
	
	public UserRecord updateUser(Long id, UserRecord userRecord){
		try {
			logger.info("updating data in user table");
			User user = new User();
			user.setUserId(id);
			user.setFirstName(userRecord.getFirstName());
			user.setLastName(userRecord.getLastName());
			user.setEmpId(userRecord.getEmpId());
			userRepository.save(user);
			return userRecord;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occured while updating data in user table",e.getMessage());
			throw e;
		}
	}
	
	public String deleteUser(Long id){
		try {
			logger.info("deleting data in user table");
			userRepository.deleteById(id);
			return "Deleted";
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occured while deleting data in user table",e.getMessage());
			throw e;
		}
	}

}
