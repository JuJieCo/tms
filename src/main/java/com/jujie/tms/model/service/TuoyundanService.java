package com.jujie.tms.model.service;

import java.util.List;

import com.jujie.tms.model.dao.KehuDAO;
import com.jujie.tms.model.dao.TuoyundanDAO;
import com.jujie.tms.model.utils.Page;
import com.jujie.tms.struts.bean.Kehu;
import com.jujie.tms.struts.bean.Tuoyundan;

public class TuoyundanService {

	private TuoyundanDAO tuoyundanDAOSer;

	public void setTuoyundanDAOSer(TuoyundanDAO tuoyundandaoSer) {
		tuoyundanDAOSer = tuoyundandaoSer;
	}
	
	private KehuDAO kehuDAOSer;

	public void setKehuDAOSer(KehuDAO kehuDAOSer) {
		this.kehuDAOSer = kehuDAOSer;
	}

	public int modifyTuoyundan(Tuoyundan tuoyundan) throws Exception {

		if(null!=tuoyundan.getTyid()&&!"".equals(tuoyundan.getTyid())){
			 tuoyundanDAOSer.editTuoyundan(tuoyundan);
			 return tuoyundan.getTyid();
		}else{
			////////////直接新增不存在的客户(供货商,修理厂)
			//判断是否有这个供货商
		 
				List<Kehu> kehuListFhf  =kehuDAOSer.queryKehuName(tuoyundan.getFhf());
				if(kehuListFhf.size()<1){//判断有没有这个供货商的名字
					Kehu kehu = new Kehu();
					kehu.setName(tuoyundan.getFhf());
					kehu.setLxr(tuoyundan.getFhflxr());
					kehu.setLxdh(tuoyundan.getFhfdh());
					kehu.setXxdz(tuoyundan.getFhfdz());
					kehu.setType(0);
					kehu.setSfqy(0);
					kehu.setState(0);
					kehuDAOSer.saveKehu(kehu);//没有就新增
				}
		 
				
			//判断是否有这个修理厂
				List<Kehu> kehuListShf  =kehuDAOSer.queryKehuName(tuoyundan.getShf());
				if(kehuListShf.size()<1){//判断有没有这个修理厂的名字
					Kehu kehu = new Kehu();
					kehu.setName(tuoyundan.getShf());
					kehu.setLxr(tuoyundan.getShflxr());
					kehu.setLxdh(tuoyundan.getShfdh());
					kehu.setXxdz(tuoyundan.getShfdz());
					kehu.setType(1);
					kehu.setSfqy(0);
					kehu.setState(0);
					kehu.getXianlu().setXlid(tuoyundan.getXlid());
					kehuDAOSer.saveKehu(kehu);//没有就新增
		 
			}
			return tuoyundanDAOSer.saveTuoyundan(tuoyundan);
		}
	}
	
	
	public void editTuoyundan(Tuoyundan tuoyundan) throws Exception {

		 tuoyundanDAOSer.editTuoyundan(tuoyundan);

	}

	public Tuoyundan findTuoyundanByID(int id) throws Exception {

		return tuoyundanDAOSer.findTuoyundanByID(id);
	}

	public List<Tuoyundan> queryTuoyundanList(Tuoyundan tuoyundan, Page page, String btime, String etime) throws Exception {
		Object[] objs = new Object[5];
		if (null != tuoyundan && !"".equals(tuoyundan)) { //运单号
			objs[0] = tuoyundan.getTydh().trim();
		}
		if (null != tuoyundan && !"".equals(tuoyundan)) { //发货方
			objs[1] = tuoyundan.getFhf().trim();
		}
		if (null != tuoyundan && !"".equals(tuoyundan)) { //收货方
			objs[2] = tuoyundan.getShf().trim();
		}
		if (null != tuoyundan && !"".equals(tuoyundan)) { //运单状态
			objs[3] = tuoyundan.getState();
		} else {
			objs[3] = 0;
		}
		if (null != tuoyundan && !"".equals(tuoyundan)) { //线路
				objs[4] = tuoyundan.getXlid();
		}
		return tuoyundanDAOSer.queryTuoyundanList(objs, page, btime, etime);
	}

	public void deleteTuoyundanByID(int id) throws Exception {
		tuoyundanDAOSer.deleteTuoyundanByID(id);
	}
	
	
//////统计//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	public List<Tuoyundan> queryTuoyundanForCount(String btime, String etime , String danshu , Tuoyundan tuoyundan) throws Exception {
		Object[] objs = new Object[5];
		if (null != tuoyundan && !"".equals(tuoyundan)) { //运单号
			objs[0] = tuoyundan.getTydh().trim();
		}
		if (null != tuoyundan && !"".equals(tuoyundan)) { //发货方
			objs[1] = tuoyundan.getFhf().trim();
		}
		if (null != tuoyundan && !"".equals(tuoyundan)) { //收货方
			objs[2] = tuoyundan.getShf().trim();
		}
		if (null != tuoyundan && !"".equals(tuoyundan)) { //运单状态
			objs[3] = tuoyundan.getState();
		} else {
			objs[3] = 0;
		}
		if (null != tuoyundan && !"".equals(tuoyundan)) { //线路
				objs[4] = tuoyundan.getXlid();
		}
		// 结算方式 开单网点 开单员
		return tuoyundanDAOSer.queryTuoyundanForCount(objs, btime, etime, danshu);
	}
	
	
	
//////导出//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	public List<Tuoyundan> exportExcel(String btime, String etime , String danshu , Tuoyundan tuoyundan) throws Exception {
		Object[] objs = new Object[5];
		if (null != tuoyundan && !"".equals(tuoyundan)) { //运单号
			objs[0] = tuoyundan.getTydh().trim();
		}
		if (null != tuoyundan && !"".equals(tuoyundan)) { //发货方
			objs[1] = tuoyundan.getFhf().trim();
		}
		if (null != tuoyundan && !"".equals(tuoyundan)) { //收货方
			objs[2] = tuoyundan.getShf().trim();
		}
		if (null != tuoyundan && !"".equals(tuoyundan)) { //运单状态
			objs[3] = tuoyundan.getState();
		} else {
			objs[3] = 0;
		}
		if (null != tuoyundan && !"".equals(tuoyundan)) { //线路
				objs[4] = tuoyundan.getXlid();
		}
		// 结算方式 开单网点 开单员
		return tuoyundanDAOSer.exportExcel(objs, btime, etime, danshu);
	}

}
