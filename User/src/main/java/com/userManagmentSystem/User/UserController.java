package com.userManagmentSystem.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userservice;
	

	
	@GetMapping("/getAllUser")
	public List<User> getAllUser() {
		return userservice.allUser();
	}
	
	@GetMapping("/getUser/{userId}")
	public User getUser(@PathVariable int userId) {
		return userservice.getUser(userId);
	}
	
	@PostMapping("/addUser")
	public void addUser(@RequestBody User user) {
		userservice.addUser(user);
	}
	
	@PutMapping("/updateUserInfo/{userId}")
	public void updareUserInfo(@PathVariable int userId,@RequestBody User user) {
		userservice.updateUserInfo(userId,user);
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public void  deleteUser(@PathVariable int userId) {
	       userservice.deleteUser(userId);
	}
	

}
