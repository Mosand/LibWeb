<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
	String path = request.getContextPath();
	String webContent = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setAttribute("webContent", webContent);
%>
<%      
String wid=request.getParameter("wid");
String nid=request.getParameter("nid");
System.out.println(wid); 
System.out.println(nid);  
%>
<!DOCTYPE html>
<html>
<head>
<title>老师端</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Societica Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />

<link href="${webContent}css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="${webContent}css/style.css" rel="stylesheet" type="text/css" media="all" />	
<link href="${webContent}css/owl.carousel.css" rel="stylesheet" />
<link rel="stylesheet" href="${webContent}css/chocolat.css" type="text/css" media="screen" charset="utf-8" />
<link rel="stylesheet" href="${webContent}css/default/bootstrap-3.3.7.min.css">
<link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,300,100,700' rel='stylesheet' type='text/css'>  
<script src="${webContent}jquery/jquery-1.11.2.min.js"></script>
<script src="${webContent}jquery/jquery.form.js"></script>
<script src="${webContent}jquery/bootstrap-3.3.7.min.js"></script>
<style>
	.login_icon{
		z-index:100;
		position:absolute;
		top:50px;
		right:20px;
	}
	
.top-nav ul li.active a {
    color: #fff;
}
</style>
<script src="${webContent}js/responsiveslides.min.js"></script>
<script src="${webContent}js/jquery.chocolat.js"></script>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
       
</head>
<body> 
<!-- 登录接口 -->
<div class="login_icon">
      <ul class="nav navbar-nav navbar-right"> 
          <li style="margin-top:15px;color:#fff;"><img src="${webContent}images/icon/main_man.png" />&nbsp;&nbsp;<%=request.getAttribute("Teacher")%></li>
          <li><a data-toggle="modal" href="${webContent}pages/login_out.jsp" ><img src="${webContent}images/icon/login_out.png" />&nbsp;</a></li>
      </ul> 
</div>
<div class="header">
	<div class="container">			
		<div class="logo">
			<a href="${webContent}pages/index.jsp"><img src="${webContent}images/logo.png" alt=" " ></a>
		</div>
<!-- 索引 -->
		<div class="top-nav" style="margin-right:50px;">			
			<span class="menu"> </span>
			<ul id="myTab">
				<li>
					<a href="#weeklyNews" data-toggle="tab">WEEKLY</a>
				</li>
				<li><a href="#noteShare" data-toggle="tab">SHARENOTE</a></li>	
		
			</ul>		
		</div>
		
		<div class="clearfix"> </div>
	</div>
</div>
<!-- end header -->
<div class="content" style="margin:20px;">
	<div class="container">
	  <div id="myTabContent" class="tab-content">
	  
		<div class="tab-pane fade in active" id="weeklyNews">
				<div class="about-top">
						<h3>WEEKLY</h3>
				</div>
				<div class="about-bottom">
		
				    <form action="weekly_findOneUserWeekly" method="post" class="navbar-form navbar-left" id="searchWeeklyNews">
				      <div class="form-group">
				          <input type="text" class="form-control" placeholder="Search" name="username3">
				      </div>
				      <button type="submit" class="btn btn-default" >查询</button>
				    </form>	
				    	
					<table class="table table-hover">
					  <thead>
					    <tr>
					    <!-- 操作用图标表示 -->
					      <th>标题</th>
					      <th>发布者</th>
					      <th>创建时间</th>
					      <th>更新时间</th>
					      <th>在线预览</th>
					      <th>下载</th>
					      <th>点评</th><!-- 如果后台传数据就写成detail.jsp，下方添加该功能；如果后台直接跳转页面，就写弹窗 -->
					    </tr>
					  </thead>
					  <tbody id="weekly_list">
					  
					  </tbody>
					</table>		
				</div>
			</div>
<!-- end weekly_news -->

		<div class="tab-pane fade" id="noteShare">
				<div class="about-top">
						<h3>SHARENOTE</h3>
				</div>
				<div class="about-bottom">
				    <form action="note_findOneUserNote" method="post" class="navbar-form navbar-left" id="searchNoteShare">
				      <div class="form-group">
				          <input type="text" class="form-control" placeholder="Search" name="username2">
				      </div>
				      <button type="submit" class="btn btn-default" >查询</button>
				    </form>	
				    	
					<table class="table table-hover">
					  <thead>
					    <tr>
					    <!-- 操作用图标表示 -->
					      <th>标题</th>
					      <th>发布者</th>
					      <th>创建时间</th>
					      <th>更新时间</th>
					      <th>在线预览</th>
					      <th>下载</th>
					      <th>点评</th><!-- 如果后台传数据就写成detail.jsp，下方添加该功能；如果后台直接跳转页面，就写弹窗 -->
					    </tr>
					  </thead>
					  <tbody id="note_list">  
					  </tbody>  
					</table>		
				</div>	
			</div>
