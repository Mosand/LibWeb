package com.service.impl;

import java.util.Date;
import java.util.List;

import com.dao.NoteDao;
import com.entity.Note;
import com.service.NoteService;

public class NoteServiceImpl implements NoteService{
	
	private NoteDao noteDao;
	public final static int SUCCESS=1;
	public final static int FAIL=2;
	public final static int SUCCESSALL=3;
	public final static int FAILALL=4;
	
	
	public NoteDao getNoteDao() {
		return noteDao;
	}

	public void setNoteDao(NoteDao noteDao){
		this.noteDao = noteDao;
	}
	
	@Override
	public String saveNote(String username,String title,String fileurl,String createtime,String updatetime){
		String result = noteDao.saveNote(username,title,fileurl,createtime,updatetime);
		if(result.equals("success")){
			return "successSave";
		}else
			return "failSave";
		
	}
	
	@Override
	public List<Note> findByNoteAuthor(String username2){
		
		return noteDao.findByNoteAuthor(username2);
	}
	
	@Override
	public int searchOneUserNote(String username2){//老师端搜索学生的名字找note
		List<Note> notelist = noteDao.findByNoteAuthor(username2);
		if(notelist==null){
			return FAIL;
		}else
			return SUCCESS;
	}

	@Override
	public int searchAllUserNote(Note note) {
		// TODO Auto-generated method stub
		List<Note> notelist = noteDao.findByNoteAll();
		if(notelist==null){
			return FAILALL;
		}else{
			return SUCCESSALL;
		}
		
	}

	@Override
	public List<Note> findByNoteAll() {
		// TODO Auto-generated method stub
		return noteDao.findByNoteAll();
	}

	@Override
	public int searchOneStuNote(String username) {//找已登录学生的note
		// TODO Auto-generated method stub
		List<Note> notelist = noteDao.findByNoteStu(username);
		if(notelist==null){
			return FAIL;
		}else
			return SUCCESS;
	}

	@Override
	public List<Note> findByNoteStu(String username) {
		// TODO Auto-generated method stub
		
		return noteDao.findByNoteStu(username);
	}

	
}
