package com.instagram.Instagram.Util;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.instagram.Instagram.Model.User;

@Component
public class UserUtil {
	
	    public static User setUser(String userData) {

	        JSONObject jsonObject = new JSONObject(userData);
	        User user = new User();

	        user.setAge(jsonObject.getInt("age"));
	        user.setEmail(jsonObject.getString("email"));
	        user.setFirstName(jsonObject.getString("firstName"));
	        user.setLastName(jsonObject.getString("lastName"));
	        user.setPhoneNumber(jsonObject.getString("phoneNumber"));

	        return user;

	    }
	  
	    public static JSONObject setUser (User user) {

	        JSONObject jsonObject = new JSONObject();
	        jsonObject.put("userId", user.getUserId());
	        jsonObject.put("firstName", user.getFirstName());
	        jsonObject.put("lastName", user.getLastName());
	        jsonObject.put("age", user.getAge());
	        jsonObject.put("email", user.getEmail());
	        jsonObject.put("phoneNumber", user.getPhoneNumber());

	        return jsonObject;

	    }

}
