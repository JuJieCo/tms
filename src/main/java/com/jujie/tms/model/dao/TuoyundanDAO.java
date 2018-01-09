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
import com.jujie.tms.struts.bean.Tuoyundan;

public class TuoyundanDAO extends SpringJDBCTemplate {
	
	
	
	@SuppressWarnings("unchecked")
	public List<Tuoyundan> queryTuoyundanList(Object[] objs , Page page , String btime , String etime) throws Exception{
		String sql = "select * from tuoyundan where 1=1 ";
		List<Object> list = new ArrayList<Object>();
		
		//sql +="  and tydate BETWEEN '"+btime+" 00:00:00' AND  '"+etime+" 24:60:60' ";
		sql +="  and tydate BETWEEN '"+btime+"' AND '" + etime +"'";
		
		if(objs!=null&&objs.length>0){
			if(objs.length>=1&&objs[0]!=null&&!"".equals(objs[0])){
				sql+=" and tydh=? ";
				list.add(objs[0]);	
			}
			if(objs.length>=1&&objs[1]!=null&&!"".equals(objs[1])){
				sql+=" and fhf like ?";
				list.add("%" +objs[1] + "%" );
			}
			if(objs.length>=1&&objs[2]!=null&&!"".equals(objs[2])){
				sql+=" and shf like ?";
				list.add("%" +objs[2] + "%" );
			}
			if(objs.length>=1&&objs[3]!=null&&!"".equals(objs[3])){
				sql+=" and state=? ";
				list.add(objs[3]);	
			}
			if(objs.length>=1&&objs[4]!=null&&!"".equals(objs[4])){
				sql+=" and xlid=? ";
				list.add(objs[4]);	
			}
		}
		sql += " order by tyid desc";
	
		return this.getJdbcTemplate().query(PageUtil.fyPage(sql, list.toArray(), page, this.getJdbcTemplate(), Page.DATABASE_TYPE_MYSQL),list.toArray(), new Tuoyundan());
	}
	

	

