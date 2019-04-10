package com.service.impl;

import java.util.Date;
import java.util.List;

import com.dao.CommentNoteDao;
import com.entity.CommentNote;
import com.service.CommentNoteService;

public class CommentNoteServiceImpl implements CommentNoteService{
	
	private CommentNoteDao commentNoteDao;
	public final static String SUCCESS = "Success"; 
	public final static String FAIL = "Fail";
	public final static String SSUCCESS = "Ssuccss";
	public final static String SFAIL = "Sfail";
	
	public void setCommentNoteDao(CommentNoteDao commentNoteDao) {
		this.commentNoteDao = commentNoteDao;
	}

//	@Override
//	public String saveNote() {
//		// TODO Auto-generated method stub
//		
//		String result = commentNoteDao.saveNote(commentNote);
//		if(result == "success"){
//			return SUCCESS;
//		}else
//			return FAIL;
//			
//	}
	
	@Override
	public String saveNote(int nid, String content, String createtime, String authorname) {
		// TODO Auto-generated method stub
		String result = commentNoteDao.saveNote(nid,content,createtime,authorname);
		if(result.equals("success")){
			return SUCCESS;
		}else
			return FAIL;
		
	}

	@Override
	public String update(int nid,String content,String createtime,String authorname){
		String result = commentNoteDao.update(nid, content, createtime, authorname);
		if(result == "success"){
			return SUCCESS;
		}else
			return FAIL;
	}
	
	@Override
	public String searchComment(int nid,String authorname) {
		// TODO Auto-generated method stub
		
		List<CommentNote> commentlist = commentNoteDao.findComment(nid,authorname);
		if(commentlist==null){
			return SFAIL;
		}else{
			return SSUCCESS;
		}
		
	}


	@Override
	public List<CommentNote> findComment(int nid,String authorname) {
		// TODO Auto-generated method stub
		return commentNoteDao.findComment(nid,authorname);
	}

	@Override
	public String searchTeaComment(int nid) {
		List<CommentNote> commentlist = commentNoteDao.findTeaComment(nid);
		if(commentlist==null){
			return SFAIL;
		}else{
			return SSUCCESS;
		}
	}

	@Override
	public List<CommentNote> findTeaComment(int nid) {
		// TODO Auto-generated method stub
		return commentNoteDao.findTeaComment(nid);
	}

	
	}
	
	
