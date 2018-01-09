package com.jujie.tms.model.utils;

public class GetPicNameUtil {
	
	public  String picName(String content){
		String picName = "";
		 
		if(null!=content&&!content.equals("")){
			
			if(content.toLowerCase().contains(".jpg")){
				 picName ="upload/file/"+ content.substring(content.indexOf(".jpg")-12, content.indexOf(".jpg")+4);
			}
			if(content.toLowerCase().contains(".bmp")){
				picName ="upload/file/"+ content.substring(content.indexOf(".bmp")-12, content.indexOf(".bmp")+4);
			}
			
			 
		}
		return picName;
	}

}
