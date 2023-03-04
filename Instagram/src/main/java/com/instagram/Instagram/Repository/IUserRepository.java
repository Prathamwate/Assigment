package com.instagram.Instagram.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.instagram.Instagram.Model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer>{

}
