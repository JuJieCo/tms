<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resource/js/jquery1.9.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resource/js/jquery.autocomplete.min.js"></script>
<link rel="Stylesheet" href="${pageContext.request.contextPath}/resource/css/jquery.autocomplete.css" />



<script type='text/javascript'>
	$(document).ready(function() {
		$("#fhf").autocomplete("${pageContext.request.contextPath}/kehuAutoAction!queryKehuListAuto", {
			minChars : 1,
			max : 50,
			width : 400,
			matchContains : true,
			autoFill : false,
			parse : function(joinresult) {
				data = joinresult.kehuList;
				var rows = [];
				for (var i = 0; i < data.length; i++) {
					rows[rows.length] = {
						data : data[i],
						value : data[i].name,
						result : data[i].name,
					};
				}
				return rows;
			},
			formatItem : function(item) {
				return item.name +"--||--"+item.lxdh;
			}
		}).result(function(e, item) {
			//$("#kdwd").val(item.khid);
			$("#fhflxr").val(item.lxr);
			$("#fhfdh").val(item.lxdh);
			$("#fhfdz").val(item.xxdz);
			$("#fhftype").val(item.type);
			$("#zhanghao").val(item.zhanghao);
			$("#fhfid").val(item.khid);
			
			if(item.sfqy ==0){
				$("#sfqyt").val("未签约");
				$("#sfqy").val(0);
			}
			if (item.sfqy ==1){
				$("#sfqyt").val("已签约");
				$("#sfqy").val(1);
			}
			if(item.type ==0){
				$("#fhftypet").val("供应商");
				$("#fhftype").val(0);
			}
			if (item.type ==1){
				$("#fhftypet").val("修理厂");
				$("#fhftype").val(1);
			}
			
		});
		
		$("#fhf").autocomplete("${pageContext.request.contextPath}/kehuAutoAction!queryKehuListAutol", {
			minChars : 1,
			max : 50,
			width : 400,
			matchContains : true,
			autoFill : false,
			parse : function(joinresult) {
				data = joinresult.kehuList;
				var rows = [];
				for (var i = 0; i < data.length; i++) {
					rows[rows.length] = {
						data : data[i],
						value : data[i].name,
						result : data[i].name,
					};
				}
				return rows;
			},
			formatItem : function(item) {
				return item.name +"--||--"+item.lxdh;
			}
		}).result(function(e, item) {
			//$("#kdwd").val(item.khid);
			$("#fhflxr").val(item.lxr);
			$("#fhfdh").val(item.lxdh);
			$("#fhfdz").val(item.xxdz);
			$("#fhftype").val(item.type);
			$("#zhanghao").val(item.zhanghao);
			$("#fhfid").val(item.khid);
			
			if(item.sfqy ==0){
				$("#sfqyt").val("未签约");
				$("#sfqy").val(0);
			}
			if (item.sfqy ==1){
				$("#sfqyt").val("已签约");
				$("#sfqy").val(1);
			}
			if(item.type ==0){
				$("#fhftypet").val("供应商");
				$("#fhftype").val(0);
			}
			if (item.type ==1){
				$("#fhftypet").val("修理厂");
				$("#fhftype").val(1);
			}
		});
	});
</script>



<script type='text/javascript'>
	$(document).ready(function() {
		$("#fhfdh").autocomplete("${pageContext.request.contextPath}/kehuAutoAction!queryKehuListAutol", {
			minChars : 1,
			max : 50,
			width : 400,
			matchContains : true,
			autoFill : false,
			parse : function(joinresult) {
				data = joinresult.kehuList;
				var rows = [];
				for (var i = 0; i < data.length; i++) {
					rows[rows.length] = {
						data : data[i],
						value : data[i].lxdh,
						result : data[i].lxdh,
					};
				}
				return rows;
			},
			formatItem : function(item) {
				return item.name +"--||--"+item.lxdh;
			}
		}).result(function(e, item) {
			//$("#kdwd").val(item.khid);
			$("#fhflxr").val(item.lxr);
			$("#fhf").val(item.name);
			$("#fhfdz").val(item.xxdz);
			$("#fhftype").val(item.type);
			$("#zhanghao").val(item.zhanghao);
			$("#fhfid").val(item.khid);
			
			if(item.sfqy ==0){
				$("#sfqyt").val("未签约");
				$("#sfqy").val(0);
			}
			if (item.sfqy ==1){
				$("#sfqyt").val("已签约");
				$("#sfqy").val(1);
			}
			if(item.type ==0){
				$("#fhftypet").val("供应商");
				$("#fhftype").val(0);
			}
			if (item.type ==1){
				$("#fhftypet").val("修理厂");
				$("#fhftype").val(1);
			}
			
		});
	});
</script>

<!-- 收货方 -->

