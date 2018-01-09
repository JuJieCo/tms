	
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

</head>



<body>
	<%@include file="/page/frame/top.jsp"%>
	<%@include file="/page/plugin/autocomplete.jsp"%>

	<div class="right" id="mainFrame">
		<div class="right_cont">
			<ul class="breadcrumb"> <li>当前位置： <a href="#">首页</a><span class="divider">/</span> <a href="#">基础资料</a> <span class="divider">/</span>  客户档案 </li></ul>
			<div class="title_right">
				<strong>查看客户档案</strong>
			</div>




			 
				<s:token name="s_token"></s:token>
				<div style="width: 1200px; margin: auto">

					<table class="table table-bordered">
						<tr>
							<td width="10%" align="right" bgcolor="#f1f1f1">客户名称：</td>
							<td> ${kehu.name} </td>
							<td width="10%" align="right" bgcolor="#f1f1f1">客户类型：</td>
							<td>${kehu.type==0?"供应商":"修理厂" } </td>
							<td width="10%" align="right" bgcolor="#f1f1f1">所属线路：</td>
							<td>
								${kehu.xianlu.xlid==1?"配送线路-01 (东郊)":"" }
								${kehu.xianlu.xlid==2?"配送线路-02 (北郊)":"" }
								${kehu.xianlu.xlid==3?"配送线路-03 (西郊)":"" }
								${kehu.xianlu.xlid==4?"配送线路-04 (南郊)":"" }
								${kehu.xianlu.xlid==5?"配送线路-05 (东南)":"" }
								${kehu.xianlu.xlid==6?"配送线路-06 (高陵)":"" }
							</td>
						</tr>

						<tr>
							<td align="right" bgcolor="#f1f1f1">联系人：</td>
							<td>${kehu.lxr}</td>
							<td align="right" bgcolor="#f1f1f1">联系电话：</td>
							<td>${kehu.lxdh}</td>
							<td align="right" bgcolor="#f1f1f1">客户状态：</td>
							<td>${kehu.state==0?"启用":"停用" } </td>
						</tr>

						<tr>
							<td align="right" bgcolor="#f1f1f1">是否签约：</td>
							<td>${kehu.sfqy==0?"未签约/包月":"已签约/包月" } </td>
							<td align="right" bgcolor="#f1f1f1">签约/包月开始时间：</td>
							<td >${kehu.sdate}</td>
							<td align="right" bgcolor="#f1f1f1">签约/包月结束时间：</td>
							<td colspan="4">${kehu.edate}</td>
						</tr>
						<tr>
							<td align="right" bgcolor="#f1f1f1">银行账号：</td>
							<td colspan="5">${kehu.zhanghao}</td>
						</tr>	
						<tr>
							<td align="right" bgcolor="#f1f1f1">详细地址：</td>
							<td colspan="5">${kehu.xxdz}</td>
						</tr>
 
					</table>


					<table id="" class="table table-bordered">
						<tr>
							<td align="left" nowrap="nowrap" bgcolor="#f1f1f1" colspan="5"><strong>备注</strong></td>
						</tr>
						<tr>
							<td><textarea name="kehu.remark" rows="3" cols="50" class="span11">${kehu.remark}</textarea></td>
						</tr>
					</table>
					
					<table class="margin-bottom-20 table  no-border">
						<tr>
							<td class="text-center">
							<td class="text-center"><input type="button" value="返回"  onclick="history.go(-1)" id="modal-9735581" class="btn btn-info btn-small"  style="width: 80px;" /></td>
						</tr>
					</table> 
					
					
						<c:if test="${!empty kehuHList }">
					<table id="" class="table table-bordered">
						<tr>
						<td align="left" nowrap="nowrap" bgcolor="#f1f1f1" colspan="4"><strong>签约包月历史记录</strong></td>
						</tr>
						<tr>
							<td align="center"><strong>客户名称</strong></td>
							<td align="center"><strong>客户类型</strong></td>
							<td align="center"><strong>签约/包月开始时间</strong></td>
							<td align="center"><strong>签约/包月结束时间</strong></td>
						</tr>
					<s:iterator value="kehuHList" var="list">
						<tr>
							<td align="center">&nbsp;${list.name }</td>
							<td align="center">&nbsp;${list.type eq 0 ? "供应商":"修理厂" }</td>
							<td align="center">&nbsp;${list.sdate }</td>
							<td align="center">&nbsp;${list.edate }</td>
						</tr>
						</s:iterator>
						</table>
					</c:if>
					
				</div>
		</div>
	</div>
	</div>

	<!-- 底部 -->
	<div id="footer">版权所有：jujie &copy; 2016&nbsp;&nbsp;&nbsp;&nbsp;</div>



	<script>
		!function() {
			laydate.skin('molv');
			laydate({
				elem : '#Calendar1'
			});
			laydate.skin('molv');
			laydate({
				elem : '#Calendar2'
			});
			laydate.skin('molv');
			laydate({
				elem : '#Calendar3'
			});
			laydate.skin('molv');
			laydate({
				elem : '#Calendar4'
			});
		}();
	</script>
</body>
</html>