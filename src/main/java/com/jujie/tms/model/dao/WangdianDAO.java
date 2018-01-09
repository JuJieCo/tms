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
import com.jujie.tms.struts.bean.Wangdian;

public class WangdianDAO extends SpringJDBCTemplate{
	
	@SuppressWarnings("unchecked")
	public List<Wangdian> queryWangdianList(Object[] objs , Page page) throws Exception{
		String sql = "select * from wangdian where  1=1  ";
		List<Object> list = new ArrayList<Object>();
		if(objs!=null&&objs.length>0){
			if(objs.length>=1&&objs[0]!=null&&!"".equals(objs[0])){
				sql+=" and name like ? ";
				list.add("%" +objs[0] + "%" );
			}
		}
		sql += "  order by wdid desc";
		return this.getJdbcTemplate().query(PageUtil.fyPage(sql, list.toArray(), page, this.getJdbcTemplate(), Page.DATABASE_TYPE_MYSQL),list.toArray(), new Wangdian());
	}
	
	/**
	 *按id查询一条记录
	 */
	@SuppressWarnings("unchecked")
	public Wangdian findWangdianByID(String id) throws Exception{
		String sql = " select * from wangdian where wdid =" +id;
		List<Wangdian> wangdianList = this.getJdbcTemplate().query(sql, new Wangdian());
		if(wangdianList!=null&&wangdianList.size()>0){
			return wangdianList.get(0);
		}
		return null;
	}
	
	/**
	 *保存
	 */
	public int saveWangdian(Wangdian wangdian) throws Exception {
		final String sql = "insert into wangdian (name , bianhao , state , remark ) values (? , ? , ? , ?)";
		final Object[] objs = {wangdian.getName() , wangdian.getState() , wangdian.getRemark()};
		KeyHolder keyHolder = new GeneratedKeyHolder(); 
		try {
			this.getJdbcTemplate().update(new PreparedStatementCreator(){
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					int i = 0;
					int n = 0;
					PreparedStatement pst = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setString(++i, DataUtil.toString(objs[n++])); 
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
	public void editWangdian(Wangdian wangdian) throws Exception {
		String sql = " update wangdian set  name=?, bianhao=?, state=?, remark=? where wdid=? " ;
		Object[] objs =  {wangdian.getName() , wangdian.getBianhao() , wangdian.getState() , wangdian.getRemark() , wangdian.getWdid()};
		this.getJdbcTemplate().update(sql,objs);   
	}
	
	/**
	 *删除
	 */
	public void deleteWangdianByID(String id) throws Exception {
		String sql = " delete from wangdian where wdid="+id;
		this.getJdbcTemplate().update(sql);
	}
	

}
