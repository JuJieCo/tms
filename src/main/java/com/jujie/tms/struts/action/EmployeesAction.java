package com.jujie.tms.struts.action;

import java.util.List;

import com.jujie.tms.model.service.EmployeesService;
import com.jujie.tms.model.utils.BaseActionSupper;
import com.jujie.tms.model.utils.Page;
import com.jujie.tms.struts.bean.Employees;

public class EmployeesAction  extends BaseActionSupper{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String s_token;
	private Page page;
	private Employees employees;
	private List<Employees> employeesList;
	public String getS_token() {
		return s_token;
	}
	public void setS_token(String s_token) {
		this.s_token = s_token;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public Employees getEmployees() {
		return employees;
	}
	public void setEmployees(Employees employees) {
		this.employees = employees;
	}
	public List<Employees> getEmployeesList() {
		return employeesList;
	}
	public void setEmployeesList(List<Employees> employeesList) {
		this.employeesList = employeesList;
	}
	
	
	
	public String  queryEmployeesList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		EmployeesService employeesService = (EmployeesService) this.getService("employeesService");
		employeesList = employeesService.queryEmployeesList(employees, page);
		return "list";
	}
	
	// 到新增或修改页面
	public String findEmployeesForModify() throws Exception {
		EmployeesService employeesService = (EmployeesService) this.getService("employeesService");
		String modify = request.getParameter("modify");
		if (null != modify && "save".equals(modify)) {
			employees = new Employees();
		} else if (null != modify && "update".equals(modify)) {
			String empid = request.getParameter("empid");
			employees = employeesService.findEmployeesByID(empid);
		}
		return "modify";
	}
	
	// 新增或修改
	public String modifyEmployees() throws Exception {
		EmployeesService employeesService = (EmployeesService) this.getService("employeesService");
		if (null != employees) {
			employeesService.modifyEmployees(employees);
		}
		return this.queryEmployeesList();
	}
	
	// 到查看页面
	public String findEmployeesForShow() throws Exception {
		EmployeesService employeesService = (EmployeesService) this.getService("employeesService");
		String empid = request.getParameter("empid");
		employees = employeesService.findEmployeesByID(empid);
		return "show";
	}
	
	// 删除
	public String deleteEmployeesByID() throws Exception {
		EmployeesService employeesService = (EmployeesService) this.getService("employeesService");
		String empid = request.getParameter("empid");
		employeesService.deleteEmployeesByID(empid);
		return this.queryEmployeesList();
	}

}
