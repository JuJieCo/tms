package com.jujie.tms.struts.bean;



import java.sql.ResultSet;
import java.sql.SQLException;

import com.jujie.tms.model.utils.BaseBean;

public class Employees extends BaseBean {

	private Integer empid;
	private String name;
	private Integer dept; // 韬唤(寮�鍗曞憳,閰嶉�佸憳,鍙栬揣鍛�,鎿嶇洏鎵�)
	private Integer state;
	private String remark;

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDept() {
		return dept;
	}

	public void setDept(Integer dept) {
		this.dept = dept;
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
	public Employees mapRow(ResultSet rst, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Employees emp = new Employees();
		emp.setEmpid(rst.getInt("empid"));
		emp.setName(rst.getString("name"));
		emp.setDept(rst.getInt("dept"));
		emp.setState(rst.getInt("state"));
		emp.setRemark(rst.getString("remark"));
		return emp;
	}

}
