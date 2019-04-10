package com.dao;

import java.util.List;

import com.entity.CommentWeekly;

public interface CommentWeeklyDao {
	
	String save(int wid,String content,String createtime,String authorname);
	String update(int wid,String content,String createtime,String authorname);
	
	List<CommentWeekly> findComment(int wid,String authorname);
	List<CommentWeekly> findTeaComment(int wid);

}
