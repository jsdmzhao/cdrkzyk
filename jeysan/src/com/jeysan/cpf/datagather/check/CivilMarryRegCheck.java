package com.jeysan.cpf.datagather.check;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.jeysan.cpf.util.Constants;
import com.jeysan.modules.utils.date.DateUtil;
import com.jeysan.modules.utils.sql.JdbcUtil;


public class CivilMarryRegCheck extends BaseCheck{
	
	private Logger logger = Logger.getLogger(CivilMarryRegCheck.class);
	
	private static final String TABLE_IN_DB = "TEMP_CIVIL_DATA_MARRY_REG";
	/**字段*/
	private static final String COLUMN_IN_DB = "REG_DATE,CODE,NAME,BIRTHDAY,MARRY_TYPE,MARRY_STATUS,HOUSEHODE,CODE2,NAME2,BIRTHDAY2,DEGREE,MARRY_TYPE2,MARRY_STATUS2,HOUSEHODE2,UPDATE_TIME,ID";
	
	private static final String INSERT_SQL_4NEWDATA_1 = "insert into FHP_PERSON(NAMEH,CODE) VALUES (?,?)";
	private static final String INSERT_SQL_4NEWDATA_2 = "insert into FHP_PERSON_BASIC(PERSON_ID,DOMICILE,BIRTHDAY,MARRY_STATUS,EDU,REMARK) select id,?,?,?,?,? from FHP_PERSON where code = ?";
	private static final String INSERT_SQL_4NEWDATA_3 = "insert into FHP_SPOUSE(PERSON_ID,NAMEH,AGE,BIRTHDAY,EDU,DOMICILE,REMARK,CODE) select id,?,?,?,?,?,?,? from FHP_PERSON where code = ?";
	
	private static final String UPDATE_SQL_4UPDATEDATA_1 = "update FHP_PERSON set NAMEH = ? where CODE = ? ";
	private static final String UPDATE_SQL_4UPDATEDATA_2 = "update FHP_PERSON_BASIC set DOMICILE = ?,BIRTHDAY = ?,MARRY_STATUS = ?,EDU = ?,REMARK = ? where PERSON_ID = (select ID from FHP_PERSON where CODE = ? limit 1)";
	private static final String UPDATE_SQL_4UPDATEDATA_3 = "update FHP_SPOUSE set NAMEH = ?,AGE = ?,BIRTHDAY = ?,EDU = ?,DOMICILE = ?,REMARK = ?,CODE = ? where PERSON_ID = (select ID from FHP_PERSON where CODE = ? limit 1)";
	
	private static List tmpIds4Update = new ArrayList();
	
