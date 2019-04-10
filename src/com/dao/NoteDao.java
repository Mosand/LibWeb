package com.dao;

import java.util.Date;
import java.util.List;

import com.entity.Note;

public interface NoteDao {
	
	String saveNote(String username,String title,String fileurl,String createtime,String updatetime);
	
	List<Note> findByNoteAuthor(String username2);
	List<Note> findByNoteStu(String username);
	
	List<Note> findByNoteAll();
	
}
