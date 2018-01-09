package com.jujie.tms.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jujie.tms.model.utils.BaseBean;

public class Tuoyundan extends BaseBean {

	private Integer tyid;

	private String kdy; // 开单员
	private String psy; // 配送员
	private String shf; // 收货方0
	private String shflxr; // 收货方联系人1
	private String shfdh; // 收货方联系电话2

	private String shfdz; // 收货方地址4
	private String shftype; // 收货方类型5
	private String fhf; // 发货方0
	private String fhflxr; // 发货方联系人1
	private String fhfdh; // 发货方联系电话2

	private String fhfdz; // 发货方地址4
	private String fhftype; // 发货方类型5
	private String kdwd; // 开单网点
	private String mdwd; // 目的网点
	private String xgwd; // 下个网点

	private Integer xlid; // 线路
	private String tydate; // 托运日期

	private String tydh; // 托运单号
	private String sfhd;// 是否回单 (是 否)
	private String dshk;// 代收货款
	private String sxf; // 手续费
	private String qtfy; // 其他费用

	private String fyhj; // 费用合计
	private String jsfs; // 费用结算方式(免单 现付 到付 包月)
	private String wljje;// 物流券金额
	private String sfsh;// 是否审核
	private String jianshu; // 件数

	private String yunfei; // 运费
	private Integer sfby;// 是否包月
	private Integer sfqy;// 是否签约
	private Integer state;

	private String huowu;
	private String zhanghao;
	private Integer fhfid;
	private Integer shfid;

	private String remark;

	public Tuoyundan() {

	}

	public Integer getTyid() {
		return tyid;
	}

	public void setTyid(Integer tyid) {
		this.tyid = tyid;
	}

	public String getKdy() {
		return kdy;
	}

	public void setKdy(String kdy) {
		this.kdy = kdy;
	}

	public String getPsy() {
		return psy;
	}

	public void setPsy(String psy) {
		this.psy = psy;
	}

	public String getShf() {
		return shf;
	}

	public void setShf(String shf) {
		this.shf = shf;
	}

	public String getShflxr() {
		return shflxr;
	}

	public void setShflxr(String shflxr) {
		this.shflxr = shflxr;
	}

	public String getShfdh() {
		return shfdh;
	}

	public void setShfdh(String shfdh) {
		this.shfdh = shfdh;
	}

	public String getShfdz() {
		return shfdz;
	}

	public void setShfdz(String shfdz) {
		this.shfdz = shfdz;
	}

	public String getShftype() {
		return shftype;
	}

	public void setShftype(String shftype) {
		this.shftype = shftype;
	}

	public String getFhf() {
		return fhf;
	}

	public void setFhf(String fhf) {
		this.fhf = fhf;
	}

	public String getFhflxr() {
		return fhflxr;
	}

	public void setFhflxr(String fhflxr) {
		this.fhflxr = fhflxr;
	}

	public String getFhfdh() {
		return fhfdh;
	}

	public void setFhfdh(String fhfdh) {
		this.fhfdh = fhfdh;
	}

	public String getFhfdz() {
		return fhfdz;
	}

	public void setFhfdz(String fhfdz) {
		this.fhfdz = fhfdz;
	}

	public String getFhftype() {
		return fhftype;
	}

	public void setFhftype(String fhftype) {
		this.fhftype = fhftype;
	}

	public String getKdwd() {
		return kdwd;
	}

	public void setKdwd(String kdwd) {
		this.kdwd = kdwd;
	}

	public String getMdwd() {
		return mdwd;
	}

	public void setMdwd(String mdwd) {
		this.mdwd = mdwd;
	}

	public String getXgwd() {
		return xgwd;
	}

	public void setXgwd(String xgwd) {
		this.xgwd = xgwd;
	}

	public Integer getXlid() {
		return xlid;
	}

	public void setXlid(Integer xlid) {
		this.xlid = xlid;
	}

	public String getTydate() {
		return tydate;
	}

	public void setTydate(String tydate) {
		this.tydate = tydate;
	}

	public String getTydh() {
		return tydh;
	}

	public void setTydh(String tydh) {
		this.tydh = tydh;
	}

	public String getSfhd() {
		return sfhd;
	}

	public void setSfhd(String sfhd) {
		this.sfhd = sfhd;
	}

	public String getDshk() {
		return dshk;
	}

	public void setDshk(String dshk) {
		this.dshk = dshk;
	}