<script type='text/javascript'>
	$(document).ready(function() {
		$("#shf").autocomplete("${pageContext.request.contextPath}/kehuAutoAction!queryKehuListAuto", {
			minChars : 1,
			max : 50,
			width : 400,
			matchContains : true,
			autoFill : false,
			parse : function(joinresult) {
				data = joinresult.kehuList;
				var rows = [];
				for (var i = 0; i < data.length; i++) {
					rows[rows.length] = {
						data : data[i], 
						value : data[i].name, 
						result : data[i].name, 
					};
				}
				return rows;
			},
			formatItem : function(item) {
				return item.name +"--||--"+item.lxdh;
			}
		}).result(function(e, item) {
			//$("#mdwd").val(item.khid);
			$("#shflxr").val(item.lxr);
			$("#shfdh").val(item.lxdh);
			$("#shfdz").val(item.xxdz);
			$("#shftype").val(item.type);
			$("#xlid").val(item.xianlu.xlid);
			$("#edate").val(item.edate);
			$("#shfid").val(item.khid);
			 
			$("#yunfei").val(0);
			$("#dshk").val(0);
			$("#sxf").val(0);
			$("#qtfy").val(0);
			$("#fyhj").val(0);
			
			
			
			if(item.sfqy ==0){
				$("#sfbyt").val("未包月");
				$("#sfby").val(0);
				$("#jsfs").val(1);
			}
			if (item.sfqy ==1){
				$("#sfbyt").val("已包月");
				$("#sfby").val(1);
				$("#jsfs").val(4);
			} 
			
			
			if(item.type ==0){
				$("#shftypet").val("供应商");
				$("#shftype").val(0);
			}
			if (item.type ==1){
				$("#shftypet").val("修理厂");
				$("#shftype").val(1);
			}
			
		});
		
		$("#shf").autocomplete("${pageContext.request.contextPath}/kehuAutoAction!queryKehuListAutol", {
			minChars : 1,
			max : 50,
			width : 400,
			matchContains : true,
			autoFill : false,
			parse : function(joinresult) {
				data = joinresult.kehuList;
				var rows = [];
				for (var i = 0; i < data.length; i++) {
					rows[rows.length] = {
						data : data[i], 
						value : data[i].name, 
						result : data[i].name, 
					};
				}
				return rows;
			},
			formatItem : function(item) {
				return item.name +"--||--"+item.lxdh;
			}
		}).result(function(e, item) {
			//$("#mdwd").val(item.khid);
			$("#shflxr").val(item.lxr);
			$("#shfdh").val(item.lxdh);
			$("#shfdz").val(item.xxdz);
			$("#shftype").val(item.type);
			$("#xlid").val(item.xianlu.xlid);
			$("#edate").val(item.edate);
			$("#shfid").val(item.khid);
			 
			$("#yunfei").val(0);
			$("#dshk").val(0);
			$("#sxf").val(0);
			$("#qtfy").val(0);
			$("#fyhj").val(0);
			
			
			
			if(item.sfqy ==0){
				$("#sfbyt").val("未包月");
				$("#sfby").val(0);
				$("#jsfs").val(1);
			}
			if (item.sfqy ==1){
				$("#sfbyt").val("已包月");
				$("#sfby").val(1);
				$("#jsfs").val(4);
			} 
			
			
			if(item.type ==0){
				$("#shftypet").val("供应商");
				$("#shftype").val(0);
			}
			if (item.type ==1){
				$("#shftypet").val("修理厂");
				$("#shftype").val(1);
			}
		});
		
	});
</script>
<script type='text/javascript'>
	$(document).ready(function() {
		$("#shfdh").autocomplete("${pageContext.request.contextPath}/kehuAutoAction!queryKehuListAutol", {
			minChars : 1,
			max : 50,
			width : 400,
			matchContains : true,
			autoFill : false,
			parse : function(joinresult) {
				data = joinresult.kehuList;
				var rows = [];
				for (var i = 0; i < data.length; i++) {
					rows[rows.length] = {
						data : data[i], 
						value : data[i].lxdh,
						result : data[i].lxdh, 
					};
				}
				return rows;
			},
			formatItem : function(item) {
				return item.name +"--||--"+item.lxdh;
			}
		}).result(function(e, item) {
			//$("#mdwd").val(item.khid);
			$("#shflxr").val(item.lxr);
			$("#shf").val(item.name);
			$("#shfdz").val(item.xxdz);
			$("#shftype").val(item.type);
			$("#xlid").val(item.xianlu.xlid);
			$("#edate").val(item.edate);
			$("#shfid").val(item.khid);
			
			$("#yunfei").val(0);
			$("#dshk").val(0);
			$("#sxf").val(0);
			$("#qtfy").val(0);
			$("#fyhj").val(0);
			
			
			if(item.sfqy ==0){
				$("#sfbyt").val("未包月");
				$("#sfby").val(0);
				$("#jsfs").val(1);
			}
			if (item.sfqy ==1){
				$("#sfbyt").val("已包月");
				$("#sfby").val(1);
				$("#jsfs").val(4);
			}
			if(item.type ==0){
				$("#shftypet").val("供应商");
				$("#shftype").val(0);
			}
			if (item.type ==1){
				$("#shftypet").val("修理厂");
				$("#shftype").val(1);
			}
			
		});
	});
</script>

