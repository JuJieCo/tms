package com.jujie.tms.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jujie.tms.model.utils.BaseBean;

public class Xianlu extends BaseBean {

	private Integer xlid;
	private String name;
	private Integer state;
	private String remark;

	public Integer getXlid() {
		return xlid;
	}

	public void setXlid(Integer xlid) {
		this.xlid = xlid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	public Xianlu mapRow(ResultSet rst, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Xianlu xianlu = new Xianlu();
		xianlu.setXlid(rst.getInt("xlid"));
		xianlu.setName(rst.getString("name"));
		xianlu.setState(rst.getInt("state"));
		xianlu.setRemark(rst.getString("remark"));
		return xianlu;
	}

}
