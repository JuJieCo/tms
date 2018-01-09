package com.jujie.tms.model.service;

import java.util.List;

import com.jujie.tms.model.dao.KehuDAO;
import com.jujie.tms.model.utils.Page;
import com.jujie.tms.struts.bean.Kehu;
import com.jujie.tms.struts.bean.KehuHistory;

public class KehuService {

	private KehuDAO kehuDAOSer;

	public void setKehuDAOSer(KehuDAO kehuDAOSer) {
		this.kehuDAOSer = kehuDAOSer;
	}

	public List<Kehu> queryKehuALLList(Kehu kehu, Page page) throws Exception {
		Object[] objs = new Object[3];
		if (null != kehu && !"".equals(kehu)) {
			objs[0] = kehu.getName().trim();
		}
		if (null != kehu && !"".equals(kehu)) {
			objs[1] = kehu.getType();
		}
		if (null != kehu && !"".equals(kehu)) {
			objs[2] = kehu.getSfqy();
		}
		return kehuDAOSer.queryKehuList(objs, page);
	}

	public Kehu findKehuByID(String id) throws Exception {
		return kehuDAOSer.findKehuByID(id);
	}

	
	//新增 修改 && 新增修改的时候插入历史表
	public void modifyKehu(Kehu kehu) throws Exception {
		if (null != kehu.getKhid() && !"".equals(kehu.getKhid())) {
			Kehu kehuTemp = new Kehu();//kehu表中原来的值
			kehuTemp = kehuDAOSer.findKehuByID(kehu.getKhid().toString());//kehu表中原来的值
			kehuDAOSer.editKehu(kehu);
			if(null!=kehuTemp.getEdate()){
				if (!kehuTemp.getEdate().equals(kehu.getEdate())) { //没有判断历史表中是否有相同的值!!!!!!!!!!
					// List<KehuHistory> kehuHList = kehuDAOSer.queryKehuHistoryList();
					this.saveKehuHistory(kehu.getKhid(), kehu);
				}
			}
		} else {
			Integer kuid = kehuDAOSer.saveKehu(kehu);
			this.saveKehuHistory(kuid, kehu);
		}
	}
	
	public  List<KehuHistory> queryKehuHistoryList(String khid) throws Exception{
		return kehuDAOSer.queryKehuHistoryList(khid);
	}
	



	public void deleteKehuByID(String id) throws Exception {
		kehuDAOSer.deleteKehuByID(id);
	}

	public void saveKehuHistory(Integer kuid, Kehu kehu) throws Exception {
		KehuHistory kehuH = new KehuHistory();
		if (kehu.getSfqy() == 1) {
			kehuH.setKhid(kuid);
			kehuH.setName(kehu.getName());
			kehuH.setType(kehu.getType());
			kehuH.setSdate(kehu.getSdate());
			kehuH.setEdate(kehu.getEdate());
			kehuDAOSer.saveKehuHistory(kehuH);
		}

	}

	// 自动补全
	public List<Kehu> queryKehuListAuto(String q) throws Exception {
		return kehuDAOSer.queryKehuListAuto(q);
	}

	public List<Kehu> queryKehuListAutol(String q) throws Exception {
		return kehuDAOSer.queryKehuListAutol(q);
	}

}
