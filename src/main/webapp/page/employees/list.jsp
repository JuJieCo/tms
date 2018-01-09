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


<script type="text/javascript">
	function selectPage(currentPage){
		var form = document.forms.form1;
		form.action = form.action+"?page.currentPage="+currentPage;
		//alert(form.action);
		form.submit();
	}
</script>
</head>
<body>
			 <%@include file="/page/frame/top.jsp" %>
			<div class="right" id="mainFrame">
			<div class="right_cont">
				<ul class="breadcrumb"><li> 当前位置：  <a href="#">首页</a> <span class="divider">/</span> <a href="#">基础资料</a> <span class="divider">/</span> 人员管理 </li></ul>
				<div class="title_right">
					<strong>人员管理查询</strong>
				</div>
				
				<div style="width: 1200px; margin: auto">
				<form action="${pageContext.request.contextPath}/employeesAction!queryEmployeesList" name="form1"  method="post" >
				<s:token name="s_token"></s:token>
				
					<table class="table table-bordered">
						<tr>
							<td width="10%" align="right" bgcolor="#f1f1f1">人员名称：</td>
							<td width="15%" ><input type="text" name="employees.name"  value="${employees.name }"  class="span3" /></td>
						</tr>
						
					</table>


					<table class="margin-bottom-20 table  no-border">
						<tr>
							<td class="text-center"><input type="submit" value="查询" class="btn btn-info " style="width: 80px;" /></td>
							<td class="text-center"><input type="button" value="新建"  onclick="location.href='${pageContext.request.contextPath}/employeesAction!findEmployeesForModify?modify=save'"  id="modal-9735581" class="btn btn-info btn-small" style="width: 80px;" /></td>
						</tr>
					</table>
					
					
					<table class="table table-bordered">
						<tr>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>人员名称</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>状态</strong></td>
							<td width="10%" align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>操作</strong></td>
						</tr>
						<s:iterator value="employeesList" var="list">
						
						<tr>
							<td align="center">&nbsp;${list.name }</td>
							<td align="center">&nbsp;${list.state eq 0 ? "启用":"停用" }</td>
							
							<td align="center">
								<a href="${pageContext.request.contextPath}/employeesAction!findEmployeesForShow?empid=${list.empid}">查看</a>&nbsp;
								<a href="${pageContext.request.contextPath}/employeesAction!findEmployeesForModify?modify=update&empid=${list.empid}">修改</a>&nbsp;
								<a href="${pageContext.request.contextPath}/employeesAction!deleteEmployeesByID?empid=${list.empid}"  onclick="return(confirm('确认要删除吗?'))" >删除</a>
							</td>
						</tr>
						
						</s:iterator>
					</table>
						 <%@include file="/page/plugin/page.jsp" %>
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