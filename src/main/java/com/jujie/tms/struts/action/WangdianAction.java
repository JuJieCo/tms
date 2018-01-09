package com.jujie.tms.struts.action;

import java.util.List;

import com.jujie.tms.model.service.WangdianService;
import com.jujie.tms.model.utils.BaseActionSupper;
import com.jujie.tms.model.utils.Page;
import com.jujie.tms.struts.bean.Wangdian;

public class WangdianAction  extends BaseActionSupper{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String s_token;
	private Page page;
	private Wangdian wangdian;
	private List<Wangdian> wangdianList;
	public String getS_token() {
		return s_token;
	}
	public void setS_token(String s_token) {
		this.s_token = s_token;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public Wangdian getWangdian() {
		return wangdian;
	}
	public void setWangdian(Wangdian wangdian) {
		this.wangdian = wangdian;
	}
	public List<Wangdian> getWangdianList() {
		return wangdianList;
	}
	public void setWangdianList(List<Wangdian> wangdianList) {
		this.wangdianList = wangdianList;
	}
	
	
	
	public String  queryWangdianList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		WangdianService wangdianService = (WangdianService) this.getService("wangdianService");
		wangdianList = wangdianService.queryWangdianList(wangdian, page);
		return "list";
	}
	
	// 到新增或修改页面
	public String findWangdianForModify() throws Exception {
		WangdianService wangdianService = (WangdianService) this.getService("wangdianService");
		String modify = request.getParameter("modify");
		if (null != modify && "save".equals(modify)) {
			wangdian = new Wangdian();
		} else if (null != modify && "update".equals(modify)) {
			String wdid = request.getParameter("wdid");
			wangdian = wangdianService.findWangdianByID(wdid);
		}
		return "modify";
	}
	
	// 新增或修改
	public String modifyWangdian() throws Exception {
		WangdianService wangdianService = (WangdianService) this.getService("wangdianService");
		if (null != wangdian) {
			wangdianService.modifyWangdian(wangdian);
		}
		return this.queryWangdianList();
	}
	
	// 到查看页面
	public String findWangdianForShow() throws Exception {
		WangdianService wangdianService = (WangdianService) this.getService("wangdianService");
		String wdid = request.getParameter("wdid");
		wangdian = wangdianService.findWangdianByID(wdid);
		return "show";
	}
	
	// 删除
	public String deleteWangdianByID() throws Exception {
		WangdianService wangdianService = (WangdianService) this.getService("wangdianService");
		String wdid = request.getParameter("wdid");
		wangdianService.deleteWangdianByID(wdid);
		return this.queryWangdianList();
	}

}
