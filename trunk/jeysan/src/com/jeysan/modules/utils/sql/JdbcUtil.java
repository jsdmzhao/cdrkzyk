package com.jeysan.modules.utils.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class JdbcUtil {
	private Log logger=LogFactory.getLog(getClass());
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private boolean need2CloseConn = false;
	public JdbcUtil(Connection conn , boolean need2CloseConn){
		this.conn = conn;
		this.need2CloseConn = need2CloseConn;
	}


	/**
	 * 使用PreparedStatement执行查询SQL语句(带参数)
	 * @param sql String 要执行的SQL语句
	 * @param paras Object[] SQL参数列表
	 * @throws Exception
	 * @return ResultSet 查询结果集
	 */
	public ResultSet executePreparedStatementQuery(String sql, Object paras[]) throws Exception {
		try {
			pstmt = conn.prepareStatement(sql);
			this.setPreparedStatementParas(pstmt, paras);
			rs = pstmt.executeQuery();
			return rs;
		} catch (SQLException ex) {
			throw new Exception("** Error in executeQuery():" + ex.getMessage()+ "**", ex);
		}
	}

	/**
	 * 使用执行更新SQL语句(带参数)
	 * @param sql String 要执行的SQL语句
	 * @param paras Object[] SQL参数列表
	 * @throws Exception
	 */
	public void executePreparedStatementUpdate(String sql, Object[] paras) throws Exception {
		try {
			pstmt = conn.prepareStatement(sql);
			this.setPreparedStatementParas(pstmt, paras);
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			throw new Exception("** Error in executeUpdate():"+ ex.getMessage() + "**", ex);
		}
	}
	
	/**
	 * 批量执行更新SQL语句(带参数)
	 * @param sql String 要执行的SQL语句
	 * @throws Exception
	 */
	public int[] executeBatchPreparedStatementUpdate(String sql,List<Object[]> params) throws Exception {
		try {
			pstmt = conn.prepareStatement(sql);
			for(Object[] param:params){
				if(param == null)
					continue;
				for(int i=0;i<param.length;i++){
					pstmt.setObject(i+1, param[i]);
				}
				pstmt.addBatch();
			}
			return pstmt.executeBatch();
		} catch (SQLException ex) {
			throw new Exception("** Error in executeBatchPreparedStatementUpdate():"+ ex.getMessage() + "**", ex);
		}
	}

	/**
	 * 实现Object数组表示的参数列表和SQL语句中的"?"绑定
	 * @param pstmt PreparedStatement
	 * @param paras Object[]
	 * @throws SQLException
	 */
	private void setPreparedStatementParas(PreparedStatement pstmt,Object[] paras) throws SQLException {
		if (paras != null && paras.length > 0) {
			for (int i = 0; i < paras.length; i++) {
				if (paras[i] == null) {
					// 注意，SQL不支持java.sql.Types.NULL，所以使用java.sql.Types.VARCHAR代替
					pstmt.setNull(i + 1, java.sql.Types.VARCHAR);
				} else {
					// begin from index 1
					pstmt.setObject(i + 1, paras[i]);
				}
			}
		}
	}
	/**
	 * 关闭连接
	 */
	public void closeDBConection() {
		try {
			if(rs!=null){
				rs.close();
				rs = null;
			}
			if(pstmt!=null){
				pstmt.close();
				pstmt = null;
			}

			if(need2CloseConn && conn!=null){
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
