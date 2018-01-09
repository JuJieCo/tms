package com.jujie.tms.model.utils;

import java.sql.ResultSet;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public abstract class  BaseBean implements RowMapper{
	
	public abstract Object mapRow(ResultSet rst, int rowNum) throws java.sql.SQLException ;

}
