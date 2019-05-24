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
<title>paper</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Societica Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />

<link href="${webContent}css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="${webContent}css/chocolat.css" type="text/css" media="screen" charset="utf-8" />
<link href="${webContent}css/style.css" rel="stylesheet" type="text/css" media="all" />	

<%-- <script src="${webContent}js/jquery.min.js"></script> --%>
<script src="${webContent}jquery/jquery-1.11.2.min.js"></script>
<script src="${webContent}jquery/jquery.form.js"></script>
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
					<li><a href="${webContent}pages/paper.jsp">PAPER</a></li>
					<li><a href="${webContent}pages/patent.jsp" data-hover="PATENT">PATENT</a></li>						
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
						<h3>PAPER</h3>
				</div>
			<div class="about-bottom">
				<div class="col-md-4 activity-grid  " style="width:1140px;">
	                <p> 1.Qianggao,FanZhou,Kunpeng Zhang,Goce Trajcevski,Xucheng Luo,Fengli Zhang. Identifying Human Mobility via Trajectory Embeddings. IJCAI 2017（CCF A）</p>
	
	                <p> 2.高强, 张凤荔, 王瑞锦,等. 轨迹大数据:数据处理关键技术研究综述[J]. 软件学报, 2017, 28(4).（EI）</p>
					
					<p> 3.Qiang Gao,Fengli Zhang,Ruijin Wang,Fan Zhou. Association Rules Mining with Quantum Computing and Quantum Storage. BigCom 2017（EI）</p>
					
					<p> 4.高强，张凤荔，陈学勤，王馨云，耿贞伟，周帆，基于改进Eclat算法的资源池节点异常模式挖掘，计算机应用研究(中文核心)</p>
					
					<p> 5.Qiang Gao, Feng-Li Zhang, and Run-Jin Wang. Mining Frequent Sets Using Fuzzy Multiple-level Association Rules. Journal of Electronic Science and Technology (EI Inspec)</p>
					
					<p> 6.Rui-jin Wang(*) ,Dong-fen Li and Zhi-guang Qin. An Immune Quantum Communication Model for Dephasing Noise Using Four-Qubit Cluster State. International Journal of Theoretical Physics, (2016):55(1):609-616. (SCI)</p>
					
					<p> 7.Dong-fen Li,Rui-jin Wang(*),Feng-li Zhang,Baagyer,Anoise immunity controlled quantum teleportation  protocol，Quantum Information Processing，2016，15（11）：4819~4837 (JRC 2，SCI)</p>
					
					<p> 8.Rui-jin Wang(*), Dong-fen Li, Fu-hu Deng. Quantum information splitting of a two-qubit bell state using a five-qubit entangled state. Int. J. Theor. Phys, (2015):54(9):3229-3237. (SCI)</p>
					
					<p> 9.Dong-fen Li,Rui-jin Wang(*),Feng-li Zhang,Baagyere,Quantum information splitting of arbitrary two-qubit state by using four-qubit cluster state and Bell-state,Quantum Information Processing，2015，14（3）：1103~1116 (JRC 2，SCI)</p>
					
					<p> 10.Rui-jin Wang(*), Dong-fen Li, Yao Liu, Zhi-guang Qin and Edward Baagyere. Two Ways of Robust Quantum Dialogue by Using Four-Qubit Cluster State. International Journal of Theoretical Physics (2016):55(4):2110-2124. (SCI)</p>
					
					<p> 11.Rui-jin Wang(*), Bao H L, Chen D J, et al. 3D-CCD:a Novel 3D Localization Algorithm Based on Concave/Convex Decomposition and Layering Scheme in WSNs. Adhoc & Sensor Wireless Networks, 2014:23(1):235-254, (SCI)</p>
					
					<p> 12.Rui-jin Wang(*), Qin Zhiguang, Li Dongfen,Chen Dajing,Wang Jiahao,3DT-PP:Localization and path planning of mobile anchors over complex 3D terrains,High Technology Letters,2014,20(4):367-375 (EI)</p>
					
					<p> 13.王瑞锦(*),秦志光,王佳昊. 无线传感器网络分簇路由协议分析,电子科技大学学报,2013：03(1):81-86. (EI)</p>
					
					<p> 14.王瑞锦(*),郭祥,王佳昊,秦志光. 无线传感器网络动态轨迹多目标跟踪算法[J]. 电子科技大学学报,2016,(02):233-239. (EI)</p>
					
					<p> 15.王瑞锦(*),黄耀东,徐志远,秦志光. 复杂山体表面传感器网络定位算法[J]. 电子科技大学学报,2015,(03):433-438. (EI)</p>
					
					<p> 16.陈大江,秦臻,秦志光,王瑞锦,基于虚拟信道的快速密钥生成协议的安全性分析,电子科技大学学报,(2015),44(1):112-116(EI)</p>
					
					<p> 17.Li M, Rui-jin Wang, Qin Z, et al. Privacy-Preserving Proximity Based Services. International Journal of Hybrid Information Technology, (2014):7(4):139-152. (EI)</p>
					
					<p> 18.王聪,张凤荔,王瑞锦,李敏,杨晓翔. 一种网络时延矩阵分布式自适应重建算法,电子与信息学报, (2014):(6)4:840-846. (EI)</p>
					
					<p> 19.聂旭云,倪伟伟,王瑞锦,赵洋,秦志光,无线传感网数据聚合隐私保护协议分析,计算机应用研究,(2013),30(5):1281-1284</p>
					
					<p> 20.张凤荔(#)(*),周洪川,张俊娇,刘渊,张春瑞.零知识下的比特流未知协议分类模型,计算机科学,2016.8.1 43(8):39~44</p>
					
					<p> 21.张凤荔(#)(*),赵永亮,王丹,王豪.基于流量特征的网络流量预测研究,Journal of Computational Information Systems,2014.4.15 9(23):9629~9636l </p>
					
					<p> 22.张凤荔(#)(*),冯波.基于关联性的漏洞评估方法,Advanced Science Letters,2013.11.01 4(7):610~613</p>
					
					<p> 23.陈俊欣(#),张凤荔(*),刘渊.基于角色的空间信息强制访问控制模型研究,计算机应用研究,2015.09.01,(7):2170~2174</p>
					
					<p> 24.Fengli Zhang(#)(*),Junxin Chen,Hongchuan Zhou,Zhengwei Geng.A dynamic Access control model for spatial data,2016 12th International Conference on Computational Intelligence and Security (CIS) (2016) ,Wuxi, Jiangsu Province, China,2016.12.16-2016.12.19</p>
					
					<p> 25.Zhang, Fengli (#)(*),Bai, Yang.ARM-based privacy preserving for medical data publishing, 1st International Conference on Cloud Computing and Security, ICCCS 2015,Nanjing,China, 2015.8.13-2015.8.15</p>
					
					<p> 26.Zhang, Fengli(#)(*),Zhang, Junjiao(*),Zhou, Hongchuan.Unknown bit stream protocol message discovery with zero knowledge,15th International Conference on Algorithms and Architectures for Parallel Processing, ICA3PP 2015,Zhangjiajie,China,2015.11.18-2015.11.20</p>
					
					<p> 27.Zhang, Fengli (#)(*), Bai, Yang,Hou, Jie,Tian, Yuan-Wei.Detecting malicious users in P2P streaming systems by using feedback correlations,4th International Conference on Networks and Communications, NetCom, n Chennai, India,2013.12.22-2013.12.24</p>

 					<p> 28.Xueqin chen, Kunpeng Zhang,Fan Zhou, Goce Trajcevski, TingZhong, Fengli Zhang, Information Cascades Modeling via Deep Multi-Task Learning, SIGIR 2019 (CCF A)</p>
 					
 					<p> 29.Qiang Gao, Fan Zhou, Kunpeng Zhang, Goce Trajcevski, TingZhong, Fengli Zhang, Predicting Human Mobility via Variational Attention, WWW 2019 (CCF A)</p>
 					
 					<p> 30.Xueqin chen, Fan Zhou, Kunpeng Zhang, Goce Trajcevski, TingZhong, Fengli Zhang, Information Diffusion Prediction via Recurrent Cascades Convolution, ICDE 2019 (CCF A)</p>
 					
 					<p> 31.Qiang Gao, Goce Trajcevski, Fan Zhou, Kunpeng Zhang, Ting Zhong and Fengli Zhang, Trajectory based Social Circle Inference, SIGSPATIAL 2018</p>
 					
 					<p> 32.Qiang Gao, Goce Trajcevski, Fan Zhou, Kunpeng Zhang, Ting Zhong and Fengli Zhang, Trajectory based Social Circle Inference, SIGSPATIAL 2018</p>
 		
 		 			<p> 33.Fan Zhou, Qiang Gao, Goce Trajcevski, Kunpeng Zhang, Ting Zhong and Fengli Zhang ,Trajectory-User Linking via Variational AutoEncoder, IJCAI 2018 (CCF A)</p>
 		 					 						 					 					 					 					
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