package com.jeysan.cpf.datagather.build;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;


public class HospitalEpistationImport extends BaseImport{
	
	private Logger logger = Logger.getLogger(HospitalEpistationImport.class);
	
	private static final String TABLE_IN_DB = "TEMP_HOSPITAL_DATA_EPISTATION";
	/**字段*/
	private static final String COLUMN_IN_DB = "CHILD_CODE,FATHER,MOTHER,NAME,SEX,BIRTHDAY,DOMICILE_TYPE,TEL,OFFICE_TEL,MOBILE,ADDRESS,AREA,CREATE_DATE,MOTHER_COMPANY,FATHER_COMPANY,DOMICILE_ADDRESS,DOMICILE_UNIT,UNIT_BELONG,STANDARD,SETTLE_OUT_DATE,UPDATE_TIME";
	/**唯一标识 用于判断重复数据 重复数据不予导入*/
	private static final String UNIQUE = "CHILD_CODE";
	
	private static final SimpleDateFormat SDF = new SimpleDateFormat("mm/dd/yy hh:mm");
	
	public HospitalEpistationImport(DataSource dataSource){
		super(dataSource);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void run(Collection datas) throws SQLException{	
		try {
			logger.info("开始导入防疫站 电子数据......");
			StringBuffer sql = new StringBuffer();
			sql.append("insert into ")
			.append(TABLE_IN_DB)
			.append("(")
			.append(COLUMN_IN_DB)
			.append(") select ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? from dual where not exists")
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
				if(i == 1) continue;
				colValue = (Object[])o;
				psmt.setObject(1, colValue[0]);
				psmt.setObject(2, colValue[1]);
				psmt.setObject(3, colValue[2]);
				psmt.setObject(4, colValue[3]);
				psmt.setObject(5, colValue[4]);
				/**日期格式 11/25/10 0:00 */
				/*if(StringUtils.isNotEmpty(colValue[5]))
					psmt.setObject(6, SDF.parse(colValue[5]));
				else
					psmt.setObject(6, null);*/
				psmt.setObject(6, (colValue[5]==null||StringUtils.isEmpty(colValue[5].toString()))?null:colValue[5]);
				
				psmt.setObject(7, colValue[6]);
				psmt.setObject(8, colValue[7]);
				psmt.setObject(9, colValue[8]);
				psmt.setObject(10, colValue[9]);
				psmt.setObject(11, colValue[10]);
				psmt.setObject(12, colValue[11]);		
				/**日期格式 11/25/10 0:00 */
				/*if(StringUtils.isNotEmpty(colValue[12]))
					psmt.setObject(13, SDF.parse(colValue[12]));
				else
					psmt.setObject(13, null);*/
				psmt.setObject(13, (colValue[12]==null||StringUtils.isEmpty(colValue[12].toString()))?null:colValue[12]);
				
				
				psmt.setObject(14, colValue[13]);
				psmt.setObject(15, colValue[14]);
				psmt.setObject(16, colValue[15]);
				psmt.setObject(17, colValue[16]);
				psmt.setObject(18, colValue[17]);
				psmt.setObject(19, colValue[18]);
				/**日期格式 11/25/10 0:00 */
				/*if(StringUtils.isNotEmpty(colValue[19]))
					psmt.setObject(20, SDF.parse(colValue[19]));
				else
					psmt.setObject(20, null);*/
				psmt.setObject(20, (colValue[19]==null||StringUtils.isEmpty(colValue[19].toString()))?null:colValue[19]);
				
				
				psmt.setObject(21, new Date());
				psmt.setObject(22, colValue[0]);
				psmt.addBatch();
			}
			int[] result = psmt.executeBatch();
			conn.commit();
			logger.info("成功导入防疫站 电子数据条数：" + getCount(result));
		} catch (Exception e) {		
			logger.error("导入防疫站 电子数据出错！" ,e);
			throw new RuntimeException(e.getMessage(),e);
		}finally{
			if(conn != null) conn.close();
		}
		
	}
	
	public static void main(String[] args)throws Exception{
		System.out.println(SDF.parse("11/25/10 0:00"));
	}
	
}
