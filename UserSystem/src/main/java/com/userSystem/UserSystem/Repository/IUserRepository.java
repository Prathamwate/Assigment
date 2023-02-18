package com.userSystem.UserSystem.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userSystem.UserSystem.Model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer>{

}
