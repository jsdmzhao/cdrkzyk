package com.jeysan.cpf.datagather.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.stereotype.Component;

import com.jeysan.cpf.datagather.build.DataImportFactory;
import com.jeysan.cpf.datagather.check.BaseCheck;
import com.jeysan.cpf.datagather.check.CivilMarryRegCheck;
import com.jeysan.cpf.datagather.check.CompanyBcsCheck;
import com.jeysan.cpf.datagather.check.GmccCheck;
import com.jeysan.cpf.datagather.check.HospitalBirthCheck;
import com.jeysan.cpf.datagather.check.HospitalEpipreCheck;
import com.jeysan.cpf.datagather.check.HospitalEpistationCheck;
import com.jeysan.cpf.datagather.check.HospitalFouropsCheck;
import com.jeysan.cpf.datagather.check.HospitalPregtestCheck;
import com.jeysan.cpf.datagather.check.PolicyBabyCheck;
import com.jeysan.cpf.datagather.check.PolicyDeathCheck;
import com.jeysan.cpf.datagather.check.PolicySettleInCheck;
import com.jeysan.cpf.datagather.dao.BasicDataInDao;

/**
 * 
 * @author gemstone
 *
 */
@Component
public class DataCheckManager {
	private static final Class[] CLAZZ_LST = new Class[]{
		PolicyBabyCheck.class,PolicySettleInCheck.class,PolicyDeathCheck.class,
		CivilMarryRegCheck.class,HospitalBirthCheck.class,HospitalFouropsCheck.class,HospitalPregtestCheck.class,HospitalEpipreCheck.class,
		GmccCheck.class,
		CompanyBcsCheck.class,
		HospitalEpistationCheck.class
	};
	
	@Autowired
	private BasicDataInDao dataCollectDao;
	
	private Connection getConnection() throws Exception{
		return SessionFactoryUtils.getDataSource(dataCollectDao.getSessionFactory()).getConnection();
	}
	
	public Map getNewDataCount() throws SQLException{
		Connection conn = null;
		try{
			conn = getConnection();
			Map count_map = new HashMap();
			for(int i=0;i<CLAZZ_LST.length;i++){
				count_map.put("s"+i, getCount(conn,CLAZZ_LST[i]));
			}
			return count_map;
		}catch(Exception e){
			e.printStackTrace();
			throw new SQLException(e);
		}finally{
			if(conn != null){
				conn.close();
				conn = null;
			}
		}
	}
	
	public void checkPolicyData()throws SQLException{
		Connection conn = null;
		try{
			conn = getConnection();
			checkPolicyData(conn);
		}catch(Exception e){
			e.printStackTrace();
			throw new SQLException(e);
		}finally{
			if(conn != null){
				conn.close();
				conn = null;
			}
		}
	}
	
	private void checkPolicyData(Connection conn)throws SQLException{
		
		try{
			/**公安部门 婴儿出生入户数据*/
			checkData(conn,PolicyBabyCheck.class);
			/**公安部门 珠海市外/市内迁入数据*/
			checkData(conn,PolicySettleInCheck.class);
			/**公安部门 死亡人口情况 数据*/
			checkData(conn,PolicyDeathCheck.class);
		}catch(Exception e){
			throw new SQLException(e);
		}
	}
	
	public void checkCivilData()throws SQLException{
		Connection conn = null;
		try{
			conn = getConnection();
			checkCivilData(conn);
		}catch(Exception e){
			e.printStackTrace();
			throw new SQLException(e);
		}finally{
			if(conn != null){
				conn.close();
				conn = null;
			}
		}
	}
	
	private void checkCivilData(Connection conn)throws SQLException{
		/**民政部门数据*/
		checkData(conn,CivilMarryRegCheck.class);
		
	}
	
	public void checkHospitalData()throws SQLException{
		Connection conn = null;
		try{
			conn = getConnection();
			checkHospitalData(conn);
		}catch(Exception e){
			e.printStackTrace();
			throw new SQLException(e);
		}finally{
			if(conn != null){
				conn.close();
				conn = null;
			}
		}
	}
	
	private void checkHospitalData(Connection conn)throws SQLException{
		/**医院 妇产科出生登记数据*/
		checkData(conn,HospitalBirthCheck.class);
		/**医院 四术落实登记数据*/
		checkData(conn,HospitalFouropsCheck.class);
		/**医院 孕前检查登记数据*/
		checkData(conn,HospitalPregtestCheck.class);
		/**医院 防疫登记数据*/
		checkData(conn,HospitalEpipreCheck.class);
	}
	
	public void checkGmccData()throws SQLException{
		Connection conn = null;
		try{
			conn = getConnection();
			checkGmccData(conn);
		}catch(Exception e){
			e.printStackTrace();
			throw new SQLException(e);
		}finally{
			if(conn != null){
				conn.close();
				conn = null;
			}
		}
	}
	
	private void checkGmccData(Connection conn)throws SQLException{
		/**社保 社会保险项目数据*/
		checkData(conn,GmccCheck.class);
	}
	
	public void checkCompanyDataBcs()throws SQLException{
		Connection conn = null;
		try{
			conn = getConnection();
			checkCompanyDataBcs(conn);
		}catch(Exception e){
			e.printStackTrace();
			throw new SQLException(e);
		}finally{
			if(conn != null){
				conn.close();
				conn = null;
			}
		}
	}
	
	private void checkCompanyDataBcs(Connection conn)throws SQLException{
		/**企业 人员计划生育数据*/
		checkData(conn,CompanyBcsCheck.class);
	}
	
	public void checkEpistationData()throws SQLException{
		Connection conn = null;
		try{
			conn = getConnection();
			checkEpistationData(conn);
		}catch(Exception e){
			e.printStackTrace();
			throw new SQLException(e);
		}finally{
			if(conn != null){
				conn.close();
				conn = null;
			}
		}
	}
	
	private void checkEpistationData(Connection conn)throws SQLException{
		/**防疫站 电子数据*/
		checkData(conn,HospitalEpistationCheck.class);
	}
	
	
	@SuppressWarnings("unchecked")
	private void checkData(Connection conn ,Class clazz)throws SQLException{
		BaseCheck bit = DataImportFactory.getCheckInstance(conn,clazz);
		bit.run();
	}
	
	@SuppressWarnings("unchecked")
	private Integer getCount(Connection conn , Class clazz)throws SQLException{	
		BaseCheck bit = DataImportFactory.getCheckInstance(conn,clazz);
		return bit.getCount();
	}

	
}