package com.jujie.tms.struts.action;

import java.util.List;

import com.jujie.tms.model.service.KehuService;
import com.jujie.tms.model.utils.BaseActionSupper;
import com.jujie.tms.model.utils.Page;
import com.jujie.tms.struts.bean.Kehu;
import com.jujie.tms.struts.bean.KehuHistory;

public class KehuAction extends BaseActionSupper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String s_token;
	private Page page;
	private List<Kehu> kehuList;
	private Kehu kehu;
	private List<KehuHistory> kehuHList;

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

	public List<Kehu> getKehuList() {
		return kehuList;
	}

	public void setKehuList(List<Kehu> kehuList) {
		this.kehuList = kehuList;
	}

	public Kehu getKehu() {
		return kehu;
	}

	public void setKehu(Kehu kehu) {
		this.kehu = kehu;
	}

	public List<KehuHistory> getKehuHList() {
		return kehuHList;
	}

	public void setKehuHList(List<KehuHistory> kehuHList) {
		this.kehuHList = kehuHList;
	}

	public String queryKehuList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		// 查询列表
		KehuService kehuService = (KehuService) this.getService("kehuService");
		kehuList = kehuService.queryKehuALLList(kehu, page);
		return "list";
	}

	// 到查看页面
	public String findKehuForShow() throws Exception {
		KehuService kehuService = (KehuService) this.getService("kehuService");
		String khid = request.getParameter("khid");
		kehu = kehuService.findKehuByID(khid);
		kehuHList = kehuService.queryKehuHistoryList(khid);
		return "show";
	}

	// 到新增或修改页面
	public String findKehuForModify() throws Exception {
		KehuService kehuService = (KehuService) this.getService("kehuService");
		String modify = request.getParameter("modify");
		if (null != modify && "save".equals(modify)) {
			kehu = new Kehu();
		} else if (null != modify && "update".equals(modify)) {
			String khid = request.getParameter("khid");
			kehu = kehuService.findKehuByID(khid);
		}
		return "modify";
	}

	// 新增或修改
	public String modifyKehu() throws Exception {
		KehuService kehuService = (KehuService) this.getService("kehuService");
		if (null != kehu) {
			kehuService.modifyKehu(kehu);
		}
		return this.queryKehuList();
	}

	// 删除
	public String deleteKehuByID() throws Exception {
		KehuService kehuService = (KehuService) this.getService("kehuService");
		String khid = request.getParameter("khid");
		kehuService.deleteKehuByID(khid);
		return this.queryKehuList();
	}

}