<!-- end note_share -->	
							
	 </div>
	</div>
</div>
<!-- end content -->
<!-- weekly_news modal -->
<form action="commentWeekly_saveComment" method="post" class="modal fade" id="weeklycomment" tabindex="-1" role="dialog" aria-labelledby="weeklycommentLabel" aria-hidden="true">
  <div class="modal-dialog">
     <div class="modal-content" style="width:420px;margin:0 auto;">
             <div class="modal-header">
                 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                     &times;
                 </button>
                 <h4 class="modal-title" id="weeklycommentLabel">
              	    点评
                 </h4>
             </div>
             <div class="modal-body">
				<div class="form-group">
				  <textarea class="form-control" rows="4" name="content" id="wc_content"></textarea>
				</div>
             </div>
             <input type="hidden" name="authorname" value="<%=request.getAttribute("Teacher")%>" />
             <input type="hidden" name="wid" value="" id="alter_wid" />             
             <div class="modal-footer">
                 <button class="btn btn-primary" type="submit" >提交</button>
                 <button class="btn btn-danger" data-dismiss="modal">取消</button>
             </div>
     </div>
  </div>
</form> 
<!-- note_share modal -->
<form action="commentNote_saveComment" method="post" id="notecomment" class="modal fade"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
 <div class="modal-dialog">
     <div class="modal-content" style="width:420px;margin:0 auto;">
             <div class="modal-header">
                 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                     &times;
                 </button>
                 <h4 class="modal-title" id="notecommentLabel">
                  点评
                 </h4>
             </div>
             <div class="modal-body">
				<div class="form-group">
				  <textarea class="form-control" rows="4" name="content" id="nc_content"></textarea>
				</div>
             </div>
             <input type="hidden" name="authorname" value="<%=request.getAttribute("Teacher")%>" />
             <input type="hidden" name="nid" value="" id="alter_nid" /> 
             <div class="modal-footer">
                 <button class="btn btn-primary" type="submit" >提交</button>
                 <button class="btn btn-danger" data-dismiss="modal">取消</button>
             </div>
         </div>
     </div>
</form> 

<!-- 数据加载 -->
<script type="text/javascript">
var authorname="<%=request.getAttribute("Teacher")%>"

   $(function() {//预加载方法
		//通过ajax请求菜单
		$.ajax({
			url : './weekly_findAllUserWeekly',
			type : 'POST',
			dataType : 'json',
			success : function(list) {
				$("#weekly_list").html("");
				if(list.length != 0) {
					for (var i = 0; i < list.length; i++) {
						 $("#weekly_list").append("<tr id='weekly_"+list[i].wid+"'><td>"+list[i].title+"</td><td>"+list[i].username2+"</td><td>"+list[i].createtime+"</td><td>"+list[i].updatetime+"</td><td><a href='displayweeklyFile?displayPath="+list[i].fileurl+"'><img src='${webContent}images/icon/see.png'/></a></td><td><a href='${webContent}weekly/"+list[i].title+"'><img src='${webContent}images/icon/download.png'/></a></td><td><span class='weeklyc'><img src='${webContent}images/icon/comment.png' /></span></td></tr>");
					}
				}
				
				   $("span.weeklyc").click(function() {
						var index0=$(this).parents("tr").attr("id");
						var weeklynum = index0.split("_")[1].substring(0);
						
				       $.ajax({
				           type: "POST",
				           url: "./commentWeekly_searchComment",
				           dataType: "json",
				           data: {"wid": weeklynum,"authorname":authorname},
				           success: function (list) {
							$("#wc_content").html("");
							$("#wc_content").append(list[0].content);
							$("#alter_wid").val(list[0].wid);   
							$("#weeklycomment").modal("show");
				           },
				           error: function (e) {
							$("#wc_content").html("");				        	   
							$("#alter_wid").val(weeklynum); 				        	   
							$("#weeklycomment").modal("show");
				           }
				       });
				   });					
			},
			//error : function(msg) {
				//alert(msg);
			//}
		});
   
		$.ajax({
			url : './note_findAllUserNote',
			type : 'POST',
			dataType : 'json',
			success : function(list) {
				$("#note_list").html("");
				if(list.length != 0) {
					for (var i = 0; i < list.length; i++) {
						 $("#note_list").append("<tr id='note_"+list[i].nid+"'><td>"+list[i].title+"</td><td>"+list[i].username+"</td><td>"+list[i].createtime+"</td><td>"+list[i].updatetime+"</td><td><a href='displaynoteFile?displayPath="+list[i].fileurl+"'><img src='${webContent}images/icon/see.png'/></a></td><td><a href='${webContent}note/"+list[i].title+"'><img src='${webContent}images/icon/download.png'/></a></td><td><span class='notec'><img src='${webContent}images/icon/comment.png' /></span></td></tr>");
					}
				}
				   $("span.notec").click(function() {
						var index1=$(this).parents("tr").attr("id");
						var notenum = index1.split("_")[1].substring(0);
				       $.ajax({
				           type: "POST",
				           url: "./commentNote_searchComment",
				           dataType: "json",
				           data: {"nid": notenum,"authorname":authorname},
				           success: function (list) {
							$("#nc_content").html("");
							$("#nc_content").append(list[0].content);
							$("#alter_nid").val(list[0].nid);   
							$("#notecomment").modal("show");
				           },
				           error: function (e) {
							$("#nc_content").html("");				        	   
							$("#alter_nid").val(notenum);				        	   
							$("#notecomment").modal("show");
				           }
				       });
				   });	
			},
			//error : function(msg) {
				//alert(msg);
			//}
		});   
	});  
	
