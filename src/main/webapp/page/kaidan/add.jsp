<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>
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
	
	
	<script type="text/javascript">
	
	 
		function validateForm(formname){
			var yunfei = $("#yunfei").val();
			 var dshk = $("#dshk").val();
			 var sxf = $("#sxf").val();
			 var qtfy = $("#qtfy").val();
			 var jianshu = $("#jianshu").val(); 
			 var xlid = $("#xlid").val(); 
			 var temp=/^\d+(\.\d+)?$/;
			 
			 var fhf = $("#fhf").val(); 
			 var shf = $("#shf").val(); 
			
			if(temp.test(yunfei)==false){
				 $("#yunfei").val(0);
				 alert("请输入运费金额");
				 return false;
			}
			if(temp.test(dshk)==false){
				 $("#dshk").val(0);
				 alert("请输入代收款金额");
				 return false;
			}
			if(temp.test(sxf)==false){
				$("#sxf").val(0);
				 alert("请输入手续费金额");
				 return false;
			}
			if(temp.test(qtfy)==false){
				 $("#qtfy").val(0);
				 alert("请输入其他费用金额");
				 return false;
			}
			if(temp.test(jianshu)==false){
				 $("#jianshu").val(0); 
				 alert("请输入件数");
				 return false;
			}
			
			
			if($.trim(fhf)==""){
				 alert("发货方不能为空");
				 $("#fhf").focus();
				 return false;
			}
			if($.trim(shf)==""){
				 alert("收货方不能为空");
				 $("#shf").focus();
				 return false;
			}
			if(jianshu==0){
				 alert("请输入件数");
				 $("#jianshu").focus();
				 return false;
			}
			if(xlid==""){
				 alert("请选择线路");
				 $("#xlid").focus();
				 return false;
			}
			
			
			
			var edate = $("#edate").val();
			var end=new Date(edate.replace("-", "/").replace("-", "/"));  
				if(end<new Date()){
					alert('包月已到期请修改该客户资料');	
					return false;
				} 
	  	}
		
		
		 function count(){
			 var yunfei = $("#yunfei").val();
			 var dshk = $("#dshk").val();
			 var sxf = $("#sxf").val();
			 var qtfy = $("#qtfy").val();
			 var temp=/^\d+(\.\d+)?$/;
			 var sfby = $("#sfby").val();
			 var shf = $("#shf").val();
			  
			 if(shf==""){
				 alert('请先选择收货方');	
				 $("#yunfei").val(0);
				 $("#shf").focus();
				 return false;
			 }
			 
			if(sfby==0){
				 if(yunfei.match(temp)&&dshk.match(temp)&&sxf.match(temp)&&qtfy.match(temp)){
					var  fyhj =(parseFloat(yunfei)+parseFloat(dshk)+parseFloat(sxf)+parseFloat(qtfy));
					 	$("#fyhj").val(fyhj);
					}else{
						$("#fyhj").val(0);
					}	
			}else if(sfby==1){
				 if(yunfei.match(temp)&&dshk.match(temp)&&sxf.match(temp)&&qtfy.match(temp)){
					var  fyhj =(parseFloat(dshk)+parseFloat(sxf)+parseFloat(qtfy));
						$("#fyhj").val(fyhj);
					}else{
						$("#fyhj").val(0);
					}	
			}
			 
		 }
		 
		 
	</script>
