<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript"
	src="../../resource/js/jquery1.9.0.min.js"></script>
<script type="text/javascript"
	src="../../resource/js/jquery.autocomplete.min.js"></script>
<link rel="Stylesheet" href="../../resource/css/jquery.autocomplete.css" />



<script type='text/javascript'>
	$(document).ready(function() {
		$("#name").autocomplete("../kehuAutoAction!queryKehuListAuto", {
			minChars : 1,
			max : 50,
			width : 150,
			matchContains : true,
			autoFill : false,

			//如果需要另外传值给action的话可以用这样的方式,如果只是把input里面的值传递给action的话,可以不写  
			//   extraParams: 
			//   {   
			//     queryCon: function() 
			//     { 
			//      return $("#queryCon").val(); 
			//     }   
			//   },

			//进行对返回数据的格式处理
			parse : function(joinresult) {
				data = joinresult.kehuList;
				var rows = [];
				for (var i = 0; i < data.length; i++) {
					rows[rows.length] = {
						data : data[i], //下拉框显示数据格式 
						value : data[i].name, //选定后实际数据格式
						result : data[i].name, //result里面显示的是要返回到列表里面的值  
						//result : data[i].khid
					};
				}
				return rows;
			},
			formatItem : function(item) {
				//我没有特殊的要求,直接返回了
				return item.name ;
			}
		}).result(function(e, item) { //result(handler, item) 为选中后触发的事件
			$("#khid").val(item.khid);
			$("#xxdz").val(item.xxdz);
			
		});
	});
</script>

<script type='text/javascript'>
	$(document).ready(function() {
		$("#names").autocomplete("../kehuAutoAction!queryKehuListAuto", {
			minChars : 1,
			max : 50,
			width : 150,
			matchContains : true,
			autoFill : false,

			//如果需要另外传值给action的话可以用这样的方式,如果只是把input里面的值传递给action的话,可以不写  
			//   extraParams: 
			//   {   
			//     queryCon: function() 
			//     { 
			//      return $("#queryCon").val(); 
			//     }   
			//   },

			//进行对返回数据的格式处理
			parse : function(joinresult) {
				data = joinresult.kehuList;
				var rows = [];
				for (var i = 0; i < data.length; i++) {
					rows[rows.length] = {
						data : data[i], //下拉框显示数据格式 
						value : data[i].name, //选定后实际数据格式
						result : data[i].name, //result里面显示的是要返回到列表里面的值  
						//result : data[i].khid
					};
				}
				return rows;
			},
			formatItem : function(item) {
				//我没有特殊的要求,直接返回了
				return item.name ;
			}
		}).result(function(e, item) { //result(handler, item) 为选中后触发的事件
			$("#khids").val(item.khid);
			$("#xxdzs").val(item.xxdz);

		});
	});
</script>

</head>
<body>
	<table>
		<tr>
		<td><input type="text" id="name" name="name">
	<input type="text" id="khid" name="khid">
	<input type="text" id="xxdz" name="xxdz">
	</td>
	</tr>
		<tr>
		<td>
		<input type="text" id="names" name="names">
	<input type="text" id="khids" name="khids">
	<input type="text" id="xxdzs" name="xxdzs">
		</td></tr>
	</table>
</body>
</html>


