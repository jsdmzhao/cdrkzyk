package com.jeysan.cpf.datagather.check;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.jeysan.cpf.util.Constants;
import com.jeysan.modules.utils.date.DateUtil;
import com.jeysan.modules.utils.sql.JdbcUtil;
import com.jeysan.modules.utils.sql.ResultSetUtil;


public class HospitalEpipreCheck extends BaseCheck{
	
	private Logger logger = Logger.getLogger(HospitalEpipreCheck.class);
	
	private static final String TABLE_IN_DB = "TEMP_HOSPITAL_DATA_EPIPRE";
	/**字段*/
	private static final String COLUMN_IN_DB = "FATHER,MOTHER,NAME,SEX,BIRTHDAY,DOMICILE_TYPE,TEL,MOBILE,ADDRESS,CREATE_DATE,DOMICILE_ADDRESS,UPDATE_TIME,ID";
	
	private static final String MAX_ID = "select max(id) from FHP_PERSON where nameh = ? ";
	
	private static final String INSERT_SQL_4NEWDATA_1 = "insert into FHP_PERSON(NAMEH,AGE,SEX,DOMICILE_TYPE) VALUES (?,?,?,?)";
	private static final String INSERT_SQL_4NEWDATA_2 = "insert into FHP_PERSON_BASIC(PERSON_ID,BIRTHDAY,ADDRESS,DOMICILE,TEL,REMARK,FATHER,MOTHER) values(?,?,?,?,?,?,?,?)";
	
	private static List tmpIds4Update = new ArrayList();
	
	
	public HospitalEpipreCheck(Connection conn){
		super(conn);
	}


	@SuppressWarnings("unchecked")
	@Override
	public void run() throws SQLException{	
		logger.info("开始导入医院 防疫登记数据......");
		JdbcUtil jdbcUtil = new JdbcUtil(conn,false);
		try {
			//新增
			addNewData(jdbcUtil);
			//更新状态
			updateStatus(TABLE_IN_DB,tmpIds4Update);
			logger.info("导入医院 防疫登记数据成功......");
		} catch (Exception e) {		
			logger.error("导入医院 防疫登记数据出错！" ,e);
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
		logger.info(String.format("开始新增医院 防疫登记数据......"));
		try{
			List<Object[]> data4new = getData4Todo();
			if(data4new!=null && data4new.size() > 0){
				//father,MOTHER,NAME,SEX,BIRTHDAY,DOMICILE_TYPE,TEL,MOBILE,ADDRESS,CREATE_DATE,DOMICILE_ADDRESS,UPDATE_TIME,ID
				String father,mother,name,tel,mobile,address,domicile_address;
				Integer sex,age = 0,domicile_type;
				Long id;
				Date birthday,create_date;
				Timestamp today = new Timestamp(new Date().getTime());
				List<Object[]> params_1 = new ArrayList(), params_2 = new ArrayList();
				for(Object[] m : data4new){
					father = (String)m[0];
					mother = (String)m[1];
					name = (String)m[2];
					sex = Constants.SEX.getStatusByLabel((String)m[3]);
					birthday = (Date)m[4];
					if(birthday != null)
						age = DateUtil.dateDiff("YEAR", today, new Timestamp(birthday.getTime()));
					
					domicile_type = Constants.DOMICILE_TYPE.getStatusByLabel((String)m[5]);
					tel = (String)m[6];
					mobile = (String)m[7];
					address = (String)m[8];
					domicile_address = (String)m[10];
					
					id = (Long)m[12];
					
					tmpIds4Update.add(new Object[]{id});
					
					jdbcUtil.executePreparedStatementUpdate(INSERT_SQL_4NEWDATA_1, new Object[]{name,age,sex,domicile_type});
					conn.commit();
					List<Object[]> max_id_lst = ResultSetUtil.toArrayList(jdbcUtil.executePreparedStatementQuery(MAX_ID, new Object[]{name}));
					Long personId = (Long)max_id_lst.get(0)[0];
					
					
					//PERSON_ID,BIRTHDAY,ADDRESS,DOMICILE,TEL,REMARK,FATHER,MOTHER
					params_2.add(new Object[]{personId,birthday,address,domicile_address,tel,String.format("手机号:%s", mobile),father,mother});
					
					checkAndCommmitData(jdbcUtil, params_2, INSERT_SQL_4NEWDATA_2, true);
				}
				checkAndCommmitData(jdbcUtil, params_2, INSERT_SQL_4NEWDATA_2, false);
			}
			logger.info(String.format("新增医院 防疫登记数据成功......"));
		}catch(Exception e){
			logger.error(String.format("新增医院 防疫登记数据出错......"),e);
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
