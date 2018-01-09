package com.jujie.tms.struts.action;

import java.util.List;

import com.jujie.tms.model.service.KehuService;
import com.jujie.tms.model.utils.BaseActionSupper;
import com.jujie.tms.struts.bean.Kehu;

public class KehuAutoAction extends BaseActionSupper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String s_token;
	private List<Kehu> kehuList; // 发货方

	public String getS_token() {
		return s_token;
	}

	public void setS_token(String s_token) {
		this.s_token = s_token;
	}

	public List<Kehu> getKehuList() {
		return kehuList;
	}

	public void setKehuList(List<Kehu> kehuList) {
		this.kehuList = kehuList;
	}

	public String queryKehuListAuto() throws Exception {

		String q = request.getParameter("q");// q 是 JQueryAutoComplete 自带的参数
		q = new String(q.getBytes("ISO-8859-1"), "UTF-8");
		System.out.println("================" + q);

		KehuService kehuService = (KehuService) this.getService("kehuService");
		kehuList = kehuService.queryKehuListAuto(q);
		return "success";
	}
	
	public String queryKehuListAutol() throws Exception {

		String q = request.getParameter("q");// q 是 JQueryAutoComplete 自带的参数
		q = new String(q.getBytes("ISO-8859-1"), "UTF-8");
		System.out.println("================" + q);

		KehuService kehuService = (KehuService) this.getService("kehuService");
		kehuList = kehuService.queryKehuListAutol(q);
		return "success";
	}

}
