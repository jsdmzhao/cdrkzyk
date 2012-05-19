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


public class HospitalBirthCheck extends BaseCheck{
	
	private Logger logger = Logger.getLogger(HospitalBirthCheck.class);
	
	private static final String TABLE_IN_DB = "TEMP_HOSPITAL_DATA_BIRTH";
	/**字段*/
	private static final String COLUMN_IN_DB = "CHART_NUMBER,FEMALE_NAME,FEMALE_CODE,FEMALE_DOMICILE,CHILD_SEQ,CHILD_SEX,CHILD_BIRTHDAY,FEMALE_ADDRESS,MALE_NAME,MALE_CODE,MALE_DOMICILE,BIRTH_STATUS,REMARK,TEL,UPDATE_TIME,ID";
	
	private static final String INSERT_SQL_4NEWDATA_1 = "insert into FHP_PERSON(NAMEH,SEX,CODE) VALUES (?,?,?)";
	private static final String INSERT_SQL_4NEWDATA_2 = "insert into FHP_PERSON_BASIC(PERSON_ID,DOMICILE,ADDRESS,TEL,REMARK) select id,?,?,?,? from FHP_PERSON where code = ?";
	private static final String INSERT_SQL_4NEWDATA_3 = "insert into FHP_FERTILE_WOMAN(PERSON_ID,NAMEH,CREATE_DATE) select id,?,? from FHP_PERSON where code = ?";
	private static final String INSERT_SQL_4NEWDATA_4 = "insert into FHP_WOMAN_MATENAL(WOMAN_ID,MATENAL_RESULT,END_DATE,CHANGE_CAUSE) select id,?,?,? from FHP_FERTILE_WOMAN where PERSON_ID = (select ID from FHP_PERSON where CODE = ? limit 1)";
	private static final String INSERT_SQL_4NEWDATA_5 = "insert into FHP_SPOUSE(PERSON_ID,NAMEH,SEX,ADDRESS,DOMICILE,REMARK,TEL) select id,?,?,?,?,?,? from FHP_PERSON where code = ?";
	
	private static final String UPDATE_SQL_4UPDATEDATA_1 = "update FHP_PERSON set NAMEH = ? , SEX = ? where CODE = ? ";
	private static final String UPDATE_SQL_4UPDATEDATA_2 = "update FHP_PERSON_BASIC set DOMICILE = ?,ADDRESS = ?,TEL = ?,REMARK = ? where PERSON_ID = (select ID from FHP_PERSON where CODE = ? limit 1)";
	private static final String UPDATE_SQL_4UPDATEDATA_3 = "update FHP_FERTILE_WOMAN set NAMEH = ?,CREATE_DATE = ? where PERSON_ID = (select id from FHP_PERSON where code = ?)";
	private static final String UPDATE_SQL_4UPDATEDATA_4 = "update FHP_WOMAN_MATENAL set MATENAL_RESULT= ?,END_DATE= ?,CHANGE_CAUSE= ? where WOMAN_ID = (select ID from FHP_FERTILE_WOMAN where PERSON_ID = (select ID from FHP_PERSON where CODE = ? limit 1) limit 1)";
	private static final String UPDATE_SQL_4UPDATEDATA_5 = "update FHP_SPOUSE set NAMEH= ?,SEX= ?,ADDRESS= ?,DOMICILE= ?,REMARK= ?,TEL= ? where PERSON_ID = (select ID from FHP_PERSON where CODE = ? limit 1)";
	
	private static List tmpIds4Update = new ArrayList();
	
