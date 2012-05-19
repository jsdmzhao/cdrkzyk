package com.jeysan.cpf.datagather.check;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.jeysan.cpf.util.Constants;
import com.jeysan.modules.utils.date.DateUtil;
import com.jeysan.modules.utils.sql.JdbcUtil;
import com.jeysan.modules.utils.sql.ResultSetUtil;


public class HospitalEpistationCheck extends BaseCheck{
	
	private Logger logger = Logger.getLogger(HospitalEpistationCheck.class);
	
	private static final String TABLE_IN_DB = "TEMP_HOSPITAL_DATA_EPISTATION";
	/**字段*/
	private static final String COLUMN_IN_DB = "CHILD_CODE,FATHER,MOTHER,NAME,SEX,BIRTHDAY,DOMICILE_TYPE,TEL,OFFICE_TEL,MOBILE,ADDRESS,AREA,CREATE_DATE,MOTHER_COMPANY,FATHER_COMPANY,DOMICILE_ADDRESS,DOMICILE_UNIT,UNIT_BELONG,STANDARD,SETTLE_OUT_DATE,UPDATE_TIME,ID";
	
	private static final String update_person4child_sql = "update FHP_PERSON set NAMEH=?,SEX=?,AGE=?,CERT_TYPE=?,CODE=?,DOMICILE_TYPE=?,CANCEL_TYPE=?,CANCEL_DATE=?,DATEH=?,AREA=? where PERSON_CODE = ? ";
	private static final String insert_person4child_sql = "insert into FHP_PERSON(NAMEH,SEX,AGE,CERT_TYPE,CODE,DOMICILE_TYPE,CANCEL_TYPE,CANCEL_DATE,DATEH,AREA,PERSON_CODE) values (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String update_personbasic4child_sql = "update FHP_PERSON_BASIC set DOMICILE=?,ADDRESS=?,BIRTHDAY=?,OWNER_NAME=?,RELATION=?,FATHER=?,MOTHER=? where PERSON_ID = (select id from FHP_PERSON where PERSON_CODE = ? limit 1)";
	private static final String insert_personbasic4child_sql = "insert FHP_PERSON_BASIC ( DOMICILE,ADDRESS,BIRTHDAY,OWNER_NAME,RELATION,FATHER,MOTHER,PERSON_ID) select ?,?,?,?,?,?,?,id from FHP_PERSON where PERSON_CODE = ?";
	private static final String insert_personbasic4parent_sql = "insert FHP_PERSON_BASIC ( DOMICILE,ADDRESS,OWNER_NAME,RELATION,COMPANY,TEL,REMARK,SPOUSE_ID,PERSON_ID) values(?,?,?,?,?,?,?,?,?) ";
	private static final String insert_spouse_sql = "insert FHP_SPOUSE (NAMEH,SEX, DOMICILE,ADDRESS,DOMICILE_TYPE,COMPANY,TEL,REMARK,PERSON_ID) values(?,?,?,?,?,?,?,?,?) ";
	private static final String insert_children_sql = "insert FHP_WOMAN_CHILDREN (NAMEH,SEX, BIRTHDAY,PERSON_ID,PERSON_SELF_ID) select ?,?,?,? id from FHP_PERSON where PERSON_CODE = ? ";
	private static final String insert_person4parent_sql = "insert into FHP_PERSON (NAMEH,SEX,DOMICILE_TYPE,CANCEL_TYPE,CANCEL_DATE,DATEH,AREA) values (?,?,?,?,?,?,?)";
	private static final String select_person_sql = "select id from FHP_PERSON where PERSON_CODE = ? ";
	
