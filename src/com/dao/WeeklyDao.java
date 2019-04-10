package com.dao;

import java.util.Date;
import java.util.List;

import com.entity.Weekly;

public interface WeeklyDao {
	
	String saveWeekly(String username2,String title,String fileurl,String createtime,String updatetime);
	
	List<Weekly> findByWeeklyAuthor(String username3);
	List<Weekly> findByWeeklyStu(String username2);
	
	List<Weekly> findByWeeklyAll();
}
