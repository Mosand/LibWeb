package com.action;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.entity.CommentWeekly;
import com.entity.Weekly;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.CommentWeeklyService;

/*
 * param解释
 * wid:评论weekly的id
 * content：评论的内容
 * authorname：评论的作者
 * lists：老师端搜索评论返回给前台的值
 * lists2：学生端搜索评论返回给前台的值
 * 
 */

@SuppressWarnings("serial")
public class CommentWeeklyAction extends ActionSupport {
	
	private CommentWeeklyService commentWeeklyService;
	private String createtime;
	private int wid;
	private String content;
	private String authorname;
	
	private List<CommentWeekly> lists = new ArrayList<CommentWeekly>();
	private List<CommentWeekly> lists2 = new ArrayList<CommentWeekly>();

	public CommentWeeklyService getCommentWeeklyService() {
		return commentWeeklyService;
	}

	public void setCommentWeeklyService(CommentWeeklyService commentWeeklyService) {
		this.commentWeeklyService = commentWeeklyService;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
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
	
	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	
	//这个方法必须写上
    public List<CommentWeekly> getLists() {
        return lists;
    }
    public void setLists(List<CommentWeekly> lists) {
        this.lists = lists;
    }
    
  //这个方法必须写上
    public List<CommentWeekly> getLists2() {
        return lists2;
    }
    public void setLists2(List<CommentWeekly> lists2) {
        this.lists2 = lists2;
    }
    
    //传统方式返回ajax数据，这种返回方式不需要再配置文件中配置
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

	public String saveComment(){//存评论方法
		
		CommentWeekly commentWeekly = new CommentWeekly();//实例一个commentWeekly
		System.out.println("save comment 方法执行");
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		createtime = time.toString();
		commentWeekly.setCreatetime(createtime);
		String result2 = commentWeeklyService.searchComment(wid,authorname);//判断有无评论，无则insert，有则update
		if(result2.equals(com.service.impl.CommentWeeklyServiceImpl.SFAIL)){//需要一个确定的值，否则回报空指针异常
			String result = commentWeeklyService.save(wid,content,createtime,authorname);//调用service的save方法
			if(result.equals(com.service.impl.CommentWeeklyServiceImpl.SUCCESS)){//成功
				ActionContext.getContext().put("Teacher", authorname);//存写评论的老师名字,返给前端获取
				System.out.println("wid:"+wid);
				return "saveSuccess";
			}else
				return "saveFail";
		}
		else{
			String result = commentWeeklyService.update(wid, content, createtime, authorname);//更新
			if(result.equals(com.service.impl.CommentWeeklyServiceImpl.SUCCESS)){
				ActionContext.getContext().put("Teacher", authorname);
				System.out.println("wid:"+wid);
				System.out.println("周报评论更新成功！");
				return "updateSuccess";
			}
			return "updateFail";
		}
			
		
	}
	
	public String searchComment(){//老师端搜索评论,来看是否已经评论或者更新评论
		
		System.out.println("Search Comment Note方法执行");
		String result = commentWeeklyService.searchComment(wid,authorname);
		if(result.equals(com.service.impl.CommentWeeklyServiceImpl.SSUCCESS)){
			lists = commentWeeklyService.findComment(wid,authorname);//返回搜索评论成功的list给前端
			System.out.println("lists:"+lists);
			return "findCommentSuccess";
		}else if(result.equals(com.service.impl.CommentWeeklyServiceImpl.SFAIL)){
			return "findCommentFail";
		}
		return null;
	}
	
	public String searchTeaComment(){//学生端搜索评论并显示，只需要通过wid来查找就行，返回时间比较近的评论weekly列表
		
		System.out.println("action.searchTeaComment方法执行");
		String result = commentWeeklyService.searchTeaComment(wid);
		if(result.equals(com.service.impl.CommentWeeklyServiceImpl.SSUCCESS)){
			lists2 = commentWeeklyService.findTeaComment(wid);
			//ActionContext.getContext().put("CommentList", commentlist);
			//Gson gson = new Gson();
			//System.out.println("lists:"+gson.toJson(lists));
			System.out.print("老师评论："+lists2);
			return "findTCommentSuccess";//返回查找teacher评论成功
		}else if(result.equals(com.service.impl.CommentWeeklyServiceImpl.SFAIL)){
			return "findTCommentFail";//返回查找teacher评论失败
		}
		return null;
		
	}
}
