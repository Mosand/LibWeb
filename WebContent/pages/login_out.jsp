<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String webContent = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setAttribute("webContent", webContent);
%>
<!DOCTYPE html>
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>login_out</title>
    	<link rel="stylesheet" href="${webContent}css/default/bootstrap-3.3.7.min.css">  
</head>
<body>
  <%  
   response.setHeader("refresh", "2; URL = index.jsp");  // 定时跳转  
   session.invalidate(); // 注销 session   
  %>  


		  <div class="panel panel-warning" style="width:480px;margin:50px auto">
		    <div class="panel-heading">
		        <h3 class="panel-title">您已成功推出本系统，两秒钟后跳转到登陆页</h3>
		    </div>
		    <div class="panel-body">
		         如果没有自动跳转，请点击<a href="${webContent}pages/index.jsp">这里</a>
		    </div>
		</div> 
</body>
</html>