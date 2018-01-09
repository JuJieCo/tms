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
import com.jujie.tms.struts.bean.Kehu;
import com.jujie.tms.struts.bean.KehuHistory;

public class KehuDAO  extends SpringJDBCTemplate{
	
	
	@SuppressWarnings("unchecked")
	public List<Kehu> queryKehuList(Object[] objs , Page page) throws Exception{
		String sql = "select * from kehu where  1=1  ";
		List<Object> list = new ArrayList<Object>();
		if(objs!=null&&objs.length>0){
			if(objs.length>=1&&objs[0]!=null&&!"".equals(objs[0])){
				sql+=" and name like ? ";
				list.add("%" +objs[0] + "%" );
			}
			if(objs.length>=2&&objs[1]!=null&!"".equals(objs[1])){
				sql += " and type=? ";
				list.add(objs[1]);
			}
			if(objs.length>=2&&objs[2]!=null&!"".equals(objs[2])){
				sql += " and sfqy=? ";
				list.add(objs[2]);
			}
		}
		sql += "  order by khid desc";
		return this.getJdbcTemplate().query(PageUtil.fyPage(sql, list.toArray(), page, this.getJdbcTemplate(), Page.DATABASE_TYPE_MYSQL),list.toArray(), new Kehu());
	}

	
	/**
	 *按id查询一条记录
	 */
	@SuppressWarnings("unchecked")
	public Kehu findKehuByID(String id) throws Exception{
		String sql = " select * from kehu where khid =" +id;
		List<Kehu> kehuList = this.getJdbcTemplate().query(sql, new Kehu());
		if(kehuList!=null&&kehuList.size()>0){
			return kehuList.get(0);
		}
		return null;
	}
	
	/**
	 *保存
	 */
	public int saveKehu(Kehu kehu) throws Exception {
		final String sql = "insert into kehu (xlid,type,khbh,name,lxr,lxdh,xxdz,zhanghao,sfqy,sdate,edate,state,remark) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		final Object[] objs = {kehu.getXianlu().getXlid(),kehu.getType(),kehu.getKhbh(),kehu.getName(),kehu.getLxr(),kehu.getLxdh(),kehu.getXxdz(),kehu.getZhanghao(),
				kehu.getSfqy(),kehu.getSdate(),kehu.getEdate(),kehu.getState(),kehu.getRemark()};
		KeyHolder keyHolder = new GeneratedKeyHolder(); 
		try {
			this.getJdbcTemplate().update(new PreparedStatementCreator(){
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					int i = 0;
					int n = 0;
					PreparedStatement pst = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
					pst.setInt(++i, DataUtil.toInt(objs[n++]));
					pst.setInt(++i, DataUtil.toInt(objs[n++]));
					
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					
					pst.setInt(++i, DataUtil.toInt(objs[n++]));
					
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					
					pst.setString(++i, DataUtil.toString(objs[n++])); 
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
	public void editKehu(Kehu kehu) throws Exception {
		String sql = " update kehu set  xlid=?, type=?,khbh=?,name=?,lxr=?,lxdh=?,xxdz=?,zhanghao=?,sfqy=?,sdate=?,edate=?,state=?,remark=? where khid=? " ;
		Object[] objs =  {kehu.getXianlu().getXlid(),kehu.getType(),kehu.getKhbh(),kehu.getName(),kehu.getLxr(),kehu.getLxdh(),kehu.getXxdz(),kehu.getZhanghao(),
				kehu.getSfqy(),kehu.getSdate(),kehu.getEdate(),kehu.getState(),kehu.getRemark(),kehu.getKhid()};
		this.getJdbcTemplate().update(sql,objs);   
	}
	
	/**
	 *删除
	 */
	public void deleteKehuByID(String id) throws Exception {
		String sql = " delete from kehu where khid="+id;
		this.getJdbcTemplate().update(sql);
	}
	
	
	
	
	/**
	 * 新增签约包月记录表
	 */
	public int saveKehuHistory(KehuHistory kehuH) throws Exception {
		final String sql = "insert into kehu_history (khid, name , type , sdate , edate,remark) values (?,?,?,?,?,?)";
		final Object[] objs = {kehuH.getKhid(),kehuH.getName(),kehuH.getType(),kehuH.getSdate(),kehuH.getEdate() ,kehuH.getRemark()};
		KeyHolder keyHolder = new GeneratedKeyHolder(); 
		try {
			this.getJdbcTemplate().update(new PreparedStatementCreator(){
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					int i = 0;
					int n = 0;
					PreparedStatement pst = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			 
					pst.setInt(++i, DataUtil.toInt(objs[n++]));
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setInt(++i, DataUtil.toInt(objs[n++]));
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					return pst;
				}}, keyHolder);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return keyHolder.getKey().intValue();
	}
	
	//查历史记录
	@SuppressWarnings("unchecked")
	public List<KehuHistory> queryKehuHistoryList(String khid) throws Exception{
		String sql = "select * from kehu_history where  khid="+khid;
	
		return this.getJdbcTemplate().query(sql, new KehuHistory());
	}
	
	//自动补全
	@SuppressWarnings("unchecked")
	public List<Kehu> queryKehuListAuto(String q) throws Exception {
		final String sql = "select * from kehu where 1=1 and name like '%"+q+"%'   order by khid desc";
		
		List<Kehu> kehuList = new ArrayList<Kehu>();
		kehuList = this.getJdbcTemplate().query(sql,new Kehu());
		return kehuList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Kehu> queryKehuListAutol(String q) throws Exception {
		final String sql = "select * from kehu where 1=1 and lxdh like '%"+q+"%'   order by khid desc";
		
		List<Kehu> kehuList = new ArrayList<Kehu>();
		kehuList = this.getJdbcTemplate().query(sql,new Kehu());
		return kehuList;
	}
	
	
	//查是有存在这个客户的名称
	@SuppressWarnings("unchecked")
	public List<Kehu> queryKehuName(String name) throws Exception {
		final String sql = "select * from kehu where 1=1 and name = '"+name+"'";
		
		List<Kehu> kehuList = new ArrayList<Kehu>();
		kehuList = this.getJdbcTemplate().query(sql,new Kehu());
		return kehuList;
	}

}
