package com.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

//import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;



public class DownloadAction extends ActionSupport{
	 
	 private String fileurl;// 下载的路径
     private String contentType;// 下载文件的类型
     private String fileName;// 文件类型
 
     
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
         System.out.println(fileurl);// downloadPath为相对路径，打印出“/UploadFile/readme.doc”
         int position = fileurl.lastIndexOf("/");// 借助lastIndexOf函数，从右向左查找第一个/
         System.out.println(position);// 打印"/"所造的坐标
         if (position > 0) {
             fileName = fileurl.substring(position + 1);// 得到文件的名字(全名，带后缀)
             System.out.println(fileName);// 輸出文件名，本例輸出readme.doc
         } else {
             fileName = fileurl;
         }
         System.out.println("fileurl:"+fileurl);
         contentType = "application/msword";// 指定下载问文件的类型
         return SUCCESS;
     }
 
     /**
      * 返回InputStream
      * 
      * @return
      */
     public InputStream getInputStream() {
         //InputStream inputStream = ServletActionContext.getServletContext().getResourceAsStream(downloadPath);
    	 File file = new File(fileurl);
    	 InputStream inputStream;
		try {
			inputStream = new FileInputStream(file);
			System.out.println(inputStream);//输出inputStream，如果为null表示路径出错
			return inputStream;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
     }
  
}

