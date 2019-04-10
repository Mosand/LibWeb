package com.service;

import java.util.Date;
import java.util.List;

import com.entity.CommentWeekly;

public interface CommentWeeklyService {
	
	String save(int wid,String content,String createtime,String authorname);
	String update(int wid,String content,String createtime,String authorname);
	
	
	String searchComment(int wid,String authorname);
	String searchTeaComment(int wid);
	
	List<CommentWeekly> findComment(int wid,String authorname);
	List<CommentWeekly> findTeaComment(int wid);

}
