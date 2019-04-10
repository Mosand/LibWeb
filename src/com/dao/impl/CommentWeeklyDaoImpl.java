package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.CommentWeeklyDao;
import com.entity.CommentWeekly;

public class CommentWeeklyDaoImpl extends HibernateDaoSupport implements CommentWeeklyDao{
	
	private CommentWeekly commentWeekly;
	
	public void setCommentWeekly(CommentWeekly commentWeekly) {
		this.commentWeekly = commentWeekly;
	}

	
public String save(int wid,String content,String createtime,String authorname){
		
		Session se =this.getSession();
		String hql="";
		if(wid==0 || authorname==""){
			return null;
		}
		hql = "insert into commentweekly(wid,content,createtime,authorname) values(?,?,?,?)";
		Query query= se.createSQLQuery(hql);
		query.setInteger(0, wid);
		query.setString(1, content);
		query.setString(2, createtime);
		query.setString(3, authorname);
		query.executeUpdate();
		System.out.println("插入成功!");
		System.out.println("wid"+wid);
		System.out.println("content"+content);
		return "success";
		
	}

public String update(int wid,String content,String createtime,String authorname){
	Session se =this.getSession();
	String hql="";
	
	hql = "update commentweekly cw set cw.content = ? , cw.createtime = ? where cw.wid = ? and cw.authorname = ?";
	Query query= se.createSQLQuery(hql);
	query.setString(0, content);
	query.setString(1, createtime);
	query.setInteger(2, wid);
	query.setString(3, authorname);
	query.executeUpdate();
	return "success";
	
}

	@Override
	public List<CommentWeekly> findComment(int wid,String authorname) {
		// TODO Auto-generated method stub
		String hql="";
		if(wid==0 || authorname == ""){
			return null;
		}			   
		hql="from commentweekly as c2 where c2.wid=? and c2.authorname=? order by createtime desc";
		List<CommentWeekly> commentlist=this.getHibernateTemplate().find(hql,wid,authorname);
		if(commentlist.size()!=0){
			System.out.println("查询评论成功");
			//System.out.println("weekly id is "+ wid);
			//System.out.println("authorname" + authorname);
			return commentlist;
		}else if(commentlist.size()==0){
			return null;
		}
		
		return null;

	}
	
	@Override
	public List<CommentWeekly> findTeaComment(int wid) {
		// TODO Auto-generated method stub
		String hql="";
		if(wid==0){
			return null;
		}			   
		hql="from commentweekly as c2 where c2.wid=? order by createtime desc";
		List<CommentWeekly> commentlist=this.getHibernateTemplate().find(hql,wid);
		if(commentlist.size()!=0){
			//System.out.println("查询成功");
			//System.out.println("weekly id is "+ wid);
			return commentlist;
		}else if(commentlist.size()==0){
			return null;
		}
		
		return null;

	}
}
