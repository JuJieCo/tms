<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ taglib prefix="fmt" uri="/WEB-INF/fmt.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>顺众物流管理系统</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resource/css/bootstrap.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resource/css/css.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resource/js/jquery1.9.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resource/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resource/js/sdmenu.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resource/js/laydate/laydate.js"></script>

</head>
 


<body>

			 <%@include file="/page/frame/top.jsp" %>
				
				<div class="right" id="mainFrame">
			<div class="right_cont">
				<ul class="breadcrumb"> <li>当前位置：  <a href="#">首页</a> <span class="divider">/</span> <a href="#">统计分析</a> <span class="divider">/</span> 数据直方图</li> </ul>
				<div class="title_right">
					<strong>数据直方图 </strong>
				</div>
				
				<div style="width: 1200px; margin: auto">
				
				
				<form action="" name=""  method="post" >
					<s:token name="s_token"></s:token>
					<img alt="jfreechart" src="${pageContext.request.contextPath}/jfreechart!showJBar"/>
				</form>
				</div>

				
			</div>
		</div>
	</div>

	<!-- 底部 -->
	<div id="footer">
		版权所有：jujie &copy; 2016&nbsp;&nbsp;&nbsp;&nbsp; 
	</div>



</body>
</html>