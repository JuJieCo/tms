package com.jujie.tms.struts.action;

import org.jfree.chart.JFreeChart;

import com.jujie.tms.model.service.JfreeChartService;
import com.jujie.tms.model.utils.BaseActionSupper;

public class JfreeCharAction extends BaseActionSupper{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String s_token;
	/**
	 * 定义JFreeChart对象 大家请注意在这里JFreeChart对象名只能为chart 
	 * 不能是别的 
	 * 关于这点
	 * 大家可以上struts2网站上面查看一下
	 * 
	 * http://struts.apache.org/2.x/docs/jfreechart-plugin.html
	 */
	private JFreeChart chart;

	public JFreeChart getChart() {
		return chart;
	}

	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}

	public String getS_token() {
		return s_token;
	}

	public void setS_token(String s_token) {
		this.s_token = s_token;
	}

	
//	public String showJ() throws Exception {
//		// 饼图调用方法
//		this.chart = JfreeChartService.createChart();
//		return SUCCESS;
//	}
	
	public String showJBar() throws Exception {
		// 柱状图调用方法
		this.chart = JfreeChartService.createChartBar();
		return SUCCESS;
	}
}
