package com.dao.impl;

import com.dao.NoteDao;
import com.entity.Note;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class NoteDaoImpl extends HibernateDaoSupport implements NoteDao{
	
	@Override
	/**
	 * Dao 层添加note的保存方法
	 */
	public String saveNote(String username,String title,String fileurl,String createtime,String updatetime) {
		// TODO Auto-generated method stub

		Session se =this.getSession();
		String hql="";
		if(username=="" || username==null){
			return null;
		}
		hql = "insert into note(username,title,fileurl,createtime,updatetime) values(?,?,?,?,?)";
		Query query= se.createSQLQuery(hql);
		query.setString(0, username);
		query.setString(1, title);
		query.setString(2, fileurl);
		query.setString(3, createtime);
		query.setString(4, updatetime);
		query.executeUpdate();
		return "success";
	}
	
	public List<Note> findByNoteAuthor(String username2){
		String hql="";
		if(username2==null||username2.equals(""))
			   return null;
		hql = "from note n where n.username = ? order by createtime";
		List<Note> notelist=this.getHibernateTemplate().find(hql,username2);
		if(notelist.size()!=0){
			System.out.println("查询成功");
			System.out.println("note author is "+ username2);
			return notelist;
		}else if(notelist.size()==0){
			return null;
		}
		
		return null;
	}
	
	public List<Note> findByNoteStu(String username){
		String hql="";
		if(username==null||username.equals(""))
			   return null;
		hql = "from note n where n.username = ? order by createtime";
		List<Note> notelist=this.getHibernateTemplate().find(hql,username);
		if(notelist.size()!=0){
			System.out.println("查询成功");
			System.out.println("note author is "+ username);
			return notelist;
		}else if(notelist.size()==0){
			return null;
		}
		
		return null;
	}
	
	public List<Note> findByNoteAll(){
		String hql="";
		hql="from note";
		List<Note> notelist = this.getHibernateTemplate().find(hql);
		if(notelist.size()!=0){
			return notelist;
		}else
			return null;
	}

	
}
