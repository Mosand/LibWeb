package com.service;

import java.util.Date;
import java.util.List;

import com.entity.CommentNote;

public interface CommentNoteService {
	
	String saveNote(int nid, String content,String createtime,String authorname);
	String update(int nid,String content,String createtime,String authorname);
	String searchComment(int nid,String authorname);
	String searchTeaComment(int nid);
	
	List<CommentNote> findComment(int nid,String authorname);
	List<CommentNote> findTeaComment(int nid);
}
