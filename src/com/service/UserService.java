package com.service;

import java.util.List;

import com.entity.User;

public interface UserService {
	
	int login(String username,String password);
	
	User findByName (String username);
	
	
	List<User> findStudentAll(User user);
}
