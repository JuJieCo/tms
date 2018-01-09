package com.jujie.tms.model.service;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;

public class JfreeChartService {

	public static JFreeChart createChartBar() {

		double[][] data = new double[][] { { 222, 166, 223, 140, 126 },  { 622, 540, 456, 678, 345 } ,{ 521, 444, 662, 482, 545 }};

		String[] rowKeys = { "单数","件数", "运费" };

		String[] columnKeys = { "线路1", "线路2", "线路3", "线路4", "线路5" };
		CategoryDataset dataset = DatasetUtilities.createCategoryDataset(
				rowKeys, columnKeys, data);

		JFreeChart chart = ChartFactory.createBarChart3D("柱状图", "", "",
				dataset, PlotOrientation.VERTICAL, true, true, false);
		// 重新设置图标标题，改变字体
		chart.setTitle(new TextTitle("单数-件数-运费对比图", new Font("黑体", Font.ITALIC, 22)));
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		// 取得横轴
		CategoryAxis categoryAxis = plot.getDomainAxis();
		// 设置横轴显示标签的字体
		categoryAxis.setLabelFont(new Font("宋体", Font.BOLD, 18));
		// 分类标签以45度角倾斜
		categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
		categoryAxis.setTickLabelFont(new Font("宋体", Font.ITALIC, 15));

		CategoryAxis domainAxis = plot.getDomainAxis();
		// 设置距离图片左端距离
		domainAxis.setLowerMargin(0.1);
		// 设置距离图片右端距离
		domainAxis.setUpperMargin(0.1);

		BarRenderer3D renderer = new BarRenderer3D();
		renderer.setItemMargin(0.1);// 组内柱子间隔为组宽的10%
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());// 显示柱子上的数值
		renderer.setBaseItemLabelsVisible(true);
		plot.setRenderer(renderer);// 使用我们设计的效果

		// 取得纵轴
		NumberAxis numberAxis = (NumberAxis) plot.getRangeAxis();
		// 设置纵轴显示标签的字体
		numberAxis.setLabelFont(new Font("宋体", Font.BOLD, 18));

		// 设置最高的一个 Item 与图片顶端的距离
		numberAxis.setUpperMargin(0.15);
		// // 设置最低的一个 Item 与图片底端的距离
		// numberAxis.setLowerMargin(0.15);
		plot.setRangeAxis(numberAxis);

		Font font00 = new Font("宋体", Font.BOLD, 18);
		LegendTitle legend = chart.getLegend();
		legend.setItemFont(font00);// 设置注释字体

		return chart;
	}

	
//饼图
//	public static JFreeChart createChart() throws IOException {
//		// 数据集
//		DefaultPieDataset dpd = new DefaultPieDataset();
//		dpd.setValue("管理人员", 25);
//		dpd.setValue("市场人员", 25);
//		dpd.setValue("开发人员", 45);
//		dpd.setValue("其它人员", 10);
//		// 创建PieChart对象
//		JFreeChart chart = ChartFactory.createPieChart3D("某公司人员组织结构图", dpd,
//				true, true, false);
//		utils.setFont(chart);
//		return chart;
//	}
}


//饼图设置字体
//class utils {
//	public static void setFont(JFreeChart chart) {
//		Font font = new Font("宋体", Font.ITALIC, 12);
//		PiePlot plot = (PiePlot) chart.getPlot();
//		chart.getTitle().setFont(font);
//		plot.setLabelFont(font);
//		chart.getLegend().setItemFont(font);
//	}
//}
