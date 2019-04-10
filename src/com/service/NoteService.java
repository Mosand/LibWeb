package com.service;

import java.util.Date;
import java.util.List;

import com.entity.Note;

public interface NoteService {
	
	String saveNote(String username,String title,String fileurl,String createtime,String updatetime);
	
	int searchOneUserNote(String username2);
	int searchOneStuNote(String username);
	
	List<Note> findByNoteAuthor(String username2);
	List<Note> findByNoteStu(String username);

	int searchAllUserNote(Note note);

	List<Note> findByNoteAll();
	
}
