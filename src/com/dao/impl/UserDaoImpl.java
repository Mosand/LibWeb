package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.UserDao;
import com.entity.User;


public class UserDaoImpl extends HibernateDaoSupport implements UserDao{
	
	public static int status = 0;
	@Autowired
	public User findByName(String username) {
		String hql1="";
		String hql2="";
		if(username==null||username.equals(""))
			   return null;
		hql1="from student where username=?";
	    List<User> users=this.getHibernateTemplate().find(hql1,username);
	    if(users.size()!=0){
	    	System.out.println("student name is "+ username);
	    	status = 1;
			return users.get(0);
	    }else if(users.size()==0){
	    	hql2="from teacher where username=?";
	    	@SuppressWarnings("unchecked")
			List<User> users2=this.getHibernateTemplate().find(hql2,username);
	    	if(users2.size()!=0){
	    		System.out.println("teacher name is "+ username);
	    		status = 2;
				return users2.get(0);
	    	}else {
				return null;
			}
	    }
	    return null;
	}
	
	
	public List<User> findStudentAll(User user){
		
		String hql="";
		if(user.getUsername()==null||user.getUsername().equals(""))
			   return null;
		hql="from student";
	    List<User> userlist=this.getHibernateTemplate().find(hql);
	    if(userlist.size()!=0){
			System.out.println("≤È—Ø≥…π¶");
			//System.out.println("username is "+ username);
			return userlist;
	    }
		return null;
	}
}
