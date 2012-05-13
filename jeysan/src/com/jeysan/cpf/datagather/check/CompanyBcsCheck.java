package com.jeysan.cpf.datagather.check;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.jeysan.cpf.util.Constants;
import com.jeysan.modules.utils.date.DateUtil;
import com.jeysan.modules.utils.sql.JdbcUtil;


public class CompanyBcsCheck extends BaseCheck{
	
	private Logger logger = Logger.getLogger(CompanyBcsCheck.class);
	
	private static final String TABLE_IN_DB = "TEMP_COMPANY_DATA_BCS";
	/**字段*/
	private static final String COLUMN_IN_DB = "NAME,RELATION,SEX,BIRTHDAY,CODE,DOMICILE,DOMICILE_TYPE,EDU,MARRY_STATUS,ADDRESS,JOIN_DATE,COMPANY,UPDATE_TIME,ID";

	private static final String INSERT_SQL_4NEWDATA_1 = "insert into FHP_PERSON(NAMEH,SEX,AGE,CERT_TYPE,CODE) VALUES (?,?,?,?,?)";
	private static final String INSERT_SQL_4NEWDATA_2 = "insert into FHP_PERSON_BASIC(PERSON_ID,ADDRESS,DOMICILE,BIRTHDAY,HOUSEHODE_KIND,RELATION,MARRY_STATUS,EDU,COMPANY,REMARK) select id,?,?,?,? from FHP_PERSON where code = ?";
	
	private static final String UPDATE_SQL_4UPDATEDATA_1 = "update FHP_PERSON set NAMEH = ? , SEX = ?,AGE = ?,CERT_TYPE = ? where CODE = ? ";
	private static final String UPDATE_SQL_4UPDATEDATA_2 = "update FHP_PERSON_BASIC set ADDRESS = ?,DOMICILE = ?,BIRTHDAY = ?,HOUSEHODE_KIND = ?,RELATION = ?,MARRY_STATUS = ?,EDU = ?,COMPANY = ?,REMARK = ? where PERSON_ID = (select ID from FHP_PERSON where CODE = ? limit 1)";
	
	private static List tmpIds4Update = new ArrayList();
	
	private static final ResourceBundle bundle = ResourceBundle.getBundle("com.jeysan.cpf.datagather.check.constants4check");
	
	public CompanyBcsCheck(Connection conn){
		super(conn);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void run() throws SQLException{	
		logger.info("开始导入企业 人员计划生育数据......");
		JdbcUtil jdbcUtil = new JdbcUtil(conn,false);
		try {
			//新增
			addNewData(jdbcUtil,false);
			//修改
			addNewData(jdbcUtil,true);
			//更新状态
			updateStatus(TABLE_IN_DB,tmpIds4Update);
			logger.info("导入企业 人员计划生育数据成功......");
		} catch (Exception e) {		
			logger.error("导入企业 人员计划生育数据出错！" ,e);
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
		logger.info(String.format("开始%s企业 人员计划生育数据......",update?"修改":"新增"));
		try{
			List<Object[]> data4new = getData4Todo(update);
			if(data4new!=null && data4new.size() > 0){
				//NAME,RELATION,SEX,BIRTHDAY,CODE,DOMICILE,
				//DOMICILE_TYPE,EDU,MARRY_STATUS,ADDRESS,JOIN_DATE,COMPANY,UPDATE_TIME,ID
				String name,code,domicile,address,company;
				Integer relation,sex,domicile_type,edu,marry_status,age=0;
				Date birthday,join_date;
				Long id;
				Timestamp today = new Timestamp(new Date().getTime());
				List<Object[]> params_1 = new ArrayList(), params_2 = new ArrayList();
				for(Object[] m : data4new){
					name = (String)m[0];
					relation = Constants.RELATION.getStatusByLabel(bundle.getString("relation_"+m[1]));
					sex = Constants.SEX.getStatusByLabel(bundle.getString("sex_"+m[2]));
					birthday = (Date)m[3];
					if(birthday != null)
						age = DateUtil.dateDiff("YEAR", new Timestamp(birthday.getTime()), today);
					code = (String)m[4];
					domicile = (String)m[5];
					domicile_type = Constants.HOUSEHODE_KIND.getStatusByLabel(bundle.getString("househode_kind_"+m[6]));
					edu = Constants.DEGREE.getStatusByLabel(bundle.getString("edu_"+m[7]));
					marry_status = Constants.MARRY_STATUS.getStatusByLabel(bundle.getString("marry_status_"+m[8]));
					address = (String)m[9];
					join_date = (Date)m[10];
					company = (String)m[11];
					
					id = (Long)m[13];
					
					tmpIds4Update.add(new Object[]{id});
					//NAMEH,SEX,AGE,CERT_TYPE,CODE
					//PERSON_ID,ADDRESS,DOMICILE,BIRTHDAY,HOUSEHODE_KIND,RELATION,MARRY_STATUS,EDU,COMPANY,REMARK
					params_1.add(new Object[]{name,sex,age,Constants.CARD_TYPE.CERT,code});
					params_2.add(new Object[]{address,domicile,birthday,domicile_type,relation,marry_status,edu,company,String.format("进厂(企业)时间:%s", join_date),code});

					checkAndCommmitData(jdbcUtil, params_1, update?UPDATE_SQL_4UPDATEDATA_1:INSERT_SQL_4NEWDATA_1, true);
					checkAndCommmitData(jdbcUtil, params_2, update?UPDATE_SQL_4UPDATEDATA_2:INSERT_SQL_4NEWDATA_2, true);
				}
				checkAndCommmitData(jdbcUtil, params_1, update?UPDATE_SQL_4UPDATEDATA_1:INSERT_SQL_4NEWDATA_1, false);
				checkAndCommmitData(jdbcUtil, params_2, update?UPDATE_SQL_4UPDATEDATA_2:INSERT_SQL_4NEWDATA_2, false);
			}
			logger.info(String.format("%s企业 人员计划生育数据成功......",update?"修改":"新增"));
		}catch(Exception e){
			logger.error(String.format("%s企业 人员计划生育数据出错......",update?"修改":"新增"),e);
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
