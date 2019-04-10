package com.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

//import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;



public class DownloadAction extends ActionSupport{
	 
	 private String fileurl;// ���ص�·��
     private String contentType;// �����ļ�������
     private String fileName;// �ļ�����
 
     
     public String getFileurl() {
		return fileurl;
	}

	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
	}

	public String getContentType() {
         return contentType;
     }
 
     public void setContentType(String contentType) {
         this.contentType = contentType;
     }
 
     public String getFileName() {
         return fileName;
     }
 
     public void setFileName(String fileName) {
         this.fileName = fileName;
     }
 
     @Override
     public String execute() throws Exception {
         // TODO Auto-generated method stub
         //downloadPath = "g://test"+ServletActionContext.getRequest().getParameter("download");
    	 fileurl = ServletActionContext.getRequest().getParameter("download");
         System.out.println(fileurl);// downloadPathΪ���·������ӡ����/UploadFile/readme.doc��
         int position = fileurl.lastIndexOf("/");// ����lastIndexOf����������������ҵ�һ��/
         System.out.println(position);// ��ӡ"/"���������
         if (position > 0) {
             fileName = fileurl.substring(position + 1);// �õ��ļ�������(ȫ��������׺)
             System.out.println(fileName);// ݔ���ļ���������ݔ��readme.doc
         } else {
             fileName = fileurl;
         }
         System.out.println("fileurl:"+fileurl);
         contentType = "application/msword";// ָ���������ļ�������
         return SUCCESS;
     }
 
     /**
      * ����InputStream
      * 
      * @return
      */
     public InputStream getInputStream() {
         //InputStream inputStream = ServletActionContext.getServletContext().getResourceAsStream(downloadPath);
    	 File file = new File(fileurl);
    	 InputStream inputStream;
		try {
			inputStream = new FileInputStream(file);
			System.out.println(inputStream);//���inputStream�����Ϊnull��ʾ·������
			return inputStream;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
     }
  
}

