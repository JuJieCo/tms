	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>	
	
	<div class="header">
		<div class="logo"> <img src="${pageContext.request.contextPath}/resource/images/logo.png" /> </div>
		<div class="header-right">
			<i class="icon-question-sign icon-white"></i> <a href="#">帮助</a> 
			<i class="icon-off icon-white"></i> <a id="modal-973558" href="#modal-container-973558" role="button" data-toggle="modal">注销</a>
			  <a href="#">发送短信</a>
			<div id="modal-container-973558" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width: 300px; margin-left: -150px; top: 30%">
			<div class="modal-header"> <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button> <h3 id="myModalLabel">注销系统</h3> </div>
			<div class="modal-body"> <p>您确定要注销退出系统吗？</p> </div>
			<div class="modal-footer"> <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button> <a class="btn btn-primary" style="line-height: 20px;" href="登录.html">确定退出</a></div>
			</div>
		</div>
	</div>
	<!-- 顶部 -->

<div id="middle">
<div class="left">
			<script type="text/javascript">
				var myMenu;
				window.onload = function() {
					myMenu = new SDMenu("my_menu");
					myMenu.init();
				};
			</script>

			<div id="my_menu" class="sdmenu">
				<div>
					<span>业务处理</span> 
					<a href="${pageContext.request.contextPath}/tuoyundanAction!queryTuoyundanList?tag=list">托运单</a>
					<!-- 
					<a href="#">中转清单</a> 
					<a href="#">送货清单</a>
					 -->
				</div>
				<!-- 
				<div class="collapsed">
					<span>调度管理</span> 
					<a href="#">调度中心</a>
				</div>
				
				<div class="collapsed">
					<span>财务管理</span> 
					 
					<a href="#">出纳日记账</a>
			
					<a href="#">结算中心</a> 
				
					<a href="#">POS刷卡对账</a> 
					
				</div>
				 -->
				<div class="collapsed">
					<span>统计分析</span> 
					<!-- 
					<a href="#">物流收入报表</a>
					<a href="#">车辆配送里程统计</a> 
					<a href="#">配送专员业务报表</a> 
					<a href="#">物流券费用结算表</a> 
					<a href="#">调度员日分享表</a> 
					<a href="#">劳务结算明细表</a> 
					<a href="#">劳务结算汇总表</a> 
					<a href="#">车辆调度表</a> 
					
					<a href="#">中转费用分析</a> 
					<a href="#">操盘手订单统计</a> 
					<a href="#">中转业务分析统计</a> 
					<a href="#">商圈活动补贴统计</a> 
					 -->
					 <a href="${pageContext.request.contextPath}/tuoyundanAction!queryTuoyundanForCount?type=page">运单统计</a> 
					 <a href="${pageContext.request.contextPath}/page/tongji/zhifang.jsp">数据直方图</a> 
				</div>
				<div class="collapsed">
					<span>基础资料</span>
					<a href="${pageContext.request.contextPath}/kehuAction!queryKehuList">客户档案</a> 
					<a href="${pageContext.request.contextPath}/xianluAction!queryXianluList">线路管理</a>
					<a href="${pageContext.request.contextPath}/employeesAction!queryEmployeesList">人员档案</a> 
					<a href="${pageContext.request.contextPath}/wangdianAction!queryWangdianList">网点管理</a> 
				
				</div>
				<div class="collapsed">
					<span>系统管理</span> 
					<a href="#">修改密码</a>
				</div>
			</div>

		</div>
		<div class="Switch"></div>
		<script type="text/javascript">
			$(document).ready(function(e) {
				$(".Switch").click(function() {
					$(".left").toggle();

				});
			});
		</script>

		