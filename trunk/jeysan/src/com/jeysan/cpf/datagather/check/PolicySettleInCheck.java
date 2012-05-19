package com.jeysan.cpf.datagather.check;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.h2.util.StringUtils;

import com.jeysan.cpf.util.Constants;
import com.jeysan.modules.utils.sql.JdbcUtil;


public class PolicySettleInCheck extends BaseCheck{
	
	private Logger logger = Logger.getLogger(PolicySettleInCheck.class);
	
	private static final String TABLE_IN_DB = "TEMP_POLICE_DATA_SETTLE_IN";
	/**字段*/
	private static final String COLUMN_IN_DB = "NAME,SEX,MARRY_STATUS,CODE,SETTLE_IN_ADDRESS,SETTLE_IN_DATE,OWNER_NAME,SETTLE_IN_TYPE,UPDATE_TIME,ID";
	
	private static final String INSERT_SQL_4NEWDATA_1 = "insert into FHP_PERSON(NAMEH,SEX,SETTLE_IN_DATE,SETTLE_IN_TYPE,CODE) VALUES (?,?,?,?,?)";
	private static final String INSERT_SQL_4NEWDATA_2 = "insert into FHP_PERSON_BASIC(PERSON_ID,MARRY_STATUS,OWNER_NAME) select id,?,? from FHP_PERSON where code = ?";
	private static final String INSERT_SQL_4NEWDATA_3 = "insert into FHP_PERSON_IN(PERSON_ID,IN_TYPE,IN_DATE,IN_ADDRESS) select id,?,?,? from FHP_PERSON where code = ?";
	
	private static final String UPDATE_SQL_4UPDATEDATA_1 = "update FHP_PERSON set NAMEH = ? , SEX = ?,SETTLE_IN_DATE = ?,SETTLE_IN_TYPE = ? where CODE = ? ";
	private static final String UPDATE_SQL_4UPDATEDATA_2 = "update FHP_PERSON_BASIC set MARRY_STATUS = ?,OWNER_NAME = ? where PERSON_ID = (select ID from FHP_PERSON where CODE = ? limit 1)";
	private static final String UPDATE_SQL_4UPDATEDATA_3 = "update FHP_PERSON_IN set IN_TYPE = ?,IN_DATE = ?,IN_ADDRESS = ? where PERSON_ID = (select ID from FHP_PERSON where CODE = ? limit 1)";
	
	private static List tmpIds4Update = new ArrayList();
	
	public PolicySettleInCheck(Connection conn){
		super(conn);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int[] run() throws SQLException{	
		logger.info("开始导入公安部门 珠海人口市内/市外 迁入数据......");
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
			logger.info("导入公安部门 珠海人口市内/市外 迁入数据成功......");
			return new int[]{add,update};
		} catch (Exception e) {		
			logger.error("导入公安部门 珠海人口市内/市外 迁入数据出错！" ,e);
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
		logger.info(String.format("开始%s公安部门 珠海人口市内/市外 迁入数据......",update?"修改":"新增"));
		try{
			//List<Object[]> data4new = getData4Todo(update);
			if(data4new!=null && data4new.size() > 0){
				String name , code ,settle_in_address , owner_name;
				Integer sex , marry_status , settle_in_type;
				Date settle_in_date;
				Long id;
				List<Object[]> params_1 = new ArrayList(), params_2 = new ArrayList(), params_3 = new ArrayList();
				for(Object[] m : data4new){
					name = (String)m[0];
					sex = Constants.SEX.getStatusByLabel((String)m[1]);
					marry_status = Constants.MARRY_STATUS.getStatusByLabel((String)m[2]);
					code = (String)m[3];
					settle_in_address = (String)m[4];
					settle_in_date = (Date)m[5];
					owner_name = (String)m[6];
					settle_in_type = StringUtils.equals((String)m[7], "0")?Constants.IN_TYPE.FROM_CITY_OUT:Constants.IN_TYPE.FROM_CITY_IN;
					id = (Long)m[9];
					
					tmpIds4Update.add(new Object[]{id});
					
					params_1.add(new Object[]{name,sex,settle_in_date,settle_in_type,code});
					params_2.add(new Object[]{marry_status,owner_name,code});
					params_3.add(new Object[]{settle_in_type,settle_in_date,settle_in_address,code});

					checkAndCommmitData(jdbcUtil, params_1, update?UPDATE_SQL_4UPDATEDATA_1:INSERT_SQL_4NEWDATA_1, true);
					checkAndCommmitData(jdbcUtil, params_2, update?UPDATE_SQL_4UPDATEDATA_2:INSERT_SQL_4NEWDATA_2, true);
					checkAndCommmitData(jdbcUtil, params_3, update?UPDATE_SQL_4UPDATEDATA_3:INSERT_SQL_4NEWDATA_3, true);
				}
				checkAndCommmitData(jdbcUtil, params_1, update?UPDATE_SQL_4UPDATEDATA_1:INSERT_SQL_4NEWDATA_1, false);
				checkAndCommmitData(jdbcUtil, params_2, update?UPDATE_SQL_4UPDATEDATA_2:INSERT_SQL_4NEWDATA_2, false);
				checkAndCommmitData(jdbcUtil, params_3, update?UPDATE_SQL_4UPDATEDATA_3:INSERT_SQL_4NEWDATA_3, false);
			}
			logger.info(String.format("%s公安部门 珠海人口市内/市外 迁入数据成功......",update?"修改":"新增"));
			return data4new.size();
		}catch(Exception e){
			logger.error(String.format("%s公安部门 珠海人口市内/市外 迁入数据出错......",update?"修改":"新增"),e);
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
