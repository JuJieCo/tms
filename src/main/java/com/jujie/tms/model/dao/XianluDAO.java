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
import com.jujie.tms.struts.bean.Xianlu;

public class XianluDAO  extends SpringJDBCTemplate{
	
	@SuppressWarnings("unchecked")
	public List<Xianlu> queryXianluList(Object[] objs , Page page) throws Exception{
		String sql = "select * from xianlu where  1=1  ";
		List<Object> list = new ArrayList<Object>();
		if(objs!=null&&objs.length>0){
			if(objs.length>=1&&objs[0]!=null&&!"".equals(objs[0])){
				sql+=" and name like ? ";
				list.add("%" +objs[0] + "%" );
			}
		}
		sql += "  and xlid <> 0  order by xlid desc";
		return this.getJdbcTemplate().query(PageUtil.fyPage(sql, list.toArray(), page, this.getJdbcTemplate(), Page.DATABASE_TYPE_MYSQL),list.toArray(), new Xianlu());
	}
	
	/**
	 *按id查询一条记录
	 */
	@SuppressWarnings("unchecked")
	public Xianlu findXianluByID(String id) throws Exception{
		String sql = " select * from xianlu where xlid =" +id;
		List<Xianlu> xianluList = this.getJdbcTemplate().query(sql, new Xianlu());
		if(xianluList!=null&&xianluList.size()>0){
			return xianluList.get(0);
		}
		return null;
	}
	
	/**
	 *保存
	 */
	public int saveXianlu(Xianlu xianlu) throws Exception {
		final String sql = "insert into xianlu (name , state , remark ) values (? , ? , ?)";
		final Object[] objs = {xianlu.getName() , xianlu.getState() , xianlu.getRemark()};
		KeyHolder keyHolder = new GeneratedKeyHolder(); 
		try {
			this.getJdbcTemplate().update(new PreparedStatementCreator(){
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					int i = 0;
					int n = 0;
					PreparedStatement pst = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
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
	public void editXianlu(Xianlu xianlu) throws Exception {
		String sql = " update xianlu set  name=?, state=?,remark=? where xlid=? " ;
		Object[] objs =  {xianlu.getName() , xianlu.getState() , xianlu.getRemark() , xianlu.getXlid()};
		this.getJdbcTemplate().update(sql,objs);   
	}
	
	/**
	 *删除
	 */
	public void deleteXianluByID(String id) throws Exception {
		String sql = " delete from xianlu where xlid="+id;
		this.getJdbcTemplate().update(sql);
	}
	

}
