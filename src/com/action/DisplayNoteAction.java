package com.action;

import java.io.File;
import java.nio.charset.Charset;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;

/*
 * param解释
 * displayPath:文件存储的路径，也是学生上传的文件的路径
 * urlData：转换后的地址
 * 解析上传的note并在线转换，预览文件
 */

public class DisplayNoteAction extends ActionSupport {

    /**
     * 向指定 URL 上传文件POST方法的请求
     *
     * @param url 发送请求的 URL
     * @param displaypath 文件路径
     * @param type 转换类型
     * @return 所代表远程资源的响应结果, json数据
     */
	private String displayPath;
	private String urlData;
	
	
	
    public String getUrlData() {
		return urlData;
	}


	public void setUrlData(String urlData) {
		this.urlData = urlData;
	}


	public String getDisplayPath() {
		return displayPath;
	}


	public void setDisplayPath(String displayPath) {
		this.displayPath = displayPath;
	}


	public static String SubmitPost(String url, String filepath, String type) {
        String requestJson = "";
        HttpClient httpclient =  HttpClients.createDefault();
        try {
            HttpPost httppost = new HttpPost(url);
            //displayPath.replaceAll("\\\\", "//");
            FileBody file = new FileBody(new File(filepath));
            System.out.println(file.getFilename());
            MultipartEntity reqEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE, null,Charset.forName("UTF-8"));
            reqEntity.addPart("file", file); // file为请求后台的File upload;属性
            reqEntity.addPart("convertType", new StringBody(type, Charset.forName("UTF-8")));
            httppost.setEntity(reqEntity);
            HttpResponse response = httpclient.execute(httppost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                HttpEntity resEntity = response.getEntity();
                requestJson = EntityUtils.toString(resEntity);
                EntityUtils.consume(resEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.getConnectionManager().shutdown();
            } catch (Exception ignore) {

            }
        }
        return requestJson;
    }
	
	public String execute() throws Exception {
		
		System.out.println("displaypath"+displayPath);
		String convertByFile = SubmitPost("http://dcs.yozosoft.com:80/upload", displayPath, "1");
        JSONObject obj = JSONObject.parseObject(convertByFile);
        if ("0".equals(obj.getString("result"))) {// 转换成功
            urlData = obj.getString("data");
            urlData = urlData.replace("[\"", "");//去掉[
            urlData = urlData.replace("\"]", "");//去掉]
            //最后urlData是文件的浏览地址
            //URL realurl=new URL(urlData);
            System.out.println("urldata"+urlData);//打印网络文件预览地址
 		    return "success";           
        } else {// 转换失败
            System.out.println("转换失败");
            return "fail";
        }
    }
	
	
}