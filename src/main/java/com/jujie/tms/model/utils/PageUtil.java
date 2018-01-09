package com.jujie.tms.model.utils;



import org.springframework.jdbc.core.JdbcTemplate;

public class PageUtil{


	@SuppressWarnings("deprecation")
	public static String fyPage(String sql,Object[] objs,Page page,JdbcTemplate jdbcTemplate,int DataBaseType){
		if(page==null){
			return sql;
		}
		String pageSql = "";
		switch(DataBaseType){
			case Page.DATABASE_TYPE_MYSQL:
				pageSql = page.mysqlPageSQL(sql);
				page.setMaxSize(jdbcTemplate.queryForInt(page.maxSizeSQL(sql),objs));
				break;
			case Page.DATABASE_TYPE_ORACLE:
				pageSql = page.oraclePageSQL(sql);
				page.setMaxSize(jdbcTemplate.queryForInt(page.maxSizeSQL(sql),objs));
				break;
			case Page.DATABASE_TYPE_MSSQL:
				page.setMaxSize(jdbcTemplate.queryForInt(page.maxSizeSQL2(sql),objs));
				pageSql = page.mssqlPageSQL(sql);
				break;
		}
		return pageSql;
	}
  
  
  
}