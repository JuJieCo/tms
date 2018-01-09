package com.jujie.tms.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jujie.tms.model.utils.BaseBean;

public class Wangdian extends BaseBean {

	private Integer wdid;
	private String name;
	private String bianhao;// 网点编号
	private Integer state;
	private String remark;

	public Integer getWdid() {
		return wdid;
	}

	public void setWdid(Integer wdid) {
		this.wdid = wdid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBianhao() {
		return bianhao;
	}

	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
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
	public Wangdian mapRow(ResultSet rst, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Wangdian wangdian = new Wangdian();
		wangdian.setWdid(rst.getInt("wdid"));
		wangdian.setName(rst.getString("name"));
		wangdian.setBianhao(rst.getString("bianhao"));
		wangdian.setState(rst.getInt("state"));
		wangdian.setRemark(rst.getString("remark"));
		return wangdian;
	}

}
