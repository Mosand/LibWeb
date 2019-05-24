<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
	String path = request.getContextPath();
	String webContent = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setAttribute("webContent", webContent);
	String downpath = "D:/workspace/libWeb/WebContent/";	
	request.setAttribute("downpath", downpath);	
%>
<%
String wid=request.getParameter("wid");
String nid=request.getParameter("nid");
%>
<!DOCTYPE html>
<html>
<head>
<title>student</title>
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
          <li style="margin-top:15px;color:#fff;"><img src="${webContent}images/icon/main_man.png" />&nbsp;&nbsp;<%=request.getAttribute("Student")%></li>
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
					<a href="#StudentWeekly" data-toggle="tab">WEEKLY</a>
				</li>
				<li><a href="#StudentNote" data-toggle="tab">SHARENOTE</a></li>	
		
			</ul>
<script>
$("span.menu").click(function(){
	$(".top-nav ul").slideToggle(500, function(){
	});
});
</script>	
</div>
</div>
</div>	
<!-- end header -->
<div class="content" style="margin:20px;">
	<div class="container">
	 <div id="myTabContent" class="tab-content">
<!-- end Upload -->

		<div class="tab-pane fade in active" id="StudentWeekly">
				<div class="about-top">
						<h3>WEEKLY</h3>
				</div>
				<div class="about-bottom">
						   <div class="weekly">
<%-- 		               <form method="post" action="weekly_upload"  enctype="multipart/form-data" id="weeklyupload">
                            <h3>上传周报:</h3><input id="upload_weekly" type="file" name="file1" /> 
                            <input type="hidden" name="username2" value="<%=request.getAttribute("Student")%>" />
                            <input type="submit" class="btnupload btn btn-danger btn-large" value="周报上传"/>
	                       </form> --%>
                  <form method="post" action="weekly_upload"  enctype="multipart/form-data" id="weeklyupload">	                       
							<input id="lefile" type="file" style="display:none" name="file1">  
							<div class="input-append" style="margin:0px 0px 50px;" >  
							    <input id="photoCover" class="input-large" type="text" style="height:30px;">  
							    <a class="btn" onclick="$('input[id=lefile]').click();">上传周报</a>  
	                            <input type="hidden" name="username2" value="<%=request.getAttribute("Student")%>" />
	                            <input type="submit" class="btnupload btn btn-danger btn-large" value="提交"/>							    
							</div>  
				  </form>
							   
							<script type="text/javascript">  
							$('input[id=lefile]').change(function() {  
							$('#photoCover').val($(this).val());  
							});  
							</script>                         
                       
                 </div>
                 <form method="post" enctype="multipart/form-data" id="weeklyHistory">
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
					      <th>老师评语</th>
					    </tr>
					  </thead>
					  <tbody id="weekly_list">  
					  </tbody>
		 			  <tbody>
					    <tr>
					    </tr>
					  </tbody>  
					</table>
				</form>		
				</div>	
			</div>
			<div class="tab-pane fade " id="StudentNote">
				<div class="about-top">
						<h3>SHARENOTE</h3>
				</div>
					<div class="about-bottom">
				    <div class="note">
<%--                        <form method="post" action="note_upload" enctype="multipart/form-data" id="noteupload">
                            <h3>上传笔记:</h3><input type="file" name="file1"  /> 
                            <input type="hidden" name="username" value="<%=request.getAttribute("Student")%>" />
                            <input type="submit" class="btnupload btn btn-danger btn-large" id="uploadNote" value="笔记上传"/>
                       </form>   --%>
                  <form method="post" action="note_upload"  enctype="multipart/form-data" id="noteupload">	                       
							<input id="rifile" type="file" style="display:none" name="file1">  
							<div class="input-append" style="margin:0px 0px 50px;" >  
							    <input id="checkCover" class="input-large" type="text" style="height:30px;">  
							    <a class="btn" onclick="$('input[id=rifile]').click();">上传笔记</a>  
	                            <input type="hidden" name="username" value="<%=request.getAttribute("Student")%>" />
	                            <input type="submit" class="btnupload btn btn-danger btn-large" value="提交"/>							    
							</div>  
				  </form> 
							<script type="text/javascript">  
							$('input[id=rifile]').change(function() {  
							$('#checkCover').val($(this).val());  
							});  
							</script>  				                        
				 </div> 
				 <form method="post" enctype="multipart/form-data" id="NoteHistory">
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
					      <th>老师点评</th>
					    </tr>
					  </thead>
					  <tbody id="note_list">
					  </tbody>
		 			  <tbody>
					 
					  </tbody>  
					</table>
				</form>	
				</div>	
				</div>
				</div>
				</div>
				</div>
			<!-- weekly_news modal -->
		
