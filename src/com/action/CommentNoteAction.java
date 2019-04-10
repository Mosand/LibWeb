package com.action;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.entity.CommentNote;
import com.entity.CommentWeekly;
import com.entity.Note;
import com.entity.User;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.CommentNoteService;


/*
 * param解释
 * nid:评论note的id
 * content：评论的内容
 * authorname：评论的作者
 * lists：老师端搜索评论返回给前台的值
 * lists2：学生端搜索评论返回给前台的值
 * 
 */
@SuppressWarnings("serial")
public class CommentNoteAction extends ActionSupport{
	
	private CommentNoteService commentNoteService;
	private String createtime;
	private int nid;
	private String content;
	private String authorname;
	private User user;
	private List<CommentNote> lists = new ArrayList<CommentNote>();
	private List<CommentNote> lists2 = new ArrayList<CommentNote>();
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getNid() {
		return nid;
	}

	public void setNid(int nid) {
		this.nid = nid;
	}

	public CommentNoteService getCommentNoteService() {
		return commentNoteService;
	}

	public void setCommentNoteService(CommentNoteService commentNoteService) {
		this.commentNoteService = commentNoteService;
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

	//这个方法必须写上
    public List<CommentNote> getLists() {
        return lists;
    }
    public void setLists(List<CommentNote> lists) {
        this.lists = lists;
    }
    
    public List<CommentNote> getLists2() {
        return lists2;
    }
    public void setLists2(List<CommentNote> lists2) {
        this.lists2 = lists2;
    }
    
    //传统方式返回ajax数据，这种返回方式不需要在配置文件中配置
    public String getState(){
        System.out.println("传统的ajax");
        HttpServletResponse response = ServletActionContext.getResponse();
        try {
            PrintWriter out = response.getWriter();
            out.println("{\"success\":\"true\",\"type\":\"succ\"}");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
	public String saveComment(){//存评论
		
		CommentNote commentNote = new CommentNote();
		System.out.println("save comment 方法执行");
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//时间格式化
		String time=format.format(date);
		createtime = time.toString();
		commentNote.setCreatetime(createtime);
		String result2 = commentNoteService.searchComment(nid,authorname);
		if(result2.equals(com.service.impl.CommentNoteServiceImpl.SFAIL)){//如果没有评论则插入，有评论则更新
			String result = commentNoteService.saveNote(nid,content,createtime,authorname);
			if(result.equals(com.service.impl.CommentNoteServiceImpl.SUCCESS)){
				ActionContext.getContext().put("Teacher", authorname);//存评论成功后，前端获取老师名字
				System.out.print(createtime);
				return "saveSuccess";			
			}	
			else
				return "saveFail";
		}else{
			String result = commentNoteService.update(nid, content, createtime, authorname);//更新
			if(result.equals(com.service.impl.CommentNoteServiceImpl.SUCCESS)){
				ActionContext.getContext().put("Teacher", authorname);
				System.out.println("nid:"+nid);
				System.out.println("笔记评论更新成功");
				return "updateSuccess";
			}
			return "updateFail";
		}
	}
	
	public String searchComment(){//老师端搜索评论,加以更新
		
		System.out.println("action.searchCommentNote方法执行");
		String result = commentNoteService.searchComment(nid,authorname);
		if(result.equals(com.service.impl.CommentNoteServiceImpl.SSUCCESS)){//search success
			lists = commentNoteService.findComment(nid,authorname);
			Gson gson = new Gson();
			System.out.println("lists:"+gson.toJson(lists));//查看json格式
			return "findCommentSuccess";
		}else if(result.equals(com.service.impl.CommentNoteServiceImpl.SFAIL)){
			return "findCommentFail";
		}
		return null;
		
	}
	
	public String searchTeaComment(){//学生端搜索评论并显示，只需要通过nid来查找就行，返回时间比较近的评论note列表
		
		System.out.println("action.searchTeaComment方法执行");
		System.out.println("nid:" + nid);
		String result = commentNoteService.searchTeaComment(nid);
		if(result.equals(com.service.impl.CommentNoteServiceImpl.SSUCCESS)){
			lists2 = commentNoteService.findTeaComment(nid);
			//Gson gson = new Gson();
			//System.out.println("lists2:"+gson.toJson(lists2));
			System.out.println(lists2);
			return "findTCommentSuccess";//返回查找teacher成功
		}else if(result.equals(com.service.impl.CommentNoteServiceImpl.SFAIL)){
			return "findTCommentFail";//返回查找teacher失败
		}
		return null;
		
	}

}
