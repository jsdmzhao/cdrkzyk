package com.jeysan.cpf.datagather.check;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.tool.hbm2x.StringUtils;

import com.jeysan.cpf.util.Constants;
import com.jeysan.modules.utils.sql.JdbcUtil;
import com.jeysan.modules.utils.sql.ResultSetUtil;


public class HospitalFouropsCheck extends BaseCheck{
	
	private Logger logger = Logger.getLogger(HospitalFouropsCheck.class);
	
	private static final String TABLE_IN_DB = "TEMP_HOSPITAL_DATA_FOUROPS";
	/**字段*/
	private static final String COLUMN_IN_DB = "NAME,AGE,FETUS_SEQ,LIGATION,SUPERRING,INDUCED_ABORTION,ABORTION,GETIUD,DOMICILE,ADDRESS,HOSPITAL,AREA,TEL,UPDATE_TIME,ID";

	private static final String MAX_ID = "select max(id) from FHP_PERSON where nameh = ? ";
	
	private static final String WOMAN_ID = "select id from FHP_FERTILE_WOMAN where PERSON_ID = ? limit 1 ";
	
	private static final String INSERT_SQL_4NEWDATA_1 = "insert into FHP_PERSON(NAMEH,AGE,SEX,AREA) VALUES (?,?,?,?)";
	private static final String INSERT_SQL_4NEWDATA_2 = "insert into FHP_PERSON_BASIC(PERSON_ID,ADDRESS,DOMICILE,TEL) values(?,?,?,?)";
	private static final String INSERT_SQL_4NEWDATA_3 = "insert into FHP_FERTILE_WOMAN(PERSON_ID,NAMEH,CREATE_DATE,AREA) values(?,?,?,?)";
	private static final String INSERT_SQL_4NEWDATA_4 = "insert into FHP_WOMAN_CONTRACEPT(PERSON_ID,METHOD,HOSPITAL,HOSPITAL_ADDRESS,REG_DATE) values(?,?,?,?,?)";
	private static final String INSERT_SQL_4NEWDATA_5 = "insert into FHP_WOMAN_MATENAL(WOMAN_ID,CONCEPT_RESULT,MATENAL_RESULT,HOSPITAL,HOSPITAL_ADDRESS,CHANGE_DATE) values (?,?,?,?,?,?)";
	private static final String INSERT_SQL_4NEWDATA_6 = "insert into FHP_GET_IUD(WOMAN_ID,HOSPITAL,HOSPITAL_ADDRESS) values (?,?,?)";
	
	
	private static List tmpIds4Update = new ArrayList();
	
	
	public HospitalFouropsCheck(Connection conn){
		super(conn);
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public int[] run() throws SQLException{	
		logger.info("开始导入医院 四术落实登记数据......");
		JdbcUtil jdbcUtil = new JdbcUtil(conn,false);
		try {
			//新增
			int add = addNewData(jdbcUtil);
			//更新状态
			updateStatus(TABLE_IN_DB,tmpIds4Update);
			logger.info("导入医院 四术落实登记数据成功......");
			return new int[]{add,0};
		} catch (Exception e) {		
			logger.error("导入医院 四术落实登记数据出错！" ,e);
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
	private int addNewData(JdbcUtil jdbcUtil) throws Exception{
		logger.info(String.format("开始新增医院 四术落实登记数据......"));
		try{
			List<Object[]> data4new = getData4Todo();
			if(data4new!=null && data4new.size() > 0){
				//NAME,AGE,FETUS_SEQ,LIGATION,SUPERRING,INDUCED_ABORTION,
				//ABORTION,GETIUD,DOMICILE,ADDRESS,HOSPITAL,AREA,TEL,UPDATE_TIME,ID
				String name , ligation,superring,induced_abortion;
				String abortion,getiud,domicile,address,hospital,area,tel;
				Integer age,fetus_seq;
				Long id;
				List<Object[]> params_1 = new ArrayList(), params_2 = new ArrayList(), params_3 = new ArrayList(),
				params_4 = new ArrayList(), params_5 = new ArrayList(), params_6 = new ArrayList();
				for(Object[] m : data4new){
					name = (String)m[0];
					age = (Integer)m[1];
					fetus_seq = (Integer)m[2];
					ligation = (String)m[3];
					superring = (String)m[4];
					induced_abortion = (String)m[5];
					abortion = (String)m[6];
					getiud = (String)m[7];
					domicile = (String)m[8];
					address = (String)m[9];
					hospital = (String)m[10];
					area = (String)m[11];
					if(StringUtils.isNotEmpty(area)){
						logger.debug(String.format("居委会名称:%s",area));
						area = getVillageCode(area);
						logger.debug(String.format("最后居委会CODE:%s",area));
					}
					tel = (String)m[12];
					
					id = (Long)m[14];
					
					tmpIds4Update.add(new Object[]{id});
					
					jdbcUtil.executePreparedStatementUpdate(INSERT_SQL_4NEWDATA_1, new Object[]{name,age,Constants.SEX.FEMALE,area});
					conn.commit();
					List<Object[]> max_id_lst = ResultSetUtil.toArrayList(jdbcUtil.executePreparedStatementQuery(MAX_ID, new Object[]{name}));
					Long personId = (Long)max_id_lst.get(0)[0];
					jdbcUtil.executePreparedStatementUpdate(INSERT_SQL_4NEWDATA_3, new Object[]{personId,name,new Date(),area});
					conn.commit();
					
					List<Object[]> woman_id_lst = ResultSetUtil.toArrayList(jdbcUtil.executePreparedStatementQuery(WOMAN_ID, new Object[]{personId}));
					Long womanId = (Long)woman_id_lst.get(0)[0];
					
					
					params_2.add(new Object[]{personId,address,domicile,tel});
					//params_3.add(new Object[]{personId,name,new Date(),area});
					//PERSON_ID,METHOD,HOSPITAL,HOSPITAL_ADDRESS,REG_DATE
					if(StringUtils.isNotEmpty(ligation))
						params_4.add(new Object[]{personId,Constants.METHOD.METHOD_202,hospital,address,new Date()});
					if(StringUtils.isNotEmpty(superring))
						params_4.add(new Object[]{personId,Constants.METHOD.METHOD_203,hospital,address,new Date()});
					//CONCEPT_RESULT,MATENAL_RESULT,HOSPITAL,HOSPITAL_ADDRESS,CHANGE_DATE,PERSON_ID
					if(StringUtils.isNotEmpty(induced_abortion))
						params_5.add(new Object[]{womanId,Constants.CONCEPT_RESULT.FAIL,"人流",hospital,address,new Date()});
					if(StringUtils.isNotEmpty(abortion))
						params_5.add(new Object[]{womanId,Constants.CONCEPT_RESULT.FAIL,"引产",hospital,address,new Date()});
					if(StringUtils.isNotEmpty(getiud))
						params_6.add(new Object[]{womanId,hospital,address});
					
					//checkAndCommmitData(jdbcUtil, params_1, update?UPDATE_SQL_4UPDATEDATA_1:INSERT_SQL_4NEWDATA_1, true);
					checkAndCommmitData(jdbcUtil, params_2, INSERT_SQL_4NEWDATA_2, true);
					//checkAndCommmitData(jdbcUtil, params_3, INSERT_SQL_4NEWDATA_3, true);
					checkAndCommmitData(jdbcUtil, params_4, INSERT_SQL_4NEWDATA_4, true);
					checkAndCommmitData(jdbcUtil, params_5, INSERT_SQL_4NEWDATA_5, true);
					checkAndCommmitData(jdbcUtil, params_6, INSERT_SQL_4NEWDATA_6, true);
				}
				//checkAndCommmitData(jdbcUtil, params_1, update?UPDATE_SQL_4UPDATEDATA_1:INSERT_SQL_4NEWDATA_1, false);
				checkAndCommmitData(jdbcUtil, params_2, INSERT_SQL_4NEWDATA_2, false);
				//checkAndCommmitData(jdbcUtil, params_3, INSERT_SQL_4NEWDATA_3, false);
				checkAndCommmitData(jdbcUtil, params_4, INSERT_SQL_4NEWDATA_4, false);
				checkAndCommmitData(jdbcUtil, params_5, INSERT_SQL_4NEWDATA_5, false);
				checkAndCommmitData(jdbcUtil, params_6, INSERT_SQL_4NEWDATA_6, false);
			}
			logger.info(String.format("新增医院 四术落实登记数据成功......"));
			return data4new.size();
		}catch(Exception e){
			logger.error(String.format("新增医院 四术落实登记数据出错......"),e);
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