</script>

<script>
$(document).ready(function() {  
		
		$('#searchWeeklyNews').ajaxForm(function(list) {
			$("#weekly_list").html("");
			if(list.length != 0) {
				for (var i = 0; i < list.length; i++) {
					 $("#weekly_list").append("<tr id='weekly_"+list[i].wid+"'><td>"+list[i].title+"</td><td>"+list[i].username2+"</td><td>"+list[i].createtime+"</td><td>"+list[i].updatetime+"</td><td><a href='displayweeklyFile?displayPath="+list[i].fileurl+"'><img src='${webContent}images/icon/see.png'/></a></td><td><a href='${webContent}weekly/"+list[i].title+"'><img src='${webContent}images/icon/download.png'/></a></td><td><span class='weeklyc'><img src='${webContent}images/icon/comment.png' /></span></td></tr>");
				}
			}
			
			   $("span.weeklyc").click(function() {
					var index0=$(this).parents("tr").attr("id");
					var weeklynum = index0.split("_")[1].substring(0);
			       $.ajax({
			           type: "POST",
			           url: "./commentWeekly_searchComment",
			           dataType: "json",
			           data: {"wid": weeklynum,"authorname":authorname},
			           success: function (list) {
						$("#wc_content").html("");
						$("#wc_content").append(list[0].content);
						$("#alter_wid").val(list[0].wid);   
						$("#weeklycomment").modal("show");
			           },
			           error: function (e) {
						$("#wc_content").html("");			        	   
						$("#alter_wid").val(weeklynum); 			        	   
						$("#weeklycomment").modal("show");
			           }
			       });
			   });		
  });
          <!--searchWeeklyNews-->
          
  		$('#searchNoteShare').ajaxForm(function(list) {
			$("#note_list").html("");
			if(list.length != 0) {
				for (var i = 0; i < list.length; i++) {
					 $("#note_list").append("<tr id='note_"+list[i].nid+"'><td>"+list[i].title+"</td><td>"+list[i].username+"</td><td>"+list[i].createtime+"</td><td>"+list[i].updatetime+"</td><td><a href='displaynoteFile?displayPath="+list[i].fileurl+"'><img src='${webContent}images/icon/see.png'/></a></td><td><a href='${webContent}note/"+list[i].title+"'><img src='${webContent}images/icon/download.png'/></a></td><td><span class='notec'><img src='${webContent}images/icon/comment.png' /></span></td></tr>");
				}
			}
			   $("span.notec").click(function() {
					var index1=$(this).parents("tr").attr("id");
					var notenum = index1.split("_")[1].substring(0);
			       $.ajax({
			           type: "POST",
			           url: "./commentNote_searchComment",
			           dataType: "json",
			           data: {"nid": notenum,"authorname":authorname},
			           success: function (list) {
						$("#nc_content").html("");
						$("#nc_content").append(list[0].content);
						$("#alter_nid").val(list[0].nid);   
						$("#notecomment").modal("show");
			           },
			           error: function (e) {
						$("#nc_content").html("");			        	   
						$("#alter_nid").val(notenum);				        	   
						$("#notecomment").modal("show");
			           }
			       });
			   });	
  });
  <!--searchNoteShare--> 
               	          
		         
});
</script>
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