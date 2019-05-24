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
<title>project</title>
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
					<li><a href="${webContent}pages/project.jsp">PROJECT</a></li>
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
			
			<div class="clearfix"> </div>
		</div>
	</div>
<!-- end header -->
	<div class="content">
		<div class="container">
		<div class="about">
				<div class="about-top">
						<h3>PROJECT</h3>
				</div>
			<div class="about-bottom">
				<div class="col-md-7 about-grid" style="width:1140px;margin:20px auto;">
					<h4>四川省科技厅，基于人工智能的跨平台中文知识图谱构建及应用</h4>
					<h6>2018/01-2019/01</h6>
<!-- 					<p>简介：</p>
                    <p>1）调研国外发达国家健康医疗大数据领域学术研究的最新成果以及产业应用前沿。</p>
                    <p>2）调研国内健康医疗大数据领域学术研究的最新成果以及在政策支撑下产业加速形成的现状。</p>
                    <p>3）基于健康医疗大数据，自底向上综述健康医疗大数据采集、存储、健康医疗数据发布与隐私保护、数据挖掘与分析、可视化等相关关键技术，分析数据挖掘技术在健康医疗大数据领域的应用；</p>
                    <p>4）开展面向“互联网+”的健康医疗大数据与互联网安全技术、规范等方面研究，立足于公民医疗信息保护、国家健康医疗数据安全，调研相关健康医疗信息保护技术、建设性提出相关指导意见与规范。</p>
                    <p>5）针对健康医疗大数据研究，建设性地提出相关发展方向与前沿技术发展指导与建议，促进我国健康医疗大数据学术研究不断推进与深入。</p>
                    <p>6）分析国内健康医疗大数据产业加速发展背景下的政策、技术上的不足，对具有发展潜力的应用场景及其支撑技术提出建议。</p> -->
				</div>
				
				<div class="col-md-7 about-grid" style="width:1140px;margin:20px auto;">
					<h4>国家计算机网络与信息安全管理中心，YJYS-XXYJ-201701，健康医疗大数据前沿技术及应用情况综述研究</h4>
					<h6>2017/11-2018/04</h6>
<!-- 					<p>简介：</p>
                    <p>1）研究跨平台和海内外市场海量数据的获取和解析技术，构建多源数据获取系统；</p>
                    <p>2）研究知识图谱的显性和隐性特征提取方法，构建从数据源中提取知识实体的实体提取系统；</p>
                    <p>3）研究知识图谱的智能分类和聚类技术，构建知识融合系统；</p>
                    <p>4）研究知识图谱的智能推理方法，构建智能推理系统</p>
                    <p>5）构建支持大规模业务应用的图数据库系统，最终应用于长虹的在线商城，实现智能搜索功能，充分体现其市场价值。</p>
                    <p>本项目的研究既可以给政府、市场、行业和企业提供更加智能的搜索服务，也能深层次的表示出各方之间的宏观联系，为政府市场政策的指定提供可靠参考，同时也为企业分析市场、投资行业提供了有效的依据。本项目的研究对政府、市场、行业和企业具有重大价值与意义。</p> -->
				</div>				
				
				<div class="col-md-7 about-grid" style="width:1140px;margin:20px auto;">
					<h4>四川高路交通信息工程有限公司， 交投大数据平台科研项目</h4>
					<h6>2017/06-2018/06</h6>
                    <img src="${webContent}images/chuangao.png" style="width: 960px;margin-top: 10px;"/>					
 					<p>简介：</p>
                    <p>1）四川省智慧高速技术路径研究</p>
                    <p>根据全国智慧高速的建设情况，基于四川省高速公路运营的实际情况对智慧高速的前沿技术进行研究。分别从硬件与软件层面分别入手，研究带有智能接口的最新技术和设备情况，并结合川高大数据平台的建设分步实施的方案，对智慧高速应用服务方案进行研究。</p>
                    <p>2）基于川高大数据平台的高速公路数据分析与示范应用</p>
                    <p>基于川高大数据平台，研究多源异构交通大数据分析处理技术，完成基础理论研究与数据模型的建立和优化，构建面向智慧高速应用的大数据分析与挖掘算法库，对基于川高大数据平台的数据分析与应用演示系统进行设计与实现。 </p>
                    <p>3）基于高速车路协同的自主驾驶云服务设计与开发</p>
                    <p>将主要研究基于高速智能路侧系统的自主驾驶，利用高速智能路侧系统结合后端云服务，探索高速公路在自主驾驶新业态中通过综合试验、高精数据等作为服务提供者的新型商业模式，并围绕高速公路实时数据采集、数据资产管理和基于数据资产对云服务设计与开发。</p> 
				</div>
				
				<div class="col-md-7 about-grid" style="width:1140px;margin:20px auto;">
					<h4>云南电网有限责任公司信息中心，基于探针技术的资源池故障诊断与定位的技术研究</h4>
					<h6>2016/11-2017/8，已结题</h6>
