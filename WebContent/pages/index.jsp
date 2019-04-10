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
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
		top:65px;
		right:50px;
	}
	
    .member_img{
        text-align: center;
        width:350px;
        font-weight:600;
        font-size:16px;
        float: left;
        margin:10px;
    }
    
    .member_img img{
    	height:256px;
    }
    
    .member_img p{
        margin-top:-20px;
    }
</style>
<script src="${webContent}js/jquery.min.js"></script>
<script src="${webContent}js/responsiveslides.min.js"></script>
<script src="${webContent}js/jquery.chocolat.js"></script>
<script>
    $(function () {
      $("#slider").responsiveSlides({
      	auto: true,
      	speed: 500,
        namespace: "callbacks",
        pager: false,
		nav:true,
      });
      
	$('#example1 a').Chocolat();
    });
</script>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
</head>
<body> 
<!--header-->
	<div class="header">
		<div class="container">			
			<div class="logo">
				<a href="${webContent}pages/index.jsp"><img src="${webContent}images/logo.png" alt="data analysis lab " ></a>
			</div>
<!-- 索引 -->
			<div class="top-nav">			
				<span class="menu"> </span>
				<ul>
					<li><a href="${webContent}pages/index.jsp"  >HOME</a></li>
					<li><a href="${webContent}pages/project.jsp" data-hover="PROJECT">PROJECT</a></li>
					<li><a href="${webContent}pages/paper.jsp" data-hover="PAPER">PAPER</a></li>
					<li><a href="${webContent}pages/patent.jsp" data-hover="PATENT">PATENT</a></li>						
				</ul>
<script>
	$("span.menu").click(function(){
		$(".top-nav ul").slideToggle(500, function(){
		});
	});
</script>				
			</div>
			
<!-- 			<div class="clearfix"> </div> -->
		</div>
	</div>
<!-- end header -->
<!-- 登录接口 -->
	<div class="login_icon"><a data-target="#login" data-toggle="modal"><img src="${webContent}images/icon/main_man.png" /></a></div>
<!--团队纪实轮播-->
	<div class="slider">
	    <div class="callbacks_container">
	      <ul class="rslides" id="slider">
	      
	        <li>
	          <img src="${webContent}images/bg1.jpg" alt="">
			  <div class="banner-matter">
				<h2></h2>
			  </div>
	        </li>
	        
	        <li>
	          <img src="${webContent}images/bg2.jpg" alt="">
			  <div class="banner-matter">
				<h2></h2>
			  </div>			  
	        </li>
	        
	        <li>
	          <img src="${webContent}images/bg3.jpg" alt="">	 
				<div class="banner-matter">
				<h2></h2>
			  </div>			  
	        </li>
	        
	      </ul>
	    </div>
	  </div>
	<!--end slider-->

	<div class="content">
		<div class="container">
<!-- 团队总体介绍 -->
			<div class="welcome">
				<div class="welcome-left-in">
					<h3>WELCOME</h3>
					<p>“智创未来”团队现在有专职教师3人，博士研究生6 人，硕士研究生19人。所有专职人员均具备博士学历，其中教授1 人、高级工程师1 人、讲师1 人。该团队隶属于电子科技大学网络与数据安全四川省重点实验室与四川省智慧交通研究院，实验室同时具备四川省软件评测中心、成都市信息保密工程技术研究中心等资质，是电子科技大学信息安全博士点的主要培养单位。团队现已具备的软硬件设施能够确保各种项目的顺利实施。</p>
					<P>团队主要研究方向包括大数据分析与应用、网络与数据安全等，现阶段的研究工作主要围绕大数据分析应用展开。从16到17年，团队承接了云南电网资源池故障诊断与定位研究、交投智慧高速示范应用研究、国家网络应急中心医疗大数据综述研究以及四川省科技厅跨平台中文知识图谱研究等项目，具备了丰富的大数据分析与应用领域的项目经验与管理经验，培养了一批具有大数据分析技能的硕士与博士生。</P>
				</div>
				
				<div class="clearfix"> </div>
			</div>
			<!-- end welcome -->
