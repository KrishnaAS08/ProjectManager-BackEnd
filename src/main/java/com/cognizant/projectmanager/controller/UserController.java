package com.cognizant.projectmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.projectmanager.model.UserRecord;
import com.cognizant.projectmanager.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/projectmanager/users")
public class UserController {

	
	@Autowired
	UserService userService;
	
	@PostMapping(value = "/addUser")
	public UserRecord addUser(@RequestBody UserRecord userRecord){
		return userService.addUser(userRecord);
	}
	
	@GetMapping(value = "/getAllUsers")
	public List<UserRecord> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@PutMapping(value = "/updateUser/{userId}")
	public UserRecord updateUser(@PathVariable("userId") Long userId, @RequestBody UserRecord userRecord){
		return userService.updateUser(userId, userRecord);
	}
	
	@DeleteMapping(value = "/deleteUser/{userId}")
	public String deleteUser(@PathVariable("userId") Long userId){
		return userService.deleteUser(userId);
	}

}