<!-- 					<p>简介：</p>
                    <p>在云计算与大数据发展的背景下，虚拟化资源产生的大量状态文件、日志信息将为云平台的故障诊断与预测提供了有力地预测与快速定位依据。通过建立探针机制的挖掘虚拟化资源池日志等信息，找出其中潜在的关联信息。构建适合云南电网公司云计算资源池的大数据分析模型，通过利用大数据技术对资源池各管理层日志进行关联性分析，快速对故障和性能瓶颈进行探查，准确给出探查出的每层资源故障路径或性能瓶颈轨迹，以智能化的方式替换随机性和经验性的人工模式。通过注入云计算操作系统的控制台接口和日志、利用SDN技术对网络流量进行采集、通过存储虚拟化控制工具采集存储性能和日志，再结合现有应用性能分析系统API接口开发，研发基于探针技术的资源池故障及性能分析探针系统。通过该模型系统能对不同资源类型的数据和日志进行综合分析，从这些数据中捕获隐患信息和故障发生点的位置信息并予以可视化表示。</p> -->
				</div>
												
				<div class="col-md-7 about-grid" style="width:1140px;margin:20px auto;">
					<h4>   四川省科技厅产学研项目，2016ZC2575，移动互联安全检测平台研发及应用</h4>
					<h6>2016/01-2019/12，在研</h6>
				</div>			
				
				<div class="col-md-7 about-grid" style="width:1140px;margin:20px auto;">
					<h4>  四川省科技计划支撑项目,2015JY0178,云计算环境中数据存储完整性验证机制研究</h4>
					<h6>2015/01-2017/12 </h6>
				</div>	
				
				<div class="col-md-7 about-grid" style="width:1140px;margin:20px auto;">
					<h4> 中国博士后科学基金第57批面上项目，2015M572464，免疫噪声的容错量子对话协议研究</h4>
					<h6>2015/1-20 15/12， 40万，已结题，主持</h6>
				</div>	
				
				<div class="col-md-7 about-grid" style="width:1140px;margin:20px auto;">
					<h4>总装技术基础项目，YXCDZ20151QB01，XXXXXXX</h4>
					<h6>2015/1-2016/12，已结题 </h6>
				</div>		
				
				<div class="col-md-7 about-grid" style="width:1140px;margin:20px auto;">
					<h4>四川省科技厅项目，基于云计算的移动安全服务平台研发及示范应用</h4>
					<h6>2014/11-20 17/12，70万，在研 </h6>
				</div>	
				
				<div class="col-md-7 about-grid" style="width:1140px;margin:20px auto;">
					<h4>总装技术基础项目，G02010601YXCDZ132QB1，XXXXXXX</h4>
					<h6>2013/6-2014/12，，已验收 </h6>
				</div>	
				
				<div class="col-md-7 about-grid" style="width:1140px;margin:20px auto;">
					<h4>国家自然科学基金委员会联合基金，基于数据报指纹关系的未知协议发现研究</h4>
					<h6>2013--2016/12，60万 </h6>
				</div>	
				
				<div class="col-md-7 about-grid" style="width:1140px;margin:20px auto;">
					<h4>广东省产学研项目,2012B091000054,移动互联网环境下面向终端的安全服务云平台关键技术及产业化示范</h4>
					<h6>2011/12-2015/2 </h6>
				</div>	
				
				<div class="col-md-7 about-grid" style="width:1140px;margin:20px auto;">
					<h4>广东省产学研项目，2010B090400179，基于虚拟现实技术的腹腔镜胃癌根治术模拟训练系统关键技术研究与应用</h4>
					<h6>2011/01—2013/12，20万元，已结题 </h6>
				</div>	
				
				<div class="col-md-7 about-grid" style="width:1140px;margin:20px auto;">
					<h4>广东省产学研项目，2009B090300400，微创手术虚拟现实训练系统关键技术研究与应用</h4>
					<h6>2010/01—2012/12，20万元，已结题 </h6>
				</div>	
				
				<div class="col-md-7 about-grid" style="width:1140px;margin:20px auto;">
					<h4>国家科技重大专项,2011ZX03002-002-03,面向移动互联网的业务能力开放平台关键技术研究及示范</h4>
					<h6>2011/01-2014/9,已结题 </h6>
				</div>
				
				<div class="col-md-7 about-grid" style="width:1140px;margin:20px auto;">
					<h4>中国人民解放军第二炮兵司令部信息化部项目，H04010601W061202，网络服务</h4>
					<h6>2011/10-2013/10，已验收</h6>
				</div>
				
				<div class="col-md-7 about-grid" style="width:1140px;margin:20px auto;">
					<h4>国家863项目，2009AA01Z422，多特征融合的P2P网络攻击监测和预警关键技术研究</h4>
					<h6>2010/01-2012/12， 98万，已验收</h6>
				</div>		
				
				<div class="col-md-7 about-grid" style="width:1140px;margin:20px auto;">
					<h4>四川省科技攻关项目，110106012009FZ0148，高可靠高性能入侵防御系统</h4>
					<h6>2010/01—2011/12，10万元，已结题</h6>
				</div>	
				
				<div class="col-md-7 about-grid" style="width:1140px;margin:20px auto;">
					<h4> 成都市科技攻关项目，0GGYB548GX-023，四川省突发公共卫生事件医疗救治信息平 台系统</h4>
					<h6>2010/01-2011/12，10万元，已结题</h6>
				</div>	
				
				<div class="col-md-7 about-grid" style="width:1140px;margin:20px auto;">
					<h4>国家科技特派员项目，2009GJE004，远程多源综合资源和环境智能监控预警系统</h4>
					<h6>2010/01—2012/12，40万元，已验收鉴定</h6>
				</div>			
				
				<div class="col-md-7 about-grid" style="width:1140px;margin:20px auto;">
					<h4>四川省科技厅项目，M110106012009FZ0148，高可靠、高性能入侵防御系统</h4>
					<h6>2010/01-2011/12, 10万，已验收</h6>
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