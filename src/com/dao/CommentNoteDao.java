package com.dao;

import java.util.Date;
import java.util.List;

import com.entity.CommentNote;

public interface CommentNoteDao {

	String saveNote(int nid,String content,String createtime,String authorname);
	String update(int nid,String content,String createtime,String authorname);
	
	List<CommentNote> findComment(int nid,String authorname);
	List<CommentNote> findTeaComment(int nid);

}
