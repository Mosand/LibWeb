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
 * param����
 * username:�ϴ�note���û�����
 * title��note��title
 * fileurl���ϴ�note���ļ�·��
 * createtime:�ϴ�note��ʱ��
 * updatetime:����note��ʱ��
 * username2:��ȡ��ʦ���������ѧ�����֣���Ϊ��ͨ��ѧ������������
 * lists����ʦ������ѧ����note��ɵ��б�
 * lists2����ʦ�˲���һ��ѧ����note��ɵ��б�
 * list3��ѧ���˲��ұ�ѧ����note��ɵ��б�
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
	//�����������д��
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
		
		ActionContext.getContext().put("Student", username);//�ϴ����ǰ�˸���username�����¼��ؽ���
		//��ʼ�õ��ϴ����ļ������д���,�ϴ�֮ǰ��Ҫ����һ��uploadĿ¼
        System.out.println("�����ϴ����ļ�");
        //���ļ��ϴ���uploadĿ¼����ȡ�ϴ���Ŀ¼·��
        String path="D://workspace//libWeb//WebContent//note";      
        System.out.println("path:"+path);
        if(file1FileName != null){
        	//����Ŀ���ļ�����,�ļ���file1FileName����ʽ_FileName
            File destFile=new File(path,file1FileName);
            System.out.println("destFile:"+destFile);
            //���ϴ����ļ���������Ŀ���ļ���
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
    		System.out.println("action note upload����ִ��");
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
	
	public String findOneUserNote(){//��һ��ѧ�����ܱ�������һ��ѧ��note�б�
		System.out.println("action.findOneUserNote����ִ��");
		
		int result = noteService.searchOneUserNote(username2);//ͨ��������username2��note
		if(result == com.service.impl.NoteServiceImpl.SUCCESS){
			lists2 = noteService.findByNoteAuthor(username2);
			System.out.println("note"+lists2);
			//ActionContext.getContext().put("Notelist", notelist);//���б���ӵ������ģ�����ǰ��
			return "findSuccess";
		}else if(result == com.service.impl.NoteServiceImpl.FAIL){
			//ActionContext.getContext().put("Teacher", );
			System.out.println(result);
			return "findfail";
		}
		return null;
	}
	
	
    
	public String findAllUserNote(){//������ѧ�����ܱ�����������ѧ���ܱ��б������ϴ�ʱ������
		System.out.println("action.findAllUserNote����ִ��");
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
	

    public String findOneStuNote(){//ѧ������ѧ����note������һ��ѧ��note�б�
		System.out.println("action.findOneStuNote����ִ��");
		int result = noteService.searchOneStuNote(username);//ͨ����ȡ����username����note
		if(result == com.service.impl.NoteServiceImpl.SUCCESS){
			
			lists3 = noteService.findByNoteStu(username);
			System.out.println("lists3"+lists3);
			//ActionContext.getContext().put("Notelist", notelist);//���б���ӵ������ģ�����ǰ��
			return "findOneSuccess";
		}else if(result == com.service.impl.NoteServiceImpl.FAIL){
			//ActionContext.getContext().put("Teacher", );
			//System.out.println(result);
			return "findOneFail";
		}
		return null;
	}
    
}
