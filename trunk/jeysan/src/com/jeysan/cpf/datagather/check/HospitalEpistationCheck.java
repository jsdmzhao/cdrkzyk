package com.jeysan.cpf.datagather.check;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.sql.DataSource;

import org.apache.log4j.Logger;


public class HospitalEpistationCheck extends BaseCheck{
	
	private Logger logger = Logger.getLogger(HospitalEpistationCheck.class);
	
	private static final String TABLE_IN_DB = "TEMP_HOSPITAL_DATA_EPISTATION";
	/**字段*/
	private static final String COLUMN_IN_DB = "CHILD_CODE,FATHER,MOTHER,NAME,SEX,BIRTHDAY,DOMICILE_TYPE,TEL,OFFICE_TEL,MOBILE,ADDRESS,AREA,CREATE_DATE,MOTHER_COMPANY,FATHER_COMPANY,DOMICILE_ADDRESS,DOMICILE_UNIT,UNIT_BELONG,STANDARD,SETTLE_OUT_DATE,UPDATE_TIME";
	/**唯一标识 用于判断重复数据 重复数据不予导入*/
	private static final String UNIQUE = "CHILD_CODE";
	
	private static final SimpleDateFormat SDF = new SimpleDateFormat("mm/dd/yy hh:mm");
	
	public HospitalEpistationCheck(Connection conn){
		super(conn);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void run() throws SQLException{	
		try {
			logger.info("开始导入防疫站 电子数据......");
			StringBuffer sql = new StringBuffer();
			
			logger.info("成功导入防疫站 电子数据条数：" + getCount());
		} catch (Exception e) {		
			logger.error("导入防疫站 电子数据出错！" ,e);
			throw new RuntimeException(e.getMessage(),e);
		}
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getCount() throws SQLException {
		return super.getCount(TABLE_IN_DB);
	}
	
}
