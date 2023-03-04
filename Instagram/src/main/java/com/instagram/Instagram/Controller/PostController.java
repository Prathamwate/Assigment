package com.instagram.Instagram.Controller;

import java.sql.Timestamp;

import org.json.JSONArray;
import org.json.JSONObject;
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

import com.instagram.Instagram.Model.Post;
import com.instagram.Instagram.Model.User;
import com.instagram.Instagram.Repository.IUserRepository;
import com.instagram.Instagram.Service.PostService;

import com.instagram.Instagram.Util.PostUtil;

import jakarta.annotation.Nullable;

@RestController
@RequestMapping("apiPost")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	IUserRepository iUserRepository;
	
	@Autowired
	PostUtil postUtil;
	

	
	@PostMapping(value = "/post")
    public ResponseEntity<String> savePost(@RequestBody String postRequest) {

        Post post =postUtil.setPost(postRequest);
        int postId = postService.savePost(post);
        return new ResponseEntity<String>(String.valueOf(postId), HttpStatus.CREATED);
    }
	
	@GetMapping(value = "/post")
	public ResponseEntity<String> getPost(@RequestParam String userId,@Nullable String postId){
		 JSONArray postArr = postService.getPost(Integer.valueOf(userId), postId);
		return new ResponseEntity<String>(postArr.toString(),HttpStatus.OK);
		
	}
	

    @PutMapping(value = "/post/{postId}")
    public ResponseEntity<String> updatePost(@PathVariable String postId, @RequestBody String postRequest) {

        Post post = setPost(postRequest);
        postService.updatePost(postId, post);
        return  new ResponseEntity<>("Post updated", HttpStatus.OK);


    }



    private Post setPost(String postRequest) {
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
        return post;


    }
	

	
}