	private static final String update_person4parent_sql = "update FHP_PERSON set NAMEH=?,SEX=?,DOMICILE_TYPE=?,CANCEL_TYPE=?,CANCEL_DATE=?,DATEH=?,AREA=? where id = ? ";
	private static final String update_personbasic4father_sql = "update FHP_PERSON_BASIC set DOMICILE=?,ADDRESS=?,OWNER_NAME=?,RELATION=?,COMPANY=?,TEL=?,REMARK=?,SPOUSE_ID=? where PERSON_ID = ? ";
	private static final String update_personbasic4mother_sql = "update FHP_PERSON_BASIC set DOMICILE=?,ADDRESS=?,OWNER_NAME=?,RELATION=?,COMPANY=?,SPOUSE_ID=? where PERSON_ID = ? ";
	private static final String update_spouse4father_sql = "update FHP_SPOUSE set NAMEH=?,SEX=?, DOMICILE=?,ADDRESS=?,DOMICILE_TYPE=?,COMPANY=? where PERSON_ID=?";
	private static final String update_spouse4mother_sql = "update FHP_SPOUSE set NAMEH=?,SEX=?, DOMICILE=?,ADDRESS=?,DOMICILE_TYPE=?,COMPANY=?,TEL=?,REMARK=? where PERSON_ID=?";
	private static final String update_children_sql = "update FHP_WOMAN_CHILDREN set NAMEH=?,SEX=?, BIRTHDAY=?,PERSON_ID=? where PERSON_SELF_ID = (select id from FHP_PERSON where PERSON_CODE = ?) ";
	
	private static final SimpleDateFormat SDF = new SimpleDateFormat("mm/dd/yy hh:mm");
	
	private static List tmpIds4Update = new ArrayList();
	
