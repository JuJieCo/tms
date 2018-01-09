package com.jujie.tms.model.service;

import java.util.List;

import com.jujie.tms.model.dao.WangdianDAO;
import com.jujie.tms.model.utils.Page;
import com.jujie.tms.struts.bean.Wangdian;

public class WangdianService {
	
	private WangdianDAO wangdianDAOSer;

	public void setWangdianDAOSer(WangdianDAO wangdianDAOSer) {
		this.wangdianDAOSer = wangdianDAOSer;
	}

	public List<Wangdian> queryWangdianList(Wangdian wangdian, Page page) throws Exception {
		Object[] objs = new Object[1];
		if (null != wangdian && !"".equals(wangdian)) {
			objs[0] = wangdian.getName().trim();
		}
		return wangdianDAOSer.queryWangdianList(objs, page);
	}

	public Wangdian findWangdianByID(String id) throws Exception {
		return wangdianDAOSer.findWangdianByID(id);
	}

	
	
	public void modifyWangdian(Wangdian wangdian) throws Exception {
		if (null != wangdian.getWdid()&& !"".equals(wangdian.getWdid())) {
			wangdianDAOSer.editWangdian(wangdian);
		} else {
			 wangdianDAOSer.saveWangdian(wangdian);
		}
	}
	

	public void editWangdian(Wangdian wangdian) throws Exception {
		wangdianDAOSer.editWangdian(wangdian);
	}

	public void deleteWangdianByID(String id) throws Exception {
		wangdianDAOSer.deleteWangdianByID(id);
	}
}
