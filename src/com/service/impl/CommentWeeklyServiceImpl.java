package com.service.impl;

import java.util.Date;
import java.util.List;

import com.dao.CommentNoteDao;
import com.dao.CommentWeeklyDao;
import com.entity.CommentNote;
import com.entity.CommentWeekly;
import com.service.CommentWeeklyService;

public class CommentWeeklyServiceImpl implements CommentWeeklyService{
	
	private CommentWeeklyDao commentWeeklyDao;
	public final static String SUCCESS = "Success"; 
	public final static String FAIL = "Fail";
	public final static String SSUCCESS = "Ssuccss";
	public final static String SFAIL = "Sfail";
	
	public void setCommentWeeklyDao(CommentWeeklyDao commentWeeklyDao) {
		this.commentWeeklyDao = commentWeeklyDao;
	}


	@Override
	public String save(int wid,String content,String createtime,String authorname) {
		// TODO Auto-generated method stub
		
		String result = commentWeeklyDao.save(wid,content,createtime,authorname);
		if(result == "success"){
			return SUCCESS;
		}else
			return FAIL;
			
	}

	@Override
	public String update(int wid,String content,String createtime,String authorname){
		String result = commentWeeklyDao.update(wid, content, createtime, authorname);
		if(result == "success"){
			return SUCCESS;
		}else
			return FAIL;
	}

	@Override
	public String searchComment(int wid,String authorname) {
		// TODO Auto-generated method stub
		
		List<CommentWeekly> commentlist = commentWeeklyDao.findComment(wid,authorname);
		if(commentlist==null){
			return SFAIL;
		}else{
			return SSUCCESS;
		}
		
	}


	@Override
	public List<CommentWeekly> findComment(int wid,String authorname) {
		// TODO Auto-generated method stub
		return commentWeeklyDao.findComment(wid,authorname);
	}


	@Override
	public String searchTeaComment(int wid) {
		// TODO Auto-generated method stub
		List<CommentWeekly> commentlist = commentWeeklyDao.findTeaComment(wid);
		if(commentlist==null){
			return SFAIL;
		}else{
			return SSUCCESS;
		}
	}


	@Override
	public List<CommentWeekly> findTeaComment(int wid) {
		// TODO Auto-generated method stub
		return commentWeeklyDao.findTeaComment(wid);
	}
	
}