<form method="post" class="modal fade" id="weeklycomment" tabindex="-1" role="dialog" aria-labelledby="weeklycommentLabel" aria-hidden="true" >
  <div class="modal-dialog">
     <div class="modal-content" style="width:420px;margin:0 auto;">
             <div class="modal-header">
                 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                     &times;
                 </button>
                 <h4 class="modal-title" id="weeklycommentLabel">
              	    老师评语
                 </h4>
             </div>        
             <div class="modal-footer">
                 <button class="btn btn-danger" data-dismiss="modal">关闭</button>
             </div>
     </div>
  </div>
</form> 
<!-- note_share modal -->
<form method="post" id="notecomment" class="modal fade"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
 <div class="modal-dialog">
     <div class="modal-content" style="width:420px;margin:0 auto;">
             <div class="modal-header">
                 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                     &times;
                 </button>
                 <h4 class="modal-title" id="notecommentLabel">
                  老师评语
                 </h4>
             </div>
             <div class="modal-footer">
                 <button class="btn btn-danger" data-dismiss="modal">关闭</button>
             </div>
         </div>
     </div>
</form> 
<!-- 数据加载 -->

<script type="text/javascript">
var authorname="<%=request.getAttribute("Student")%>"

$(function(){
	$("#uploadweekly").click(function(){
		$("#upload_weekly").ajaxSubmit({
			url:"/weekly_upload",
			type:"POST",
			dataType:"text",
			success: function(res){
				alyer.alert("上传成功!")
			}
		})
	})
}
		);
$(function(){
	$("#uploadnote").click(function(){
		$("#upload_note").ajaxSubmit({
			url:"/weekly_note",
			type:"POST",
			dataType:"text",
			success: function(res){
				alyer.alert("上传成功!")
			}
		})
	})
}
		);

$(function() {//预加载方法
		//通过ajax请求菜单
		$.ajax({
			url : './weekly_findOneStuWeekly',
			type : 'POST',
			dataType : 'json',
			data:{"username2":authorname},
			success : function(list) {
				$("#weekly_list").html("");
				if(list.length != 0) {
					for (var i = 0; i < list.length; i++) {
						 $("#weekly_list").append("<tr id='weekly_"+list[i].wid+"'><td>"+list[i].title+"</td><td>"+list[i].username2+"</td><td>"+list[i].createtime+"</td><td>"+list[i].updatetime+"</td><td><a href='displayweeklyFile?displayPath="+list[i].fileurl+"'><img src='${webContent}images/icon/see.png'/></a></td><td><a href='${webContent}weekly/"+list[i].title+"'><img src='${webContent}images/icon/download.png'/></a></td><td><span class='weeklyc'><img src='${webContent}images/icon/comment.png' /></span></td></tr>");
					}
				}
				
			   $("span.weeklyc").click(function() {
						var index=$(this).parents("tr").attr("id");
						var weeklynum = index.split("_")[1].substring(0);					   
				       $.ajax({
				           type: "POST",
				           url: "./commentWeekly_searchTeaComment",
				           dataType: "json",
				           data: {"wid": weeklynum},
				           success: function (list) {
								$("#weeklycommentLabel").html("");				        	   
							for(var i = 0; i < list.length; i++){								
								$("#weeklycommentLabel").append("<div class='modal-body'><div class='form-group'><textarea class='form-control' rows='4' name=content'>"+list[i].content+"</textarea></div><div class='col-sm-10'><p style='float:right;color:#9d9d9d;margin:-12px -60px;font-size:16px;'>老师：&nbsp;"+list[i].authorname+"</p></div></div>");		
							    $("#weeklycomment").modal("show");		
						    
							}
				           }			           
				       });
				   }); 					
			},
			//error : function(msg) {
				//alert(msg);
			//}
		});

		$.ajax({
			url : './note_findOneStuNote',
			type : 'POST',
			dataType : 'json',
			data:{"username":authorname},
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
				           url: "./commentNote_searchTeaComment",
				           dataType: "json",
				           data: {"nid" : notenum},
				           success: function (list) {
								$("#notecommentLabel").html("");
							for(var i = 0; i < list.length; i++){						
								$("#notecommentLabel").append("<div class='modal-body'><div class='form-group'><textarea class='form-control' rows='4' name=content'>"+list[i].content+"</textarea></div><div class='col-sm-10'><p style='float:right;color:#9d9d9d;margin:-12px -60px;font-size:16px;'>老师：&nbsp;"+list[i].authorname+"</p></div></div>");
							    $("#notecomment").modal("show");
														
							}
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