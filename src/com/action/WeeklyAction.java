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
 * param解释
 * username2:上传weekly的用户名字
 * title：weekly的title
 * fileurl：上传weekly的文件路径
 * createtime:上传weekly的时间
 * updatetime:更新weekly的时间
 * username3:获取老师端搜索框的学生名字，因为是通过学生名字来搜索
 * lists：老师端所有学生的weekly组成的列表
 * lists2：老师端查找一个学生的weekly组成的列表
 * list3：学生端查找本学生的weekly组成的列表
 */
public class WeeklyAction extends ActionSupport  implements ModelDriven<Weekly>{
	
	private Weekly weekly;
	private WeeklyService weeklyService;
	private String username2;
	private String username3;//接收界面输入的查询框的学生名字
	private String title;
	private String fileurl;
	private String createtime;
	private String updatetime;
	private int uid;
	
	
	private List< Weekly> lists = new ArrayList<Weekly>();
	private List< Weekly> lists2 = new ArrayList<Weekly>();
	private List<Weekly> lists3 = new ArrayList<Weekly>();
	
	//对应表单的file1  <input type="file" name="file1"/>
	private File file1;
	//当前上传的文件名
	private String file1FileName;
	//文件类型(MIME)
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

	//模型驱动
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
	//注入weeklyService
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
	
	//这个方法必须写上
    public List<Weekly> getLists() {
        return lists;
    }
    public void setLists(List<Weekly> lists) {
        this.lists = lists;
    }
    
  //这个方法必须写上
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
	
		//开始拿到上传的文件，进行处理,上传之前，要创建一个upload目录
		ActionContext.getContext().put("Student", username2);//上传完后，前端根据username2来重新加载界面
	    System.out.println("测试上传的文件");
	    //把文件上传到upload目录，获取上传的目录路径
	    //String target1 = WeeklyAction.class.getClass().getResource("/").getPath();	    
	    String path="/weekly";
	    String target=ServletActionContext.getServletContext().getRealPath(path);
	    System.out.println("target:"+target);
	    /*String path="/WEB-INF/upload";
	    File file = new File(path);
		    InputStream inputStream=new FileInputStream(file); */
	    System.out.println("path:"+target);
	    //创建目标文件对象,文件名file1FileName，格式_FileName
	    if(file1FileName != null){
	    	File destFile=new File(target,file1FileName);
		    System.out.println("destFile:"+destFile);
		    //把上传的文件，拷贝到目标文件中
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
			System.out.println("action.upload方法执行");
			String result=weeklyService.saveWeekly(username2,title,fileurl,createtime,updatetime);
			if(result.equals("successSave")){
				return "uploadSuccess";
			}else
				return "uploadFail";
	    }
		else
			return "uploadFail";
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
	
	public String findOneUserWeekly(){//老师端找一个学生的周报，返回一个学生周报列表
		System.out.println("action.findOneUserWeekly方法执行");	
		
		int result = weeklyService.searchOneUserWeekly(username3);//通过username3找周报
		if(result == com.service.impl.WeeklyServiceImpl.SUCCESS){
			lists2 = weeklyService.findByWeeklyAuthor(username3);
			System.out.printf("weeklylist"+lists2);
			return "findSuccess";
		}else if(result == com.service.impl.WeeklyServiceImpl.FAIL){
			return "findFail";
		}
		return null;
	}
	
	public String findAllUserWeekly(){//老师端找所有学生的周报，返回所有学生周报列表，按照上传时间排序
		System.out.println("action.findAllUserWeekly方法执行");
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

	public String findOneStuWeekly(){//学生端找学生的weekly，返回一个学生weekly列表
		System.out.println("action.findOneStuNote方法执行");
		int result = weeklyService.searchOneStuWeekly(username2);//通过获取界面username2来找weekly
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
