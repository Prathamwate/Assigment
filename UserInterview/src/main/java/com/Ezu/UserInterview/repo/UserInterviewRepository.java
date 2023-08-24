package com.Ezu.UserInterview.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ezu.UserInterview.model.UserInterview;

@Repository
public interface UserInterviewRepository extends JpaRepository<UserInterview, Integer>{

}