	public HospitalBirthCheck(Connection conn){
		super(conn);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public int[] run() throws SQLException{	
		logger.info("开始导入医院 妇产科出生登记数据......");
		JdbcUtil jdbcUtil = new JdbcUtil(conn,false);
		try {
			List add_lst = getData4Todo(false);
			List update_lst = getData4Todo(true);
			//新增
			int add = addNewData(jdbcUtil,false,add_lst);
			//修改
			int update = addNewData(jdbcUtil,true,update_lst);
			//更新状态
			updateStatus(TABLE_IN_DB,tmpIds4Update);
			logger.info("导入医院 妇产科出生登记数据成功......");
			return new int[]{add,update};
		} catch (Exception e) {		
			logger.error("导入医院 妇产科出生登记数据出错！" ,e);
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
	private int addNewData(JdbcUtil jdbcUtil,boolean update,List<Object[]> data4new) throws Exception{
		logger.info(String.format("开始%s医院 妇产科出生登记数据......",update?"修改":"新增"));
		try{
			//List<Object[]> data4new = getData4Todo(update);
			if(data4new!=null && data4new.size() > 0){
				//CHART_NUMBER,FEMALE_NAME,FEMALE_CODE,FEMALE_DOMICILE,
				//CHILD_SEQ,CHILD_SEX,CHILD_BIRTHDAY,FEMALE_ADDRESS,
				//MALE_NAME,MALE_CODE,MALE_DOMICILE,BIRTH_STATUS,REMARK,TEL,UPDATE_TIME,ID
				String chart_number,fe_name , fe_code ,fe_domicile,fe_address ;
				String m_name,m_code,m_domicile,birth_status,remark,tel;
				Integer child_sex,child_seq;
				Date child_birthday;
				Long id;
				List<Object[]> params_1 = new ArrayList(), params_2 = new ArrayList(), 
				params_3 = new ArrayList(), params_4 = new ArrayList(), params_5 = new ArrayList();
				

				List<Object[]> params_1_b = new ArrayList(), params_2_b = new ArrayList(), 
				params_5_b = new ArrayList();
				
				for(Object[] m : data4new){
					chart_number = (String)m[0];
					fe_name = (String)m[1];
					fe_code = (String)m[2];
					fe_domicile = (String)m[3];
					child_seq = (Integer)m[4];
					child_sex = Constants.SEX.getStatusByLabel((String)m[5]);
					child_birthday = (Date)m[6];
					fe_address = (String)m[7];
					m_name = (String)m[8];
					m_code = (String)m[9];
					m_domicile = (String)m[10];
					m_code = (String)m[9];
					birth_status = (String)m[11];
					remark = (String)m[12];
					tel = (String)m[13];
					
					id = (Long)m[15];
					
					tmpIds4Update.add(new Object[]{id});
					
					//女性
					params_1.add(new Object[]{fe_name,Constants.SEX.FEMALE,fe_code});
					//DOMICILE,ADDRESS,TEL,REMARK
					params_2.add(new Object[]{fe_domicile,fe_address,tel,remark,fe_code});
					//PERSON_ID,NAMEH,CREATE_DATE
					params_3.add(new Object[]{fe_name,new Date(),fe_code});
					//MATENAL_RESULT,END_DATE,CHANGE_CAUSE
					params_4.add(new Object[]{birth_status,child_birthday,String.format("病历号:%s,婴儿孩次:%s,婴儿性别:%s",chart_number,child_seq,child_sex),fe_code});
					//PERSON_ID,NAMEH,SEX,ADDRESS,DOMICILE,REMARK,TEL
					params_5.add(new Object[]{fe_name,Constants.SEX.FEMALE,fe_address,fe_domicile,remark,tel,m_code});
					
					//男性
					params_1_b.add(new Object[]{m_name,Constants.SEX.MALE,m_code});
					params_2_b.add(new Object[]{m_domicile,fe_address,tel,remark,m_code});
					params_5.add(new Object[]{m_name,Constants.SEX.MALE,fe_address,m_domicile,remark,tel,fe_code});
					
					checkAndCommmitData(jdbcUtil, params_1, update?UPDATE_SQL_4UPDATEDATA_1:INSERT_SQL_4NEWDATA_1, true);
					checkAndCommmitData(jdbcUtil, params_1_b, update?UPDATE_SQL_4UPDATEDATA_1:INSERT_SQL_4NEWDATA_1, true);
					
					checkAndCommmitData(jdbcUtil, params_2, update?UPDATE_SQL_4UPDATEDATA_2:INSERT_SQL_4NEWDATA_2, true);
					checkAndCommmitData(jdbcUtil, params_2_b, update?UPDATE_SQL_4UPDATEDATA_2:INSERT_SQL_4NEWDATA_2, true);
					
					checkAndCommmitData(jdbcUtil, params_3, update?UPDATE_SQL_4UPDATEDATA_3:INSERT_SQL_4NEWDATA_3, true);
					checkAndCommmitData(jdbcUtil, params_4, update?UPDATE_SQL_4UPDATEDATA_5:INSERT_SQL_4NEWDATA_4, true);
					
					checkAndCommmitData(jdbcUtil, params_5, update?UPDATE_SQL_4UPDATEDATA_5:INSERT_SQL_4NEWDATA_5, true);
					checkAndCommmitData(jdbcUtil, params_5_b, update?UPDATE_SQL_4UPDATEDATA_5:INSERT_SQL_4NEWDATA_5, true);
				}
				checkAndCommmitData(jdbcUtil, params_1, update?UPDATE_SQL_4UPDATEDATA_1:INSERT_SQL_4NEWDATA_1, false);
				checkAndCommmitData(jdbcUtil, params_1_b, update?UPDATE_SQL_4UPDATEDATA_1:INSERT_SQL_4NEWDATA_1, false);
				
				checkAndCommmitData(jdbcUtil, params_2, update?UPDATE_SQL_4UPDATEDATA_2:INSERT_SQL_4NEWDATA_2, false);
				checkAndCommmitData(jdbcUtil, params_2_b, update?UPDATE_SQL_4UPDATEDATA_2:INSERT_SQL_4NEWDATA_2, false);
				
				checkAndCommmitData(jdbcUtil, params_3, update?UPDATE_SQL_4UPDATEDATA_3:INSERT_SQL_4NEWDATA_3, false);
				checkAndCommmitData(jdbcUtil, params_4, update?UPDATE_SQL_4UPDATEDATA_4:INSERT_SQL_4NEWDATA_4, false);
				
				checkAndCommmitData(jdbcUtil, params_5, update?UPDATE_SQL_4UPDATEDATA_5:INSERT_SQL_4NEWDATA_5, false);
				checkAndCommmitData(jdbcUtil, params_5_b, update?UPDATE_SQL_4UPDATEDATA_5:INSERT_SQL_4NEWDATA_5, false);
			}
			logger.info(String.format("%s医院 妇产科出生登记数据成功......",update?"修改":"新增"));
			return data4new.size();
		}catch(Exception e){
			logger.error(String.format("%s医院 妇产科出生登记数据出错......",update?"修改":"新增"),e);
			throw e;
		}
	}
	
	/**
	 * 得到需要新增或者更新的数据
	 * @param update
	 * @return
	 * @throws SQLException
	 */
	private List getData4Todo(boolean update) throws SQLException{
		ResultSet rs = null;
		JdbcUtil jdbcUtil = null;
		try {
			jdbcUtil = new JdbcUtil(conn,false);
			rs = jdbcUtil.executePreparedStatementQuery(new StringBuilder().append("select ").append(COLUMN_IN_DB).append(" from " ).append(TABLE_IN_DB).append( " as a where a.check_type = ? and ").append((update?"":"not")).append(" exists (select 1 from FHP_PERSON as b where b.CODE = a.FEMALE_CODE)").toString(), new Object[]{0});
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
