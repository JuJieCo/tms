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

	function doReport(){
		var form = document.forms.form1;
		var action = form.action;
		form.action = "${pageContext.request.contextPath}/exportExcel!exportExcel";
		form.submit();
		form.action = action;
	}

</script>
</head>
 


<body>

			 <%@include file="/page/frame/top.jsp" %>
				
				<div class="right" id="mainFrame">
			<div class="right_cont">
				<ul class="breadcrumb"><li> 当前位置：  <a href="#">首页</a> <span class="divider">/</span> <a href="#">统计分析</a> <span class="divider">/</span> 运单统计 </li></ul>
				<div class="title_right">
					<strong>运单统计</strong>
				</div>
				
				<div style="width: 1200px; margin: auto">
				<form action="${pageContext.request.contextPath}/tuoyundanAction!queryTuoyundanForCount" name="form1"  method="post" >
				<s:token name="s_token"></s:token>
				
					<table class="table table-bordered">
						<tr>
							<td width="7%" align="right" bgcolor="#f1f1f1">托运时间：</td>
							<td width="10%" colspan="3">
								<input type="text"  name="btime"  value="${btime }"  class="laydate-icon span2"  id="Calendar1"  /> 
									&nbsp; 至 &nbsp; 
								<input type="text"  name="etime"  value="${etime }"  class="laydate-icon span2" id="Calendar2"   />
							</td>
							<td width="7%" align="right" bgcolor="#f1f1f1">发货方：</td>
							<td width="10%" ><input type="text" name="tuoyundan.fhf"  value="${tuoyundan.fhf }"  class="span1-1" /></td>
					 		<td width="7%" align="right" bgcolor="#f1f1f1">收货方：</td>
							<td width="10%" ><input type="text" name="tuoyundan.shf"  value="${tuoyundan.shf }"  class="span1-1" /></td>
							<td width="7%" align="right" bgcolor="#f1f1f1">开单网点：</td>
							<td width="10%" ><input type="text" name=""  class="span1-1" /></td>
						</tr>
						<tr>
						 
							<td width="7%" align="right" bgcolor="#f1f1f1">托运单号：</td>
							<td width="10%" ><input type="text" name="tuoyundan.tydh" value="${tuoyundan.tydh }" class="span1-1" /></td>
							<td width="7%" align="right" bgcolor="#f1f1f1">单据状态：</td>
							<td width="10%" >
								<select name="tuoyundan.state"  id="state"  class="span1-1">
							 		<option value="0">正常订单</option>
							 		<option value="1">撤销订单</option>
								</select>
							</td>
							<td width="7%" align="right" bgcolor="#f1f1f1">结算方式：</td>
							<td><input type="text" name=""  class="span1-1" /></td>
							<td width="7%" align="right" bgcolor="#f1f1f1">线路名称：</td>
							<td>
								<select id="xlid"  name="tuoyundan.xlid" class="span1-1" >
									<option value="">&nbsp;&nbsp;&nbsp;-配送线路-</option>
							 		<option value="1"  ${tuoyundan.xlid==1?"selected":"" }>配送线路-01 (东郊)</option>
									<option value="2"  ${tuoyundan.xlid==2?"selected":"" }>配送线路-02 (北郊)</option>
									<option value="3"  ${tuoyundan.xlid==3?"selected":"" }>配送线路-03 (西郊)</option>
									<option value="4"  ${tuoyundan.xlid==4?"selected":"" }>配送线路-04 (南郊)</option>
									<option value="5"  ${tuoyundan.xlid==5?"selected":"" }>配送线路-05 (东南)</option>
									<option value="6"  ${tuoyundan.xlid==6?"selected":"" }>配送线路-06 (高陵)</option>
								</select>
							</td>
							<td width="7%" align="right" bgcolor="#f1f1f1">开单员：</td>
							<td><input type="text" name=""  class="span1-1" /></td>
						</tr>
						
					</table>


					<table class="margin-bottom-20 table  no-border">
						<tr>
							<td class="text-right"><input type="submit" value="查询" class="btn btn-info " style="width: 80px;" /></td>
							<td class="text-left"><strong>单数：</strong> <input name="danshu" type="text" class="span1" id="input" value="${danshu }" /></td>
							<td class="text-left"><input type="button" value="导出"  class="btn btn-info " style="width: 80px;"  onclick="doReport()"  /></td>
						</tr>
						
					</table>
					
						<table class="table table-bordered">
						<tr>
							<td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">单据合计：</td>
							<td><input name="input" type="text" class="span1" id="input" value="${contMap['djhj']}" /></td>
							<td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">运费合计：</td>
							<td><input name="input14" type="text" class="span1" id="input14" value="${contMap['yfhj']}" /> </td>
							<td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">代收货款合计：</td>
							<td><input name="input14" type="text" class="span1" id="input14" value="${contMap['dshj']}" /> </td>
							<td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">手续费合计：</td>
							<td><input name="input14" type="text" class="span1" id="input14" value="${contMap['sxhj']}" /> </td>
							<td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">其他费用合计：</td>
							<td><input name="input13" type="text" class="span1" id="input13" value="${contMap['qthj']}" /></td>
							<td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">费用总合计：</td>
							<td><input name="input14" type="text" class="span1" id="input14" value="${contMap['fzhj']}" /> </td>
							<td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">件数合计：</td>
							<td><input name="input14" type="text" class="span1" id="input14" value="${contMap['jshj']}" /> </td>
							<!-- 
							<td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">物流券合计：</td>
							<td><input name="input14" type="text" class="span1" id="input14" value="0" /> </td>
							 -->
						</tr>
						 
					</table>
					
					<table class="table table-bordered">
						<tr>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>托运日期</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>托运单号</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>发货方</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>收货方</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>开单网点</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>开单员</strong></td>
							<td width="10%" align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>操作</strong></td>
						</tr>
						<s:iterator value="tuoyundanList" var="list">
						
						<tr>
							<td align="center">&nbsp;${list.tydate }</td>
							<td align="center">&nbsp;${list.tydh }</td>
							<td align="center">&nbsp;${list.fhf }</td>
							<td align="center">&nbsp;${list.shf }</td>
							<td align="center">&nbsp;${list.kdwd }</td>
							<td align="center">&nbsp;${list.kdy }</td>
							<td align="center">
							<c:if test="${list.state eq '0' }">
								<a href="${pageContext.request.contextPath}/tuoyundanAction!showTuoyundanByID?tyid=${list.tyid }">查看打印</a>&nbsp;&nbsp;
							</c:if>
							<c:if test="${list.state eq '1' }">
								<font color="red" >已撤销的运单</font>
							</c:if>
							</td>
						</tr>
						
						</s:iterator>
					</table>
					
			
				
					</form>
				</div>

				
			</div>
		</div>
	</div>

	<!-- 底部 -->
	<div id="footer">
		版权所有：jujie &copy; 2016&nbsp;&nbsp;&nbsp;&nbsp; 
	</div>



	<script>
		!function() {
			laydate.skin('molv');
			laydate({
				elem : '#Calendar1',
				istime : 'true',
				format : 'YYYY-MM-DD hh:mm'
			});
			laydate.skin('molv');
			laydate({
				elem : '#Calendar2',
					istime : 'true',
					format : 'YYYY-MM-DD hh:mm'
			});
	
		}();
	</script>




</body>
</html>