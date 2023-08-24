package com.Ezu.UserInterview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ezu.UserInterview.model.UserInterview;
import com.Ezu.UserInterview.repo.UserInterviewRepository;


@Service
public class UserService {

	@Autowired
	private UserInterviewRepository userInterviewRepository;
	
	public UserInterview saveUser(UserInterview userInterview) {
		return userInterviewRepository.save(userInterview);
		
	}

	public List<UserInterview> getAll() {
	   List<UserInterview> aList=userInterviewRepository.findAll();
		return aList;
	}

	public String updateData(Integer userid, String email) {
		try {
			UserInterview userInterview=userInterviewRepository.findById(userid).get();
			userInterview.setEmail(email);
			return "Data Updated";
		}
		catch (Exception e) {
			return "User Not Found";
		}
	}

	public String deleteUser(Integer userid) {
		try{
			userInterviewRepository.deleteById(userid);
			return "User Deleted";
		} catch (Exception e) {
			return "User Not Found";
		}
		
	}

}
