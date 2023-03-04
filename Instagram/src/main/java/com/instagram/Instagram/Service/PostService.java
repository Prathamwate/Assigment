package com.instagram.Instagram.Service;

import java.sql.Timestamp;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instagram.Instagram.Model.Post;
import com.instagram.Instagram.Model.User;
import com.instagram.Instagram.Repository.IPostRepository;
import com.instagram.Instagram.Util.PostUtil;

@Service
public class PostService {

	@Autowired
	IPostRepository iPostRepository;

	@Autowired
	PostUtil postUtil;
	
	
	
//	public PostService(PostUtil postUtil,IPostRepository iPostRepository) {
//		this.postUtil=postUtil;
//		this.iPostRepository=iPostRepository;
//	}

	public int savePost(Post post) {
		Post savedPost = iPostRepository.save(post);
		return savedPost.getPostId();

	}

	public JSONArray getPost(Integer valueOf, String postId) {
		JSONArray postArr = new JSONArray();

		if (null != postId && iPostRepository.findById(Integer.valueOf(postId)).isPresent()) {
			Post post = iPostRepository.findById(Integer.valueOf(postId)).get();
			JSONObject postObj = postUtil.setPost(post);
			postArr.put(postObj);
		} else {
			List<Post> postList = iPostRepository.findAll();
			for (Post post : postList) {
				JSONObject postObj = postUtil.setPost(post);
				postArr.put(postObj);
			}
		}

		return postArr;
	}

	 public void updatePost(String postId, Post updatedPost) {

	        if(iPostRepository.findById(Integer.valueOf(postId)).isPresent()) {
	            Post olderPost = iPostRepository.findById(Integer.valueOf(postId)).get();
	            updatedPost.setPostId(olderPost.getPostId());
	            updatedPost.setUser(olderPost.getUser());
	            updatedPost.setCreatedDate(olderPost.getCreatedDate());
	            Timestamp updatedDate = new Timestamp(System.currentTimeMillis());
	            updatedPost.setUpdatedDate(updatedDate);


	            iPostRepository.save(updatedPost);
	        }
	 }

}
