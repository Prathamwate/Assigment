package com.instagram.Instagram.Service;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instagram.Instagram.Model.User;
import com.instagram.Instagram.Repository.IUserRepository;
import com.instagram.Instagram.Util.UserUtil;

@Service
public class UserService{
	
	@Autowired
	public IUserRepository iUserRepository;

	public int saveUser(User user) {
	    User idUser= iUserRepository.save(user);
		return idUser.getUserId();
	}

	public JSONArray getUser(String userId) {
		 JSONArray userArray = new JSONArray();
		 if( null != userId && iUserRepository.findById(Integer.valueOf(userId)).isPresent()) {

	            User user = iUserRepository.findById(Integer.valueOf(userId)).get();
	            JSONObject userObj = UserUtil.setUser(user);
	            userArray.put(userObj);
	        } else {
	            List<User> userList = iUserRepository.findAll();
	            for (User user: userList) {
	                JSONObject userObj = UserUtil.setUser(user);
	                userArray.put(userObj);
	            }
	        }
	        return userArray;
	}
	
	    public void updateUser(User newUser, String userId) {

	        if(iUserRepository.findById(Integer.valueOf(userId)).isPresent()) {
	            User user = iUserRepository.findById(Integer.valueOf(userId)).get();
	            iUserRepository.save(newUser);
	        }
	
	    }

}
