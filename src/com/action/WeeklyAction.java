package com.action;

import java.io.File;
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

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.entity.User;
import com.entity.Weekly;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.WeeklyService;

/*
 * param����
 * username2:�ϴ�weekly���û�����
 * title��weekly��title
 * fileurl���ϴ�weekly���ļ�·��
 * createtime:�ϴ�weekly��ʱ��
 * updatetime:����weekly��ʱ��
 * username3:��ȡ��ʦ���������ѧ�����֣���Ϊ��ͨ��ѧ������������
 * lists����ʦ������ѧ����weekly��ɵ��б�
 * lists2����ʦ�˲���һ��ѧ����weekly��ɵ��б�
 * list3��ѧ���˲��ұ�ѧ����weekly��ɵ��б�
 */
public class WeeklyAction extends ActionSupport  implements ModelDriven<Weekly>{
	
	private Weekly weekly;
	private WeeklyService weeklyService;
	private String username2;
	private String username3;//���ս�������Ĳ�ѯ���ѧ������
	private String title;
	private String fileurl;
	private String createtime;
	private String updatetime;
	private int uid;
	
	
	private List< Weekly> lists = new ArrayList<Weekly>();
	private List< Weekly> lists2 = new ArrayList<Weekly>();
	private List<Weekly> lists3 = new ArrayList<Weekly>();
	
	//��Ӧ����file1  <input type="file" name="file1"/>
	private File file1;
	//��ǰ�ϴ����ļ���
	private String file1FileName;
	//�ļ�����(MIME)
	private String file1ContentType;
	public void setFile1(File file1) {
	    this.file1 = file1;
	}
	public void setFile1FileName(String file1FileName) {
	    this.file1FileName = file1FileName;
	}
	public void setFile1ContentType(String file1ContentType) {
	    this.file1ContentType = file1ContentType;
    }	

	//ģ������
	@Override
	public Weekly getModel(){
		return weekly;
	}
	
	public String getUsername3() {
		return username3;
	}

	public void setUsername3(String username3) {
		this.username3 = username3;
	}
	

    public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	//ע��weeklyService
	public void setWeeklyService(WeeklyService weeklyService) {
		this.weeklyService = weeklyService;
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
	
	//�����������д��
    public List<Weekly> getLists() {
        return lists;
    }
    public void setLists(List<Weekly> lists) {
        this.lists = lists;
    }
    
  //�����������д��
    public List<Weekly> getLists2() {
        return lists2;
    }
    public void setLists2(List<Weekly> lists2) {
        this.lists2 = lists2;
    }
    
    public List<Weekly> getLists3() {
        return lists3;
    }
    public void setLists3(List<Weekly> lists3) {
        this.lists3 = lists3;
    }
    
	public String upload() throws Exception{
	
		//��ʼ�õ��ϴ����ļ������д���,�ϴ�֮ǰ��Ҫ����һ��uploadĿ¼
		ActionContext.getContext().put("Student", username2);//�ϴ����ǰ�˸���username2�����¼��ؽ���
	    System.out.println("�����ϴ����ļ�");
	    //���ļ��ϴ���uploadĿ¼����ȡ�ϴ���Ŀ¼·��
	    //String target1 = WeeklyAction.class.getClass().getResource("/").getPath();	    
	    String path="/weekly";
	    String target=ServletActionContext.getServletContext().getRealPath(path);
	    System.out.println("target:"+target);
	    /*String path="/WEB-INF/upload";
	    File file = new File(path);
		    InputStream inputStream=new FileInputStream(file); */
	    System.out.println("path:"+target);
	    //����Ŀ���ļ�����,�ļ���file1FileName����ʽ_FileName
	    if(file1FileName != null){
	    	File destFile=new File(target,file1FileName);
		    System.out.println("destFile:"+destFile);
		    //���ϴ����ļ���������Ŀ���ļ���
		    FileUtils.copyFile(file1, destFile);
		    
		    Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time=format.format(date);
			String time2 = format.format(date);
			//System.out.println(createtime);
			Weekly weekly = new Weekly();
			title = file1FileName;
			weekly.setTitle(title);
			createtime = time.toString();
			updatetime = time2.toString();
			weekly.setCreatetime(createtime);
			weekly.setUpdatetime(updatetime);
			weekly.setUsername2(username2);
			User user = new User();
			user.setUid(uid);
			fileurl=destFile.getPath();
			System.out.println("fileurl:"+fileurl);
			weekly.setFileurl(fileurl);
			System.out.println("action.upload����ִ��");
			String result=weeklyService.saveWeekly(username2,title,fileurl,createtime,updatetime);
			if(result.equals("successSave")){
				return "uploadSuccess";
			}else
				return "uploadFail";
	    }
		else
			return "uploadFail";
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
	
	public String findOneUserWeekly(){//��ʦ����һ��ѧ�����ܱ�������һ��ѧ���ܱ��б�
		System.out.println("action.findOneUserWeekly����ִ��");	
		
		int result = weeklyService.searchOneUserWeekly(username3);//ͨ��username3���ܱ�
		if(result == com.service.impl.WeeklyServiceImpl.SUCCESS){
			lists2 = weeklyService.findByWeeklyAuthor(username3);
			System.out.printf("weeklylist"+lists2);
			return "findSuccess";
		}else if(result == com.service.impl.WeeklyServiceImpl.FAIL){
			return "findFail";
		}
		return null;
	}
	
	public String findAllUserWeekly(){//��ʦ��������ѧ�����ܱ�����������ѧ���ܱ��б������ϴ�ʱ������
		System.out.println("action.findAllUserWeekly����ִ��");
		int result = weeklyService.searchAllUserWeekly(weekly);
		if(result == com.service.impl.WeeklyServiceImpl.SUCCESSALL){
			lists = weeklyService.findByWeeklyAll();
			System.out.println("weekly"+lists);
			return "findAllSuccess";
		}else if(result == com.service.impl.WeeklyServiceImpl.FAILALL){
			return "findAllFail";
		}
		return null;
	}

	public String findOneStuWeekly(){//ѧ������ѧ����weekly������һ��ѧ��weekly�б�
		System.out.println("action.findOneStuNote����ִ��");
		int result = weeklyService.searchOneStuWeekly(username2);//ͨ����ȡ����username2����weekly
		if(result == com.service.impl.NoteServiceImpl.SUCCESS){			
			lists3 = weeklyService.findByWeeklyStu(username2);
			System.out.println("lists3"+lists3);
			return "findOneSuccess";
		}else if(result == com.service.impl.NoteServiceImpl.FAIL){
			//ActionContext.getContext().put("Teacher", );
			//System.out.println(result);
			return "findOneFail";
		}
		return null;
	}

}
