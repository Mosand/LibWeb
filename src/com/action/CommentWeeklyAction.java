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
 * param����
 * wid:����weekly��id
 * content�����۵�����
 * authorname�����۵�����
 * lists����ʦ���������۷��ظ�ǰ̨��ֵ
 * lists2��ѧ�����������۷��ظ�ǰ̨��ֵ
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
	
	//�����������д��
    public List<CommentWeekly> getLists() {
        return lists;
    }
    public void setLists(List<CommentWeekly> lists) {
        this.lists = lists;
    }
    
  //�����������д��
    public List<CommentWeekly> getLists2() {
        return lists2;
    }
    public void setLists2(List<CommentWeekly> lists2) {
        this.lists2 = lists2;
    }
    
    //��ͳ��ʽ����ajax���ݣ����ַ��ط�ʽ����Ҫ�������ļ�������
    public String getState(){
        System.out.println("��ͳ��ajax");
        HttpServletResponse response = ServletActionContext.getResponse();
        try {
            PrintWriter out = response.getWriter();
            out.println("{\"success\":\"true\",\"type\":\"succ\"}");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

	public String saveComment(){//�����۷���
		
		CommentWeekly commentWeekly = new CommentWeekly();//ʵ��һ��commentWeekly
		System.out.println("save comment ����ִ��");
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		createtime = time.toString();
		commentWeekly.setCreatetime(createtime);
		String result2 = commentWeeklyService.searchComment(wid,authorname);//�ж��������ۣ�����insert������update
		if(result2.equals(com.service.impl.CommentWeeklyServiceImpl.SFAIL)){//��Ҫһ��ȷ����ֵ������ر���ָ���쳣
			String result = commentWeeklyService.save(wid,content,createtime,authorname);//����service��save����
			if(result.equals(com.service.impl.CommentWeeklyServiceImpl.SUCCESS)){//�ɹ�
				ActionContext.getContext().put("Teacher", authorname);//��д���۵���ʦ����,����ǰ�˻�ȡ
				System.out.println("wid:"+wid);
				return "saveSuccess";
			}else
				return "saveFail";
		}
		else{
			String result = commentWeeklyService.update(wid, content, createtime, authorname);//����
			if(result.equals(com.service.impl.CommentWeeklyServiceImpl.SUCCESS)){
				ActionContext.getContext().put("Teacher", authorname);
				System.out.println("wid:"+wid);
				System.out.println("�ܱ����۸��³ɹ���");
				return "updateSuccess";
			}
			return "updateFail";
		}
			
		
	}
	
	public String searchComment(){//��ʦ����������,�����Ƿ��Ѿ����ۻ��߸�������
		
		System.out.println("Search Comment Note����ִ��");
		String result = commentWeeklyService.searchComment(wid,authorname);
		if(result.equals(com.service.impl.CommentWeeklyServiceImpl.SSUCCESS)){
			lists = commentWeeklyService.findComment(wid,authorname);//�����������۳ɹ���list��ǰ��
			System.out.println("lists:"+lists);
			return "findCommentSuccess";
		}else if(result.equals(com.service.impl.CommentWeeklyServiceImpl.SFAIL)){
			return "findCommentFail";
		}
		return null;
	}
	
	public String searchTeaComment(){//ѧ�����������۲���ʾ��ֻ��Ҫͨ��wid�����Ҿ��У�����ʱ��ȽϽ�������weekly�б�
		
		System.out.println("action.searchTeaComment����ִ��");
		String result = commentWeeklyService.searchTeaComment(wid);
		if(result.equals(com.service.impl.CommentWeeklyServiceImpl.SSUCCESS)){
			lists2 = commentWeeklyService.findTeaComment(wid);
			//ActionContext.getContext().put("CommentList", commentlist);
			//Gson gson = new Gson();
			//System.out.println("lists:"+gson.toJson(lists));
			System.out.print("��ʦ���ۣ�"+lists2);
			return "findTCommentSuccess";//���ز���teacher���۳ɹ�
		}else if(result.equals(com.service.impl.CommentWeeklyServiceImpl.SFAIL)){
			return "findTCommentFail";//���ز���teacher����ʧ��
		}
		return null;
		
	}
}
