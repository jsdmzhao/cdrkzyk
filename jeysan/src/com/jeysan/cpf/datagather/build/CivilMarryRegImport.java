package com.jeysan.cpf.datagather.build;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.hibernate.tool.hbm2x.StringUtils;

import com.jeysan.modules.utils.date.DateUtil;


public class CivilMarryRegImport extends BaseImport{
	
	private Logger logger = Logger.getLogger(CivilMarryRegImport.class);
	
	private static final String TABLE_IN_DB = "TEMP_CIVIL_DATA_MARRY_REG";
	/**字段*/
	private static final String COLUMN_IN_DB = "REG_DATE,CODE,NAME,BIRTHDAY,MARRY_TYPE,MARRY_STATUS,HOUSEHODE,CODE2,NAME2,BIRTHDAY2,DEGREE,MARRY_TYPE2,MARRY_STATUS2,HOUSEHODE2,UPDATE_TIME";
	/**唯一标识 用于判断重复数据 重复数据不予导入*/
	private static final String UNIQUE = "CODE";
	
	
	public CivilMarryRegImport(DataSource dataSource){
		super(dataSource);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int run(Collection datas) throws SQLException{	
		try {
			logger.info("开始导入民政部门 结婚登记数据......");
			StringBuffer sql = new StringBuffer();
			sql.append("insert into ")
			.append(TABLE_IN_DB)
			.append("(")
			.append(COLUMN_IN_DB)
			.append(") select ?,?,?,?,?,?,?,?,?,?,?,?,?,?,? from dual where not exists")
			.append("(select id from ")
			.append(TABLE_IN_DB)
			.append(" where ")
			.append(UNIQUE)
			.append(" = ? )");
			
			conn = dataSource.getConnection();
			PreparedStatement psmt = conn.prepareStatement(sql.toString());
			Object[] colValue = null;
			int i = 0;
			for(Object o : datas){
				i++;
				/**忽略行数*/
				if(i <= 2) continue;
				colValue = (Object[])o;
				psmt.setObject(1,colValue[1]);
				psmt.setObject(2,colValue[2]);
				psmt.setObject(3,colValue[3]);
				psmt.setObject(4,colValue[4]);
				psmt.setObject(5,colValue[5]);
				psmt.setObject(6,colValue[6]);
				psmt.setObject(7,colValue[7]);
				psmt.setObject(8,colValue[8]);
				psmt.setObject(9,colValue[9]);
				psmt.setObject(10,colValue[10]);
				psmt.setObject(11,colValue[11]);
				psmt.setObject(12,colValue[12]);
				psmt.setObject(13,colValue[13]);
				psmt.setObject(14,colValue[14]);
				psmt.setObject(15,new Date());
				psmt.setObject(16,colValue[2]);
				psmt.addBatch();
			}
			int[] result = psmt.executeBatch();
			conn.commit();
			logger.info("成功导入民政部门 结婚登记数据条数：" + getCount(result));
			return getCount(result);
		} catch (SQLException e) {		
			logger.error("导入民政部门 结婚登记数据出错！" ,e);
			throw e;
		}finally{
			if(conn != null) conn.close();
		}
		
	}
	
	private String translateDateValue(String dateStr){
		if(StringUtils.isEmpty(dateStr))
			return null;
		String[] datetimes = dateStr.split(" ");
		String[] subs = datetimes[0].split("-");
		if(subs.length != 3)
			return dateStr;
		StringBuilder sb = new StringBuilder();
		if(subs[0].length() == 2)
			sb.append("20").append(subs[0]);
		else
			sb.append(subs[0]);
		sb.append("-");
		if(subs[1].length() == 1)
			sb.append("0").append(subs[1]);
		else
			sb.append(subs[1]);
		sb.append("-");
		if(subs[2].length() == 1)
			sb.append("0").append(subs[2]);
		else
			sb.append(subs[2]);
		return sb.toString();
		
	}
	
}
