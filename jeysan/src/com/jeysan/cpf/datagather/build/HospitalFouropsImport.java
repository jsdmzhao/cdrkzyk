package com.jeysan.cpf.datagather.build;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

import javax.sql.DataSource;

import org.apache.log4j.Logger;


public class HospitalFouropsImport extends BaseImport{
	
	private Logger logger = Logger.getLogger(HospitalFouropsImport.class);
	
	private static final String TABLE_IN_DB = "TEMP_HOSPITAL_DATA_FOUROPS";
	/**字段*/
	private static final String COLUMN_IN_DB = "NAME,AGE,FETUS_SEQ,LIGATION,SUPERRING,INDUCED_ABORTION,ABORTION,GETIUD,DOMICILE,ADDRESS,HOSPITAL,AREA,TEL,UPDATE_TIME";
	/**唯一标识 用于判断重复数据 重复数据不予导入*/
	private static final String UNIQUE = "ID";
	
	
	public HospitalFouropsImport(DataSource dataSource){
		super(dataSource);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void run(Collection datas) throws SQLException{	
		try {
			logger.info("开始导入医院 四术落实登记数据......");
			StringBuffer sql = new StringBuffer();
			sql.append("insert into ")
			.append(TABLE_IN_DB)
			.append("(")
			.append(COLUMN_IN_DB)
			.append(") select ?,?,?,?,?,?,?,?,?,?,?,?,?,? from dual where not exists")
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
				psmt.setObject(1, colValue[0]);
				psmt.setObject(2, colValue[1]);
				psmt.setObject(3, colValue[2]);
				psmt.setObject(4, colValue[3]);
				psmt.setObject(5, colValue[4]);
				psmt.setObject(6, colValue[5]);
				psmt.setObject(7, colValue[6]);
				psmt.setObject(8, colValue[7]);
				psmt.setObject(9, colValue[8]);
				psmt.setObject(10, colValue[9]);
				psmt.setObject(11, colValue[10]);
				psmt.setObject(12, colValue[11]);
				psmt.setObject(13, colValue[12]);
				psmt.setObject(14, new Date());
				psmt.setObject(15, "");
				psmt.addBatch();
			}
			int[] result = psmt.executeBatch();
			conn.commit();
			logger.info("成功导入医院 四术落实登记数据条数：" + getCount(result));
		} catch (SQLException e) {		
			logger.error("导入医院 四术落实登记数据出错！" ,e);
			throw e;
		}finally{
			if(conn != null) conn.close();
		}
		
	}
	
}
