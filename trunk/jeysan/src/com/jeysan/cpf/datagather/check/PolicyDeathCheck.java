package com.jeysan.cpf.datagather.check;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.jeysan.cpf.util.Constants;
import com.jeysan.modules.utils.sql.JdbcUtil;


public class PolicyDeathCheck extends BaseCheck{
	
	private Logger logger = Logger.getLogger(PolicyDeathCheck.class);
	
	private static final String TABLE_IN_DB = "TEMP_POLICE_DATA_DEATH";
	/**字段*/
	private static final String COLUMN_IN_DB = "NAME,SEX,CODE,BIRTHDAY,ADDRESS,DEATH_DATE,OWNER_NAME,UPDATE_TIME,ID";
	
	private static final String INSERT_SQL_4NEWDATA_1 = "insert into FHP_PERSON(NAMEH,SEX,CANCEL_TYPE,CANCEL_DATE,DATEH,CODE) VALUES (?,?,?,?,?,?)";
	private static final String INSERT_SQL_4NEWDATA_2 = "insert into FHP_PERSON_BASIC(PERSON_ID,ADDRESS,BIRTHDAY,OWNER_NAME) select id,?,?,? from FHP_PERSON where code = ?";
	private static final String INSERT_SQL_4NEWDATA_3 = "insert into FHP_DEATH_REG(PERSON_ID,DATEH,NAMEH,OLD_ADDRESS) select id,?,?,? from FHP_PERSON where code = ?";
	
	private static final String UPDATE_SQL_4UPDATEDATA_1 = "update FHP_PERSON set NAMEH = ?,SEX = ?,CANCEL_TYPE = ?,CANCEL_DATE = ?,DATEH = ? where CODE = ? ";
	private static final String UPDATE_SQL_4UPDATEDATA_2 = "update FHP_PERSON_BASIC set ADDRESS = ?,BIRTHDAY = ?,OWNER_NAME = ? where PERSON_ID = (select ID from FHP_PERSON where CODE = ? limit 1)";
	private static final String UPDATE_SQL_4UPDATEDATA_3 = "update FHP_DEATH_REG set DATEH = ?,NAMEH = ?,OLD_ADDRESS = ? where PERSON_ID = (select ID from FHP_PERSON where CODE = ? limit 1)";
	
	private static List tmpIds4Update = new ArrayList();
	
	public PolicyDeathCheck(Connection conn){
		super(conn);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public void run() throws SQLException{	
		logger.info("开始导入公安部门 死亡人口数据......");
		JdbcUtil jdbcUtil = new JdbcUtil(conn,false);
		try {
			//新增
			addNewData(jdbcUtil,false);
			//修改
			addNewData(jdbcUtil,true);
			//更新状态
			updateStatus(TABLE_IN_DB,tmpIds4Update);
			logger.info("导入公安部门 死亡人口数据成功......");
		} catch (Exception e) {		
			logger.error("导入公安部门 死亡人口数据出错！" ,e);
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
	private void addNewData(JdbcUtil jdbcUtil,boolean update) throws Exception{
		logger.info(String.format("开始%s公安部门 死亡人口数据......",update?"修改":"新增"));
		try{
			List<Object[]> data4new = getData4Todo(update);
			if(data4new!=null && data4new.size() > 0){
				String name , code ,address , owner_name;
				Integer sex;
				Date birthday , dateh_date;
				Long id;
				List<Object[]> params_1 = new ArrayList(), params_2 = new ArrayList(), params_3 = new ArrayList();
				for(Object[] m : data4new){
					name = (String)m[0];
					sex = Constants.SEX.getStatusByLabel((String)m[1]);
					code = (String)m[2];
					birthday = (Date)m[3];
					address = (String)m[4];
					dateh_date = (Date)m[5];
					owner_name = (String)m[6];
					id = (Long)m[8];
					
					tmpIds4Update.add(new Object[]{id});
					
					params_1.add(new Object[]{name,sex,Constants.CANCEL_TYPE.DEATH,new Date(),dateh_date,code});
					params_2.add(new Object[]{address,birthday,owner_name,code});
					params_3.add(new Object[]{dateh_date,owner_name,address,code});

					checkAndCommmitData(jdbcUtil, params_1, update?UPDATE_SQL_4UPDATEDATA_1:INSERT_SQL_4NEWDATA_1, true);
					checkAndCommmitData(jdbcUtil, params_2, update?UPDATE_SQL_4UPDATEDATA_2:INSERT_SQL_4NEWDATA_2, true);
					checkAndCommmitData(jdbcUtil, params_3, update?UPDATE_SQL_4UPDATEDATA_3:INSERT_SQL_4NEWDATA_3, true);
				}
				checkAndCommmitData(jdbcUtil, params_1, update?UPDATE_SQL_4UPDATEDATA_1:INSERT_SQL_4NEWDATA_1, false);
				checkAndCommmitData(jdbcUtil, params_2, update?UPDATE_SQL_4UPDATEDATA_2:INSERT_SQL_4NEWDATA_2, false);
				checkAndCommmitData(jdbcUtil, params_3, update?UPDATE_SQL_4UPDATEDATA_3:INSERT_SQL_4NEWDATA_3, false);
			}
			logger.info(String.format("%s公安部门 死亡人口数据成功......",update?"修改":"新增"));
		}catch(Exception e){
			logger.error(String.format("%s公安部门 死亡人口数据出错......",update?"修改":"新增"),e);
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
		return getData4Todo(COLUMN_IN_DB,TABLE_IN_DB,update);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public int getCount() throws SQLException {
		return super.getCount(TABLE_IN_DB);
	}
	
}