	public HospitalEpistationCheck(Connection conn){
		super(conn);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void run() throws SQLException{	
		logger.info("开始导入防疫站 电子数据......");
		JdbcUtil jdbcUtil = new JdbcUtil(conn,false);
		try {
			//新增
			addNewData(jdbcUtil,false);
			//更新状态
			updateStatus(TABLE_IN_DB,tmpIds4Update);
			logger.info("导入防疫站 电子数据成功......");
		} catch (Exception e) {		
			logger.error("导入防疫站 电子数据出错！" ,e);
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
		logger.info(String.format("开始%s防疫站 电子数据......",update?"修改":"新增"));
		try{
			List<Object[]> data4new = getData4Todo();
			if(data4new!=null && data4new.size() > 0){
				//CHILD_CODE,FATHER,MOTHER,NAME,SEX,BIRTHDAY,DOMICILE_TYPE,TEL,OFFICE_TEL,MOBILE,ADDRESS,AREA,CREATE_DATE,MOTHER_COMPANY,
				//FATHER_COMPANY,DOMICILE_ADDRESS,DOMICILE_UNIT,UNIT_BELONG,STANDARD,SETTLE_OUT_DATE,UPDATE_TIME,ID
				String child_code,father,mother,name,tel,office_tel,mobile,address,area,mother_company;
				String father_company,domicile_address,domicile_unit,unit_belong,standard;
				Integer sex,domicile_type;
				Date birthday,create_date,settle_out_date;
				Long id;
				List<Object[]> params_updateperson4child = new ArrayList(), params_insertperson4child = new ArrayList(), 
				params_updatepersonbasic4child = new ArrayList(), params_insertpersonbasic4child = new ArrayList();
				
				List<Object[]> params_updateperson4parent = new ArrayList(), params_insertpersonbasic4parent = new ArrayList();

				List<Object[]> params_updatepersonbasic4father = new ArrayList(),params_updatepersonbasic4mother = new ArrayList();
				
				List<Object[]> params_insertspouse = new ArrayList(), params_insertchildren = new ArrayList(),params_updatechildren = new ArrayList();
				
				List<Object[]> params_updatespouse4father = new ArrayList(), params_updatespouse4mother = new ArrayList();
				
				Date today = new Date();

				for(Object[] m : data4new){
					child_code = (String)m[0];
					father = (String)m[1];
					mother = (String)m[2];
					name = (String)m[3];
					sex = Constants.SEX.getStatusByLabel((String)m[4]);
					birthday = (Date)m[5];
					domicile_type = StringUtils.equals((String)m[6],"本地")?Constants.DOMICILE_TYPE.FIX:Constants.DOMICILE_TYPE.FLOW;
					tel = (String)m[7];
					office_tel = (String)m[8];
					mobile = (String)m[9];
					address = (String)m[10];
					area = (String)m[11];
					if(StringUtils.isNotEmpty(area)){
						logger.debug(String.format("居委会名称:%s",area));
						area = getVillageCode(area);
						logger.debug(String.format("最后居委会CODE:%s",area));
					}
					create_date = (Date)m[12];
					mother_company = (String)m[13];
					father_company = (String)m[14];
					domicile_address = (String)m[15];
					domicile_unit = (String)m[16];
					unit_belong = (String)m[17];
					standard = (String)m[18];
					settle_out_date = (Date)m[19];
					
					id = (Long)m[21];
					
					tmpIds4Update.add(new Object[]{id});
					//人员表是否已经存在小孩
					List<Object[]> rst = ResultSetUtil.toArrayList(jdbcUtil.executePreparedStatementQuery(select_person_sql, new String[]{child_code}));
					Object[] params_person4child = new Object[]{name,sex,DateUtil.dateDiff("YEAR", birthday, today),Constants.CARD_TYPE.CERT,standard,domicile_type,settle_out_date==null?null:Constants.CANCEL_TYPE.PERSON_OUT,settle_out_date,settle_out_date==null?null:today,area,child_code};
					Object[] params_personbasic4child = new Object[]{domicile_address,address,birthday,father,sex.intValue()==Constants.SEX.MALE?Constants.RELATION.RE_4:Constants.RELATION.RE_5,father,mother,child_code};
					if(rst.size() > 0){
						Long childPersonId = (Long)(rst.get(0)[0]);
						params_updateperson4child.add(params_person4child);
						params_updatepersonbasic4child.add(params_personbasic4child);
						
						String sql = "select PERSON_ID from FHP_WOMAN_CHILDREN where PERSON_SELF_ID = ? ";
						List<Object[]> lst_tmp = ResultSetUtil.toArrayList(jdbcUtil.executePreparedStatementQuery(sql, new Object[]{childPersonId}));
						//看是否有父亲信息
						Long fatherPersonId = null;
						if(lst_tmp.size()>0){//如果有
							//Long childrenId = (Long)(lst_tmp.get(0)[0]);
							fatherPersonId = (Long)(lst_tmp.get(0)[1]);
							
							sql = "select ID from FHP_PERSON_BASIC where SPOUSE_ID = ? ";
							lst_tmp = ResultSetUtil.toArrayList(jdbcUtil.executePreparedStatementQuery(sql, new Object[]{fatherPersonId}));
							//看是否有母亲信息
							Long motherPersonId = null;
							if(lst_tmp.size()>0){//如果有，则更新母亲信息
								motherPersonId = (Long)(lst_tmp.get(0)[0]);
								Object[] params_person4mother = new Object[]{father,Constants.SEX.FEMALE,domicile_type,settle_out_date==null?null:Constants.CANCEL_TYPE.PERSON_OUT,settle_out_date,settle_out_date==null?null:today,area,motherPersonId};
								params_updateperson4parent.add(params_person4mother);
								Object[] params_personbasic4mother = new Object[]{domicile_address,address,mother,Constants.RELATION.RE_3,father_company,fatherPersonId,motherPersonId};
								params_updatepersonbasic4mother.add(params_personbasic4mother);
								
								sql = "select count(1) from FHP_SPOUSE where PERSON_ID = ? ";
								lst_tmp = ResultSetUtil.toArrayList(jdbcUtil.executePreparedStatementQuery(sql, new Object[]{motherPersonId}));
								//看是否有配偶
								if(lst_tmp.size()>0){//如果有，则更新
									Object[] params_spouse4mother = new Object[]{father,Constants.SEX.MALE,domicile_address,address,domicile_type,father_company,tel,String.format("联系电话:%s,办公室电话:%s",mobile,office_tel),motherPersonId};
									params_updatespouse4mother.add(params_spouse4mother);
								}else{//如果没有，则新增
									Object[] params_spouse4mother = new Object[]{father,Constants.SEX.MALE,domicile_address,address,domicile_type,father_company,tel,String.format("联系电话:%s,办公室电话:%s",mobile,office_tel),motherPersonId};
									params_insertspouse.add(params_spouse4mother);
								}
							}else{//如果没有，则新增母亲信息
								Object[] params_person4mother = new Object[]{mother,Constants.SEX.FEMALE,domicile_type,settle_out_date==null?null:Constants.CANCEL_TYPE.PERSON_OUT,settle_out_date,settle_out_date==null?null:today,area};
								jdbcUtil.executePreparedStatementUpdate(insert_person4parent_sql, params_person4mother);
								conn.commit();
								motherPersonId = getCurrentId("FHP_PERSON");
								Object[] params_personbasic4mother = new Object[]{domicile_address,address,mother,Constants.RELATION.RE_3,mother_company,null,null,fatherPersonId,motherPersonId};
								params_insertpersonbasic4parent.add(params_personbasic4mother);
								//父亲信息入库到母亲配偶表
								Object[] params_spouse4mother = new Object[]{father,Constants.SEX.MALE,domicile_address,address,domicile_type,father_company,tel,String.format("联系电话:%s,办公室电话:%s",mobile,office_tel),motherPersonId};
								params_insertspouse.add(params_spouse4mother);
							}
							//更新父亲信息
							Object[] params_person4father = new Object[]{father,Constants.SEX.MALE,domicile_type,settle_out_date==null?null:Constants.CANCEL_TYPE.PERSON_OUT,settle_out_date,settle_out_date==null?null:today,area,fatherPersonId};
							params_updateperson4parent.add(params_person4father);
							Object[] params_personbasic4father = new Object[]{domicile_address,address,father,Constants.RELATION.RE_1,father_company,tel,String.format("联系电话:%s,办公室电话:%s",mobile,office_tel),motherPersonId,fatherPersonId};
							params_updatepersonbasic4father.add(params_personbasic4father);
							
							
							sql = "select count(1) from FHP_SPOUSE where PERSON_ID = ? ";
							lst_tmp = ResultSetUtil.toArrayList(jdbcUtil.executePreparedStatementQuery(sql, new Object[]{fatherPersonId}));
							//看是否有配偶
							if(lst_tmp.size()>0){//如果有，则更新
								Object[] params_spouse4father = new Object[]{father,Constants.SEX.MALE,domicile_address,address,domicile_type,father_company,fatherPersonId};
								params_updatespouse4father.add(params_spouse4father);
							}else{//如果没有，则新增
								Object[] params_spouse4father = new Object[]{father,Constants.SEX.MALE,domicile_address,address,domicile_type,father_company,fatherPersonId};
								params_insertspouse.add(params_spouse4father);
							}
						}else{//如果没有父亲信息，则增加双亲信息
							//父亲信息入库
							Object[] params_person4father = new Object[]{father,Constants.SEX.MALE,domicile_type,settle_out_date==null?null:Constants.CANCEL_TYPE.PERSON_OUT,settle_out_date,settle_out_date==null?null:today,area};
							jdbcUtil.executePreparedStatementUpdate(insert_person4parent_sql, params_person4father);
							conn.commit();
							fatherPersonId = getCurrentId("FHP_PERSON");
							//母亲信息入库
							Object[] params_person4mother = new Object[]{mother,Constants.SEX.FEMALE,domicile_type,settle_out_date==null?null:Constants.CANCEL_TYPE.PERSON_OUT,settle_out_date,settle_out_date==null?null:today,area};
							jdbcUtil.executePreparedStatementUpdate(insert_person4parent_sql, params_person4mother);
							conn.commit();
							Long motherPersonId = getCurrentId("FHP_PERSON");
							//父亲、母亲入库到基本信息表
							Object[] params_personbasic4father = new Object[]{domicile_address,address,father,Constants.RELATION.RE_1,father_company,tel,String.format("联系电话:%s,办公室电话:%s",mobile,office_tel),motherPersonId,fatherPersonId};
							params_insertpersonbasic4parent.add(params_personbasic4father);
							Object[] params_personbasic4mother = new Object[]{domicile_address,address,mother,Constants.RELATION.RE_3,mother_company,null,null,fatherPersonId,motherPersonId};
							params_insertpersonbasic4parent.add(params_personbasic4mother);
							//父亲、母亲信息入库到配偶表
							Object[] params_spouse4father = new Object[]{father,Constants.SEX.MALE,domicile_address,address,domicile_type,father_company,tel,String.format("联系电话:%s,办公室电话:%s",mobile,office_tel),motherPersonId};
							Object[] params_spouse4mother = new Object[]{mother,Constants.SEX.FEMALE,domicile_address,address,domicile_type,mother_company,null,null,fatherPersonId};
							params_insertspouse.add(params_spouse4father);
							params_insertspouse.add(params_spouse4mother);
						}
						
						sql = "select count(1) from FHP_WOMAN_CHILDREN where PERSON_SELF_ID = ? ";
						lst_tmp = ResultSetUtil.toArrayList(jdbcUtil.executePreparedStatementQuery(sql, new Object[]{childPersonId}));
						//看是否有children表记录
						if(lst_tmp.size()>0){//如果有，则更新
							Object[] params_children = new Object[]{name,sex,birthday,fatherPersonId,child_code};
							params_updatechildren.add(params_children);
						}else{//如果没有，则新增
							Object[] params_children = new Object[]{name,sex,birthday,fatherPersonId,child_code};
							params_insertchildren.add(params_children);
						}
					}else{
						//小孩子信息入库
						params_insertperson4child.add(params_person4child);
						params_insertpersonbasic4child.add(params_personbasic4child);
						//父亲信息入库
						Object[] params_person4father = new Object[]{father,Constants.SEX.MALE,domicile_type,settle_out_date==null?null:Constants.CANCEL_TYPE.PERSON_OUT,settle_out_date,settle_out_date==null?null:today,area};
						jdbcUtil.executePreparedStatementUpdate(insert_person4parent_sql, params_person4father);
						conn.commit();
						Long fatherPersonId = getCurrentId("FHP_PERSON");
						//母亲信息入库
						Object[] params_person4mother = new Object[]{mother,Constants.SEX.FEMALE,domicile_type,settle_out_date==null?null:Constants.CANCEL_TYPE.PERSON_OUT,settle_out_date,settle_out_date==null?null:today,area};
						jdbcUtil.executePreparedStatementUpdate(insert_person4parent_sql, params_person4mother);
						conn.commit();
						Long motherPersonId = getCurrentId("FHP_PERSON");
						//父亲、母亲入库到基本信息表
						Object[] params_personbasic4father = new Object[]{domicile_address,address,father,Constants.RELATION.RE_1,father_company,tel,String.format("联系电话:%s,办公室电话:%s",mobile,office_tel),motherPersonId,fatherPersonId};
						params_insertpersonbasic4parent.add(params_personbasic4father);
						Object[] params_personbasic4mother = new Object[]{domicile_address,address,mother,Constants.RELATION.RE_3,mother_company,null,null,fatherPersonId,motherPersonId};
						params_insertpersonbasic4parent.add(params_personbasic4mother);
						//父亲、母亲信息入库到配偶表
						Object[] params_spouse4father = new Object[]{father,Constants.SEX.MALE,domicile_address,address,domicile_type,father_company,tel,String.format("联系电话:%s,办公室电话:%s",mobile,office_tel),motherPersonId};
						Object[] params_spouse4mother = new Object[]{mother,Constants.SEX.FEMALE,domicile_address,address,domicile_type,mother_company,null,null,fatherPersonId};
						params_insertspouse.add(params_spouse4father);
						params_insertspouse.add(params_spouse4mother);
						//小孩信息入库到子女表
						Object[] params_children = new Object[]{name,sex,birthday,fatherPersonId,child_code};
						params_insertchildren.add(params_children);
						
					}
					
					
					checkAndCommmitData(jdbcUtil, params_insertperson4child, insert_person4child_sql, true);
					checkAndCommmitData(jdbcUtil, params_updateperson4child, update_person4child_sql, true);
					checkAndCommmitData(jdbcUtil, params_insertpersonbasic4child, insert_personbasic4child_sql, true);
					checkAndCommmitData(jdbcUtil, params_updatepersonbasic4child, update_personbasic4child_sql, true);
					checkAndCommmitData(jdbcUtil, params_insertpersonbasic4parent, insert_personbasic4parent_sql, true);
					checkAndCommmitData(jdbcUtil, params_insertspouse, insert_spouse_sql, true);
					checkAndCommmitData(jdbcUtil, params_insertchildren, insert_children_sql, true);
					
					checkAndCommmitData(jdbcUtil, params_updateperson4parent, update_person4parent_sql, true);
					checkAndCommmitData(jdbcUtil, params_updatepersonbasic4father, update_personbasic4father_sql, true);
					checkAndCommmitData(jdbcUtil, params_updatepersonbasic4mother, update_personbasic4mother_sql, true);
					
					checkAndCommmitData(jdbcUtil, params_updatespouse4mother, update_spouse4mother_sql, true);
					checkAndCommmitData(jdbcUtil, params_updatespouse4father, update_spouse4father_sql, true);
					
					checkAndCommmitData(jdbcUtil, params_updatechildren, update_children_sql, true);
				}
				
				checkAndCommmitData(jdbcUtil, params_insertperson4child, insert_person4child_sql, false);
				checkAndCommmitData(jdbcUtil, params_updateperson4child, update_person4child_sql, false);
				checkAndCommmitData(jdbcUtil, params_insertpersonbasic4child, insert_personbasic4child_sql, false);
				checkAndCommmitData(jdbcUtil, params_updatepersonbasic4child, update_personbasic4child_sql, false);
				checkAndCommmitData(jdbcUtil, params_insertpersonbasic4parent, insert_personbasic4parent_sql, false);
				checkAndCommmitData(jdbcUtil, params_insertspouse, insert_spouse_sql, false);
				checkAndCommmitData(jdbcUtil, params_insertchildren, insert_children_sql, false);
				

				checkAndCommmitData(jdbcUtil, params_updateperson4parent, update_person4parent_sql, false);
				checkAndCommmitData(jdbcUtil, params_updatepersonbasic4father, update_personbasic4father_sql, false);
				checkAndCommmitData(jdbcUtil, params_updatepersonbasic4mother, update_personbasic4mother_sql, false);
				
				checkAndCommmitData(jdbcUtil, params_updatespouse4mother, update_spouse4mother_sql, false);
				checkAndCommmitData(jdbcUtil, params_updatespouse4father, update_spouse4father_sql, false);
				
				checkAndCommmitData(jdbcUtil, params_updatechildren, update_children_sql, false);
				
			}
			logger.info(String.format("%s防疫站 电子数据成功......",update?"修改":"新增"));
		}catch(Exception e){
			logger.error(String.format("%s防疫站 电子数据出错......",update?"修改":"新增"),e);
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
			rs = jdbcUtil.executePreparedStatementQuery(new StringBuilder().append("select ").append(COLUMN_IN_DB).append(" from " ).append(TABLE_IN_DB).append( " as a where a.check_type = ? ").toString(), new Object[]{0});
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
