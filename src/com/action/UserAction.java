package com.action;
/**
 * �û�web��
 * ����ģ������
 *
 */
import com.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.UserService;
/*
 * param����
 * username���û���¼��
 * password���û�����
 */

public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	private User user;
	private UserService userService;
	private String username;
	private String password;
	

	public UserService getUserService() {
		return userService;
	}

	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public User getModel(){
		return user;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String login(){
		System.out.println("action.login����ִ��");
		// ����ҵ��㷽��
		int result = userService.login(username,password);//����service��login����
		if (result == com.service.impl.UserServiceImpl.TEACHER) {//ʶ��ΪTEACHER
			User user = userService.findByName(username);
			ActionContext.getContext().put("Teacher", user.getUsername());//�洢teacher name ǰ�˺�ʶ��
			System.out.println("Teacher name : "+user.getUsername());
			return "TEACHER";
		} else if (result == com.service.impl.UserServiceImpl.STUDENT) {
			User user = userService.findByName(username);
			ActionContext.getContext().put("Student", user.getUsername());
			System.out.println("Student name : "+user.getUsername());
			return "STUDENT";
		}  
		  else if (result == com.service.impl.UserServiceImpl.PWDERROR) {
			return "PWDERROR";
		} 
		  else if (result == com.service.impl.UserServiceImpl.NONEXIST) {
			return "NONEXIST";
		}
		return null;
	}
	
	
}
