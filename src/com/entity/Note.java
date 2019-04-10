package com.entity;

import java.util.Date;

public class Note {
	
	private int nid;
	private String username;
	private String title;
	private String fileurl;
	private String createtime;
	private String updatetime;
	private User user;
	private String username2;
	
	
	
	public Note(int nid,String username,String title,String createtime,String updatetime){
		super();
		this.nid = nid;
		this.username = username;
		this.title = title;
		this.createtime = createtime;
		this.updatetime = updatetime;
		
	}
	
	public Note(int nid,String username,String title,String createtime){
		super();
		this.nid = nid;
		this.username = username;
		this.title = title;
		this.createtime = createtime;
	}
	
	public Note(){
		
	}

	public int getNid() {
		return nid;
	}

	public void setNid(int nid) {
		this.nid = nid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFileurl() {
		return fileurl;
	}

	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUsername2() {
		return username2;
	}

	public void setUsername2(String username2) {
		this.username2 = username2;
	}
	
	
	
}
