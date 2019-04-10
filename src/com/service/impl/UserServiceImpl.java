package com.service.impl;

import java.util.List;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.entity.User;
import com.service.UserService;

public class UserServiceImpl implements UserService{
	
	private UserDao userDao;
	
	public static final int PWDERROR = 1;

	public static final int NONEXIST = 2;
	
	public static final int STUDENT = 3;
	
	public static final int TEACHER = 4;
	
	public void setUserDao(UserDao userDao){
		this.userDao = userDao;
	}

	
	@Override
	public int login(String username,String password) {
		User user = userDao.findByName(username);
		if (user != null && UserDaoImpl.status==1) {
			if (user.getPassword().equals(password)) {
				return STUDENT;
			}			
			return PWDERROR;
		}
		
		else {
			User user1 = userDao.findByName(username);
			if (user1 !=null && UserDaoImpl.status==2){
				if (user1.getPassword().equals(password)) {
					return TEACHER;
				}
				return PWDERROR;
			}else{
				return NONEXIST;
			}	
		}
	}
	@Override
	public User findByName(String username) {
		// TODO Auto-generated method stub
		return userDao.findByName(username);
	}

	@Override
	public List<User> findStudentAll(User user){
		return userDao.findStudentAll(user);
	}

	
}
