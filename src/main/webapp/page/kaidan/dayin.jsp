<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ taglib prefix="fmt" uri="/WEB-INF/fmt.tld"%>
<script>
	function preview(oper) {
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
<!--startprint1-->
<div>
	<table class="table-print">
		<tr>
			<td colspan="6">
				<h3 align="center" style="line-height: 20px;">顺众物流货物配送单</h3>
				<h6 align="right" style="line-height: 10px;">电话：02981336780 ,
					02961859112&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h6>
			</td>
		</tr>
		<tr>
			<td width="10%" align="right" bgcolor="#f1f1f1">单号:</td>
			<td>&nbsp;${tuoyundan.tydh }</td>
			<td width="10%" align="right" bgcolor="#f1f1f1">开单网点:</td>
			<td>&nbsp;${tuoyundan.kdwd }</td>
			<td width="10%" align="right" bgcolor="#f1f1f1">时间:</td>
			<td>&nbsp;${tuoyundan.tydate }</td>
		</tr>
	</table>

	<table class="table-print">
		<tr>
			<td width="10%" align="right" bgcolor="#f1f1f1">发货方:</td>
			<td colspan="3" style="word-break: break-all">&nbsp;${tuoyundan.fhf }</td>
			<td width="10%" align="right" bgcolor="#f1f1f1">收货方:</td>
			<td colspan="3" style="word-break: break-all">&nbsp;${tuoyundan.shf }</td>
		</tr>
		<tr>
			<td width="10%" align="right" bgcolor="#f1f1f1">联系地址:</td>
			<td colspan="3" style="word-break: break-all">&nbsp;${tuoyundan.fhfdz }</td>
			<td width="10%" align="right" bgcolor="#f1f1f1">联系地址:</td>
			<td colspan="3" style="word-break: break-all">&nbsp;${tuoyundan.shfdz }</td>
		</tr>

		<tr>
			<td width="10%" align="right" bgcolor="#f1f1f1">联系电话:</td>
			<td width="20%" style="word-break: break-all">&nbsp;${tuoyundan.fhfdh }</td>

			<td width="10%" align="right" bgcolor="#f1f1f1">联系人:</td>
			<td width="10%" style="word-break: break-all">&nbsp;${tuoyundan.fhflxr }</td>

			<td width="10%" align="right" bgcolor="#f1f1f1">联系电话:</td>
			<td width="20%" style="word-break: break-all">&nbsp;${tuoyundan.shfdh }</td>

			<td width="10%" align="right" bgcolor="#f1f1f1">联系人:</td>
			<td width="10%" style="word-break: break-all">&nbsp;${tuoyundan.shflxr }</td>
		</tr>
	</table>

	<table class="table-print">
		<tr>
			<td align="left" nowrap="nowrap" bgcolor="#f1f1f1"><strong>货物名称</strong></td>
			<td width="10%" align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>件数</strong></td>
			<td width="10%" align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>是否签约</strong></td>
		</tr>
		<tr>
			<td><textarea rows="2" cols="70" class="span7">&nbsp;${tuoyundan.huowu } </textarea></td>
			<td align="center">&nbsp;${tuoyundan.jianshu }&nbsp;件</td>
			<td align="center">&nbsp;${tuoyundan.sfqy eq 0 ? "未签约":"已签约" }&nbsp;</td>
		</tr>

		<tr>
			<td width="5%" align="left" bgcolor="#f1f1f1" colspan="3"><strong>备注：</strong>
				&nbsp;${tuoyundan.remark }</td>

		</tr>

	</table>


	<table class="table-print">
		<tr>
			<td width="10%" align="right" bgcolor="#f1f1f1">所属线路</td>
			<td width="15%">&nbsp; ${tuoyundan.xlid eq 1 ? "配送线路-01 (东郊)" : "" }
				${tuoyundan.xlid eq 2 ? "配送线路-02 (北郊)" : "" } ${tuoyundan.xlid eq 3 ? "配送线路-03 (西郊)" : "" }
				${tuoyundan.xlid eq 4 ? "配送线路-04 (南郊)" : "" } ${tuoyundan.xlid eq 5 ? "配送线路-05 (东南)" : "" }
				${tuoyundan.xlid eq 6 ? "配送线路-06 (高陵)" : "" }</td>
			<td width="10%" align="right" bgcolor="#f1f1f1">结算方式</td>
			<td width="15%">&nbsp; ${tuoyundan.jsfs eq 1 ? "到付":""}
				${tuoyundan.jsfs eq 2 ? "现付":""} ${tuoyundan.jsfs eq 3 ? "免单":""}
				${tuoyundan.jsfs eq 4 ? "包月":""}</td>
			<td width="10%" align="right" bgcolor="#f1f1f1">合计金额</td>
			<td width="15%">&nbsp;${tuoyundan.fyhj  }</td>
		</tr>

		<tr>
			<td width="10%" align="right" bgcolor="#f1f1f1">运费合计</td>
			<td width="15%">&nbsp;${tuoyundan.yunfei  }</td>
			<td width="10%" align="right" bgcolor="#f1f1f1">其他费用</td>
			<td width="15%">&nbsp;${tuoyundan.qtfy }</td>
			<td width="10%" align="right" bgcolor="#f1f1f1">代收款合计</td>
			<td width="15%">&nbsp;${tuoyundan.dshk }</td>
		</tr>
		<tr>
			<td width="10%" align="right" bgcolor="#f1f1f1" rowspan="2">发货方签字</td>
			<td width="15%">&nbsp;</td>
			<td width="10%" align="right" bgcolor="#f1f1f1" rowspan="2">收货方签字</td>
			<td width="15%">&nbsp;</td>
			<td width="10%" align="right" bgcolor="#f1f1f1" rowspan="2">配送专员签字</td>
			<td width="15%">&nbsp;</td>
		</tr>
	</table>

</div>
<!--endprint1-->
