package com.jujie.tms.model.utils;

import java.util.List;

public class Page
{
	public static final int DATABASE_TYPE_MYSQL = 0;
	
	public static final int DATABASE_TYPE_ORACLE = 1;
	
	public static final int DATABASE_TYPE_MSSQL = 2;
	private int currentPage = 1;
	@SuppressWarnings("unused")
	private int maxPage = 0;
	private int pageSize = 20;
	private int maxSize = 0;
	@SuppressWarnings("rawtypes")
	private List list;
	private String pageHtml;

	public Page(int currentPage) {
		this.currentPage = currentPage == 0 ? 1 : currentPage;
	}

	public Page(int currentPage, int pageSize) {
		this.currentPage = currentPage == 0 ? 1 : currentPage;
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage == 0 ? 1 : currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage == 0 ? 1 : currentPage;
	}

	public int getMaxPage() {
		return (maxSize + pageSize - 1) / pageSize;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public String mysqlPageSQL(String sql) {
		int start = (currentPage - 1) * pageSize;
		//int end = currentPage * pageSize;
		String str = "select t1.* from ("
				+ sql
				+ ") t1 LIMIT " + start + "," + pageSize;
		return str;
	}

	public String oraclePageSQL(String sql) {
		int start=(currentPage-1)*pageSize;
		int end=currentPage*pageSize;
		String str = "select * from (select t1.*,rownum r from (select t.* from ("+sql+") t where rownum<="+end+" ) t1) t2 where t2.r>"+start;
		return str;
	}

	public String mssqlPageSQL(String sql){
		try{
			StringBuffer sb = new StringBuffer("");
			if(sql!=null){
				sql = sql.toLowerCase();
				sb.append("select top "+(currentPage*pageSize));
				sb.append(sql.substring(6));
			}
			String[] fileds = sql.substring(sql.lastIndexOf("order by")).split(" ");
			String ob1 = "";
			String ob2 = "";
			if(fileds[2].indexOf(".")!=-1){
				fileds[2] = fileds[2].substring(fileds[2].indexOf(".")+1);
			}
			if(fileds.length>3){
				if("desc".equals(fileds[3])){
					ob1 = fileds[2]+" asc ";
					ob2 = fileds[2]+" desc ";
				}else{
					ob1 = fileds[2]+" desc ";
					ob2 = fileds[2]+" asc ";
				}
			}else{
				ob1 = fileds[2]+" desc ";
				ob2 = fileds[2]+" asc ";
			}
			int t_pageSize = pageSize;
			if(currentPage*pageSize-this.getMaxSize()>0){
				t_pageSize = this.getMaxSize() - (currentPage-1)*pageSize;
			}
			String str = "select * from (select top "+t_pageSize+" * from ("+sb.toString()+") as a order by "+ob1+" )as b order by "+ob2;
			return str;
		}catch(Exception e){
			e.printStackTrace();
		}
		return sql;
	}

	public static void main(String[] args) {	
		Page page = new Page(3);
		String sql = "select task.uuid,task.task_code,task.title,task.task_content,task.task_level,task.start_time,task.finish_time,"
			+"task.issued_time,task.status,task.hold1,DATEDIFF(day,getdate(),task.finish_time) remindDay,task.remark,"
			+"saffer.uuid saffer_uuid,saffer.execute_dept saffer_dept,saffer.execute_userName saffer_name,"
			+"leader.uuid leader_uuid,leader.execute_dept leader_dept,leader.execute_userName leader_name "
			+"from works_task task "
			+"inner join execute_user saffer on task.execute_user_uuid=saffer.uuid "
			+"inner join execute_user leader on task.leader_uuid=leader.uuid "
			+" order by task.start_time";
		
		System.out.println(page.mssqlPageSQL(sql));
	}

	public String maxSizeSQL(String sql) {
		return "select count(*) from (" + sql + ") t";
	}

	public String maxSizeSQL2(String sql) {
		StringBuffer sb = new StringBuffer("");
		if(sql!=null){
			sql = sql.toLowerCase();
			sb.append("select top 100 Percent ");
			sb.append(sql.substring(6));
		}
		return "select count(*) from (" + sb.toString() + ") t";
	}
	
	public Page() {
	}

	@SuppressWarnings("rawtypes")
	public List getList() {
		return list;
	}

	@SuppressWarnings("rawtypes")
	public void setList(List list) {
		this.list = list;
		setPageHtml(createPageTag());
	}

	public String getPageHtml() {
		return pageHtml;
	}


	public void setPageHtml(String pageHtml) {
		this.pageHtml = pageHtml;
	}

  public String createPageTag()
  {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append("<div id=\"pageTag\" align=\"right\" style=\"font-size:12px\">");
    if ((getMaxPage() == 1) || (getMaxPage() == 0)) {
      stringBuffer.append("首页&nbsp;|&nbsp;上一页&nbsp;|&nbsp;下一页&nbsp;|&nbsp;尾页");
    } else if ((this.currentPage > 1) && (this.currentPage < getMaxPage()) && (this.maxSize != 0)) {
      stringBuffer.append("<a href=\"javascript:void(0);\" onclick=\"selectPage('1');\">首页</a>&nbsp;|&nbsp;");
      stringBuffer.append("<a href=\"javascript:void(0);\" onclick=\"selectPage('" + (this.currentPage - 1) + "');\">上一页</a>&nbsp;|&nbsp;");
      stringBuffer.append("<a href=\"javascript:void(0);\" onclick=\"selectPage('" + (this.currentPage + 1) + "');\">下一页</a>&nbsp;|&nbsp;");
      stringBuffer.append("<a href=\"javascript:void(0);\" onclick=\"selectPage('" + getMaxPage() + "');\">尾页</a>");
    } else if ((this.currentPage <= 1) && (getMaxPage() != 1) && (this.maxSize != 0)) {
      stringBuffer.append("首页&nbsp;|&nbsp;上一页&nbsp;|&nbsp;");
      stringBuffer.append("<a href=\"javascript:void(0);\" onclick=\"selectPage('" + (this.currentPage + 1) + "');\">下一页</a>&nbsp;|&nbsp;");
      stringBuffer.append("<a href=\"javascript:void(0);\" onclick=\"selectPage('" + getMaxPage() + "');\">尾页</a>");
    } else if ((this.currentPage >= getMaxPage()) && (getMaxPage() != 1) && (this.maxSize != 0)) {
      stringBuffer.append("<a href=\"javascript:void(0);\" onclick=\"selectPage('1');\">首页</a>&nbsp;|&nbsp;");
      stringBuffer.append("<a href=\"javascript:void(0);\" onclick=\"selectPage('" + (this.currentPage - 1) + "');\">上一页</a>&nbsp;|&nbsp;");
      stringBuffer.append("下一页&nbsp;|&nbsp;尾页");
    }
    stringBuffer.append(" &nbsp;&nbsp;共");
    if (getMaxPage() == 0)
      stringBuffer.append("1");
    else
      stringBuffer.append(getMaxPage());

    stringBuffer.append("页&nbsp;当前第");
    stringBuffer.append(this.currentPage);
    stringBuffer.append("页&nbsp;");
    stringBuffer.append("</div>");
    return stringBuffer.toString();
  }
}