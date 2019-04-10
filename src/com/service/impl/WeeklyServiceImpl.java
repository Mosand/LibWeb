package com.service.impl;

import java.util.Date;
import java.util.List;

import com.dao.WeeklyDao;
import com.entity.Weekly;
import com.service.WeeklyService;

public class WeeklyServiceImpl implements WeeklyService{
	private WeeklyDao weeklyDao;
	public final static int SUCCESS=1;
	public final static int FAIL=2;
	public final static int SUCCESSALL=3;
	public final static int FAILALL=4;
	
	
	public WeeklyDao getWeeklyDao() {
		return weeklyDao;
	}

	public void setWeeklyDao(WeeklyDao weeklyDao){
		this.weeklyDao = weeklyDao;
	}
	
	@Override
	public String saveWeekly(String username2,String title,String fileurl,String createtime,String updatetime){
		String result = weeklyDao.saveWeekly(username2,title,fileurl,createtime,updatetime);
		if(result.equals("success")){
			return "successSave";
		}else
			return "failSave";
	}
	
	@Override
	public List<Weekly> findByWeeklyAuthor(String username3){
		return weeklyDao.findByWeeklyAuthor(username3);
	}
	
	@Override
	public int searchOneUserWeekly(String username3){
		
		List<Weekly> weeklylist = weeklyDao.findByWeeklyAuthor(username3);//调用dao
		//System.out.println("username3:"+username3);
		if(weeklylist==null){//没查到返回fail
			return FAIL;
		}else{
			return SUCCESS;//查到返回success
		}
			
	}

	@Override
	public int searchAllUserWeekly(Weekly Weekly) {
		// TODO Auto-generated method stub
		List<Weekly> weeklylist = weeklyDao.findByWeeklyAll();
		if(weeklylist==null){
			return FAILALL;
		}else{
			return SUCCESSALL;
		}
		
	}

	@Override
	public List<Weekly> findByWeeklyAll() {
		// TODO Auto-generated method stub
		return weeklyDao.findByWeeklyAll();
	}

	@Override
	public int searchOneStuWeekly(String username2) {
		// TODO Auto-generated method stub
		List<Weekly> weeklylist = weeklyDao.findByWeeklyStu(username2);//调用dao
		
		if(weeklylist==null){//没查到返回fail
			return FAIL;
		}else{
			return SUCCESS;//查到返回success
		}
	}

	@Override
	public List<Weekly> findByWeeklyStu(String username2) {
		// TODO Auto-generated method stub
		return weeklyDao.findByWeeklyStu(username2);
	}
}
