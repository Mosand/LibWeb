package com.entity;

import java.util.Date;

public class CommentNote implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private int cid;
	private int nid;
	private String content;
	private String createtime;
	private String authorname;
	
	public CommentNote(){};
	
	public CommentNote(int cid,int nid,String content,String createtime,String authorname){
		super();
		this.cid = cid;
		this.nid = nid;
		this.content = content;
		this.createtime = createtime;	
		this.authorname = authorname;
	}
	
	public CommentNote(int nid,String content,String createtime,String authorname){
		super();
		this.nid = nid;
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

	public int getNid() {
		return nid;
	}

	public void setNid(int nid) {
		this.nid = nid;
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