	public int saveTuoyundan(Tuoyundan tuoyundan) throws Exception {
		final String sql = "insert into tuoyundan ( kdy,psy,shf,shflxr,shfdh,shfdz,shftype,fhf,fhflxr,fhfdh,fhfdz,fhftype,"
				+ "kdwd,mdwd,xgwd,xlid,tydate,tydh,sfhd,dshk,sxf,qtfy,fyhj,jsfs,wljje,sfsh,jianshu,yunfei,sfby,sfqy,state,huowu,fhfid,shfid,zhanghao,remark"
				+ " ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		final Object[] objs = {tuoyundan.getKdy(),tuoyundan.getPsy(),tuoyundan.getShf(),tuoyundan.getShflxr(),tuoyundan.getShfdh(),tuoyundan.getShfdz(),
				tuoyundan.getShftype(),tuoyundan.getFhf(),tuoyundan.getFhflxr(),tuoyundan.getFhfdh(),tuoyundan.getFhfdz(),tuoyundan.getFhftype(),
				tuoyundan.getKdwd(),tuoyundan.getMdwd(),tuoyundan.getXgwd(),tuoyundan.getXlid(),tuoyundan.getTydate(),tuoyundan.getTydh(),
				tuoyundan.getSfhd(),tuoyundan.getDshk(),tuoyundan.getSxf(),tuoyundan.getQtfy(),tuoyundan.getFyhj(),tuoyundan.getJsfs(),tuoyundan.getWljje(),
				tuoyundan.getSfsh(),tuoyundan.getJianshu(),tuoyundan.getYunfei(),tuoyundan.getSfby(),tuoyundan.getSfqy(),tuoyundan.getState(),
				tuoyundan.getHuowu(),tuoyundan.getFhfid(),tuoyundan.getShfid(),tuoyundan.getZhanghao(),tuoyundan.getRemark()};
		KeyHolder keyHolder = new GeneratedKeyHolder(); 
		try {
			this.getJdbcTemplate().update(new PreparedStatementCreator(){
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					int i = 0;
					int n = 0;
					PreparedStatement pst = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setString(++i, DataUtil.toString(objs[n++])); 
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
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					
					
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setInt(++i, DataUtil.toInt(objs[n++])); 
					pst.setInt(++i, DataUtil.toInt(objs[n++])); 
					pst.setInt(++i, DataUtil.toInt(objs[n++])); 
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setInt(++i, DataUtil.toInt(objs[n++])); 
					pst.setInt(++i, DataUtil.toInt(objs[n++])); 
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
	public void editTuoyundan(Tuoyundan tuoyundan) throws Exception {
		String sql = " update tuoyundan set  kdy=?,psy=?,shf=?,shflxr=?,shfdh=?,shfdz=?,shftype=?,fhf=?,fhflxr=?,fhfdh=?,fhfdz=?,fhftype=?,"
				+ " kdwd=?,mdwd=?,xgwd=?,xlid=?,tydate=?,tydh=?,sfhd=?,dshk=?,sxf=?,qtfy=?,fyhj=?,jsfs=?,wljje=?,sfsh=?,jianshu=?,yunfei=?,"
				+ " sfby=?,sfqy=?,state=?,huowu=?,zhanghao=?,remark=? where tyid=?" ;
		Object[] objs =  {tuoyundan.getKdy(),tuoyundan.getPsy(),tuoyundan.getShf(),tuoyundan.getShflxr(),tuoyundan.getShfdh(),tuoyundan.getShfdz(),
				tuoyundan.getShftype(),tuoyundan.getFhf(),tuoyundan.getFhflxr(),tuoyundan.getFhfdh(),tuoyundan.getFhfdz(),tuoyundan.getFhftype(),
				tuoyundan.getKdwd(),tuoyundan.getMdwd(),tuoyundan.getXgwd(),tuoyundan.getXlid(),tuoyundan.getTydate(),tuoyundan.getTydh(),
				tuoyundan.getSfhd(),tuoyundan.getDshk(),tuoyundan.getSxf(),tuoyundan.getQtfy(),tuoyundan.getFyhj(),tuoyundan.getJsfs(),tuoyundan.getWljje(),
				tuoyundan.getSfsh(),tuoyundan.getJianshu(),tuoyundan.getYunfei(),tuoyundan.getSfby(),tuoyundan.getSfqy(),tuoyundan.getState(),
				tuoyundan.getHuowu(),tuoyundan.getZhanghao(),tuoyundan.getRemark(),tuoyundan.getTyid()};
		this.getJdbcTemplate().update(sql,objs);   
	}
	
	
	@SuppressWarnings("unchecked")
	public Tuoyundan findTuoyundanByID(int id) throws Exception {
		String sql = "  select *  from tuoyundan where tyid="+id;
		List<Tuoyundan> tuoyundanList = this.getJdbcTemplate().query(sql,new Tuoyundan());
		if(tuoyundanList!=null&&tuoyundanList.size()>0){
			return tuoyundanList.get(0);
		}
		return null;
	}
	
	public void deleteTuoyundanByID(int id) throws Exception {
			String sql = "update tuoyundan set state ='1' where tyid="+id;
			this.getJdbcTemplate().update(sql);   
		}
	
	
///////统计/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@SuppressWarnings("unchecked")
	public List<Tuoyundan> queryTuoyundanForCount(Object[] objs , String btime , String etime , String danshu) throws Exception{
		String sql = "select * from tuoyundan where 1=1 ";
		List<Object> list = new ArrayList<Object>();
		
		if(null!=btime&&!"".equals(btime)&&null!=etime&&!"".equals(etime)){
			//sql +="  and tydate BETWEEN '"+btime+" 00:00:00' AND  '"+etime+" 24:60:60' ";
			sql +="  and tydate BETWEEN '"+btime+"' AND '" + etime +"'";
		}
		if(objs!=null&&objs.length>0){
			if(objs.length>=1&&objs[0]!=null&&!"".equals(objs[0])){
				sql+=" and tydh=? ";
				list.add(objs[0]);	
			}
			if(objs.length>=1&&objs[1]!=null&&!"".equals(objs[1])){
				sql+=" and fhf like ?";
				list.add("%" +objs[1] + "%" );
			}
			if(objs.length>=1&&objs[2]!=null&&!"".equals(objs[2])){
				sql+=" and shf like ?";
				list.add("%" +objs[2] + "%" );
			}
			if(objs.length>=1&&objs[3]!=null&&!"".equals(objs[3])){
				sql+=" and state=? ";
				list.add(objs[3]);	
			}
			if(objs.length>=1&&objs[4]!=null&&!"".equals(objs[4])){
				sql+=" and xlid=? ";
				list.add(objs[4]);	
			}
		}
		sql += " order by tyid desc";
		
		if(null!=danshu&&!"".equals(danshu)){
			sql += " LIMIT " + danshu;
		}
		return this.getJdbcTemplate().query(sql, list.toArray(),  new Tuoyundan());
	}
	
///////导出/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//托运时间(分) 发货方名称/电话/账号 收货方名称/电话 件数 运费 代收 是否签约/包月 线路 网点
		@SuppressWarnings("unchecked")
		public List<Tuoyundan> exportExcel(Object[] objs , String btime , String etime , String danshu) throws Exception{
			String sql = "select *  from tuoyundan where 1=1 ";
			List<Object> list = new ArrayList<Object>();
			
			if(null!=btime&&!"".equals(btime)&&null!=etime&&!"".equals(etime)){
				//sql +="  and tydate BETWEEN '"+btime+" 00:00:00' AND  '"+etime+" 24:60:60' ";
				sql +="  and tydate BETWEEN '"+btime+"' AND '" + etime +"'";
			}
			if(objs!=null&&objs.length>0){
				if(objs.length>=1&&objs[0]!=null&&!"".equals(objs[0])){
					sql+=" and tydh=? ";
					list.add(objs[0]);	
				}
				if(objs.length>=1&&objs[1]!=null&&!"".equals(objs[1])){
					sql+=" and fhf like ?";
					list.add("%" +objs[1] + "%" );
				}
				if(objs.length>=1&&objs[2]!=null&&!"".equals(objs[2])){
					sql+=" and shf like ?";
					list.add("%" +objs[2] + "%" );
				}
				if(objs.length>=1&&objs[3]!=null&&!"".equals(objs[3])){
					sql+=" and state=? ";
					list.add(objs[3]);	
				}
				if(objs.length>=1&&objs[4]!=null&&!"".equals(objs[4])){
					sql+=" and xlid=? ";
					list.add(objs[4]);	
				}
			}
			sql += " order by tyid desc";
			
			if(null!=danshu&&!"".equals(danshu)){
				sql += " LIMIT " + danshu;
			}
			return this.getJdbcTemplate().query(sql, list.toArray(),  new Tuoyundan());
		}
}
