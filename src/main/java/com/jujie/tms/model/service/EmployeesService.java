package com.jujie.tms.model.service;

import java.util.List;

import com.jujie.tms.model.dao.EmployeesDAO;
import com.jujie.tms.model.utils.Page;
import com.jujie.tms.struts.bean.Employees;

public class EmployeesService {
	
	private EmployeesDAO employeesDAOSer;

	public void setEmployeesDAOSer(EmployeesDAO employeesDAOSer) {
		this.employeesDAOSer = employeesDAOSer;
	}

	public List<Employees> queryEmployeesList(Employees employees, Page page) throws Exception {
		Object[] objs = new Object[2];
		if (null != employees && !"".equals(employees)) {
			objs[0] = employees.getName().trim();
		}
		if (null != employees && !"".equals(employees)) {
			objs[1] = employees.getDept();
		}
		return employeesDAOSer.queryEmployeesList(objs, page);
	}

	public Employees findEmployeesByID(String id) throws Exception {
		return employeesDAOSer.findEmployeesByID(id);
	}

	
	
	public void modifyEmployees(Employees employees) throws Exception {
		if (null != employees.getEmpid()&& !"".equals(employees.getEmpid())) {
			employeesDAOSer.editEmployees(employees);
		} else {
			 employeesDAOSer.saveEmployees(employees);
		}
	}
	

	public void editEmployees(Employees employees) throws Exception {
		employeesDAOSer.editEmployees(employees);
	}

	public void deleteEmployeesByID(String id) throws Exception {
		employeesDAOSer.deleteEmployeesByID(id);
	}

}
