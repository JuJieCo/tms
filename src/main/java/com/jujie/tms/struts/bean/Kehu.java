package com.jujie.tms.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jujie.tms.model.utils.BaseBean;

public class Kehu extends BaseBean {

	private Integer khid;
	private Xianlu xianlu;
	private Integer type; // 客户类型 0 供货商 1 修理厂
	private String khbh; // 客户编号
	private String name; // 客户名称
	private String lxr; // 联系人
	private String lxdh;// 联系电话
	private String xxdz; // 详细地址
	private String zhanghao; // 助记码
	private Integer sfqy; // 是否签约  0 未包月  1已包月
	private String sdate; // 签约开始时间
	private String edate;// 签约到期时间
	private Integer state; // 状态
	private String remark;

	public Kehu() {
		this.xianlu = new Xianlu();

	}

	public Integer getKhid() {
		return khid;
	}

	public void setKhid(Integer khid) {
		this.khid = khid;
	}

	public Xianlu getXianlu() {
		return xianlu;
	}

	public void setXianlu(Xianlu xianlu) {
		this.xianlu = xianlu;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getKhbh() {
		return khbh;
	}

	public void setKhbh(String khbh) {
		this.khbh = khbh;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLxr() {
		return lxr;
	}

	public void setLxr(String lxr) {
		this.lxr = lxr;
	}

	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	public String getXxdz() {
		return xxdz;
	}

	public void setXxdz(String xxdz) {
		this.xxdz = xxdz;
	}

	public String getZhanghao() {
		return zhanghao;
	}

	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}

	public Integer getSfqy() {
		return sfqy;
	}

	public void setSfqy(Integer sfqy) {
		this.sfqy = sfqy;
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
	public Kehu mapRow(ResultSet rst, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Kehu kehu = new Kehu();
		kehu.setKhid(rst.getInt("khid"));
		kehu.getXianlu().setXlid(rst.getInt("xlid"));
		kehu.setType(rst.getInt("type"));
		kehu.setKhbh(rst.getString("khbh"));
		kehu.setName(rst.getString("name"));
		kehu.setLxr(rst.getString("lxr"));
		kehu.setLxdh(rst.getString("lxdh"));
		kehu.setXxdz(rst.getString("xxdz"));
		kehu.setZhanghao (rst.getString("zhanghao"));
		kehu.setSfqy(rst.getInt("sfqy"));
		kehu.setSdate(rst.getString("sdate"));
		kehu.setEdate(rst.getString("edate"));
		kehu.setState(rst.getInt("state"));
		kehu.setRemark(rst.getString("remark"));
		return kehu;
	}

}