</head>
<body>
	<%@include file="/page/frame/top.jsp"%>
	<%@include file="/page/plugin/autocomplete.jsp"%>
	
	<div class="right" id="mainFrame">
		<div class="right_cont">
			<ul class="breadcrumb"> <li>当前位置： <a href="#">首页</a> <span class="divider">/</span> <a href="#">业务处理</a> <span class="divider">/</span> 托运单</li> </ul>
			<div class="title_right">
				<strong>新建托运单</strong>
			</div>
				<!--  onkeydown="if(event.keyCode==13)return false;" -->
			<form name="form" method="post" action="${pageContext.request.contextPath}/tuoyundanAction!modifyTuoyundan"   onsubmit="return validateForm(this)">
				<s:token name="s_token"></s:token>
				<div style="width: 1200px; margin: auto">
					<table class="table table-bordered">
						<tr>
							<td width="7%" align="right" bgcolor="#f1f1f1">托运单号：</td>
							<td>
								<input type="text" name="tuoyundan.tydh" class="span1-1" value="${tuoyundan.tydh }" />
								<input type="hidden" name="tuoyundan.tyid"   value="${tuoyundan.tyid }" />
							</td>
							<td width="7%" align="right" bgcolor="#f1f1f1">开单员：</td>
							<td>
								<select name="tuoyundan.kdy" class="span1-1">
							 		<option value="王蒙">王蒙</option>
								</select>
							</td>
							<td width="7%" align="right" bgcolor="#f1f1f1">托运时间：</td>
							<td><input type="text" name="tuoyundan.tydate" class="span2" value="${tuoyundan.tydate }" /></td>
							<td width="7%" align="right" bgcolor="#f1f1f1">线路：</td>
							<td colspan="3">
							<script type="text/javascript">
								 $("#xlid").find("option").eq(1).attr("selected","selected");
								 $("#xlid").find("option").eq(2).attr("selected","selected");
								 $("#xlid").find("option").eq(3).attr("selected","selected");
								 $("#xlid").find("option").eq(4).attr("selected","selected");
								 $("#xlid").find("option").eq(5).attr("selected","selected");
								 $("#xlid").find("option").eq(6).attr("selected","selected");
 							</script>
								<select id="xlid"  name="tuoyundan.xlid" class="span2" >
										<option value="">&nbsp;&nbsp;&nbsp;-配送线路-</option>
							 		<option value="1"  ${tuoyundan.xlid==1?"selected":"" }>配送线路-01 (东郊)</option>
									<option value="2"  ${tuoyundan.xlid==2?"selected":"" }>配送线路-02 (北郊)</option>
									<option value="3"  ${tuoyundan.xlid==3?"selected":"" }>配送线路-03 (西郊)</option>
									<option value="4"  ${tuoyundan.xlid==4?"selected":"" }>配送线路-04 (南郊)</option>
									<option value="5"  ${tuoyundan.xlid==5?"selected":"" }>配送线路-05 (东南)</option>
									<option value="6"  ${tuoyundan.xlid==6?"selected":"" }>配送线路-06 (高陵)</option>
								</select>
							</td>
						</tr>
						<tr>
							<td align="right" bgcolor="#f1f1f1">开单网点：</td>
							<td>
								<select name="tuoyundan.kdwd"  id="kdwd"  class="span1-1">
							 		<option value="三桥">三桥</option>
								</select>
							<td align="right" bgcolor="#f1f1f1">目的网点：</td>
							<td><input type="text" id="mdwd"  name="tuoyundan.mdwd"  value="${tuoyundan.mdwd}" class="span1-1" /></td>
							<td align="right" bgcolor="#f1f1f1">下个网点：</td>
							<td><input type="text" name="tuoyundan.xgwd" class="span1-1"  value="${tuoyundan.xgwd}"/></td>
							<td align="right" bgcolor="#f1f1f1">配送员：</td>
							<td><input type="text" name="tuoyundan.psy" class="span1-1" value="${tuoyundan.psy}"/></td>
						</tr>
					</table>

					<table class="table table-bordered">
						<tr>
							<td width="7%" align="right" bgcolor="#f1f1f1">发货方：</td>
							<td colspan="2">
								<input type="text" id="fhf" name="tuoyundan.fhf" value="${tuoyundan.fhf}" class="span3" />
								<input type="hidden" id="fhfid" name="tuoyundan.fhfid" value="${tuoyundan.fhfid}" class="span3" />
								<input type="hidden" id="zhanghao" name="tuoyundan.zhanghao" value="${tuoyundan.zhanghao}" class="span3" />
							</td>
							<td width="7%" align="right" bgcolor="#f1f1f1">联系人：</td>
							<td><input type="text" id="fhflxr" name="tuoyundan.fhflxr"  value="${tuoyundan.fhflxr}" class="span1-1" /></td>
							<td width="7%" align="right" bgcolor="#f1f1f1">收货方：</td>
							<td colspan="2">
								<input type="text" id="shf"  name="tuoyundan.shf"  value="${tuoyundan.shf}" class="span3" />
								<input type="hidden" id="shfid" 	name="tuoyundan.shfid"  value="${tuoyundan.shfid}" class="span3" />
							</td>
							<td width="7%" align="right" bgcolor="#f1f1f1">联系人：</td>
							<td><input type="text" id="shflxr" name="tuoyundan.shflxr"  value="${tuoyundan.shflxr}"  class="span1-1" /></td>
						</tr>

						<tr>
							<td   align="right" bgcolor="#f1f1f1">联系电话：</td>
							<td colspan="4"><input type="text" id="fhfdh" name="tuoyundan.fhfdh" value="${tuoyundan.fhfdh}" class="span6" /></td>
							<td   align="right" bgcolor="#f1f1f1">联系电话：</td>
							<td colspan="4"><input type="text" id="shfdh" name="tuoyundan.shfdh"  value="${tuoyundan.shfdh}" class="span6"  /></td>
						</tr>

						<tr>
							<td align="right" bgcolor="#f1f1f1">详细地址：</td>
							<td colspan="4"><input type="text" id="fhfdz" name="tuoyundan.fhfdz"  value="${tuoyundan.fhfdz}" class="span6" /></td>
							<td align="right" bgcolor="#f1f1f1">详细地址：</td>
							<td colspan="4"><input type="text" id="shfdz" name="tuoyundan.shfdz"  value="${tuoyundan.shfdz}" class="span6" /></td>
						</tr>

						<tr>
							<td align="right" bgcolor="#f1f1f1">发货方类型：</td>
							<td colspan="2">
								<input type="text" id="fhftypet" name="fhftype" value="${tuoyundan.fhftype==1?'修理厂':'供应商'}"  class="span3" />
								<input type="hidden" id="fhftype" name="tuoyundan.fhftype"  value="${tuoyundan.fhftype}"  class="span3" />
							</td>
							<td align="right" bgcolor="#f1f1f1">是否签约：</td>
							<td>
								<input type="text" id="sfqyt" name="sfqy" value="${tuoyundan.sfqy==1?'已签约':'未签约' }"  class="span1-1" />
								<input type="hidden"  id="sfqy"  name="tuoyundan.sfqy"  value="${tuoyundan.sfqy}"  class="span1-1" />
							</td>
							<td align="right" bgcolor="#f1f1f1">收货方类型：</td>
							<td colspan="2">
								<input type="text" id="shftypet" name="shftype" class="span3" value="${tuoyundan.fhftype==0?'供应商':'修理厂'}" />
								<input type="hidden" id="shftype" name="tuoyundan.shftype"  value="${tuoyundan.fhftype}" class="span3" />
							</td>
							<td align="right" bgcolor="#f1f1f1">是否包月：</td>
							<td>
								<input type="text" id="sfbyt" name="sfby" value="${tuoyundan.sfby==1?'已包月':'未包月' }"  class="span1-1" />
								<input type="hidden"  id="sfby"  name="tuoyundan.sfby"  value="${tuoyundan.sfby}"  class="span1-1" />
								<input type="hidden"  id="edate"    class="span1-1" />
							</td>
						</tr>
					</table>


					<table id="" class="table table-bordered">
							<tr>
								<td align="left" nowrap="nowrap" bgcolor="#f1f1f1" colspan="5"><strong>货物名称</strong></td>
							</tr>
							<tr>
								<td><textarea name="tuoyundan.huowu" rows="3" cols="50" class="span11">${tuoyundan.huowu} </textarea></td>
								<td width="10%" align="right">件数：</td>
								<td><input type="text"  id="jianshu" name="tuoyundan.jianshu"  value="${tuoyundan.jianshu}"  class="span1" /></td>
								<td width="10%" align="right">运费：</td>
								<td><input type="text"  id="yunfei"  name="tuoyundan.yunfei" value="${tuoyundan.yunfei}"  class="span1"  onblur="count();" /></td>
							</tr>
						</table>


					<table class="table table-bordered">
						<tr>
							<td  align="left" bgcolor="#f1f1f1" colspan="12"><strong>备注：</strong></td>
						</tr>
						<tr>
							<td colspan="12"><textarea name="tuoyundan.remark"  rows="2" cols="50" class="span11">${tuoyundan.remark}</textarea></td>
						</tr>
						<tr>
							<td align="right" bgcolor="#f1f1f1">是否回单：</td>
							<td>
								<select name="tuoyundan.sfhd" class="span1-1">
									<option value="否"  ${tuoyundan.sfhd=='否'?"selected":"" }>否</option>
									<option value="是"  ${tuoyundan.sfhd=='是'?"selected":"" }>是</option>
								</select>
							</td>
							<td align="right" bgcolor="#f1f1f1">代收货款：</td>
							<td><input type="text"  id="dshk"  name="tuoyundan.dshk"  value="${tuoyundan.dshk}"  class="span1-1"  onblur="count();" /></td>
							<td align="right" bgcolor="#f1f1f1">手续费：</td>
							<td><input type="text" id="sxf"  name="tuoyundan.sxf"  value="${tuoyundan.sxf}"  class="span1-1"  onblur="count();" /></td>
							<td align="right" bgcolor="#f1f1f1">其他费用：</td>
							<td><input type="text"  id="qtfy" name="tuoyundan.qtfy"  value="${tuoyundan.qtfy}"  class="span1-1"  onblur="count();" /></td>
							<td align="right" bgcolor="#f1f1f1">费用合计：</td>
							<td><input type="text"  id="fyhj"  name="tuoyundan.fyhj"  value="${tuoyundan.fyhj}"   class="span1-1"  readonly="readonly"/></td>
							<td align="right" bgcolor="#f1f1f1">结算方式：</td>
							<td>
							<script type="text/javascript">
								 $("#jsfs").find("option").eq(1).attr("selected","selected" );
								 $("#jsfs").find("option").eq(4).attr("selected","selected" );
 							</script>
							<select  id="jsfs"  name="tuoyundan.jsfs"   class="span1-1">
								<option value="1"  ${tuoyundan.jsfs==1?"selected":"" }>到付</option>
								<option value="2"  ${tuoyundan.jsfs==2?"selected":"" }>现付</option>
								<option value="3"  ${tuoyundan.jsfs==3?"selected":"" }>免单</option>
								<option value="4"  ${tuoyundan.jsfs==4?"selected":"" }>包月</option>
							</select> 
							<input type="hidden" name="tuoyundan.sfsh" value="1" class="span1-1" />
							<input type="hidden" name="tuoyundan.state" value="${tuoyundan.state}" class="span1-1" /></td>
						</tr>
						<tr>
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