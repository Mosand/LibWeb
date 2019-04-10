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
 * param����
 * displayPath:�ļ��洢��·����Ҳ��ѧ���ϴ����ļ���·��
 * urlData��ת����ĵ�ַ
 * �����ϴ���note������ת����Ԥ���ļ�
 */

public class DisplayNoteAction extends ActionSupport {

    /**
     * ��ָ�� URL �ϴ��ļ�POST����������
     *
     * @param url ��������� URL
     * @param displaypath �ļ�·��
     * @param type ת������
     * @return ������Զ����Դ����Ӧ���, json����
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
            reqEntity.addPart("file", file); // fileΪ�����̨��File upload;����
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
        if ("0".equals(obj.getString("result"))) {// ת���ɹ�
            urlData = obj.getString("data");
            urlData = urlData.replace("[\"", "");//ȥ��[
            urlData = urlData.replace("\"]", "");//ȥ��]
            //���urlData���ļ��������ַ
            //URL realurl=new URL(urlData);
            System.out.println("urldata"+urlData);//��ӡ�����ļ�Ԥ����ַ
 		    return "success";           
        } else {// ת��ʧ��
            System.out.println("ת��ʧ��");
            return "fail";
        }
    }
	
	
}