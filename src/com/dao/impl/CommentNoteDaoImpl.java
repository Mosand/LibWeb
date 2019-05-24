package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.CommentNoteDao;
import com.entity.CommentNote;

public class CommentNoteDaoImpl extends HibernateDaoSupport implements CommentNoteDao{
	
	private CommentNote commentNote;
	
	public void setCommentNote(CommentNote commentNote) {
		this.commentNote = commentNote;
	}
	
	@Override
	public String saveNote(int nid, String content, String createtime, String authorname) {
		// TODO Auto-generated method stub
		Session se =this.getSession();
		String hql="";
		if(nid==0 || authorname==""){
			return null;
		}
		hql = "insert into commentnote(nid,content,createtime,authorname) values(?,?,?,?)";
		Query query= se.createSQLQuery(hql);
		query.setInteger(0, nid);
		query.setString(1, content);
		query.setString(2, createtime);
		query.setString(3, authorname);
		query.executeUpdate();
		return "success";
	}
	
	public String update(int nid,String content,String createtime,String authorname){
		Session se =this.getSession();
		String hql="";
		hql = "update commentnote cn set cn.content = ? , cn.createtime = ? where cn.nid = ? and cn.authorname = ?";
		Query query= se.createSQLQuery(hql);
		query.setString(0, content);
		query.setString(1, createtime);
		query.setInteger(2, nid);
		query.setString(3, authorname);
		query.executeUpdate();
		return "success";
		
	}
	

	@Override
	public List<CommentNote> findComment(int nid,String authorname) {
		// TODO Auto-generated method stub
		String hql="";
		if(nid==0 || authorname==""){
			return null;
		}			   
		hql = "from commentnote c1 where c1.nid=? and c1.authorname=? order by createtime desc";
		@SuppressWarnings("unchecked")
		List<CommentNote> commentlist=this.getHibernateTemplate().find(hql,nid,authorname);
		if(commentlist.size()!=0){
			System.out.println("查询成功");
			System.out.println("note id is "+ nid);
			System.out.println("note authorname is "+ authorname);
			return commentlist;
		}else if(commentlist.size()==0){
			return null;
		}
		
		return null;

	}

	public List<CommentNote> findTeaComment(int nid) {
		// TODO Auto-generated method stub
		String hql="";
		if(nid==0){
			return null;
		}			   
		hql = "from commentnote c1 where c1.nid=? order by createtime desc";
		@SuppressWarnings("unchecked")
		List<CommentNote> commentlist=this.getHibernateTemplate().find(hql,nid);
		if(commentlist.size()!=0){
			System.out.println("查询成功");
			System.out.println("note id is "+ nid);
			return commentlist;
		}else if(commentlist.size()==0){
			return null;
		}
		
		return null;

	}
}
