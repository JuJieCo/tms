package com.jujie.tms.struts.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.jujie.tms.model.service.TuoyundanService;
import com.jujie.tms.model.utils.BaseActionSupper;
import com.jujie.tms.struts.bean.Tuoyundan;

public class ExcelExportAction extends BaseActionSupper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/** 导出Excel测试 */
	private InputStream excelStream; // 输出流变量
	private String excelFileName; // 下载文件名
	private Tuoyundan tuoyundan;
	
	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}

	public String getExcelFileName() {
		return excelFileName;
	}

	public void setExcelFileName(String excelFileName) {
		this.excelFileName = excelFileName;
	}

	public Tuoyundan getTuoyundan() {
		return tuoyundan;
	}

	public void setTuoyundan(Tuoyundan tuoyundan) {
		this.tuoyundan = tuoyundan;
	}

	
	public String exportExcel() throws Exception {
		try {
			// 第一步，创建一个webbook，对应一个Excel文件
			HSSFWorkbook wb = new HSSFWorkbook();
			// 第二步，在webbook中添加一个sheet，对应Excel文件中的 sheet
			HSSFSheet sheet = wb.createSheet("托运单");
			// 第三步，在sheet中添加表头第0行，注意老版本poi对Excel的行数列数有限制
			HSSFRow row = sheet.createRow(0);
			// 第四步，创建单元格样式：居中
			HSSFCellStyle style = wb.createCellStyle();
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			// 第五步，创建表头单元格，并设置样式
			HSSFCell cell;

			cell = row.createCell(0);
			cell.setCellValue("时间(分)");
			cell.setCellStyle(style);

			cell = row.createCell(1);
			cell.setCellValue("发货方名称");
			cell.setCellStyle(style);

			cell = row.createCell(2);
			cell.setCellValue("发货方电话");
			cell.setCellStyle(style);

			cell = row.createCell(3);
			cell.setCellValue("发货方账号");
			cell.setCellStyle(style);

			cell = row.createCell(4);
			cell.setCellValue("收货方名称");
			cell.setCellStyle(style);

			cell = row.createCell(5);
			cell.setCellValue("收货方电话");
			cell.setCellStyle(style);

			cell = row.createCell(6);
			cell.setCellValue("件数");
			cell.setCellStyle(style);

			cell = row.createCell(7);
			cell.setCellValue("运费");
			cell.setCellStyle(style);

			cell = row.createCell(8);
			cell.setCellValue("代收金额");
			cell.setCellStyle(style);

			cell = row.createCell(9);
			cell.setCellValue("是否包月");
			cell.setCellStyle(style);

			cell = row.createCell(10);
			cell.setCellValue("线路");
			cell.setCellStyle(style);

			cell = row.createCell(11);
			cell.setCellValue("网点");
			cell.setCellStyle(style);

			// 第六步，写入实体数据
			String btime = request.getParameter("btime");
			String etime = request.getParameter("etime"); 
			String danshu = request.getParameter("danshu"); 
			request.setAttribute("btime", btime);
			request.setAttribute("etime", etime);
			request.setAttribute("danshu", danshu);
			TuoyundanService tuoyundanService = (TuoyundanService) this.getService("tuoyundanService");
			List<Tuoyundan> tuoyundanList = tuoyundanService.exportExcel(btime, etime, danshu, tuoyundan);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
			
			 for (int i = 1; i <= tuoyundanList.size(); i++) {  
	                row = sheet.createRow(i);  
	                row.createCell(0).setCellValue(sdf.format(sdf.parse(tuoyundanList.get(i-1).getTydate())));//sdf.parse把字符串解析成一个DATE 再format
					row.createCell(1).setCellValue(tuoyundanList.get(i-1).getFhf());
					row.createCell(2).setCellValue(tuoyundanList.get(i-1).getFhfdh());
					row.createCell(3).setCellValue(tuoyundanList.get(i-1).getZhanghao());
					row.createCell(4).setCellValue(tuoyundanList.get(i-1).getShf());
					row.createCell(5).setCellValue(tuoyundanList.get(i-1).getShfdh());
					row.createCell(6).setCellValue(tuoyundanList.get(i-1).getJianshu());
					row.createCell(7).setCellValue(tuoyundanList.get(i-1).getYunfei());
					row.createCell(8).setCellValue(tuoyundanList.get(i-1).getDshk());
					if(tuoyundanList.get(i-1).getSfby()==1){
						row.createCell(9).setCellValue("已包月");
					}
					if(tuoyundanList.get(i-1).getSfby()==0){
						row.createCell(9).setCellValue("未包月");
					}
					if(tuoyundanList.get(i-1).getXlid()==1){
						row.createCell(10).setCellValue("配送线路-01 (东郊)");
					}
					if(tuoyundanList.get(i-1).getXlid()==2){
						row.createCell(10).setCellValue("配送线路-02 (北郊)");
					}
					if(tuoyundanList.get(i-1).getXlid()==3){
						row.createCell(10).setCellValue("配送线路-03 (西郊)");
					}
					if(tuoyundanList.get(i-1).getXlid()==4){
						row.createCell(10).setCellValue("配送线路-04 (南郊)");
					}
					if(tuoyundanList.get(i-1).getXlid()==5){
						row.createCell(10).setCellValue("配送线路-05 (东南)");
					}
					row.createCell(11).setCellValue(tuoyundanList.get(i-1).getKdwd());
	            }  
			 
			 
			 

			// 第七步，将文件存到流中
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			wb.write(os);
			byte[] fileContent = os.toByteArray();
			ByteArrayInputStream is = new ByteArrayInputStream(fileContent);

			excelStream = is; // 文件流
			excelFileName = "report.xls"; // 设置下载的文件名
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "success";
	}

}
