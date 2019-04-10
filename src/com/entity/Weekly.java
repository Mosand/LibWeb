package com.entity;


public class Weekly {
	private int wid;
	private String username2;
	private String username3;
	private String title;
	private String fileurl;
	private String createtime;
	private String updatetime;
	private User user;
	
	public Weekly(int wid,String username2,String title,String createtime,String updatetime){
		super();
		this.wid = wid;
		this.username2 = username2;
		this.title = title;
		this.createtime = createtime;
		this.updatetime = updatetime;
		
	}
	
	public Weekly(int wid,String username2,String title,String createtime){
		super();
		this.wid = wid;
		this.username2 = username2;
		this.title = title;
		this.createtime = createtime;
	}
	
	public Weekly(){
		
	}

	public int getWid() {
		return wid;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}

	public String getUsername2() {
		return username2;
	}

	public void setUsername2(String username2) {
		this.username2 = username2;
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

	public String getUsername3() {
		return username3;
	}

	public void setUsername3(String username3) {
		this.username3 = username3;
	}
	
	
}
