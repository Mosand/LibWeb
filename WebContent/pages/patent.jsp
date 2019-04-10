<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
	String path = request.getContextPath();
	String webContent = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setAttribute("webContent", webContent);
%>
<!DOCTYPE html>
<html>
<head>
<title>patent</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Societica Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />

<link href="${webContent}css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="${webContent}css/chocolat.css" type="text/css" media="screen" charset="utf-8" />
<link href="${webContent}css/style.css" rel="stylesheet" type="text/css" media="all" />	
<script src="${webContent}jquery/jquery-1.11.2.min.js"></script>
<script src="${webContent}jquery/bootstrap-3.3.7.min.js"></script>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
</head>
<body> 
	<div class="header">
		<div class="container">			
			<div class="logo">
				<a href="${webContent}pages/index.jsp"><img src="${webContent}images/logo.png" alt=" " ></a>
			</div>
<!-- 索引 -->
			<div class="top-nav">			
				<span class="menu"> </span>
				<ul>
					<li><a href="${webContent}pages/index.jsp" data-hover="HOME">HOME</a></li>
					<li><a href="${webContent}pages/project.jsp" data-hover="PROJECT">PROJECT</a></li>
					<li><a href="${webContent}pages/paper.jsp" data-hover="PAPER">PAPER</a></li>
					<li><a href="${webContent}pages/patent.jsp">PATENT</a></li>						
				</ul>
<script>
	$("span.menu").click(function(){
		$(".top-nav ul").slideToggle(500, function(){
		});
	});
</script>		
			</div>
			
			<div class="clearfix"> </div>
		</div>
	</div>
<!-- end header -->
	<div class="content">
		<div class="container">
		<div class="about">
				<div class="about-top">
						<h3>PATENT</h3>
				</div>
			<div class="about-bottom">
				<div class="col-md-4 activity-grid  " style="width:1140px;">
	                <p>1.一种实时监控系统， 2015.5.27，其他国家，CN201520044514.7</p>
	
	                <p>2.一种面向移动互联网的离线可视化业务开发生成器，2012.10.22 2016.10.22，中国，201210224772.4</p>
	  
					<p>3.一种不甚发达网络环境下的云计算服务节点选取方法，2014.7.23-2034.3.27，四川，CN201410119283.1</p>
	                
					<p>4.一种基于掌纹识别的Android隐私保护系统，中国，201510609322.0 </p>
	                
					<p>5.一种基于移动终端的双线架构快递信息保护方法，中国，201510608491.2</p>
	                
					<p>6.一种恶意代码情报检测分析方法及系统，中国，201510608807.8 </p>
	                
					<p>7.一种虚拟桌面的管理控制系统和方法，中国，201510607598.5 </p>
	                
					<p>8.一种基于智能终端的自助存取系统，中国，201510615446.X </p>
	                
					<p>9.一个基于步态生物特征的移动设备身份认证方法，中国，201510609523.0 </p>
	                
					<p>10.一种基于掌纹识别的私密信息保护软件及新型掌纹图像预处理方法，中国，201510608491.2 </p>
	                
					<p>11.一种基于传感器技术并结合智能穿戴设备的移动设备实时防护方法，中国，201510607658.3 </p>
	                
					<p>12.一种多维度的垃圾短信过滤方法及系统，中国，201510607658.3 </p>
	                
					<p>13基于多维影响因素的交通事故分析预警</p>
	                
					<p>14.一种基于 web 的交通数据分析系统</p>
	                
					<p>15.一种基于多变量灰色模型的车流量预测方法</p>
	                
					<p>16.一种基于多算法融合的车流量预测方法</p>		
				</div>					
			</div>
		</div>
		</div>
	</div>
<!-- end content -->
<!-- footer -->
    <div class="footer">
        相关链接：&nbsp;&nbsp;
        <a href="https://dblp.uni-trier.de" style="color:#fff">DBLP</a>&nbsp;&nbsp;&nbsp;
        <a href="https://www.ccf.org.cn/c/2016-12-27/569124.shtml " style="color:#fff">中国计算机学会推荐国际学术会议和期刊目录</a>&nbsp;&nbsp;&nbsp;  
        <a href="http://www.cnki.net/" style="color:#fff">中国知网</a> &nbsp;&nbsp;&nbsp;   
        <a href="http://idas.uestc.edu.cn/authserver/login?service=http://portal.uestc.edu.cn/" style="color:#fff">信息门户登陆</a>&nbsp;&nbsp;&nbsp;                 
    </div>
	
</body>
</html>