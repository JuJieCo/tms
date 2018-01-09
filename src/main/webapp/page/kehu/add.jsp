	
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
function validateForm(formname){
	
	var name = $("#name").val();
	var lxr = $("#lxr").val();
	var lxdh = $("#lxdh").val();
	var xlid = $("#xlid").val();
	var type = $("#type").val();
	var sfqy = $("#sfqy").val();
	var Calendar1 = $("#Calendar1").val();
	var Calendar2 = $("#Calendar2").val();
	
	
	
	if($.trim(name)==""){
		 alert("客户名称不能为空");
		 $("#name").focus();
		 return false;
	}
	
	if($.trim(lxr)==""){
		 alert("联系人不能为空");
		 $("#lxr").focus();
		 return false;
	}
	
	if($.trim(lxdh)==""){
		 alert("联系电话不能为空");
		 $("#lxdh").focus();
		 return false;
	}
	
	if($.trim(xlid)=="0"&&type==1){
		 alert("请选择线路");
		 $("#xlid").focus();
		 return false;
	}
	
	if(sfqy==1&&$.trim(Calendar1)==""){
		alert("签约/包月开始时间不能为空");
		 $("#Calendar1").focus();
		 return false;
	}
	
	if(sfqy==1&&$.trim(Calendar2)==""){
		alert("签约/包月结束时间不能为空");
		 $("#Calendar2").focus();
		 return false;
	}
	
	if($.trim(Calendar1)==""&&$.trim(Calendar2)!=""){
		alert("请选择开始时间");
		 $("#Calendar1").focus();
		 return false;
	}
	
	if($.trim(Calendar1)!=""&&$.trim(Calendar2)==""){
		alert("请选择结束时间");
		 $("#Calendar2").focus();
		 return false;
	}
	
	if(sfqy==0&&$.trim(Calendar1)!=""&&$.trim(Calendar2)!=""){
		alert("请设置为签约/包月用户");
		 $("#sfqy").focus();
		 return false;
	}
	
	var edate = $("#edate").val();
	var sdate = $("#sdate").val();
	var end=new Date(edate.replace("-", "/").replace("-", "/"));  
		if(end<new Date()){
			alert('包月已到期请修改该客户资料');	
			return false;
		} 
	
}

function checkqysj(){
	var sfqy = $("#sfqy").val();
	if(sfqy==0){
		$("#Calendar1").val('');
		$("#Calendar2").val('');
	}
}
 
</script>

</head>



<body>
	<%@include file="/page/frame/top.jsp"%>
	<%@include file="/page/plugin/autocomplete.jsp"%>

	<div class="right" id="mainFrame">
		<div class="right_cont"> <ul class="breadcrumb"> <li>当前位置： <a href="#">首页</a> <span class="divider">/</span> <a href="#">基础资料</a> <span class="divider">/</span>  客户档案 </li></ul>
			<div class="title_right">
				<strong>新建客户档案</strong>
			</div>
			<form name="form" method="post" 	action="${pageContext.request.contextPath}/kehuAction!modifyKehu" onsubmit="return validateForm(this)">
				<s:token name="s_token"></s:token>
				<div style="width: 1200px; margin: auto">

					<table class="table table-bordered">
						<tr>
							<td width="10%" align="right" bgcolor="#f1f1f1">客户名称：</td>
							<td>
								<input type="text" id="name" name="kehu.name" value="${kehu.name}" class="span1-1" />
								 <input name="kehu.khid" type="hidden" value="${kehu.khid }">
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">客户类型：</td>
							<td>
								<select name="kehu.type"  id="type"  class="span1-1">
							 		<option value="0"  ${kehu.type==0?"selected":"" }>供应商</option>
									<option value="1"  ${kehu.type==1?"selected":"" }>修理厂</option>									
								</select>
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">所属线路：</td>
							<td>
								<select name="kehu.xianlu.xlid" id="xlid" class="span1-1">
							 		<option value="0" >&nbsp;&nbsp;&nbsp;-配送线路-</option>
							 		<option value="1"  ${kehu.xianlu.xlid==1?"selected":"" }>配送线路-01 (东郊)</option>
									<option value="2"  ${kehu.xianlu.xlid==2?"selected":"" }>配送线路-02 (北郊)</option>
									<option value="3"  ${kehu.xianlu.xlid==3?"selected":"" }>配送线路-03 (西郊)</option>
									<option value="4"  ${kehu.xianlu.xlid==4?"selected":"" }>配送线路-04 (南郊)</option>
									<option value="5"  ${kehu.xianlu.xlid==5?"selected":"" }>配送线路-05 (东南)</option>
									<option value="6"  ${kehu.xianlu.xlid==6?"selected":"" }>配送线路-06 (高陵)</option>
								</select>
							</td>
						</tr>

						<tr>
							<td align="right" bgcolor="#f1f1f1">联系人：</td>
							<td><input type="text" id="lxr" name="kehu.lxr" value="${kehu.lxr}" class="span1-1" /></td>
							<td align="right" bgcolor="#f1f1f1">联系电话：</td>
							<td><input type="text" id="lxdh" name="kehu.lxdh"  value="${kehu.lxdh}" class="span1-1" /></td>
							<td align="right" bgcolor="#f1f1f1">客户状态：</td>
							<td>
								<select name="kehu.state"  class="span1-1">
							 		<option value="0"  ${kehu.state==0?"selected":"" }>启用</option>
									<option value="1"  ${kehu.state==1?"selected":"" }>停用</option>									
								</select>
							</td>
						</tr>

						<tr>
							<td align="right" bgcolor="#f1f1f1">是否签约：</td>
							<td>
								<select name="kehu.sfqy" id="sfqy"  class="span1-1" onchange="checkqysj();">
							 		<option value="0" ${kehu.sfqy==0?"selected":"" }>未签约/包月</option>
									<option value="1" ${kehu.sfqy==1?"selected":"" }>已签约/包月</option>									
								</select>
							</td>
							<td align="right" bgcolor="#f1f1f1">签约/包月开始时间：</td>
							<td ><input type="text"  name="kehu.sdate"   value="${kehu.sdate}"  class="laydate-icon span1-1" id="Calendar1"   /></td>
							<td align="right" bgcolor="#f1f1f1">签约/包月结束时间：</td>
							<td colspan="4"><input type="text"  name="kehu.edate"  value="${kehu.edate}"  class="laydate-icon span1-1" id="Calendar2"   /></td>
						</tr>
						
						<tr>
							<td align="right" bgcolor="#f1f1f1">银行账号：</td>
							<td colspan="5"><input type="text" id="zhanghao" name="kehu.zhanghao" value="${kehu.zhanghao}" class="span6" /></td>
						</tr>							
						<tr>
							<td align="right" bgcolor="#f1f1f1">详细地址：</td>
							<td colspan="5"><input type="text" id="xxdz" name="kehu.xxdz" value="${kehu.xxdz}" class="span6" /></td>
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
							<td class="text-center"><input type="submit" value="保存" id="modal-9735581" class="btn btn-info btn-small" style="width: 80px;" /> 
							 <input type="button" value="返回"  onclick="history.go(-1)" id="modal-9735581" class="btn btn-info btn-small"  style="width: 80px;"/></td>
						</tr>
					</table>
				</div>
			</form>

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