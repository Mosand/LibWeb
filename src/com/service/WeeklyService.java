package com.service;

import java.util.Date;
import java.util.List;

import com.entity.Weekly;

public interface WeeklyService {
	
	String saveWeekly(String username2,String title,String fileurl,String createtime,String updatetime);
	
	int searchOneUserWeekly(String username3);
	int searchOneStuWeekly(String username2);
	
	
	List<Weekly> findByWeeklyAuthor(String username3);
	List<Weekly> findByWeeklyStu(String username2);

	int searchAllUserWeekly(Weekly weekly);

	List<Weekly> findByWeeklyAll();
}
