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
 * param����
 * nid:����note��id
 * content�����۵�����
 * authorname�����۵�����
 * lists����ʦ���������۷��ظ�ǰ̨��ֵ
 * lists2��ѧ�����������۷��ظ�ǰ̨��ֵ
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

	//�����������д��
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
    
	public String saveComment(){//������
		
		CommentNote commentNote = new CommentNote();
		System.out.println("save comment ����ִ��");
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//ʱ���ʽ��
		String time=format.format(date);
		createtime = time.toString();
		commentNote.setCreatetime(createtime);
		String result2 = commentNoteService.searchComment(nid,authorname);
		if(result2.equals(com.service.impl.CommentNoteServiceImpl.SFAIL)){//���û����������룬�����������
			String result = commentNoteService.saveNote(nid,content,createtime,authorname);
			if(result.equals(com.service.impl.CommentNoteServiceImpl.SUCCESS)){
				ActionContext.getContext().put("Teacher", authorname);//�����۳ɹ���ǰ�˻�ȡ��ʦ����
				System.out.print(createtime);
				return "saveSuccess";			
			}	
			else
				return "saveFail";
		}else{
			String result = commentNoteService.update(nid, content, createtime, authorname);//����
			if(result.equals(com.service.impl.CommentNoteServiceImpl.SUCCESS)){
				ActionContext.getContext().put("Teacher", authorname);
				System.out.println("nid:"+nid);
				System.out.println("�ʼ����۸��³ɹ�");
				return "updateSuccess";
			}
			return "updateFail";
		}
	}
	
	public String searchComment(){//��ʦ����������,���Ը���
		
		System.out.println("action.searchCommentNote����ִ��");
		String result = commentNoteService.searchComment(nid,authorname);
		if(result.equals(com.service.impl.CommentNoteServiceImpl.SSUCCESS)){//search success
			lists = commentNoteService.findComment(nid,authorname);
			Gson gson = new Gson();
			System.out.println("lists:"+gson.toJson(lists));//�鿴json��ʽ
			return "findCommentSuccess";
		}else if(result.equals(com.service.impl.CommentNoteServiceImpl.SFAIL)){
			return "findCommentFail";
		}
		return null;
		
	}
	
	public String searchTeaComment(){//ѧ�����������۲���ʾ��ֻ��Ҫͨ��nid�����Ҿ��У�����ʱ��ȽϽ�������note�б�
		
		System.out.println("action.searchTeaComment����ִ��");
		System.out.println("nid:" + nid);
		String result = commentNoteService.searchTeaComment(nid);
		if(result.equals(com.service.impl.CommentNoteServiceImpl.SSUCCESS)){
			lists2 = commentNoteService.findTeaComment(nid);
			//Gson gson = new Gson();
			//System.out.println("lists2:"+gson.toJson(lists2));
			System.out.println(lists2);
			return "findTCommentSuccess";//���ز���teacher�ɹ�
		}else if(result.equals(com.service.impl.CommentNoteServiceImpl.SFAIL)){
			return "findTCommentFail";//���ز���teacherʧ��
		}
		return null;
		
	}

}
