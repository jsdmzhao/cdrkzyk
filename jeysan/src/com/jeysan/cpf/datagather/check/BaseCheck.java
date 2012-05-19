package com.jeysan.cpf.datagather.check;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jeysan.cpf.util.Constants;
import com.jeysan.modules.utils.sql.JdbcUtil;
import com.jeysan.modules.utils.sql.ResultSetUtil;


public abstract class BaseCheck {
	protected static final int BATCH_LIMIT = 500 ;
    protected Connection conn;
    private Map<String,String> villages = new HashMap<String,String>();
    public BaseCheck(Connection conn){	
    	this.conn = conn;
    }
    
    protected String getVillageCode(String name) throws Exception{
    	if(villages.isEmpty()){
    		ResultSet rs = null;
    		JdbcUtil jdbcUtil = new JdbcUtil(conn,false);
    		try {
    			rs = jdbcUtil.executePreparedStatementQuery("select CODE,NAME from FHP_DISTRICT_VILLAGE where PARENT_ID = ? order by id " , new Object[]{Constants.COMMON_PARAM.CURRENT_TOWN_ID});
    			while(rs.next()){
    				villages.put(rs.getString(2), rs.getString(1));
    			}
    		} catch (Exception e) {
    			throw new SQLException(e);
    		}finally{
    			jdbcUtil.closeDBConection();
    		}
    	}
    	if(!villages.containsKey(name)){
	    	if(name.contains("居委会"))
	    		name = name.replaceAll("居委会", "社区居委会");
			else
				name = name + "社区居委会";
    	}
    	if(villages.containsKey(name)){
    		return villages.get(name);
    	}
    	return name;
    }
    

	protected int getCount(String table) throws SQLException {
		ResultSet rs = null;
		JdbcUtil jdbcUtil = new JdbcUtil(conn,false);
		try {
			int count = 0;
			rs = jdbcUtil.executePreparedStatementQuery("select count(1) as c from " + table + " where check_type = 0 " , null);
			while(rs.next()){
				count = rs.getInt(1);
			}
			return count;
		} catch (Exception e) {
			throw new SQLException(e);
		}finally{
			jdbcUtil.closeDBConection();
		}
	}
	
	protected Long getCurrentId(String table) throws SQLException {
		JdbcUtil jdbcUtil = new JdbcUtil(conn,false);
		try {
			List<Object[]> rst = ResultSetUtil.toArrayList(jdbcUtil.executePreparedStatementQuery("select max(id) from " + table, null));
			return (Long)(rst.get(0)[0]);
		} catch (Exception e) {
			throw new SQLException(e);
		}finally{
			jdbcUtil.closeDBConection();
		}
	}
	

	/**
	 * 校验参数集的长度，并判断是否提交批处理事务
	 * @param jdbcUtil
	 * @param params
	 * @param sql
	 * @param inLoop
	 * @throws Exception
	 */
	protected void checkAndCommmitData(JdbcUtil jdbcUtil , List params , String sql , boolean inLoop) throws Exception{
		if((inLoop && params.size() >= BATCH_LIMIT) || (!inLoop && params.size() > 0) ){
			jdbcUtil.executeBatchPreparedStatementUpdate(sql, params);
			params.clear();
			conn.commit();
		}
	}
	
	protected List getData4Todo(String column , String table ,boolean update) throws SQLException{
		ResultSet rs = null;
		JdbcUtil jdbcUtil = null;
		try {
			jdbcUtil = new JdbcUtil(conn,false);
			rs = jdbcUtil.executePreparedStatementQuery(new StringBuilder().append("select ").append(column).append(" from " ).append( table ).append( " as a where a.check_type = ? and ").append((update?"":"not")).append(" exists (select 1 from FHP_PERSON as b where b.CODE = a.CODE)").toString(), new Object[]{0});
			return ResultSetUtil.toArrayList(rs);
		} catch (Exception e) {
			throw new SQLException(e);
		}finally{
			if(jdbcUtil != null){
				jdbcUtil.closeDBConection();
			}
		}
	}
	
	protected void updateStatus(String table , List params) throws SQLException {
		JdbcUtil jdbcUtil = new JdbcUtil(conn,false);
		try {
			jdbcUtil.executeBatchPreparedStatementUpdate("update " + table + " set check_type = 1 where id = ? ", params);
			conn.commit();
		} catch (Exception e) {
			throw new SQLException(e);
		}finally{
			jdbcUtil.closeDBConection();
		}
	}

	public abstract int getCount() throws SQLException;
	
	public abstract void run() throws SQLException;
	
}
