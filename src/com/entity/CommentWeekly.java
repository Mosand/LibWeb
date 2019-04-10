package com.entity;

import java.util.Date;

public class CommentWeekly {
	private int cid;
	private int wid;
	private String content;
	private String createtime;
	private String authorname;
	
	public CommentWeekly(){};
	
	public CommentWeekly(int cid,int wid,String content,String createtime,String authorname){
		super();
		this.cid = cid;
		this.wid = wid;
		this.content = content;
		this.createtime = createtime;	
		this.authorname = authorname;
	}
	
	public CommentWeekly(int wid,String content,String createtime,String authorname){
		super();
		this.wid = wid;
		this.content = content;
		this.createtime = createtime;
		this.authorname = authorname;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getWid() {
		return wid;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	
	
}
