 package com.instagram.Instagram.Util;

import java.sql.Timestamp;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.instagram.Instagram.Model.Post;
import com.instagram.Instagram.Model.User;
import com.instagram.Instagram.Repository.IUserRepository;


@Component
public class PostUtil {
	
	@Autowired
	IUserRepository iUserRepository;
	
	
    public Post setPost(String postRequest) {
    	
        JSONObject jsonObject = new JSONObject(postRequest);

        User user = null;

        int userId = jsonObject.getInt("userId");

        if(iUserRepository.findById(userId).isPresent()) {
            user = iUserRepository.findById(userId).get();
        } else {
            return null;
        }

        Post post = new Post();
        post.setUser(user);
        post.setPostData(jsonObject.getString("postData"));
        Timestamp createdTime = new Timestamp(System.currentTimeMillis());
        post.setCreatedDate(createdTime);
        Timestamp updateDate = new Timestamp(System.currentTimeMillis());
        post.setUpdatedDate(updateDate);

        return post;


    }
    public JSONObject setPost(Post post) {

        JSONObject masterJson = new JSONObject();
        masterJson.put("postId", post.getPostId());
        masterJson.put("postData" , post.getPostData());

        User user = post.getUser();

        JSONObject userJsonObj = new JSONObject();
        userJsonObj.put("userId", user.getUserId());
        userJsonObj.put("firstName" , user.getFirstName());
        userJsonObj.put("age" , user.getAge());

        masterJson.put("user" , userJsonObj);

        return masterJson;
    }
}