	public CivilMarryRegCheck(Connection conn){
		super(conn);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public int[] run() throws SQLException{	
		logger.info("开始民政部门 结婚登记数据......");
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
			logger.info("民政部门 结婚登记数据成功......");
			return new int[]{add,update};
		} catch (Exception e) {		
			logger.error("民政部门 结婚登记数据出错！" ,e);
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
		logger.info(String.format("开始%s民政部门 结婚登记数据......",update?"修改":"新增"));
		try{
			//List<Object[]> data4new = getData4Todo(update);
			if(data4new!=null && data4new.size() > 0){
				//REG_DATE,CODE,NAME,BIRTHDAY,MARRY_TYPE,MARRY_STATUS,HOUSEHODE,CODE2,NAME2,BIRTHDAY2,
				//DEGREE,MARRY_TYPE2,MARRY_STATUS2,HOUSEHODE2,UPDATE_TIME,ID
				String name , code ,housecode,code2,name2,housecode2,marry_type,marry_type2;
				Integer marry_status,degree,marry_status2,age=0,age2=0;
				Date birthday,birthday2;
				Long id;
				List<Object[]> params_1 = new ArrayList(), params_2 = new ArrayList(), params_3 = new ArrayList(),
				params_1_b = new ArrayList(),params_2_b = new ArrayList(), params_3_b = new ArrayList();
				Timestamp today = new Timestamp(new Date().getTime());
				for(Object[] m : data4new){
					//reg_date = (Date)m[0];
					code = (String)m[1];
					name = (String)m[2];
					birthday = (Date)m[3];
					if(birthday != null)
						age = DateUtil.dateDiff("YEAR", new Timestamp(birthday.getTime()), today);
					marry_type = (String)m[4];
					marry_status = Constants.MARRY_STATUS.getStatusByLabel((String)m[5]);
					housecode = (String)m[6];
					code2 = (String)m[7];
					name2 = (String)m[8];
					birthday2 = (Date)m[9];
					if(birthday2 != null)
						age2 = DateUtil.dateDiff("YEAR", new Timestamp(birthday2.getTime()), today);
					degree = Constants.DEGREE.getStatusByLabel((String)m[10]);
					marry_type2 = (String)m[11];
					marry_status2 = Constants.MARRY_STATUS.getStatusByLabel((String)m[12]);
					housecode2 = (String)m[13];
					
					id = (Long)m[15];
					
					tmpIds4Update.add(new Object[]{id});
					
					params_1.add(new Object[]{name,code});
					params_1_b.add(new Object[]{name2,code2});
					//DOMICILE,BIRTHDAY,MARRY_STATUS,EDU,REMARK
					params_2.add(new Object[]{housecode,birthday,marry_status,null,String.format("登记日期:%s,结婚类别:%s",m[0],marry_type),code});
					params_2_b.add(new Object[]{housecode2,birthday2,marry_status2,degree,String.format("登记日期:%s,结婚类别:%s",m[0],marry_type2),code2});
					//NAMEH,AGE,BIRTHDAY,EDU,DOMICILE,REMARK,CODE
					params_3.add(new Object[]{name,age,birthday,null,housecode,String.format("登记日期:%s,结婚类别:%s",m[0],marry_type),code,code2});
					params_3_b.add(new Object[]{name2,age2,birthday2,degree,housecode2,String.format("登记日期:%s,结婚类别:%s",m[0],marry_type2),code2,code});
					
					
					checkAndCommmitData(jdbcUtil, params_1, update?UPDATE_SQL_4UPDATEDATA_1:INSERT_SQL_4NEWDATA_1, true);
					checkAndCommmitData(jdbcUtil, params_1_b, update?UPDATE_SQL_4UPDATEDATA_1:INSERT_SQL_4NEWDATA_1, true);
					
					checkAndCommmitData(jdbcUtil, params_2, update?UPDATE_SQL_4UPDATEDATA_2:INSERT_SQL_4NEWDATA_2, true);
					checkAndCommmitData(jdbcUtil, params_2_b, update?UPDATE_SQL_4UPDATEDATA_2:INSERT_SQL_4NEWDATA_2, true);
					
					checkAndCommmitData(jdbcUtil, params_3, update?UPDATE_SQL_4UPDATEDATA_3:INSERT_SQL_4NEWDATA_3, true);
					checkAndCommmitData(jdbcUtil, params_3_b, update?UPDATE_SQL_4UPDATEDATA_3:INSERT_SQL_4NEWDATA_3, true);
					
				}
				checkAndCommmitData(jdbcUtil, params_1, update?UPDATE_SQL_4UPDATEDATA_1:INSERT_SQL_4NEWDATA_1, false);
				checkAndCommmitData(jdbcUtil, params_1_b, update?UPDATE_SQL_4UPDATEDATA_1:INSERT_SQL_4NEWDATA_1, false);
				
				checkAndCommmitData(jdbcUtil, params_2, update?UPDATE_SQL_4UPDATEDATA_2:INSERT_SQL_4NEWDATA_2, false);
				checkAndCommmitData(jdbcUtil, params_2_b, update?UPDATE_SQL_4UPDATEDATA_2:INSERT_SQL_4NEWDATA_2, false);
				
				checkAndCommmitData(jdbcUtil, params_3, update?UPDATE_SQL_4UPDATEDATA_3:INSERT_SQL_4NEWDATA_3, false);
				checkAndCommmitData(jdbcUtil, params_3_b, update?UPDATE_SQL_4UPDATEDATA_3:INSERT_SQL_4NEWDATA_3, false);
			}
			logger.info(String.format("%s民政部门 结婚登记数据成功......",update?"修改":"新增"));
			return data4new.size();
		}catch(Exception e){
			logger.error(String.format("%s民政部门 结婚登记数据出错......",update?"修改":"新增"),e);
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
