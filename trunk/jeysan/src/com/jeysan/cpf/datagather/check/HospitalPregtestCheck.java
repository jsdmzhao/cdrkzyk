package com.jeysan.cpf.datagather.check;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.jeysan.cpf.util.Constants;
import com.jeysan.modules.utils.sql.JdbcUtil;
import com.jeysan.modules.utils.sql.ResultSetUtil;


public class HospitalPregtestCheck extends BaseCheck{
	
	private Logger logger = Logger.getLogger(HospitalPregtestCheck.class);
	
	private static final String TABLE_IN_DB = "TEMP_HOSPITAL_DATA_PREGTEST";
	/**字段*/
	private static final String COLUMN_IN_DB = "CHECK_DATE,FEMALE_NAME,AGE,FETUS_SEQ,DOMICILE,ADDRESS,EDD,TEL,CHECK_ADDRESS,HUSBAND,UPDATE_TIME,ID";
	
	private static final String MAX_ID = "select max(id) from FHP_PERSON where nameh = ? ";
	
	private static final String WOMAN_ID = "select id from FHP_FERTILE_WOMAN where PERSON_ID = ? limit 1 ";
	
	private static final String INSERT_SQL_4NEWDATA_1 = "insert into FHP_PERSON(NAMEH,AGE,SEX) VALUES (?,?,?)";
	private static final String INSERT_SQL_4NEWDATA_2 = "insert into FHP_PERSON_BASIC(PERSON_ID,ADDRESS,DOMICILE,TEL) values(?,?,?,?)";
	private static final String INSERT_SQL_4NEWDATA_3 = "insert into FHP_FERTILE_WOMAN(PERSON_ID,NAMEH,CREATE_DATE) values(?,?,?)";
	private static final String INSERT_SQL_4NEWDATA_4 = "insert into FHP_SPOUSE(PERSON_ID,NAMEH,SEX,ADDRESS,TEL) values(?,?,?,?,?)";
	private static final String INSERT_SQL_4NEWDATA_5 = "insert into FHP_WOMAN_MATENAL(WOMAN_ID,EDD,HOSPITAL_ADDRESS) values (?,?,?)";
	
	private static List tmpIds4Update = new ArrayList();
	
	public HospitalPregtestCheck(Connection conn){
		super(conn);
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public void run() throws SQLException{	
		logger.info("开始导入医院 孕前检查登记数据......");
		JdbcUtil jdbcUtil = new JdbcUtil(conn,false);
		try {
			//新增
			addNewData(jdbcUtil);
			//更新状态
			updateStatus(TABLE_IN_DB,tmpIds4Update);
			logger.info("导入医院 孕前检查登记数据成功......");
		} catch (Exception e) {		
			logger.error("导入医院 孕前检查登记数据出错！" ,e);
			throw new SQLException(e);
		}finally{
			jdbcUtil.closeDBConection();
		}
		
	}

	/**
	 * 新增或者修改数据
	 * @param jdbcUtil
	 * @param update
	 * @throws Exception
	 */
	private void addNewData(JdbcUtil jdbcUtil) throws Exception{
		logger.info(String.format("开始新增医院 孕前检查登记数据......"));
		try{
			List<Object[]> data4new = getData4Todo();
			if(data4new!=null && data4new.size() > 0){
				//CHECK_DATE,FEMALE_NAME,AGE,FETUS_SEQ,DOMICILE,ADDRESS,EDD,TEL,CHECK_ADDRESS,HUSBAND,UPDATE_TIME,ID
				String name,domicile,address,tel,hospital_address,husband_name;
				Integer age,fetus_seq;
				Long id;
				Date edd;
				List<Object[]> params_1 = new ArrayList(), params_2 = new ArrayList(), params_3 = new ArrayList(),
				params_4 = new ArrayList(),params_5 = new ArrayList();
				for(Object[] m : data4new){
					name = (String)m[1];
					age = (Integer)m[2];
					fetus_seq = (Integer)m[3];
					domicile = (String)m[4];
					address = (String)m[5];
					edd = (Date)m[6];
					tel = (String)m[7];
					hospital_address = (String)m[8];
					husband_name = (String)m[9];
					
					
					id = (Long)m[11];
					
					tmpIds4Update.add(new Object[]{id});
					
					jdbcUtil.executePreparedStatementUpdate(INSERT_SQL_4NEWDATA_1, new Object[]{name,age,Constants.SEX.FEMALE});
					conn.commit();
					List<Object[]> max_id_lst = ResultSetUtil.toArrayList(jdbcUtil.executePreparedStatementQuery(MAX_ID, new Object[]{name}));
					Long personId = (Long)max_id_lst.get(0)[0];
					jdbcUtil.executePreparedStatementUpdate(INSERT_SQL_4NEWDATA_3, new Object[]{personId,name,new Date()});
					conn.commit();
					
					List<Object[]> woman_id_lst = ResultSetUtil.toArrayList(jdbcUtil.executePreparedStatementQuery(WOMAN_ID, new Object[]{personId}));
					Long womanId = (Long)woman_id_lst.get(0)[0];
					
					//PERSON_ID,ADDRESS,DOMICILE,TEL
					params_2.add(new Object[]{personId,address,domicile,tel});
					//PERSON_ID,NAMEH,SEX,ADDRESS,TEL
					params_4.add(new Object[]{personId,husband_name,Constants.SEX.MALE,address,tel});
					//WOMAN_ID,EDD,HOSPITAL_ADDRESS
					params_5.add(new Object[]{womanId,edd,hospital_address});
					
					checkAndCommmitData(jdbcUtil, params_2, INSERT_SQL_4NEWDATA_2, true);
					checkAndCommmitData(jdbcUtil, params_4, INSERT_SQL_4NEWDATA_4, true);
					checkAndCommmitData(jdbcUtil, params_5, INSERT_SQL_4NEWDATA_5, true);
				}
				checkAndCommmitData(jdbcUtil, params_2, INSERT_SQL_4NEWDATA_2, false);
				checkAndCommmitData(jdbcUtil, params_4, INSERT_SQL_4NEWDATA_4, false);
				checkAndCommmitData(jdbcUtil, params_5, INSERT_SQL_4NEWDATA_5, false);
			}
			logger.info(String.format("新增医院 孕前检查登记数据成功......"));
		}catch(Exception e){
			logger.error(String.format("新增医院 孕前检查登记数据出错......"),e);
			throw e;
		}
	}
	
	/**
	 * 得到需要新增或者更新的数据
	 * @param update
	 * @return
	 * @throws SQLException
	 */
	private List getData4Todo() throws SQLException{
		ResultSet rs = null;
		JdbcUtil jdbcUtil = null;
		try {
			jdbcUtil = new JdbcUtil(conn,false);
			rs = jdbcUtil.executePreparedStatementQuery(new StringBuilder().append("select ").append(COLUMN_IN_DB).append(" from " ).append( TABLE_IN_DB ).append( " as a where a.check_type = ? ").toString(), new Object[]{0});
			return ResultSetUtil.toArrayList(rs);
		} catch (Exception e) {
			throw new SQLException(e);
		}finally{
			if(jdbcUtil != null){
				jdbcUtil.closeDBConection();
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getCount() throws SQLException {
		return super.getCount(TABLE_IN_DB);
	}
	
}
