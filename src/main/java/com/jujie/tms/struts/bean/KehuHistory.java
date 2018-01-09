package com.jujie.tms.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jujie.tms.model.utils.BaseBean;
/**
 * 历史表是说 签约(包月)的历史记录 签约的过往历史
 * 修改客户信息为签约(包月)的时候 就会给历史表里插一条记录
 * @author ek
 *
 */
public class KehuHistory extends BaseBean {

	private Integer khid_h;
	private Integer khid;
	private String name;
	private Integer type;
	private String sdate;
	private String edate;
	private String remark;

	public Integer getKhid_h() {
		return khid_h;
	}

	public void setKhid_h(Integer khid_h) {
		this.khid_h = khid_h;
	}

	public Integer getKhid() {
		return khid;
	}

	public void setKhid(Integer khid) {
		this.khid = khid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public KehuHistory mapRow(ResultSet rst, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		KehuHistory kehuH = new KehuHistory();
		kehuH.setKhid_h(rst.getInt("khid_h"));
		kehuH.setKhid(rst.getInt("khid"));
		kehuH.setName(rst.getString("name"));
		kehuH.setType(rst.getInt("type"));
		kehuH.setSdate(rst.getString("sdate"));
		kehuH.setEdate(rst.getString("edate"));
		kehuH.setRemark(rst.getString("remark"));
		return kehuH;
	}

}
