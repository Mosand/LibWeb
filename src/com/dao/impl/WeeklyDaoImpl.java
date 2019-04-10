package com.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.WeeklyDao;
import com.entity.Note;
import com.entity.Weekly;

public class WeeklyDaoImpl extends HibernateDaoSupport implements WeeklyDao{
	
	@Override
	/**
	 * Dao 层添加weekly的保存方法
	 */
	public String saveWeekly(String username2,String title,String fileurl,String createtime,String updatetime) {
		// TODO Auto-generated method stub
		Session se =this.getSession();
		String hql="";
		if(username2==""){
			return null;
		}
		hql = "insert into weekly(username2,title,fileurl,createtime,updatetime) values(?,?,?,?,?)";
		Query query= se.createSQLQuery(hql);
		query.setString(0, username2);
		query.setString(1, title);
		query.setString(2, fileurl);
		query.setString(3, createtime);
		query.setString(4, updatetime);
		query.executeUpdate();
		return "success";
	}
	
	public List<Weekly> findByWeeklyAuthor(String username3){
		String hql="";
		if(username3==null||username3.equals("")){
			System.out.println("姓名为空");	
			return null;
		}
		hql="from weekly w where w.username2 = ? order by createtime";
		@SuppressWarnings("unchecked")
		List<Weekly> weeklylist=this.getHibernateTemplate().find(hql,username3);
		if(weeklylist.size()!=0){
			System.out.println("查询成功");
			System.out.println("weekly author is "+ username3);
			return weeklylist;
		}else if(weeklylist.size()==0){
			System.out.println("没有查询到username为"+username3+"的周报");
			return null;
		}
		
		return null;
	}
	
	public List<Weekly> findByWeeklyStu(String username2){
		String hql="";
		if(username2==null||username2.equals("")){
			System.out.println("姓名为空");	
			return null;
		}
		hql="from weekly w where w.username2 = ? order by createtime";
		@SuppressWarnings("unchecked")
		List<Weekly> weeklylist=this.getHibernateTemplate().find(hql,username2);
		if(weeklylist.size()!=0){
			System.out.println("查询成功");
			System.out.println("weekly author is "+ username2);
			return weeklylist;
		}else if(weeklylist.size()==0){
			System.out.println("没有查询到username为"+username2+"的周报");
			return null;
		}
		
		return null;
	}
	
	public List<Weekly> findByWeeklyAll(){
		String hql="";
		hql="from weekly";
		List<Weekly> weeklylist = this.getHibernateTemplate().find(hql);
		if(weeklylist.size()!=0){
			return weeklylist;
		}else
			return null;
	}
}
