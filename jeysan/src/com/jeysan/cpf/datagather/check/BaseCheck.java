package com.jeysan.cpf.datagather.check;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.jeysan.modules.utils.sql.JdbcUtil;
import com.jeysan.modules.utils.sql.ResultSetUtil;


public abstract class BaseCheck {
	protected static final int BATCH_LIMIT = 500 ;
    protected Connection conn;
    
    public BaseCheck(Connection conn){	
    	this.conn = conn;
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
