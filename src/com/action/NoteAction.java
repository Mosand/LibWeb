package com.action;

import java.io.File;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.entity.Note;
import com.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.NoteService;

/*
 * param解释
 * username:上传note的用户名字
 * title：note的title
 * fileurl：上传note的文件路径
 * createtime:上传note的时间
 * updatetime:更新note的时间
 * username2:获取老师端搜索框的学生名字，因为是通过学生名字来搜索
 * lists：老师端所有学生的note组成的列表
 * lists2：老师端查找一个学生的note组成的列表
 * list3：学生端查找本学生的note组成的列表
 */
public class NoteAction extends ActionSupport implements ModelDriven<Note>{
	
	private Note note;
	private NoteService noteService;
	private String username;
	private String title;
	private String fileurl;
	private String createtime;
	private String updatetime;
	private String username2;
	private User user;
	HttpServletRequest request;
	private List<Note> lists = new ArrayList<Note>();
	private List<Note> lists2 = new ArrayList<Note>();
	private List<Note> lists3 = new ArrayList<Note>();
	private static final long serialVersionUID = 1L;
	
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

	public String getUsername2() {
		return username2;
	}

	public void setUsername2(String username2) {
		this.username2 = username2;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public Note getModel(){
		return note;
	}

	public void setNoteService(NoteService noteService) {
		this.noteService = noteService;
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
	//这个方法必须写上
    public List<Note> getLists() {
        return lists;
    }
    public void setLists(List<Note> lists) {
        this.lists = lists;
    }
    
    public List<Note> getLists2() {
        return lists2;
    }
    public void setLists2(List<Note> lists2) {
        this.lists2 = lists2;
    }
    
    public List<Note> getLists3() {
        return lists3;
    }
    public void setLists3(List<Note> lists3) {
        this.lists3 = lists3;
    }
    
	
	public String upload() throws Exception{
		
		ActionContext.getContext().put("Student", username);//上传完后，前端根据username来重新加载界面
		//开始拿到上传的文件，进行处理,上传之前，要创建一个upload目录
        System.out.println("测试上传的文件");
        //把文件上传到upload目录，获取上传的目录路径
        String path="/note";//相对路径
	String target=ServletActionContext.getServletContext().getRealPath(path);
        System.out.println("path:"+path);
        if(file1FileName != null){
        	//创建目标文件对象,文件名file1FileName，格式_FileName
            File destFile=new File(target,file1FileName);
            System.out.println("destFile:"+destFile);
            //把上传的文件，拷贝到目标文件中
            FileUtils.copyFile(file1, destFile);
            Date date=new Date();
    		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		String time=format.format(date);
    		String time2 = format.format(date);
    		
    		Note note = new Note();
    		title = file1FileName;
    		note.setTitle(title);
    		createtime = time.toString();
    		updatetime = time2.toString();
    		note.setCreatetime(createtime);
    		note.setUpdatetime(updatetime);
    		note.setUsername(username);
    		//System.out.println(username);
    		fileurl=destFile.getPath();
    		//fileurl=destFile.getPath();
    		note.setFileurl(fileurl);
    		System.out.println("action note upload方法执行");
    		String result=noteService.saveNote(username,title,fileurl,createtime,updatetime);
    		if(result.equals("successSave")){
    			//ActionContext.getContext().put("Student",username);
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
	
	public String findOneUserNote(){//找一个学生的周报，返回一个学生note列表
		System.out.println("action.findOneUserNote方法执行");
		
		int result = noteService.searchOneUserNote(username2);//通过输入框的username2找note
		if(result == com.service.impl.NoteServiceImpl.SUCCESS){
			lists2 = noteService.findByNoteAuthor(username2);
			System.out.println("note"+lists2);
			//ActionContext.getContext().put("Notelist", notelist);//将列表添加到上下文，传给前端
			return "findSuccess";
		}else if(result == com.service.impl.NoteServiceImpl.FAIL){
			//ActionContext.getContext().put("Teacher", );
			System.out.println(result);
			return "findfail";
		}
		return null;
	}
	
	
    
	public String findAllUserNote(){//找所有学生的周报，返回所有学生周报列表，按照上传时间排序
		System.out.println("action.findAllUserNote方法执行");
		int result = noteService.searchAllUserNote(note);
		if(result == com.service.impl.NoteServiceImpl.SUCCESSALL){
			lists = noteService.findByNoteAll();
			//ActionContext.getContext().put("Note", notelist);
			System.out.println("note"+lists);
			return "findAllSuccess";
		}else if(result == com.service.impl.NoteServiceImpl.FAILALL){
			return "findAllFail";		
		}
		return null;
	}
	

    public String findOneStuNote(){//学生端找学生的note，返回一个学生note列表
		System.out.println("action.findOneStuNote方法执行");
		int result = noteService.searchOneStuNote(username);//通过获取界面username来找note
		if(result == com.service.impl.NoteServiceImpl.SUCCESS){
			
			lists3 = noteService.findByNoteStu(username);
			System.out.println("lists3"+lists3);
			//ActionContext.getContext().put("Notelist", notelist);//将列表添加到上下文，传给前端
			return "findOneSuccess";
		}else if(result == com.service.impl.NoteServiceImpl.FAIL){
			//ActionContext.getContext().put("Teacher", );
			//System.out.println(result);
			return "findOneFail";
		}
		return null;
	}
    
}
