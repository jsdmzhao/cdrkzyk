package com.jeysan.cpf.datagather.check;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.jeysan.cpf.util.Constants;
import com.jeysan.modules.utils.sql.JdbcUtil;
import com.jeysan.modules.utils.sql.ResultSetUtil;


public class GmccCheck extends BaseCheck{
	
	private Logger logger = Logger.getLogger(GmccCheck.class);
	
	private static final String TABLE_IN_DB = "TEMP_GMCC_DATA";
	/**字段*/
	private static final String COLUMN_IN_DB = "BCS_TYPE,BCS_CODE,DOMICILE_TYPE,BIRTH_TYPE,CODE,HOSPITAL,NAME,BIRTH_DATE,FETUS_COUNT,DEATH_FLAG,TEL,ADDRESS,COMPANY,AREA,UPDATE_TIME,ID";
	
	private static final String MAX_ID = "select max(id) from FHP_PERSON where nameh = ? ";
	
	private static final String WOMAN_ID = "select id from FHP_FERTILE_WOMAN where PERSON_ID = ? limit 1 ";
	
	private static final String INSERT_SQL_4NEWDATA_1 = "insert into FHP_PERSON(NAMEH,CERT_TYPE,CODE,SEX,AREA) VALUES (?,?,?,?,?)";
	private static final String INSERT_SQL_4NEWDATA_2 = "insert into FHP_PERSON_BASIC(PERSON_ID,ADDRESS,COMPANY,HOUSEHODE_KIND,TEL,REMARK) values(?,?,?,?,?,?)";
	private static final String INSERT_SQL_4NEWDATA_3 = "insert into FHP_FERTILE_WOMAN(PERSON_ID,NAMEH,CREATE_DATE,AREA) values(?,?,?,?)";
	private static final String INSERT_SQL_4NEWDATA_4 = "insert into FHP_WOMAN_BASIC(WOMAN_ID,CERT_CODE,REMARK) values(?,?,?)";
	
	private static List tmpIds4Update = new ArrayList();
	
	
	public GmccCheck(Connection conn){
		super(conn);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int[] run() throws SQLException{	
		logger.info("开始导入社保 社会保险项目数据......");
		JdbcUtil jdbcUtil = new JdbcUtil(conn,false);
		try {
			//新增
			int add = addNewData(jdbcUtil);
			//更新状态
			updateStatus(TABLE_IN_DB,tmpIds4Update);
			logger.info("导入社保 社会保险项目数据成功......");
			return new int[]{add,0};
		} catch (Exception e) {		
			logger.error("导入社保 社会保险项目数据出错！" ,e);
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
		logger.info(String.format("开始新增社保 社会保险项目数据......"));
		try{
			List<Object[]> data4new = getData4Todo();
			if(data4new!=null && data4new.size() > 0){
				//BCS_TYPE,BCS_CODE,DOMICILE_TYPE,BIRTH_TYPE,CODE,HOSPITAL,NAME,
				//BIRTH_DATE,FETUS_COUNT,DEATH_FLAG,TEL,ADDRESS,COMPANY,AREA,UPDATE_TIME,ID
				String bcs_type,bcs_code,birth_type,code,hospital,name,remark;
				String death_flag,tel,address,company,area;
				Integer domicile_type,fetus_count;
				Date birth_date;
				Long id;
				List<Object[]> params_1 = new ArrayList(), params_2 = new ArrayList(), params_3 = new ArrayList(),
				params_4 = new ArrayList(), params_5 = new ArrayList(), params_6 = new ArrayList();
				for(Object[] m : data4new){
					bcs_type = (String)m[0];
					bcs_code = (String)m[1];
					domicile_type = Constants.HOUSEHODE_KIND.getStatusByLabel((String)m[2]);
					birth_type = (String)m[3];
					code = (String)m[4];
					hospital = (String)m[5];
					name = (String)m[6];
					birth_date = (Date)m[7];
					fetus_count = (Integer)m[8];
					death_flag = (String)m[9];
					tel = (String)m[10];
					address = (String)m[11];
					company = (String)m[12];
					area = (String)m[13];
					if(StringUtils.isNotEmpty(area)){
						logger.debug(String.format("居委会名称:%s",area));
						area = getVillageCode(area);
						logger.debug(String.format("最后居委会CODE:%s",area));
					}
					id = (Long)m[15];
					
					remark = String.format("生育证件类型:%s,生育类型:%s,医疗机构名称:%s,生育发生时间:%s,胎儿数:%s,子女死亡标志:%s", bcs_type,birth_type,hospital,m[7],fetus_count,death_flag);
					
					tmpIds4Update.add(new Object[]{id});
					//NAMEH,CERT_TYPE,CODE,SEX,AREA
					jdbcUtil.executePreparedStatementUpdate(INSERT_SQL_4NEWDATA_1, new Object[]{name,Constants.CARD_TYPE.CERT,code,Constants.SEX.FEMALE,area});
					conn.commit();
					List<Object[]> max_id_lst = ResultSetUtil.toArrayList(jdbcUtil.executePreparedStatementQuery(MAX_ID, new Object[]{name}));
					Long personId = (Long)max_id_lst.get(0)[0];
					//PERSON_ID,NAMEH,CREATE_DATE,AREA
					jdbcUtil.executePreparedStatementUpdate(INSERT_SQL_4NEWDATA_3, new Object[]{personId,name,new Date(),area});
					conn.commit();
					
					List<Object[]> woman_id_lst = ResultSetUtil.toArrayList(jdbcUtil.executePreparedStatementQuery(WOMAN_ID, new Object[]{personId}));
					Long womanId = (Long)woman_id_lst.get(0)[0];
					
					
					params_2.add(new Object[]{personId,address,company,domicile_type,tel,remark});
					//PERSON_ID,ADDRESS,COMPANY,HOUSEHODE_KIND,TEL,REMARK   3
					//WOMAN_ID,CERT_CODE,REMARK 4
					params_4.add(new Object[]{womanId,bcs_code,remark});
					
					
					checkAndCommmitData(jdbcUtil, params_2, INSERT_SQL_4NEWDATA_2, true);
					checkAndCommmitData(jdbcUtil, params_4, INSERT_SQL_4NEWDATA_4, true);
				}
				checkAndCommmitData(jdbcUtil, params_2, INSERT_SQL_4NEWDATA_2, false);
				checkAndCommmitData(jdbcUtil, params_4, INSERT_SQL_4NEWDATA_4, false);
			}
			logger.info(String.format("新增社保 社会保险项目数据成功......"));
			return data4new.size();
		}catch(Exception e){
			logger.error(String.format("新增社保 社会保险项目数据出错......"),e);
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
