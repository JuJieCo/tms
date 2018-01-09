package com.jujie.tms.model.service;

import java.util.List;

import com.jujie.tms.model.dao.XianluDAO;
import com.jujie.tms.model.utils.Page;
import com.jujie.tms.struts.bean.Xianlu;

public class XianluService {

	private XianluDAO xianLuDAOSer;

	public void setXianLuDAOSer(XianluDAO xianLuDAOSer) {
		this.xianLuDAOSer = xianLuDAOSer;
	}

	public List<Xianlu> queryXianluList(Xianlu xianlu, Page page) throws Exception {
		Object[] objs = new Object[1];
		if (null != xianlu && !"".equals(xianlu)) {
			objs[0] = xianlu.getName().trim();
		}
		return xianLuDAOSer.queryXianluList(objs, page);
	}

	public Xianlu findXianluByID(String id) throws Exception {
		return xianLuDAOSer.findXianluByID(id);
	}

	
	
	public void modifyXianlu(Xianlu xianlu) throws Exception {
		if (null != xianlu.getXlid()&& !"".equals(xianlu.getXlid())) {
			xianLuDAOSer.editXianlu(xianlu);
		} else {
			 xianLuDAOSer.saveXianlu(xianlu);
		}
	}
	

	public void editXianlu(Xianlu xianlu) throws Exception {
		xianLuDAOSer.editXianlu(xianlu);
	}

	public void deleteXianluByID(String id) throws Exception {
		xianLuDAOSer.deleteXianluByID(id);
	}

}
