
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>
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
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resource/js/add.js"></script>


<script type="text/javascript">
	function validateForm(formname) {

		var name = $("#name").val();
		if ($.trim(name) == "") {
			alert("名称不能为空");
			$("#name").focus();
			return false;
		}
	}
</script>

</head>
<body>
	<%@include file="/page/frame/top.jsp"%>
	<%@include file="/page/plugin/autocomplete.jsp"%>

	<div class="right" id="mainFrame">
		<div class="right_cont">
			<ul class="breadcrumb"><li> 当前位置： <a href="#">首页</a> <span class="divider">/</span> <a href="#">基础资料</a> <span class="divider">/</span> 人员管理</li> </ul>
			<div class="title_right">
				<strong>新建人员</strong>
			</div>
			<form name="form" method="post" action="${pageContext.request.contextPath}/employeesAction!modifyEmployees" onsubmit="return validateForm(this)">
				<s:token name="s_token"></s:token>
				<div style="width: 1200px; margin: auto">

					<table class="table table-bordered">
						<tr>
							<td width="10%" align="right" bgcolor="#f1f1f1">人员名称：</td>
							<td>
								<input type="text"  id="name" name="employees.name" value="${employees.name}" class="span2" /> 
								<input  type="hidden"  name="employees.empid" value="${employees.empid }">
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">人员状态：</td>
							<td>
								<select name="employees.state" class="span1-1">
									<option value="0" ${employees.state==0?"selected":"" }>启用</option>
									<option value="1" ${employees.state==1?"selected":"" }>停用</option>
								</select>
							</td>
						</tr>
					</table>
					<table id="" class="table table-bordered">
						<tr>
							<td align="left" nowrap="nowrap" bgcolor="#f1f1f1" colspan="5"><strong>备注</strong></td>
						</tr>
						<tr>
							<td><textarea name="employees.remark" rows="3" cols="50" class="span11">${employees.remark}</textarea></td>
						</tr>
					</table>

					<table class="margin-bottom-20 table  no-border">
						<tr>
							<td class="text-center">
								<input type="submit" value="保存"  id="modal-9735581" class="btn btn-info btn-small" style="width: 80px;" /> 
								<input type="button" value="返回"  id="modal-9735581" class="btn btn-info btn-small" style="width: 80px;" onclick="history.go(-1)"/>
							</td>
						</tr>
					</table>
				</div>
			</form>

		</div>
	</div>
	</div>

	<!-- 底部 -->
	<div id="footer">版权所有：jujie &copy; 2016&nbsp;&nbsp;&nbsp;&nbsp;</div>
</body>
</html>