package com.jujie.tms.struts.bean;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jujie.tms.model.utils.BaseBean;

public class Peijian extends BaseBean {

	private Integer pjid;
	private String name;
	private String zjm; // 助记码
	private Integer state;
	private String remark;

	public Integer getPjid() {
		return pjid;
	}

	public void setPjid(Integer pjid) {
		this.pjid = pjid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZjm() {
		return zjm;
	}

	public void setZjm(String zjm) {
		this.zjm = zjm;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public Peijian mapRow(ResultSet rst, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Peijian peijian = new Peijian();
		peijian.setPjid(rst.getInt("pjid"));
		peijian.setName(rst.getString("name"));
		peijian.setZjm(rst.getString("zjm"));
		peijian.setState(rst.getInt("state"));
		peijian.setRemark(rst.getString("remark"));
		return peijian;
	}

}