<!-- 团队老师介绍 -->
			<div class="gallery">
				<h3>LEADER</h3>
					<div class="activity-grids">
						<div class="col-md-4 activity-grid">
                            <div class="member_img">
                                <img src="${webContent}images/zhangfengli.png" />
                                <p style="margin-top:10px;">张凤荔&nbsp;&nbsp;教授&nbsp;&nbsp;博士导师</p>
                                <p>研究方向：宏观网络安全、移动数据管理</p>
                                <p>联系方式：fzhang@uestc.edu.cn</p>
                            </div>

                            <div>
                                <p>女，博士，电子科技大学信息与软件工程学院教授，博士生导师。1986年研究生毕业于电子科技大学（原成都电讯工程学院）计算机软件专业研究生，2000年至2002年美国依理诺大学芝加哥分校计算机系高级访问学者，在Ouri Wolfson教授的指导下，从事时间空间数据库移动数据库系统的开发和研究。2003年至2007年在电子科技大学计算机学院在职攻读博士，2007年获得计算机应用技术工学博士学位。现任电子科技大学计算机学院教授，博士生导师。1986年以来主要在电子科技大学从事计算机教学和科研工作。
                                </p>
                            </div>
						</div>
						
						<div class="col-md-4 activity-grid">
                                <div class="member_img">
                                    <img src="${webContent}images/hexinggao.png" />
                                    <p style="margin-top:10px;">何兴高&nbsp;&nbsp;高级工程师&nbsp;&nbsp;研究生导师</p>
                                    <p>研究方向：嵌入式应用、计算机应用</p>
                                    <p>联系方式：happy_he@vip.163.com</p>
                                </div>

                                <div>
                                    <p>个人简介：1984年9月至1988年6月在电子科技大学本科学习，专业：计算机硬件；1988年7月至1993年8月在电子科技大学工作，主要从事过程控制，如基于单板机、单片机、工控机的应用开发；1993年9月至1996年6月在电子科技大学读在职研究生，专业：计算机应用；1996年7月至今在电子科技大学工作，从事教学、科研工作，主要从事计算机应用，网络安全应用等软件的开发应用，熟悉计算机硬件和软件。</p>
                                    <p>教学情况：先后承担了本科生、研究生课程：《单片机》、《ARM微处理器》、《可编程逻辑设计》、《逆向工程》、《计算机组成原理与结构》等。</p>
                                    <p>获奖情况：获得四川省科技进步二等奖1次，四川省科技进步三等奖1次。</p>
                                </div>												
						</div>
									
						<div class="col-md-4 activity-grid">
                                <div class="member_img">
                                    <img src="${webContent}images/wangruijin.png" />
                                    <p style="margin-top:10px;">王瑞锦&nbsp;&nbsp;讲师</p>
                                    <p> 研究方向：量子通信安全、大数据分析及安全</p>
                                </div>

                                <div>
                                    <p>男，博士，电子科技大学信息安全专业博士后，讲师，中国计算机学会  &amp;ACM 会员，中国量子密码会员，研究方向为移动互联安全和量子通信安全，具体包括移动安全、量子对话、量子隐形传态、云存储、物联网等中的安全协议设计及应用研究。2013年12月于电子科技大学获得信息与通信工程（信息安全）专业工学博士学位，同年进入电子科技大学计算机科学与工程学院任教，加入网络与数据安全四川省重点实验室。2015年9月至2016年9月，国家留学基金委公派到美国西北大学计算机科学系 Kuzmanovic Aleksandra 教授团队进行交流访学一年。在包括 Quantum Information Processing、Int. J. Theor. Phys、Adhoc &amp; Sensor Wireless Networks等高质量的国内外期刊和会议上发表（录用）学术论文20余篇，其中被 SCI、EI检索10余篇，申报发明专利10余项。主持博士后面上项目一项、四川省科技厅项目两项，参与国家自然科学基金重点项目、国家科技重大专项等项目3项。</p>
                                </div>											
						</div>											
						<div class="clearfix"> </div>
					</div>
			</div>

