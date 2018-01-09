package com.jujie.tms.struts.action;

import java.util.List;

import com.jujie.tms.model.service.XianluService;
import com.jujie.tms.model.utils.BaseActionSupper;
import com.jujie.tms.model.utils.Page;
import com.jujie.tms.struts.bean.Xianlu;

public class XianluAction  extends BaseActionSupper{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String s_token;
	private Page page;
	private Xianlu xianlu;
	private List<Xianlu> xianluList;
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
	public Xianlu getXianlu() {
		return xianlu;
	}
	public void setXianlu(Xianlu xianlu) {
		this.xianlu = xianlu;
	}
	public List<Xianlu> getXianluList() {
		return xianluList;
	}
	public void setXianluList(List<Xianlu> xianluList) {
		this.xianluList = xianluList;
	}
	
	
	
	public String  queryXianluList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		XianluService xianluService = (XianluService) this.getService("xianluService");
		xianluList = xianluService.queryXianluList(xianlu, page);
		return "list";
	}
	
	// 到新增或修改页面
	public String findXianluForModify() throws Exception {
		XianluService xianluService = (XianluService) this.getService("xianluService");
		String modify = request.getParameter("modify");
		if (null != modify && "save".equals(modify)) {
			xianlu = new Xianlu();
		} else if (null != modify && "update".equals(modify)) {
			String xlid = request.getParameter("xlid");
			xianlu = xianluService.findXianluByID(xlid);
		}
		return "modify";
	}
	
	// 新增或修改
	public String modifyXianlu() throws Exception {
		XianluService xianluService = (XianluService) this.getService("xianluService");
		if (null != xianlu) {
			xianluService.modifyXianlu(xianlu);
		}
		return this.queryXianluList();
	}
	
	// 到查看页面
	public String findXianluForShow() throws Exception {
		XianluService xianluService = (XianluService) this.getService("xianluService");
		String xlid = request.getParameter("xlid");
		xianlu = xianluService.findXianluByID(xlid);
		return "show";
	}
	
	// 删除
	public String deleteXianluByID() throws Exception {
		XianluService xianluService = (XianluService) this.getService("xianluService");
		String xlid = request.getParameter("xlid");
		xianluService.deleteXianluByID(xlid);
		return this.queryXianluList();
	}

}