	public String getSxf() {
		return sxf;
	}

	public void setSxf(String sxf) {
		this.sxf = sxf;
	}

	public String getQtfy() {
		return qtfy;
	}

	public void setQtfy(String qtfy) {
		this.qtfy = qtfy;
	}

	public String getFyhj() {
		return fyhj;
	}

	public void setFyhj(String fyhj) {
		this.fyhj = fyhj;
	}

	public String getJsfs() {
		return jsfs;
	}

	public void setJsfs(String jsfs) {
		this.jsfs = jsfs;
	}

	public String getWljje() {
		return wljje;
	}

	public void setWljje(String wljje) {
		this.wljje = wljje;
	}

	public String getSfsh() {
		return sfsh;
	}

	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}

	public String getJianshu() {
		return jianshu;
	}

	public void setJianshu(String jianshu) {
		this.jianshu = jianshu;
	}

	public String getYunfei() {
		return yunfei;
	}

	public void setYunfei(String yunfei) {
		this.yunfei = yunfei;
	}

	public Integer getSfby() {
		return sfby;
	}

	public void setSfby(Integer sfby) {
		this.sfby = sfby;
	}

	public Integer getSfqy() {
		return sfqy;
	}

	public void setSfqy(Integer sfqy) {
		this.sfqy = sfqy;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getHuowu() {
		return huowu;
	}

	public void setHuowu(String huowu) {
		this.huowu = huowu;
	}

	public Integer getFhfid() {
		return fhfid;
	}

	public void setFhfid(Integer fhfid) {
		this.fhfid = fhfid;
	}

	public Integer getShfid() {
		return shfid;
	}

	public void setShfid(Integer shfid) {
		this.shfid = shfid;
	}

	public String getZhanghao() {
		return zhanghao;
	}

	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public Tuoyundan mapRow(ResultSet rst, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Tuoyundan tuoyundan = new Tuoyundan();
		tuoyundan.setTyid(rst.getInt("tyid"));
		tuoyundan.setKdy(rst.getString("kdy"));
		tuoyundan.setPsy(rst.getString("psy"));

		tuoyundan.setShf(rst.getString("shf"));
		tuoyundan.setShflxr(rst.getString("shflxr"));
		tuoyundan.setShfdh(rst.getString("shfdh"));
		tuoyundan.setShfdz(rst.getString("shfdz"));
		tuoyundan.setShftype(rst.getString("shftype"));

		tuoyundan.setFhf(rst.getString("fhf"));
		tuoyundan.setFhflxr(rst.getString("fhflxr"));
		tuoyundan.setFhfdh(rst.getString("fhfdh"));
		tuoyundan.setFhfdz(rst.getString("fhfdz"));
		tuoyundan.setFhftype(rst.getString("fhftype"));

		tuoyundan.setKdwd(rst.getString("kdwd"));
		tuoyundan.setMdwd(rst.getString("mdwd"));
		tuoyundan.setXgwd(rst.getString("xgwd"));
		tuoyundan.setXlid(rst.getInt("xlid"));
		tuoyundan.setTydate(rst.getString("tydate"));
		tuoyundan.setTydh(rst.getString("tydh"));
		tuoyundan.setSfhd(rst.getString("sfhd"));
		tuoyundan.setDshk(rst.getString("dshk"));
		tuoyundan.setSxf(rst.getString("sxf"));
		tuoyundan.setQtfy(rst.getString("qtfy"));
		tuoyundan.setFyhj(rst.getString("fyhj"));
		tuoyundan.setJsfs(rst.getString("jsfs"));
		tuoyundan.setWljje(rst.getString("wljje"));
		tuoyundan.setSfsh(rst.getString("sfsh"));
		tuoyundan.setJianshu(rst.getString("jianshu"));
		tuoyundan.setYunfei(rst.getString("yunfei"));
		tuoyundan.setSfby(rst.getInt("sfby"));
		tuoyundan.setSfqy(rst.getInt("sfqy"));
		tuoyundan.setState(rst.getInt("state"));
		tuoyundan.setHuowu(rst.getString("huowu"));
		tuoyundan.setFhfid(rst.getInt("fhfid"));
		tuoyundan.setShfid(rst.getInt("shfid"));
		tuoyundan.setZhanghao(rst.getString("zhanghao"));
		tuoyundan.setRemark(rst.getString("remark"));

		return tuoyundan;

	}

}
