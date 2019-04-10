package com.dao;

import java.util.List;

import com.entity.User;

public interface UserDao {
	
	
	User findByName (String username);
	
	
	List<User> findStudentAll (User user);

}
