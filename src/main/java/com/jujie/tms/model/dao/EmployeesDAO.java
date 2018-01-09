package com.jujie.tms.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.jujie.tms.model.utils.DataUtil;
import com.jujie.tms.model.utils.Page;
import com.jujie.tms.model.utils.PageUtil;
import com.jujie.tms.model.utils.SpringJDBCTemplate;
import com.jujie.tms.struts.bean.Employees;

public class EmployeesDAO extends SpringJDBCTemplate{
	
	@SuppressWarnings("unchecked")
	public List<Employees> queryEmployeesList(Object[] objs , Page page) throws Exception{
		String sql = "select * from employees where  1=1  ";
		List<Object> list = new ArrayList<Object>();
		if(objs!=null&&objs.length>0){
			if(objs.length>=1&&objs[0]!=null&&!"".equals(objs[0])){
				sql+=" and name like ? ";
				list.add("%" +objs[0] + "%" );
			}
			if(objs.length>=2&&objs[1]!=null&!"".equals(objs[1])){
				sql += " and dept=? ";
				list.add(objs[1]);
			}
		}
		sql += "  order by empid desc";
		return this.getJdbcTemplate().query(PageUtil.fyPage(sql, list.toArray(), page, this.getJdbcTemplate(), Page.DATABASE_TYPE_MYSQL),list.toArray(), new Employees());
	}
	
	/**
	 *按id查询一条记录
	 */
	@SuppressWarnings("unchecked")
	public Employees findEmployeesByID(String id) throws Exception{
		String sql = " select * from employees where empid =" +id;
		List<Employees> employeesList = this.getJdbcTemplate().query(sql, new Employees());
		if(employeesList!=null&&employeesList.size()>0){
			return employeesList.get(0);
		}
		return null;
	}
	
	/**
	 *保存
	 */
	public int saveEmployees(Employees employees) throws Exception {
		final String sql = "insert into employees (name , dept , state , remark ) values (? , ? , ? , ?)";
		final Object[] objs = {employees.getName() , employees.getDept() , employees.getState() , employees.getRemark()};
		KeyHolder keyHolder = new GeneratedKeyHolder(); 
		try {
			this.getJdbcTemplate().update(new PreparedStatementCreator(){
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					int i = 0;
					int n = 0;
					PreparedStatement pst = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setInt(++i, DataUtil.toInt(objs[n++]));
					pst.setInt(++i, DataUtil.toInt(objs[n++]));
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					return pst;
				}}, keyHolder);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return keyHolder.getKey().intValue();
	}
	
	/**
	 *修改
	 */
	public void editEmployees(Employees employees) throws Exception {
		String sql = " update employees set  name=?, dept=?, state=?,remark=? where empid=? " ;
		Object[] objs =  {employees.getName() , employees.getDept() , employees.getState() , employees.getRemark() , employees.getEmpid()};
		this.getJdbcTemplate().update(sql,objs);   
	}
	
	/**
	 *删除
	 */
	public void deleteEmployeesByID(String id) throws Exception {
		String sql = " delete from employees where empid="+id;
		this.getJdbcTemplate().update(sql);
	}
	

}
