package com.Ezu.UserInterview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Ezu.UserInterview.model.UserInterview;
import com.Ezu.UserInterview.service.UserService;


@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody UserInterview userInterview){
		UserInterview userInterview2=userService.saveUser(userInterview);
		return new ResponseEntity<>(userInterview2.toString(),HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<String> getAllUser(){
		List<UserInterview> aList=userService.getAll();
		return new ResponseEntity<String>(aList.toString(),HttpStatus.OK);
	}
	
	@PutMapping("/updateData/{userId}/{email}")
	public ResponseEntity<String> updateData(@PathVariable Integer userId, @PathVariable String email){
		String msgString=userService.updateData(userId ,email );
		return new ResponseEntity<String>(msgString,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{userid}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer userid){
		String msgString=userService.deleteUser(userid);
		return new ResponseEntity<String>(msgString,HttpStatus.OK);
	}
}