<!-- 团队学生成员介绍 -->	
			<div class="gallery" style="margin-top:-110px;">
				<h3>STAFF</h3>
					<div class="activity-grids">
						<div class="col-md-4 activity-grid">
                            <div class="member_img">
                                <img src="${webContent}images/member/gaoqiang.jpg" />
                                <p style="margin-top:10px;">高强&nbsp;&nbsp;&nbsp;博士生</p>
                                <p> 研究方向：深度学习与时空轨迹处理</p>
                                <p>邮箱：qianggao@std.uestc.edu.cn</p>
                            </div>
						</div>
						
						<div class="col-md-4 activity-grid">
                            <div class="member_img">
                                <img src="${webContent}images/member/chenxueqin.png" />
                                <p style="margin-top:10px;">陈学勤&nbsp;&nbsp;&nbsp;博士生</p>
                                <p>研究方向：深度学习、数据挖掘、社交网络分析</p>
                                <p>邮箱：chenxueqin@std.uestc.edu.cn</p>
                            </div>
						</div>
									
						<div class="col-md-4 activity-grid">
                            <div class="member_img">
                                <img src="${webContent}images/member/zhangxueyan.png" />
                                <p style="margin-top:10px;">张雪岩&nbsp;&nbsp;&nbsp;硕士生</p>
                                <p>研究方向：深度学习，数据挖掘</p>
                            </div>
						</div>	
							
						<div class="clearfix"> </div>	
