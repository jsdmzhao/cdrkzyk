package com.jeysan.cpf.datagather.build;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

import javax.sql.DataSource;

import org.apache.log4j.Logger;


public class CompanyBcsImport extends BaseImport{
	
	private Logger logger = Logger.getLogger(CompanyBcsImport.class);
	
	private static final String TABLE_IN_DB = "TEMP_COMPANY_DATA_BCS";
	/**字段*/
	private static final String COLUMN_IN_DB = "NAME,RELATION,SEX,BIRTHDAY,CODE,DOMICILE,DOMICILE_TYPE,EDU,MARRY_STATUS,ADDRESS,JOIN_DATE,COMPANY,UPDATE_TIME";
	/**唯一标识 用于判断重复数据 重复数据不予导入*/
	private static final String UNIQUE = "CODE";
	
	
	public CompanyBcsImport(DataSource dataSource){
		super(dataSource);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int run(Collection datas) throws SQLException{	
		try {
			logger.info("开始导入企业 人员计划生育数据......");
			StringBuffer sql = new StringBuffer();
			sql.append("insert into ")
			.append(TABLE_IN_DB)
			.append("(")
			.append(COLUMN_IN_DB)
			.append(") select ?,?,?,?,?,?,?,?,?,?,?,?,? from dual where not exists")
			.append("(select id from ")
			.append(TABLE_IN_DB)
			.append(" where ")
			.append(UNIQUE)
			.append(" = ? )");
			
			conn = dataSource.getConnection();
			PreparedStatement psmt = conn.prepareStatement(sql.toString());
			Object[] colValue = null;
			int i = 0;
			Object company = null;
			for(Object o : datas){
				i++;
				/**忽略行数*/
				colValue = (Object[])o;
				if(i == 2) company = colValue[1];
				if(i <= 12) continue;
				if(colValue[0].toString().contains("调查人")) continue;
				
				psmt.setObject(1, colValue[0]);
				psmt.setObject(2, colValue[1]);
				psmt.setObject(3, colValue[2]);
				psmt.setObject(4, colValue[3]);
				psmt.setObject(5, colValue[4]);
				psmt.setObject(6, colValue[5]);
				psmt.setObject(7, colValue[6]);
				psmt.setObject(8, colValue[7]);
				psmt.setObject(9, colValue[8]);
				psmt.setObject(10, colValue[9].toString()+colValue[10].toString()+colValue[11].toString()+colValue[12].toString());
				psmt.setObject(11, colValue[13]);
				psmt.setObject(12, company);
				psmt.setObject(13, new Date());
				psmt.setObject(14, colValue[4]);
				psmt.addBatch();
			}
			int[] result = psmt.executeBatch();
			conn.commit();
			logger.info("成功导入企业 人员计划生育数据条数：" + getCount(result));
			return getCount(result);
		} catch (SQLException e) {		
			logger.error("导入企业 人员计划生育数据出错！" ,e);
			throw e;
		}finally{
			if(conn != null) conn.close();
		}
		
	}
	
}
