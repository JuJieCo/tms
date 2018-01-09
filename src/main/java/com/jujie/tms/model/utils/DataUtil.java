package com.jujie.tms.model.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {

	public static int toInt(Object obj) {
		if (obj == null) {
			return 0;
		} else {
			try {
				return Integer.parseInt(obj.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return 0;
		}
	}
	
	public static String toString(Object obj){
		if(obj == null){
			return "";
		}else{
			try {
				return obj.toString();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "";
		}
	}
	

	
	public static java.sql.Date toSqlDate(Object obj){
		if(obj==null){
			return null;
		}
		if(obj instanceof Date){
			return new java.sql.Date(((Date) obj).getTime());
		}
		return null;
	}
	
	public static java.sql.Timestamp toTimestamp(Object obj){
		if(obj==null){
			return null;
		}
		if(obj instanceof Date){
			return new java.sql.Timestamp(((Date) obj).getTime());
		}
		if(obj instanceof java.sql.Timestamp){
			return (java.sql.Timestamp)obj;
		}
		return null;
	}
	
	
	
	public static String DateUtilFormat(Date date,String prex){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy"+prex+"MM"+prex+"dd");
		try {
			return sf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static java.util.Date DateUtilFormat(String str,String prex){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy"+prex+"MM"+prex+"dd");
		try {
			java.util.Date date = sf.parse(str);
			return date;
		} catch (Exception e) {
			//e.printStackTrace();
			return null;
		}
	}
	

}