<!--每行都要添加<div class="clearfix"> </div> -->						
											
						<div class="col-md-4 activity-grid">
                            <div class="member_img">
                                <img src="${webContent}images/member/liujuexiong.png" />
                                <p style="margin-top:10px;">刘崛雄&nbsp;&nbsp;&nbsp;硕士生</p>
                                <p>研究方向：数据研发、机器学习</p>
                            </div>
						</div>	
						<div class="col-md-4 activity-grid">
                            <div class="member_img">
                                <img src="${webContent}images/member/liuxing.png" />
                                <p style="margin-top:10px;">刘行&nbsp;&nbsp;&nbsp;硕士生</p>
                                <p>研究方向：数据研发、机器学习</p>
                            </div>
						</div>		
						<div class="col-md-4 activity-grid">
                            <div class="member_img">
                                <img src="${webContent}images/member/zhaijiayi.png" />
                                <p style="margin-top:10px;">翟嘉伊&nbsp;&nbsp;&nbsp;硕士生</p>
                                <p>研究方向：数据研发、机器学习</p>
                            </div>
						</div>			
						<div class="clearfix"> </div>
						
						<div class="col-md-4 activity-grid">
                            <div class="member_img">
                                <img src="${webContent}images/member/zhangxueyan.png" />
                                <p style="margin-top:10px;">张雪岩&nbsp;&nbsp;&nbsp;硕士生</p>
                                <p>研究方向：数据研发、机器学习</p>
                            </div>
						</div>	
						<div class="col-md-4 activity-grid">
                            <div class="member_img">
                                <img src="${webContent}images/member/zhangweiqi.png" />
                                <p style="margin-top:10px;">张巍琦&nbsp;&nbsp;&nbsp;硕士生</p>
                                <p>研究方向：数据研发、机器学习</p>
                            </div>
						</div>		
						<div class="col-md-4 activity-grid">
                            <div class="member_img">
                                <img src="${webContent}images/member/aiqing.png" />
                                <p style="margin-top:10px;">艾擎&nbsp;&nbsp;&nbsp;硕士生</p>
                                <p>研究方向：数据研发、机器学习</p>
                            </div>
						</div>			
						<div class="clearfix"> </div>
						
						
						
						
						<div class="col-md-4 activity-grid">
                            <div class="member_img">
                                <img src="${webContent}images/member/dengyijiao.png" />
                                <p style="margin-top:10px;">邓一姣&nbsp;&nbsp;&nbsp;硕士生</p>
                                <p>研究方向：数据研发、机器学习</p>
                            </div>
						</div>	
						<div class="col-md-4 activity-grid">
                            <div class="member_img">
                                <img src="${webContent}images/member/caiting.png" />
                                <p style="margin-top:10px;">才婷&nbsp;&nbsp;&nbsp;硕士生</p>
                                <p>研究方向：数据研发、机器学习</p>
                            </div>
						</div>		
						<div class="col-md-4 activity-grid">
                            <div class="member_img">
                                <img src="${webContent}images/member/liunan.png" />
                                <p style="margin-top:10px;">刘楠&nbsp;&nbsp;&nbsp;硕士生</p>
                                <p>研究方向：数据研发、机器学习</p>
                            </div>
						</div>			
						<div class="clearfix"> </div>
												
												
												
						<div class="col-md-4 activity-grid">
                            <div class="member_img">
                                <img src="${webContent}images/member/weikai.png" />
                                <p style="margin-top:10px;">魏楷&nbsp;&nbsp;&nbsp;硕士生</p>
                                <p>研究方向：数据研发、机器学习</p>
                            </div>
						</div>	
						<div class="col-md-4 activity-grid">
                            <div class="member_img">
                                <img src="${webContent}images/member/yusuzhe.png" />
                                <p style="margin-top:10px;">余苏哲&nbsp;&nbsp;&nbsp;硕士生</p>
                                <p>研究方向：数据研发、机器学习</p>
                            </div>
						</div>		
						<div class="col-md-4 activity-grid">
                            <div class="member_img">
                                <img src="${webContent}images/member/guopengyu.png" />
                                <p style="margin-top:10px;">郭鹏宇&nbsp;&nbsp;&nbsp;硕士生</p>
                                <p>研究方向：数据研发、机器学习</p>
                            </div>
						</div>			
						<div class="clearfix"> </div>
						
						
						
						<div class="col-md-4 activity-grid">
                            <div class="member_img">
                                <img src="${webContent}images/member/tangyucheng.png" />
                                <p style="margin-top:10px;">唐榆程&nbsp;&nbsp;&nbsp;硕士生</p>
                                <p>研究方向：数据研发、机器学习</p>
                            </div>
						</div>	
						<div class="col-md-4 activity-grid">
                            <div class="member_img">
                                <img src="${webContent}images/member/zhangzhiyang.png" />
                                <p style="margin-top:10px;">张志扬&nbsp;&nbsp;&nbsp;硕士生</p>
                                <p>研究方向：数据研发、机器学习</p>
                            </div>
						</div>		
						<div class="col-md-4 activity-grid">
                            <div class="member_img">
                                <img src="${webContent}images/member/tanqi.png" />
                                <p style="margin-top:10px;">谭琪&nbsp;&nbsp;&nbsp;硕士生</p>
                                <p>研究方向：数据研发、机器学习</p>
                            </div>
						</div>			
						<div class="clearfix"> </div>
						
						
						
						
						<div class="col-md-4 activity-grid">
                            <div class="member_img">
                                <img src="${webContent}images/member/liailing.png" />
                                <p style="margin-top:10px;">李艾玲&nbsp;&nbsp;&nbsp;硕士生</p>
                                <p>研究方向：数据研发、机器学习</p>
                            </div>
						</div>	
						<div class="col-md-4 activity-grid">
                            <div class="member_img">
                                <img src="${webContent}images/member/wangting.png" />
                                <p style="margin-top:10px;">王婷&nbsp;&nbsp;&nbsp;硕士生</p>
                                <p>研究方向：数据研发、机器学习</p>
                            </div>
						</div>		
						<div class="col-md-4 activity-grid">
                            <div class="member_img">
                                <img src="${webContent}images/member/songweicong.png" />
                                <p style="margin-top:10px;">宋伟聪&nbsp;&nbsp;&nbsp;硕士生</p>
                                <p>研究方向：数据研发、机器学习</p>
                            </div>
						</div>			
						<div class="clearfix"> </div>
						
						<div class="col-md-4 activity-grid">
                            <div class="member_img">
                                <img src="${webContent}images/member/xvjunhao.jpg" />
                                <p style="margin-top:10px;">徐钧豪&nbsp;&nbsp;&nbsp;硕士生</p>
                                <p>研究方向：数据研发、机器学习</p>
                            </div>
						</div>			
						<div class="clearfix"> </div>
					</div>
			</div>		

<!-- end staff -->
	 </div>	
	</div>
<!--end container-->
<!-- 模态框（Modal） -->
<!--login-->
 <form action="user_login" method="post" class="modal fade" id="login" tabindex="-1" role="dialog" aria-labelledby="myLogin" aria-hidden="true">
  <div class="modal-dialog">
      <div class="modal-content" style="width:420px;margin:0 auto;">
           <div class="modal-header">
               <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                   &times;
               </button>
               <h4 class="modal-title" id="myLogin">
                   登录
               </h4>
           </div>
           <div class="modal-body">
               <div class="form-group">
                   <label for="">用户名</label>
                   <input class="form-control" type="text" placeholder="6-15位字母或数字" name="username">
               </div>
               <div class="form-group">
                   <label for="">密码</label>
                   <input class="form-control" type="password" placeholder="至少6位字母或数字" name="password">
               </div>
           </div>
           <div class="modal-footer">
               <button class="btn btn-primary" type="submit" >提交</button>
               <button class="btn btn-danger" data-dismiss="modal">取消</button>
           </div>
       </div>
   </div>
</form> 
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