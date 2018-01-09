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

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/bootstrap.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/css.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery1.9.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/sdmenu.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/laydate/laydate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/add.js"></script>


<!-- 这个样式是给三桥用的,玉祥门是否合适还不知道 放在这里是为了提升这段css的优先级(整了我几个小时才发现的原因)-->
<style type="text/css">
.table-print {
	border:1px solid #000000;
	border-collapse:collapse;
	border-spacing:0;
	width:97%;
	margin:auto;
}
.table-print  td {
	border: 1px solid #000000;
}

.table-printp {
	border: 1px solid #000000;
	border-collapse: collapse;
	border-spacing: 0;
	width: 250px;
}
.table-printp  td {
	border: 1px solid #000000;
}
</style>



</head>
<body>
	<%@include file="/page/frame/top.jsp" %>
	
		<div class="right" id="mainFrame">
			<div class="right_cont">
				<ul class="breadcrumb"> <li>当前位置： <a href="#">首页</a> <span class="divider">/</span> <a href="#">业务处理</a> <span class="divider">/</span> 托运单 </li></ul>
				<div class="title_right">
					<strong>新建托运单</strong>
				</div>

			



				<div style="width: 1200px; margin: auto">
					<table class="table table-bordered">
						<tr>
						
							<td width="7%" align="right" bgcolor="#f1f1f1">托运单号：</td>
							<td width="15%" >&nbsp;${tuoyundan.tydh }</td>
							<td width="7%" align="right" bgcolor="#f1f1f1">开单员：</td>
							<td width="15%" >&nbsp;${tuoyundan.kdy }</td>
							<td width="7%" align="right" bgcolor="#f1f1f1">托运时间：</td>
							<td width="15%" >&nbsp;${tuoyundan.tydate }</td>
							<td width="7%" align="right" bgcolor="#f1f1f1">线路：</td>
							<td width="15%" colspan="3"  >&nbsp;
								${tuoyundan.xlid eq 1 ? "配送线路-01 (东郊)" : "" }
								${tuoyundan.xlid eq 2 ? "配送线路-02 (北郊)" : "" }
								${tuoyundan.xlid eq 3 ? "配送线路-03 (西郊)" : "" }
								${tuoyundan.xlid eq 4 ? "配送线路-04 (南郊)" : "" }
								${tuoyundan.xlid eq 5 ? "配送线路-05 (东南)" : "" }
								${tuoyundan.xlid eq 6 ? "配送线路-06 (高陵)" : "" }
							</td>
						</tr>

						<tr>
							<td align="right" bgcolor="#f1f1f1">开单网点：</td>
							<td> &nbsp;${tuoyundan.kdwd }</td>
							<td align="right" bgcolor="#f1f1f1">目的网点：</td>
							<td>&nbsp;${tuoyundan.mdwd }</td>
							<td align="right" bgcolor="#f1f1f1">下个网点：</td>
							<td>&nbsp;${tuoyundan.xgwd }</td>
							<td align="right" bgcolor="#f1f1f1">配送员：</td>
							<td>&nbsp;${tuoyundan.psy }</td>
						</tr>
					</table>



					<table class="table table-bordered">
						<tr>
							<td width="7%" align="right" bgcolor="#f1f1f1">发货方：</td>
							<td width="15%"  colspan="2">&nbsp;${tuoyundan.fhf }</td>
							<td width="7%" align="right" bgcolor="#f1f1f1">联系人：</td>
							<td width="15%" > &nbsp;${tuoyundan.fhflxr }</td>
							<td width="7%" align="right" bgcolor="#f1f1f1">收货方：</td>
							<td  width="15%"  colspan="2">&nbsp;${tuoyundan.shf }</td>
							<td width="7%" align="right" bgcolor="#f1f1f1">联系人：</td>
							<td width="15%" >&nbsp;${tuoyundan.shflxr }</td>
						</tr>

						<tr>
							<td align="right" bgcolor="#f1f1f1">联系电话：</td>
							<td colspan="4"   >&nbsp;${tuoyundan.fhfdh }</td>
							
							<td align="right" bgcolor="#f1f1f1">联系电话：</td>
							<td  colspan="4" >&nbsp;${tuoyundan.shfdh }</td>
							
						</tr>

						<tr>
							<td align="right" bgcolor="#f1f1f1">详细地址：</td>
							<td  colspan="4"   >&nbsp;${tuoyundan.fhfdz }</td>
							<td align="right" bgcolor="#f1f1f1">详细地址：</td>
							<td  colspan="4"  >&nbsp;${tuoyundan.shfdz }</td>
						</tr>

						<tr>
							<td align="right" bgcolor="#f1f1f1">发货方类型：</td>
							<td  colspan="2">&nbsp;${tuoyundan.fhftype eq 0 ? "供应商":"修理厂" }</td>
							<td align="right" bgcolor="#f1f1f1">是否签约：</td>
							<td >&nbsp;${tuoyundan.sfqy eq 0 ? "未签约":"已签约" }</td>
							<td align="right" bgcolor="#f1f1f1">收货方类型：</td>
							<td  colspan="2">&nbsp;${tuoyundan.shftype  eq 0 ? "供应商":"修理厂" } </td>
							<td align="right" bgcolor="#f1f1f1">是否包月：</td>
							<td >&nbsp;${tuoyundan.sfby eq 0 ? "未包月":"已包月" }</td>
							
						</tr>
					</table>




					<table id="" class="table table-bordered">
							<tr>
								<td align="left" nowrap="nowrap" bgcolor="#f1f1f1" colspan="5"><strong>货物名称</strong></td>
								
							</tr>
							<tr >
								<td ><textarea name="tuoyundan.remark"  rows="3" cols="50" class="span11"  >${tuoyundan.huowu}</textarea></td>
								<td width="10%" align="right"  >件数：</td><td width="10%" >${tuoyundan.jianshu } </td>
								<td width="10%" align="right"  >运费：</td><td width="10%" >${tuoyundan.yunfei } </td>
							</tr>
						</table>
						
						
					
					<table class="table table-bordered">
						<tr>
							<td  align="left" bgcolor="#f1f1f1" colspan="12"><strong>备注：</strong></td>
						</tr>
						<tr>
							<td colspan="12"><textarea name="tuoyundan.remark"  rows="2" cols="50" class="span11"> ${tuoyundan.remark }</textarea></td>
						</tr>
						<tr>
							<td align="right" bgcolor="#f1f1f1" width="8%">是否回单：</td>
							<td width="8%">&nbsp;${tuoyundan.sfhd }</td>
							<td align="right" bgcolor="#f1f1f1" width="8%">代收货款：</td>
							<td width="8%">&nbsp;${tuoyundan.dshk }</td>
							<td align="right" bgcolor="#f1f1f1" width="8%">手续费：</td>
							<td width="8%">&nbsp;${tuoyundan.sxf }</td>
							<td align="right" bgcolor="#f1f1f1" width="8%">其他费用：</td>
							<td width="8%">&nbsp;${tuoyundan.qtfy }</td>
							<td align="right" bgcolor="#f1f1f1" width="8%">费用合计：</td>
							<td width="8%">&nbsp;${tuoyundan.fyhj }</td>
							<td align="right" bgcolor="#f1f1f1" width="8%">结算方式：</td>
							<td width="8%">&nbsp;
									${tuoyundan.jsfs eq 1 ? "到付":""}
									${tuoyundan.jsfs eq 2 ? "现付":""}
									${tuoyundan.jsfs eq 3 ? "免单":""}
			    					${tuoyundan.jsfs eq 4 ? "包月":""}
							</td>
						</tr>

						
					</table>


					<table class="margin-bottom-20 table  no-border">
						<tr>
							<td class="text-center"> 
							<input type="button" value="打印贴纸"  id="modal-9735581" class="btn btn-info btn-small" style="width: 80px;"  onclick=previewp(2) /> 
							<input type="button" value="打印配送单" id="modal-9735581" class="btn btn-info btn-small" style="width: 80px;"  onclick=preview(1) /> 
							</td>
						</tr>
					</table>
					
					<table class="margin-bottom-20 table  no-border">
						<tr>
							<td class="text-center"> 
							<input  type="button" value="返回"  id="modal-9735581" class="btn btn-info btn-small" style="width: 80px;" onclick="history.go(-1)"/>	
							</td>
						</tr>
					</table>
				</div>
				
				<div id="divs" style="display:none">
				 <%@include file="/page/kaidan/dayinp.jsp" %>
				</div>
				<div id="divs" style="display:none">
				 <%@include file="/page/kaidan/dayin.jsp" %>
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