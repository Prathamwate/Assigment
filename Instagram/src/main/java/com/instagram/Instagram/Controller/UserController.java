package com.instagram.Instagram.Controller;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.instagram.Instagram.Model.User;
import com.instagram.Instagram.Service.UserService;
import com.instagram.Instagram.Util.UserUtil;

import jakarta.annotation.Nullable;
import lombok.Getter;

@RestController
@RequestMapping("/apiUser")
public class UserController {
	
	@GetMapping("/msg")
	public String getMsg() {
		return "Hii";
	}
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/user")
	public ResponseEntity<String> saveUser(@RequestBody String userData){
		
		  User user =UserUtil.setUser(userData);
	      int userId = userService.saveUser(user);
	        
	     return new ResponseEntity<>("user saved with id- " +userId, HttpStatus.CREATED);
	
		
	}
	
	 @GetMapping(value = "/user")
	 public ResponseEntity<String> getUser(@Nullable @RequestParam String userId) {
		 	JSONArray userDetails = userService.getUser(userId);
	        return new ResponseEntity<String>(userDetails.toString(), HttpStatus.OK);
	    }
	 
	 
	  @PutMapping(value = "/user/{userId}")
	    public ResponseEntity<String> updateUser(@PathVariable String userId, @RequestBody String userData) {

	        User user = UserUtil.setUser(userData);
	        userService.updateUser(user, userId);

	        return new ResponseEntity<String>("user updated", HttpStatus.OK);

	    }
} 

