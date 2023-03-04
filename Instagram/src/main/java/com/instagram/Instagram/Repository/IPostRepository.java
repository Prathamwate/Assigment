package com.instagram.Instagram.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.instagram.Instagram.Model.Post;

public interface IPostRepository extends JpaRepository<Post, Integer>{

}
