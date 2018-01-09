<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ taglib prefix="fmt" uri="/WEB-INF/fmt.tld"%>
<script>
	function previewp(oper) {
		if (oper < 10) {
			bdhtml = window.document.body.innerHTML;//获取当前页的html代码 
			sprnstr = "<!--startprint" + oper + "-->";//设置打印开始区域 
			eprnstr = "<!--endprint" + oper + "-->";//设置打印结束区域 
			prnhtml = bdhtml.substring(bdhtml.indexOf(sprnstr) + 18); //从开始代码向后取html 

			prnhtml = prnhtml.substring(0, prnhtml.indexOf(eprnstr));//从结束代码向前取html 
			window.document.body.innerHTML = prnhtml;
			window.print();
			window.document.body.innerHTML = bdhtml;
		} else {
			window.print();
		}
	}
</script>
<!--startprint2-->
<div style="width:250px; margin: auto">

	<table class="table-printp" >
		<tr>
			<td width="20%" align="right" bgcolor="#f1f1f1">单号:</td>
			<td width="80%" style="word-break:break-all">&nbsp;${tuoyundan.tydh }</td>
		</tr>
		<tr>
			<td  align="right" bgcolor="#f1f1f1">收货人:</td>
			<td style="word-break:break-all">&nbsp;${tuoyundan.shf }</td>
		</tr>
			
		<tr>
			<td  align="right" bgcolor="#f1f1f1">电话:</td>
			<td style="word-break:break-all">&nbsp;${tuoyundan.shfdh }</td>
		</tr>
		
		<tr>
			<td align="right" bgcolor="#f1f1f1">地址:</td>
			<td style="word-break:break-all">&nbsp;${tuoyundan.shfdz }</td>
		</tr>
		
		<tr>
			<td align="right" bgcolor="#f1f1f1">件数:</td>
			<td style="word-break:break-all">&nbsp;${tuoyundan.jianshu }</td>
		</tr>
		
		<tr>
			<td   align="right" bgcolor="#f1f1f1">路线:</td>
			<td style="word-break:break-all">&nbsp;
				${tuoyundan.xlid eq 1 ? "配送线路-01 (东郊)" : "" }
				${tuoyundan.xlid eq 2 ? "配送线路-02 (北郊)" : "" }
				${tuoyundan.xlid eq 3 ? "配送线路-03 (西郊)" : "" }
			    ${tuoyundan.xlid eq 4 ? "配送线路-04 (南郊)" : "" }
				${tuoyundan.xlid eq 5 ? "配送线路-05 (东南)" : "" }	
				${tuoyundan.xlid eq 6 ? "配送线路-06 (高陵)" : "" }
			</td>
		</tr>
	</table>
</div>
<!--endprint2-->
