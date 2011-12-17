package com.jeysan.cpf.decision.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.decision.dao.FlowStatReportsDao;
import com.jeysan.cpf.district.entity.DistrictVillage;
import com.jeysan.cpf.district.service.DistrictVillageManager;
import com.jeysan.cpf.util.Constants;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.utils.date.DateUtil;
import com.jeysan.modules.utils.math.DoubleUtil;
import com.jeysan.modules.utils.math.IntegerUtil;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class FlowStatReportsManager {
	private static Logger logger = LoggerFactory.getLogger(FlowStatReportsManager.class);
	
	private FlowStatReportsDao flowStatReportsDao;
	private DistrictVillageManager districtVillageManager;

	@Autowired
	public void setFlowStatReportsDao(FlowStatReportsDao flowStatReportsDao) {
		this.flowStatReportsDao = flowStatReportsDao;
	}
	
	@Autowired
	public void setDistrictVillageManager(DistrictVillageManager districtVillageManager) {
		this.districtVillageManager = districtVillageManager;
	}
	
	/**
	 * 统计表1-期间计划生育情况统计表 
	 * @param page
	 * @param startDate
	 * @param endDate
	 * @param area
	 * @return
	 */
	private Map findStat1Reports(Page page,Date startDate,Date endDate,String area,Integer domicileType){
		List params = new ArrayList();
		StringBuilder sql = new StringBuilder()

		.append(" select * from ( ")
		//一孩、政策内一孩、二孩、政策内二孩、三孩及以上、政策内三孩及以上
		.append(" select count(1) as counth,p.area,11 as TYPEH from fhp_woman_children as wc LEFT JOIN fhp_person as p on p.ID = wc.PERSON_ID ")
		.append(" where wc.BIRTHDAY BETWEEN ? AND ? and p.DOMICILE_TYPE = ? ")
		.append(" and wc.CHILD_INDEX = 1 group by p.area  ")
		.append(" union all ")
		.append(" select count(1) as counth,p.area,12 as TYPEH from fhp_woman_children as wc LEFT JOIN fhp_person as p on p.ID = wc.PERSON_ID ")
		.append(" where wc.BIRTHDAY BETWEEN ? AND ? and p.DOMICILE_TYPE = ? ")
		.append(" and wc.CHILD_INDEX = 1 and wc.POLICY = 290 group by p.area  ")
		.append(" union all ")
		.append(" select count(1) as counth,p.area,13 as TYPEH from fhp_woman_children as wc LEFT JOIN fhp_person as p on p.ID = wc.PERSON_ID ")
		.append(" where wc.BIRTHDAY BETWEEN ? AND ? and p.DOMICILE_TYPE = ? ")
		.append(" and wc.CHILD_INDEX = 2 group by p.area ")
		.append(" union all ")
		.append(" select count(1) as counth,p.area,14 as TYPEH from fhp_woman_children as wc LEFT JOIN fhp_person as p on p.ID = wc.PERSON_ID ")
		.append(" where wc.BIRTHDAY BETWEEN ? AND ? and p.DOMICILE_TYPE = ? ")
		.append(" and wc.CHILD_INDEX = 2 and wc.POLICY = 290 group by p.area ")
		.append(" union all ")
		.append(" select count(1) as counth,p.area,15 as TYPEH from fhp_woman_children as wc LEFT JOIN fhp_person as p on p.ID = wc.PERSON_ID ")
		.append(" where wc.BIRTHDAY BETWEEN ? AND ? and p.DOMICILE_TYPE = ? ")
		.append(" and wc.CHILD_INDEX >= 3 group by p.area ")
		.append(" union all ")
		.append(" select count(1) as counth,p.area,16 as TYPEH from fhp_woman_children as wc LEFT JOIN fhp_person as p on p.ID = wc.PERSON_ID ")
		.append(" where wc.BIRTHDAY BETWEEN ? AND ? and p.DOMICILE_TYPE = ? ")
		.append(" and wc.CHILD_INDEX >= 3 and wc.POLICY = 290 group by p.area ")

		.append(" union all ")
		//男扎、女扎、二孩结扎、纯二女结扎
		.append(" select count(1) as COUNTH,p.AREA,21 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id ")
		.append(" where wc.METHOD = 201 and wc.OPS_DATE  BETWEEN ? AND ? and p.DOMICILE_TYPE = ? ")
		.append(" group by p.area ")
		.append(" union all ")
		.append(" select count(1) as COUNTH,p.AREA,22 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id ")
		.append(" where wc.METHOD = 202 and wc.OPS_DATE  BETWEEN ? AND ? and p.DOMICILE_TYPE = ? ")
		.append(" group by p.area ")
		.append(" union all ")
		.append(" select count(1) as COUNTH,p.AREA,23 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id ")
		.append(" where (wc.METHOD = 201 or wc.METHOD = 202) ")
		.append(" and wc.OPS_DATE  BETWEEN ? AND ? and p.DOMICILE_TYPE = ? ")
		.append(" and (select count(1) from fhp_woman_children as wc where wc.person_id = p.ID ) = 2 ")
		.append(" group by p.area ")
		.append(" union all ")
		.append(" select count(1) as COUNTH,p.AREA,24 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id ")
		.append(" where (wc.METHOD = 201 or wc.METHOD = 202) ")
		.append(" and wc.OPS_DATE  BETWEEN ? AND ? and p.DOMICILE_TYPE = ? ")
		.append(" and (select count(1) from fhp_woman_children as wc where wc.person_id = p.ID ) = 2 ")
		.append(" and (select count(1) from fhp_woman_children as wc where wc.person_id = p.ID and wc.sex = 2 ) = 2 ")
		.append(" group by p.area ")

		.append(" union all ")
		//上环、一孩上环
		.append(" select count(1) as COUNTH,p.AREA,31 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id ")
		.append(" where wc.METHOD = 203 ")
		.append(" and wc.OPS_DATE  BETWEEN ? AND ? and p.DOMICILE_TYPE = ? ")
		.append(" group by p.area ")
		.append(" union all ")
		.append(" select count(1) as COUNTH,p.AREA,32 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id ")
		.append(" where wc.METHOD = 203 ")
		.append(" and wc.OPS_DATE  BETWEEN ? AND ? and p.DOMICILE_TYPE = ? ")
		.append(" and (select count(1) from fhp_woman_children as wc where wc.person_id = p.ID ) = 1 ")
		.append(" group by p.area ")

		.append(" union all  ")
		//补救措施一、补救措施二
		.append(" select count(1) as COUNTH,p.AREA,41 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id ")
		.append(" where wc.REPAIR_METHOD = 266 ")
		.append(" and wc.REPAIR_DATE  BETWEEN ? AND ? and p.DOMICILE_TYPE = ? ")
		.append(" group by p.area ")
		.append(" union all ")
		.append(" select count(1) as COUNTH,p.AREA,42 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id ")
		.append(" where wc.REPAIR_METHOD = 267 ")
		.append(" and wc.REPAIR_DATE  BETWEEN ? AND ? and p.DOMICILE_TYPE = ? ")
		.append(" group by p.area ")

		.append(" union all  ")
		//皮下埋植
		.append(" select count(1) as COUNTH,p.AREA,51 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id ")
		.append(" where wc.METHOD = 207 ")
		.append(" and wc.OPS_DATE  BETWEEN ? AND ? and p.DOMICILE_TYPE = ? ")
		.append(" group by p.area ")
		.append(" ) a where 1=1 ");
		
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);

		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		
		if(StringUtils.isNotEmpty(area)){
			sql.append(" and a.AREA = ? ");
			params.add(area);
		}
		if(StringUtils.isNotEmpty(page.getOrderBy())){
			sql.append(" order by a.").append(page.getOrderBy());
			if(StringUtils.isNotEmpty(page.getOrder()))
				sql.append(" ").append(page.getOrder());
		}
		List<Map<String,Object>> result_orin = this.flowStatReportsDao.findBySql(sql.toString(), params.toArray());
		Map<String,Map<String,Object>> result = new HashMap<String,Map<String,Object>>();
		String area_tmp = null ;
		Integer count_tmp = null , type_tmp = null;
		for(Map<String,Object> ros : result_orin){
			area_tmp = (String)ros.get("AREA");
			count_tmp = ((BigInteger)ros.get("COUNTH")).intValue();
			type_tmp = ((BigInteger)ros.get("TYPEH")).intValue();
			//注意这里极易出现统计错误
			if(!result.containsKey(area_tmp)){
				result.put(area_tmp, new HashMap<String,Object>());
			}
			result.get(area_tmp).put("s"+type_tmp, count_tmp);
		}
		return result;
	}
	
	public List findStat1Reports_4AutoPrint(Page page,Date startDate,Date endDate,String area,Integer domicileType){
		Map<String,Map<String,Object>> result = findStat1Reports(page, startDate, endDate, area, domicileType);
		List<DistrictVillage> villages = districtVillageManager.getAllByParentId(Constants.COMMON_PARAM.CURRENT_TOWN_ID);
		List lst = new ArrayList();
		Map tmp = null;
		Map<String,Object> si = null; 
		for(DistrictVillage dv : villages){
			tmp = new HashMap();
			if(result == null){
				setValue2Map4stat1(tmp,dv.getName(),0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
			}else{
				si = result.get(dv.getCode());
				if(si == null){
					setValue2Map4stat1(tmp,dv.getName(),0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
				}else{
					setValue2Map4stat1(tmp,dv.getName(),
							(Integer)si.get("s11"),
							(Integer)si.get("s12"),
							(Integer)si.get("s13"),
							(Integer)si.get("s14"),
							(Integer)si.get("s15"),
							(Integer)si.get("s16"),
							(Integer)si.get("s21"),
							(Integer)si.get("s22"),
							(Integer)si.get("s23"),
							(Integer)si.get("s24"),
							(Integer)si.get("s31"),
							(Integer)si.get("s32"),
							(Integer)si.get("s41"),
							(Integer)si.get("s42"),
							(Integer)si.get("s51"));
				}
			}
			lst.add(tmp);
		}
		lst.set(0, getTotal1(lst));
		return lst;
	}
	
	private Map getTotal1(List<Map> lst){
		Map tmp = new HashMap();
		Integer s11 = 0,s12 = 0,s13 = 0,s14 = 0,s15 = 0,s16 = 0,s21 = 0,s22 = 0,s23 = 0,s24 = 0,s31 = 0,s32 = 0,s41 = 0,s42 = 0,s51 = 0;
		for(Map m : lst){
			s11 = IntegerUtil.add(s11,(Integer)m.get("s11"));
			s12 = IntegerUtil.add(s12,(Integer)m.get("s12"));
			s13 = IntegerUtil.add(s13,(Integer)m.get("s13"));
			s14 = IntegerUtil.add(s14,(Integer)m.get("s14"));
			s15 = IntegerUtil.add(s15,(Integer)m.get("s15"));
			s16 = IntegerUtil.add(s16,(Integer)m.get("s16"));
			s21 = IntegerUtil.add(s21,(Integer)m.get("s21"));
			s22 = IntegerUtil.add(s22,(Integer)m.get("s22"));
			s23 = IntegerUtil.add(s23,(Integer)m.get("s23"));
			s24 = IntegerUtil.add(s24,(Integer)m.get("s24"));
			s31 = IntegerUtil.add(s31,(Integer)m.get("s31"));
			s32 = IntegerUtil.add(s32,(Integer)m.get("s32"));
			s41 = IntegerUtil.add(s41,(Integer)m.get("s41"));
			s42 = IntegerUtil.add(s42,(Integer)m.get("s42"));
			s51 = IntegerUtil.add(s51,(Integer)m.get("s51"));
		}
		setValue2Map4stat1(tmp, "总计", s11, s12, s13,s14,s15,s16,s21,s22,s23,s24,s31,s32,s41,s42,s51);
		return tmp;
	}
	
	@SuppressWarnings("unchecked")
	private void setValue2Map4stat1(Map map_tmp,String area,Integer s11,Integer s12,Integer s13,Integer s14,Integer s15,Integer s16,Integer s21,Integer s22,Integer s23,Integer s24,Integer s31,Integer s32,Integer s41,Integer s42,Integer s51){
		if(s11 == null) s11 = 0;
		if(s12 == null) s12 = 0;
		if(s13 == null) s13 = 0;
		if(s14 == null) s14 = 0;
		if(s15 == null) s15 = 0;
		if(s16 == null) s16 = 0;
		if(s21 == null) s21 = 0;
		if(s22 == null) s22 = 0;
		if(s23 == null) s23 = 0;
		if(s24 == null) s24 = 0;
		if(s31 == null) s31 = 0;
		if(s32 == null) s32 = 0;
		if(s41 == null) s41 = 0;
		if(s42 == null) s42 = 0;
		if(s51 == null) s51 = 0;
		map_tmp.put("s11", s11);
		map_tmp.put("s12", s12);
		map_tmp.put("s13", s13);
		map_tmp.put("s14", s14);
		map_tmp.put("s15", s15);
		map_tmp.put("s16", s16);
		map_tmp.put("s21", s21);
		map_tmp.put("s22", s22);
		map_tmp.put("s23", s23);
		map_tmp.put("s24", s24);
		map_tmp.put("s31", s31);
		map_tmp.put("s32", s32);
		map_tmp.put("s41", s41);
		map_tmp.put("s42", s42);
		map_tmp.put("s51", s51);
		
		map_tmp.put("area", area);
		Integer totalBorn = IntegerUtil.add(s11,s13,s15);
		Integer totalBornPolicy = IntegerUtil.add(s12,s14,s16);
		map_tmp.put("a1", DoubleUtil.div(s11, totalBorn));
		map_tmp.put("a2", DoubleUtil.div(s13, totalBorn));
		map_tmp.put("a3", DoubleUtil.div(s14, s13));
		map_tmp.put("a4", DoubleUtil.div(s15, totalBorn));
		map_tmp.put("a5", totalBorn);
		//map_tmp.put("a6", );与去年同期相比 暂未加
		map_tmp.put("a7", DoubleUtil.div(totalBornPolicy, totalBorn));
		
		map_tmp.put("b1", IntegerUtil.add(s21,s22));//结扎小计
		map_tmp.put("c1", IntegerUtil.add(s41,s42));//补救措施小计
		map_tmp.put("d1", IntegerUtil.add(totalBorn,(Integer)map_tmp.get("b1"),s31,(Integer)map_tmp.get("c1"),s51));//合计
		//map_tmp.put("e1", );与去年同期相比 暂未加
	}
	
	/**
	 * 统计表2-期间人口自然变动及女性初婚情况统计表
	 * @param page
	 * @param startDate
	 * @param endDate
	 * @param area
	 * @return
	 */
	public Map findStat2Reports(Page page,Date startDate,Date endDate,String area,Integer domicileType){
		List params = new ArrayList();
		StringBuilder sql = new StringBuilder()

		.append(" select * from ( ")
		//一孩、政策内一孩、二孩、政策内二孩、三孩、政策内三孩
		.append(" select count(1) as counth,p.area,11 as TYPEH,wc.sex from fhp_woman_children as wc LEFT JOIN fhp_person as p on p.ID = wc.PERSON_ID ")
		.append(" where wc.BIRTHDAY BETWEEN ? AND ? and p.DOMICILE_TYPE = ? ")
		.append(" and wc.CHILD_INDEX = 1 group by p.area,wc.sex  ")
		.append(" union all ")
		.append(" select count(1) as counth,p.area,12 as TYPEH,wc.sex from fhp_woman_children as wc LEFT JOIN fhp_person as p on p.ID = wc.PERSON_ID ")
		.append(" where wc.BIRTHDAY BETWEEN ? AND ? and p.DOMICILE_TYPE = ? ")
		.append(" and wc.CHILD_INDEX = 1 and wc.POLICY = 290 group by p.area,wc.sex  ")
		.append(" union all ")
		.append(" select count(1) as counth,p.area,13 as TYPEH,wc.sex from fhp_woman_children as wc LEFT JOIN fhp_person as p on p.ID = wc.PERSON_ID ")
		.append(" where wc.BIRTHDAY BETWEEN ? AND ? and p.DOMICILE_TYPE = ? ")
		.append(" and wc.CHILD_INDEX = 2 group by p.area,wc.sex ")
		.append(" union all ")
		.append(" select count(1) as counth,p.area,14 as TYPEH,wc.sex from fhp_woman_children as wc LEFT JOIN fhp_person as p on p.ID = wc.PERSON_ID ")
		.append(" where wc.BIRTHDAY BETWEEN ? AND ? and p.DOMICILE_TYPE = ? ")
		.append(" and wc.CHILD_INDEX = 2 and wc.POLICY = 290 group by p.area,wc.sex ")
		.append(" union all ")
		.append(" select count(1) as counth,p.area,15 as TYPEH,wc.sex from fhp_woman_children as wc LEFT JOIN fhp_person as p on p.ID = wc.PERSON_ID ")
		.append(" where wc.BIRTHDAY BETWEEN ? AND ? and p.DOMICILE_TYPE = ? ")
		.append(" and wc.CHILD_INDEX >= 3 group by p.area,wc.sex ")
		.append(" union all ")
		.append(" select count(1) as counth,p.area,16 as TYPEH,wc.sex from fhp_woman_children as wc LEFT JOIN fhp_person as p on p.ID = wc.PERSON_ID ")
		.append(" where wc.BIRTHDAY BETWEEN ? AND ? and p.DOMICILE_TYPE = ? ")
		.append(" and wc.CHILD_INDEX >= 3 and wc.POLICY = 290 group by p.area,wc.sex ")
		.append(" union all ")
		//死亡
		.append(" select count(1) as counth,p.area,21 as TYPEH,-1 as sex from fhp_death_reg as dr LEFT JOIN fhp_person as p on p.ID = dr.PERSON_ID ")
		.append(" where dr.DATEH  BETWEEN ? AND ? and p.DOMICILE_TYPE = ? ")
		.append(" union all ")
		//女性初婚、20岁以下、23岁以上
		.append(" select count(1) as counth,p.area,31 as TYPEH,-1 as sex from fhp_person as p LEFT JOIN fhp_person_basic as pb on pb.PERSON_ID = p.ID ")
		.append(" where p.SEX = 2 and pb.FIRST_MARRY_DATE BETWEEN ? AND ? and p.DOMICILE_TYPE = ? ")
		.append(" union all ")
		.append(" select count(1) as counth,p.area,32 as TYPEH,-1 as sex from fhp_person as p LEFT JOIN fhp_person_basic as pb on pb.PERSON_ID = p.ID ")
		.append(" where p.SEX = 2 and pb.FIRST_MARRY_DATE BETWEEN ? AND ? and p.age <= 20 and p.DOMICILE_TYPE = ? ")
		.append(" union all ")
		.append(" select count(1) as counth,p.area,33 as TYPEH,-1 as sex from fhp_person as p LEFT JOIN fhp_person_basic as pb on pb.PERSON_ID = p.ID ")
		.append(" where p.SEX = 2 and pb.FIRST_MARRY_DATE BETWEEN ? AND ? and p.age >= 23 and p.DOMICILE_TYPE = ? ")
		.append(" ) a where 1=1 ");
		
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		
		if(StringUtils.isNotEmpty(area)){
			sql.append(" and a.AREA = ? ");
			params.add(area);
		}
		if(StringUtils.isNotEmpty(page.getOrderBy())){
			sql.append(" order by a.").append(page.getOrderBy());
			if(StringUtils.isNotEmpty(page.getOrder()))
				sql.append(" ").append(page.getOrder());
		}
		List<Map<String,Object>> result_orin = this.flowStatReportsDao.findBySql(sql.toString(), params.toArray());
		Map<String,Map<String,Object>> result = new HashMap<String,Map<String,Object>>();
		String area_tmp = null ;
		Integer count_tmp = null , type_tmp = null, sex_tmp = null;
		for(Map<String,Object> ros : result_orin){
			area_tmp = (String)ros.get("AREA");
			count_tmp = ((BigInteger)ros.get("counth")).intValue();
			type_tmp = ((BigInteger)ros.get("TYPEH")).intValue();
			sex_tmp = ((BigInteger)ros.get("sex")).intValue();
			//注意这里极易出现统计错误
			if(!result.containsKey(area_tmp)){
				result.put(area_tmp, new HashMap<String,Object>());
			}
			if(type_tmp >= 11 && type_tmp <= 16){
				result.get(area_tmp).put("s"+type_tmp+"_"+sex_tmp, count_tmp);
			}else
				result.get(area_tmp).put("s"+type_tmp, count_tmp);
		}
		return result;
	}
	
	public List findStat2Reports_4AutoPrint(Page page,Date startDate,Date endDate,String area,Integer domicileType){
		Map<String,Map<String,Object>> result = findStat2Reports(page, startDate, endDate, area, domicileType);
		List<DistrictVillage> villages = districtVillageManager.getAllByParentId(Constants.COMMON_PARAM.CURRENT_TOWN_ID);
		List lst = new ArrayList();
		Map tmp = null;
		Map<String,Object> si = null; 
		for(DistrictVillage dv : villages){
			tmp = new HashMap();
			if(result == null){
				setValue2Map4stat2(tmp,dv.getName(),0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
			}else{
				si = result.get(dv.getCode());
				if(si == null){
					setValue2Map4stat2(tmp,dv.getName(),0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
				}else{
					setValue2Map4stat2(tmp,dv.getName(),
							(Integer)si.get("s11_1"),
							(Integer)si.get("s11_2"),
							(Integer)si.get("s12_1"),
							(Integer)si.get("s12_2"),
							(Integer)si.get("s13_1"),
							(Integer)si.get("s13_2"),
							(Integer)si.get("s14_1"),
							(Integer)si.get("s14_2"),
							(Integer)si.get("s15_1"),
							(Integer)si.get("s15_2"),
							(Integer)si.get("s16_1"),
							(Integer)si.get("s16_2"),
							(Integer)si.get("s21"),
							(Integer)si.get("s31"),
							(Integer)si.get("s32"),
							(Integer)si.get("s33"));
				}
			}
			lst.add(tmp);
		}
		lst.set(0, getTotal2(lst));
		return lst;
	}
	
	private Map getTotal2(List<Map> lst){
		Map tmp = new HashMap();
		Integer s11_1 = 0,s11_2 = 0,s12_1 = 0,s12_2 = 0,s13_1 = 0,s13_2 = 0,s14_1 = 0,s14_2 = 0,s15_1 = 0,s15_2 = 0,s16_1 = 0,s16_2 = 0,s21 = 0,s31 = 0,s32 = 0,s33 = 0;
		for(Map m : lst){
			s11_1 = IntegerUtil.add(s11_1,(Integer)m.get("s11_1"));
			s12_1 = IntegerUtil.add(s12_1,(Integer)m.get("s12_1"));
			s13_1 = IntegerUtil.add(s13_1,(Integer)m.get("s13_1"));
			s14_1 = IntegerUtil.add(s14_1,(Integer)m.get("s14_1"));
			s15_1 = IntegerUtil.add(s15_1,(Integer)m.get("s15_1"));
			s16_1 = IntegerUtil.add(s16_1,(Integer)m.get("s16_1"));
			s11_2 = IntegerUtil.add(s11_2,(Integer)m.get("s11_2"));
			s12_2 = IntegerUtil.add(s12_2,(Integer)m.get("s12_2"));
			s13_2 = IntegerUtil.add(s13_2,(Integer)m.get("s13_2"));
			s14_2 = IntegerUtil.add(s14_2,(Integer)m.get("s14_2"));
			s15_2 = IntegerUtil.add(s15_2,(Integer)m.get("s15_2"));
			s16_2 = IntegerUtil.add(s16_2,(Integer)m.get("s16_2"));
			s21 = IntegerUtil.add(s21,(Integer)m.get("s21"));
			s31 = IntegerUtil.add(s31,(Integer)m.get("s31"));
			s32 = IntegerUtil.add(s32,(Integer)m.get("s32"));
			s33 = IntegerUtil.add(s33,(Integer)m.get("s33"));
		}
		setValue2Map4stat2(tmp, "总计", s11_1,s11_2, s12_1,s12_2, s13_1,s13_2,s14_1,s14_2,s15_1,s15_2,s16_1,s16_2,s21,s31,s32,s33);
		return tmp;
	}
	
	private void setValue2Map4stat2(Map map_tmp,String area,Integer s11_1,Integer s12_1,Integer s13_1,Integer s14_1,Integer s15_1,Integer s16_1,Integer s11_2,Integer s12_2,Integer s13_2,Integer s14_2,Integer s15_2,Integer s16_2,Integer s21,Integer s31,Integer s32,Integer s33){
		if(s11_1 == null) s11_1 = 0;
		if(s12_1 == null) s12_1 = 0;
		if(s13_1 == null) s13_1 = 0;
		if(s14_1 == null) s14_1 = 0;
		if(s15_1 == null) s15_1 = 0;
		if(s16_1 == null) s16_1 = 0;
		if(s11_2 == null) s11_2 = 0;
		if(s12_2 == null) s12_2 = 0;
		if(s13_2 == null) s13_2 = 0;
		if(s14_2 == null) s14_2 = 0;
		if(s15_2 == null) s15_2 = 0;
		if(s16_2 == null) s16_2 = 0;
		if(s21 == null) s21 = 0;
		if(s31 == null) s31 = 0;
		if(s32 == null) s32 = 0;
		if(s33 == null) s33 = 0;
		map_tmp.put("s11_1", s11_1);
		map_tmp.put("s12_1", s12_1);
		map_tmp.put("s13_1", s13_1);
		map_tmp.put("s14_1", s14_1);
		map_tmp.put("s15_1", s15_1);
		map_tmp.put("s16_1", s16_1);
		map_tmp.put("s11_2", s11_2);
		map_tmp.put("s12_2", s12_2);
		map_tmp.put("s13_2", s13_2);
		map_tmp.put("s14_2", s14_2);
		map_tmp.put("s15_2", s15_2);
		map_tmp.put("s16_2", s16_2);
		map_tmp.put("s17", IntegerUtil.add(s16_1,s16_2));//三孩及以上政策内总人数
		map_tmp.put("s21", s21);
		map_tmp.put("s31", s31);
		map_tmp.put("s32", s32);
		map_tmp.put("s33", s33);
		
		map_tmp.put("area", area);
		Integer s1t = IntegerUtil.add(s11_1,s11_2);//一孩总数
		Integer s2t = IntegerUtil.add(s13_1,s13_2);//二孩总数
		Integer s3t = IntegerUtil.add(s15_1,s15_2);//三孩以上总数

		map_tmp.put("s1t", s1t);
		map_tmp.put("s2t", s2t);
		map_tmp.put("s3t", s3t);
		
		Integer totalBorn = IntegerUtil.add(s1t,s2t,s3t);
		Integer totalBornPolicy = IntegerUtil.add(s12_1,s14_1,s16_1,s12_2,s14_2,s16_2);
		
		//总人口数、平均人口数、自然增长人数
		Integer m1 = 0 , m2 = 0 , s22 = 0;
		map_tmp.put("m1", m1);//总人口数
		map_tmp.put("m2", m2);//平均人口数
		
		map_tmp.put("a1", DoubleUtil.div(s1t, totalBorn));
		map_tmp.put("a2", DoubleUtil.div(s2t, totalBorn));
		map_tmp.put("a3", DoubleUtil.div(s3t, totalBorn));
		
		map_tmp.put("a4", totalBorn);
		map_tmp.put("a5", DoubleUtil.div(totalBorn, m2));//出生率
		map_tmp.put("a6", DoubleUtil.div(totalBornPolicy, totalBorn));//政策出生率
		
		map_tmp.put("b1", DoubleUtil.div(s21, m2));//死亡率
		
		s22 = totalBorn - s21;//自然增长人数
		map_tmp.put("s22", s22);
		map_tmp.put("c1", DoubleUtil.div(s22, m2));//自然增长率
		
	}

	/**
	 * 统计表3-已婚育龄夫妇节育情况统计表
	 * @param page
	 * @param startDate
	 * @param endDate
	 * @param area
	 * @return
	 */
	public Map findStat3Reports(Page page,Date startDate,Date endDate,String area,Integer domicileType){
		List params = new ArrayList();
		StringBuilder sql = new StringBuilder()

		.append(" select * from ( ")
		//已婚妇女人数
		.append(" select count(1) as counth,p.area,11 as TYPEH from fhp_person as p LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where pb.MARRY_STATUS <> 175 and p.DOMICILE_TYPE = ? group by p.area ")
		
		.append(" union all ")
		//男扎、女扎、二孩结扎、纯二女结扎
		.append(" select count(1) as COUNTH,p.AREA,21 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD = 201 and wc.OPS_DATE  BETWEEN ? AND ? and pb.MARRY_STATUS <> 175 and p.DOMICILE_TYPE = ? ")
		.append(" group by p.area ")
		.append(" union all ")
		.append(" select count(1) as COUNTH,p.AREA,22 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD = 202 and wc.OPS_DATE  BETWEEN ? AND ? and pb.MARRY_STATUS <> 175 and p.DOMICILE_TYPE = ? ")
		.append(" group by p.area ")
		.append(" union all ")
		.append(" select count(1) as COUNTH,p.AREA,23 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where (wc.METHOD = 201 or wc.METHOD = 202) ")
		.append(" and wc.OPS_DATE  BETWEEN ? AND ? and pb.MARRY_STATUS <> 175 and p.DOMICILE_TYPE = ? ")
		.append(" and (select count(1) from fhp_woman_children as wc where wc.person_id = p.ID ) = 2 ")
		.append(" group by p.area ")
		.append(" union all ")
		.append(" select count(1) as COUNTH,p.AREA,24 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where (wc.METHOD = 201 or wc.METHOD = 202) ")
		.append(" and wc.OPS_DATE  BETWEEN ? AND ? and pb.MARRY_STATUS <> 175 and p.DOMICILE_TYPE = ? ")
		.append(" and (select count(1) from fhp_woman_children as wc where wc.person_id = p.ID ) = 2 ")
		.append(" and (select count(1) from fhp_woman_children as wc where wc.person_id = p.ID and wc.sex = 2 ) = 2 ")
		.append(" group by p.area ")
		
		.append(" union all ")
		//上环、一孩上环
		.append(" select count(1) as COUNTH,p.AREA,31 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD = 203 ")
		.append(" and wc.OPS_DATE  BETWEEN ? AND ? and pb.MARRY_STATUS <> 175 and p.DOMICILE_TYPE = ? ")
		.append(" group by p.area ")
		.append(" union all ")
		.append(" select count(1) as COUNTH,p.AREA,32 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id ")
		.append(" LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD = 203 ")
		.append(" and wc.OPS_DATE  BETWEEN ? AND ? and pb.MARRY_STATUS <> 175 and p.DOMICILE_TYPE = ? ")
		.append(" and (select count(1) from fhp_woman_children as wc where wc.person_id = p.ID ) = 1 ")
		.append(" group by p.area ")
		
		.append(" union all  ")
		//补救措施一、补救措施二、小计
		.append(" select count(1) as COUNTH,p.AREA,41 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.REPAIR_METHOD = 266 ")
		.append(" and wc.REPAIR_DATE  BETWEEN ? AND ?  and pb.MARRY_STATUS <> 175 and p.DOMICILE_TYPE = ? ")
		.append(" group by p.area ")
		.append(" union all ")
		.append(" select count(1) as COUNTH,p.AREA,42 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.REPAIR_METHOD = 267 ")
		.append(" and wc.REPAIR_DATE  BETWEEN ? AND ? and pb.MARRY_STATUS <> 175 and p.DOMICILE_TYPE = ? ")
		.append(" group by p.area ")
		.append(" union all ")
		.append(" select count(1) as COUNTH,p.AREA,43 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.REPAIR_DATE  BETWEEN ? AND ? and pb.MARRY_STATUS <> 175 and p.DOMICILE_TYPE = ? ")
		.append(" group by p.area ")
		
		.append(" union all  ")
		//皮下埋植
		.append(" select count(1) as COUNTH,p.AREA,51 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD = 207 ")
		.append(" and wc.OPS_DATE  BETWEEN ? AND ? and pb.MARRY_STATUS <> 175 and p.DOMICILE_TYPE = ? ")
		.append(" group by p.area ")
		
		.append(" union all  ")
		//男扎、女扎、放环、服药、避孕套、外用药、皮下埋植、其它
		.append(" select count(1) as COUNTH,p.AREA,61 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD = 201 and pb.MARRY_STATUS <> 175 and p.DOMICILE_TYPE = ? ")
		.append(" group by p.area ")
		.append(" union all  ")
		.append(" select count(1) as COUNTH,p.AREA,62 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD = 202 and pb.MARRY_STATUS <> 175 and p.DOMICILE_TYPE = ? ")
		.append(" group by p.area ")
		.append(" union all  ")
		.append(" select count(1) as COUNTH,p.AREA,63 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD = 203 and pb.MARRY_STATUS <> 175 and p.DOMICILE_TYPE = ? ")
		.append(" group by p.area ")
		.append(" union all  ")
		.append(" select count(1) as COUNTH,p.AREA,64 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD = 204 and pb.MARRY_STATUS <> 175 and p.DOMICILE_TYPE = ? ")
		.append(" group by p.area ")
		.append(" union all  ")
		.append(" select count(1) as COUNTH,p.AREA,65 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD = 205 and pb.MARRY_STATUS <> 175 and p.DOMICILE_TYPE = ? ")
		.append(" group by p.area ")
		.append(" union all  ")
		.append(" select count(1) as COUNTH,p.AREA,66 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD = 206 and pb.MARRY_STATUS <> 175 and p.DOMICILE_TYPE = ? ")
		.append(" group by p.area ")
		.append(" union all  ")
		.append(" select count(1) as COUNTH,p.AREA,67 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD = 207 and pb.MARRY_STATUS <> 175 and p.DOMICILE_TYPE = ? ")
		.append(" group by p.area ")
		.append(" union all  ")
		.append(" select count(1) as COUNTH,p.AREA,68 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD >= 209 and wc.METHOD <= 212 and pb.MARRY_STATUS <> 175 and p.DOMICILE_TYPE = ? ")
		.append(" group by p.area ")
		
		.append(" union all  ")
		//领独身子女证：本期、期末
		.append(" select count(1) as COUNTH,p.AREA,71 as TYPEH from FHP_TOC_CERT as tc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = tc.PERSON_ID LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where tc.ISS_DATE BETWEEN ? AND ? and pb.MARRY_STATUS <> 175 and p.DOMICILE_TYPE = ?  ")
		.append(" group by p.area ")
		.append(" union all ")
		.append(" select count(1) as COUNTH,p.AREA,72 as TYPEH from FHP_TOC_CERT as tc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = tc.PERSON_ID LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where tc.ISS_DATE BETWEEN ? AND ? and pb.MARRY_STATUS <> 175 and p.DOMICILE_TYPE = ?  ")
		.append(" group by p.area ")
		
		.append(" union all  ")
		//取环
		.append(" select count(1) as COUNTH,p.AREA,81 as TYPEH from FHP_GET_IUD as gi ")
		.append(" LEFT JOIN fhp_fertile_woman as fw on fw.ID = gi.WOMAN_ID LEFT JOIN fhp_person as p on p.ID = fw.PERSON_ID ")
		.append(" LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where gi.DATEH BETWEEN ? AND ? and pb.MARRY_STATUS <> 175 and p.DOMICILE_TYPE = ?  ")
		.append(" group by p.area ")
		.append(" ) a where 1=1 ");

		params.add(domicileType);
		
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		
		params.add(domicileType);
		params.add(domicileType);
		params.add(domicileType);
		params.add(domicileType);
		params.add(domicileType);
		params.add(domicileType);
		params.add(domicileType);
		params.add(domicileType);
		
		
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		//期末人数
		int year = startDate.getYear() - 1;
		params.add(DateUtil.createUtilDate(year+"-01-01 00:00:00"));
		params.add(DateUtil.createUtilDate(year+"-12-31 23:59:59"));
		params.add(domicileType);

		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		
		if(StringUtils.isNotEmpty(area)){
			sql.append(" and a.AREA = ? ");
			params.add(area);
		}
		if(StringUtils.isNotEmpty(page.getOrderBy())){
			sql.append(" order by a.").append(page.getOrderBy());
			if(StringUtils.isNotEmpty(page.getOrder()))
				sql.append(" ").append(page.getOrder());
		}
		List<Map<String,Object>> result_orin = this.flowStatReportsDao.findBySql(sql.toString(), params.toArray());
		Map<String,Map<String,Object>> result = new HashMap<String,Map<String,Object>>();
		String area_tmp = null ;
		Integer count_tmp = null , type_tmp = null;
		for(Map<String,Object> ros : result_orin){
			area_tmp = (String)ros.get("AREA");
			count_tmp = ((BigInteger)ros.get("counth")).intValue();
			type_tmp = ((BigInteger)ros.get("TYPEH")).intValue();
			//注意这里极易出现统计错误
			if(!result.containsKey(area_tmp)){
				result.put(area_tmp, new HashMap<String,Object>());
			}
			result.get(area_tmp).put("s"+type_tmp, count_tmp);
		}
		return result;
	}
	
	public List findStat3Reports_4AutoPrint(Page page,Date startDate,Date endDate,String area,Integer domicileType){
		Map<String,Map<String,Object>> result = findStat3Reports(page, startDate, endDate, area, domicileType);
		List<DistrictVillage> villages = districtVillageManager.getAllByParentId(Constants.COMMON_PARAM.CURRENT_TOWN_ID);
		List lst = new ArrayList();
		Map tmp = null;
		Map<String,Object> si = null; 
		for(DistrictVillage dv : villages){
			tmp = new HashMap();
			if(result == null){
				setValue2Map4stat3(tmp,dv.getName(),0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
			}else{
				si = result.get(dv.getCode());
				if(si == null){
					setValue2Map4stat3(tmp,dv.getName(),0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
				}else{
					setValue2Map4stat3(tmp,dv.getName(),
							(Integer)si.get("s11"),
							(Integer)si.get("s21"),
							(Integer)si.get("s22"),
							(Integer)si.get("s23"),
							(Integer)si.get("s24"),
							(Integer)si.get("s31"),
							(Integer)si.get("s32"),
							(Integer)si.get("s41"),
							(Integer)si.get("s42"),
							(Integer)si.get("s43"),
							(Integer)si.get("s51"),
							(Integer)si.get("s61"),
							(Integer)si.get("s62"),
							(Integer)si.get("s63"),
							(Integer)si.get("s64"),
							(Integer)si.get("s65"),
							(Integer)si.get("s66"),
							(Integer)si.get("s67"),
							(Integer)si.get("s68"),
							(Integer)si.get("s71"),
							(Integer)si.get("s72"),
							(Integer)si.get("s81"));
				}
			}
			lst.add(tmp);
		}
		lst.set(0, getTotal3(lst));
		return lst;
	}
	
	private Map getTotal3(List<Map> lst){
		Map tmp = new HashMap();
		Integer s11 = 0,s21 = 0,s22 = 0,s23 = 0,s24 = 0,s31 = 0,s32 = 0,s41 = 0,s42 = 0,s43 = 0,s51 = 0,s61 = 0,s62 = 0,s63 = 0,s64 = 0,s65 = 0,s66 = 0,s67 = 0,s68 = 0,s71 = 0,s72 = 0,s81 = 0;
		for(Map m : lst){
			s11 = IntegerUtil.add(s11,(Integer)m.get("s11"));
			s21 = IntegerUtil.add(s21,(Integer)m.get("s21"));
			s22 = IntegerUtil.add(s22,(Integer)m.get("s22"));
			s23 = IntegerUtil.add(s23,(Integer)m.get("s23"));
			s24 = IntegerUtil.add(s24,(Integer)m.get("s24"));
			s31 = IntegerUtil.add(s31,(Integer)m.get("s31"));
			s32 = IntegerUtil.add(s32,(Integer)m.get("s32"));
			s41 = IntegerUtil.add(s41,(Integer)m.get("s41"));
			s42 = IntegerUtil.add(s42,(Integer)m.get("s42"));
			s43 = IntegerUtil.add(s43,(Integer)m.get("s43"));
			s51 = IntegerUtil.add(s51,(Integer)m.get("s51"));
			s61 = IntegerUtil.add(s61,(Integer)m.get("s61"));
			s62 = IntegerUtil.add(s62,(Integer)m.get("s62"));
			s63 = IntegerUtil.add(s63,(Integer)m.get("s63"));
			s64 = IntegerUtil.add(s64,(Integer)m.get("s64"));
			s65 = IntegerUtil.add(s65,(Integer)m.get("s65"));
			s66 = IntegerUtil.add(s66,(Integer)m.get("s66"));
			s67 = IntegerUtil.add(s67,(Integer)m.get("s67"));
			s68 = IntegerUtil.add(s68,(Integer)m.get("s68"));
			s71 = IntegerUtil.add(s71,(Integer)m.get("s71"));
			s72 = IntegerUtil.add(s72,(Integer)m.get("s72"));
			s81 = IntegerUtil.add(s81,(Integer)m.get("s81"));
		}
		setValue2Map4stat3(tmp, "总计", s11,s21,s22,s23,s24, s31,s32, s41,s42,s43,s51,s61,s62,s63,s64,s65,s66,s67,s68,s71,s72,s81);
		return tmp;
	}
	
	private void setValue2Map4stat3(Map map_tmp,String area,Integer s11,Integer s21,Integer s22,Integer s23,Integer s24, Integer s31,Integer s32, Integer s41,Integer s42,Integer s43,Integer s51,Integer s61,Integer s62,Integer s63,Integer s64,Integer s65,Integer s66,Integer s67,Integer s68,Integer s71,Integer s72,Integer s81){
		if(s11 == null) s11 = 0;
		if(s21 == null) s21 = 0;
		if(s22 == null) s22 = 0;
		if(s23 == null) s23 = 0;
		if(s24 == null) s24 = 0;
		if(s31 == null) s31 = 0;
		if(s32 == null) s32 = 0;
		if(s41 == null) s41 = 0;
		if(s42 == null) s42 = 0;
		if(s43 == null) s43 = 0;
		if(s51 == null) s51 = 0;
		if(s61 == null) s61 = 0;
		if(s62 == null) s62 = 0;
		if(s63 == null) s63 = 0;
		if(s64 == null) s64 = 0;
		if(s65 == null) s65 = 0;
		if(s66 == null) s66 = 0;
		if(s67 == null) s67 = 0;
		if(s68 == null) s68 = 0;
		if(s71 == null) s71 = 0;
		if(s72 == null) s72 = 0;
		if(s81 == null) s81 = 0;
		
		map_tmp.put("s11", s11);
		map_tmp.put("s21", s21);
		map_tmp.put("s22", s22);
		map_tmp.put("s23", s23);
		map_tmp.put("s24", s24);
		map_tmp.put("s31", s31);
		map_tmp.put("s32", s32);
		map_tmp.put("s41", s41);
		map_tmp.put("s42", s42);
		map_tmp.put("s43", s43);
		map_tmp.put("s51", s51);
		map_tmp.put("s61", s61);
		map_tmp.put("s62", s62);
		map_tmp.put("s63", s63);
		map_tmp.put("s64", s64);
		map_tmp.put("s65", s65);
		map_tmp.put("s66", s66);
		map_tmp.put("s67", s67);
		map_tmp.put("s68", s68);
		map_tmp.put("s71", s71);
		map_tmp.put("s72", s72);
		map_tmp.put("s81", s81);
		
		map_tmp.put("area", area);
		
		Integer a1 = IntegerUtil.add(s21,s22);//结扎小计
		map_tmp.put("a1", a1);

		Integer a2 = IntegerUtil.add(s41,s42);//补救措施小计
		map_tmp.put("a2", a2);
		
		Integer a3 = IntegerUtil.add(a1,s21,a2,s51);//计划生育手术合计
		map_tmp.put("a3", a3);
		
		Integer a4 = IntegerUtil.add(s61,s62,s63,s64,s65,s66,s67,s68);//现有计划生育手术合计
		map_tmp.put("a4", a4);
		
		map_tmp.put("a5", DoubleUtil.div(a4, s11));//节育率
		map_tmp.put("a6", DoubleUtil.div(s72, s11));//领证率
		
	}
	
	/**
	 * 统计表4-期间分孩次落实节育措施情况统计表
	 * @param page
	 * @param startDate
	 * @param endDate
	 * @param area
	 * @return
	 */
	public Map findStat4Reports(Page page,Date startDate,Date endDate,String area,Integer domicileType){
		List params = new ArrayList();
		StringBuilder sql = new StringBuilder()

		.append(" select * from ( ")
		//男扎、女扎、放环、避孕套具、皮下埋植、其它、纯二女人数、纯二女结扎人数、总人数、
		.append(" select count(1) as COUNTH,p.AREA,11 as TYPEH, ")
		.append(" (select count(1) from fhp_woman_children as wc where wc.person_id = p.ID ) as CHIND_INDEX ")
		.append(" from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD = 201 and wc.OPS_DATE  BETWEEN ? AND ? and p.DOMICILE_TYPE = ? and pb.MARRY_STATUS <> 175 ")
		.append(" group by p.area ")
		.append(" union all ")
		.append(" select count(1) as COUNTH,p.AREA,12 as TYPEH, ")
		.append(" (select count(1) from fhp_woman_children as wc where wc.person_id = p.ID ) as CHIND_INDEX from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD = 202 and wc.OPS_DATE  BETWEEN ? AND ? and p.DOMICILE_TYPE = ? and pb.MARRY_STATUS <> 175 ")
		.append(" group by p.area ")
		.append(" union all ")
		.append(" select count(1) as COUNTH,p.AREA,13 as TYPEH, ")
		.append(" (select count(1) from fhp_woman_children as wc where wc.person_id = p.ID ) as CHIND_INDEX from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD = 203 and wc.OPS_DATE  BETWEEN ? AND ? and p.DOMICILE_TYPE = ? and pb.MARRY_STATUS <> 175 ")
		.append(" group by p.area ")
		.append(" union all ")
		.append(" select count(1) as COUNTH,p.AREA,14 as TYPEH, ")
		.append(" (select count(1) from fhp_woman_children as wc where wc.person_id = p.ID ) as CHIND_INDEX from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD >= 204 and wc.METHOD <= 206 and wc.OPS_DATE  BETWEEN ? AND ? and p.DOMICILE_TYPE = ? and pb.MARRY_STATUS <> 175 ")
		.append(" group by p.area ")
		.append(" union all ")
		.append(" select count(1) as COUNTH,p.AREA,15 as TYPEH, ")
		.append(" (select count(1) from fhp_woman_children as wc where wc.person_id = p.ID ) as CHIND_INDEX from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD >= 207 and wc.OPS_DATE  BETWEEN ? AND ? and p.DOMICILE_TYPE = ? and pb.MARRY_STATUS <> 175 ")
		.append(" group by p.area ")
		.append(" union all ")
		.append(" select count(1) as COUNTH,p.AREA,16 as TYPEH, ")
		.append(" (select count(1) from fhp_woman_children as wc where wc.person_id = p.ID ) as CHIND_INDEX from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD >= 209 and wc.METHOD <= 212 and wc.OPS_DATE  BETWEEN ? AND ? and p.DOMICILE_TYPE = ? and pb.MARRY_STATUS <> 175 ")
		.append(" group by p.area ")
		.append(" union all ")
		.append(" select count(1) as COUNTH,p.AREA,17 as TYPEH , -1 as CHIND_INDEX from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.OPS_DATE  BETWEEN ? AND ? and p.DOMICILE_TYPE = ? and pb.MARRY_STATUS <> 175 ")
		.append(" and (select count(1) from fhp_woman_children as wc where wc.person_id = p.ID ) = 2 ")
		.append(" and (select count(1) from fhp_woman_children as wc where wc.person_id = p.ID and wc.sex = 2 ) = 2 ")
		.append(" group by p.area ")
		.append(" union all ")
		.append(" select count(1) as COUNTH,p.AREA,18 as TYPEH , -1 as CHIND_INDEX from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD <> 208 and wc.OPS_DATE  BETWEEN ? AND ? and p.DOMICILE_TYPE = ? and pb.MARRY_STATUS <> 175 ")
		.append(" and (select count(1) from fhp_woman_children as wc where wc.person_id = p.ID ) = 2 ")
		.append(" and (select count(1) from fhp_woman_children as wc where wc.person_id = p.ID and wc.sex = 2 ) = 2 ")
		.append(" group by p.area ")
		.append(" union all ")
		.append(" select count(1) as COUNTH,p.AREA,19 as TYPEH, ")
		.append(" (select count(1) from fhp_woman_children as wc where wc.person_id = p.ID ) as CHIND_INDEX from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.OPS_DATE  BETWEEN ? AND ? and p.DOMICILE_TYPE = ? and pb.MARRY_STATUS <> 175 ")
		.append(" group by p.area ")
		.append(" ) a where 1=1 ");
		
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		

		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		
		if(StringUtils.isNotEmpty(area)){
			sql.append(" and a.AREA = ? ");
			params.add(area);
		}
		if(StringUtils.isNotEmpty(page.getOrderBy())){
			sql.append(" order by a.").append(page.getOrderBy());
			if(StringUtils.isNotEmpty(page.getOrder()))
				sql.append(" ").append(page.getOrder());
		}
		List<Map<String,Object>> result_orin = this.flowStatReportsDao.findBySql(sql.toString(), params.toArray());
		Map<String,Map<String,Object>> result = new HashMap<String,Map<String,Object>>();
		String area_tmp = null ;
		Integer count_tmp = null , type_tmp = null , chind_index_tmp = null;
		for(Map<String,Object> ros : result_orin){
			area_tmp = (String)ros.get("AREA");
			count_tmp = ((BigInteger)ros.get("counth")).intValue();
			type_tmp = ((BigInteger)ros.get("TYPEH")).intValue();
			chind_index_tmp = ((BigInteger)ros.get("CHIND_INDEX")).intValue();
			//注意这里极易出现统计错误
			if(!result.containsKey(area_tmp)){
				result.put(area_tmp, new HashMap<String,Object>());
			}
			if(chind_index_tmp == 1 || chind_index_tmp == 2){
				result.get(area_tmp).put("s"+type_tmp+"_"+chind_index_tmp, count_tmp);
			}else if(chind_index_tmp >= 3){
				result.get(area_tmp).put("s"+type_tmp+"_"+3, IntegerUtil.add(count_tmp,(Integer)result.get(area_tmp).get("s"+type_tmp+"_"+3)));
			}else if(chind_index_tmp == -1){
				result.get(area_tmp).put("s"+type_tmp, count_tmp);
			}
		}
		return result;
	}
	
	public List findStat4Reports_4AutoPrint(Page page,Date startDate,Date endDate,String area,Integer domicileType){
		Map<String,Map<String,Object>> result = findStat4Reports(page, startDate, endDate, area, domicileType);
		List<DistrictVillage> villages = districtVillageManager.getAllByParentId(Constants.COMMON_PARAM.CURRENT_TOWN_ID);
		List lst = new ArrayList();
		Map tmp = null;
		Map<String,Object> si = null; 
		for(DistrictVillage dv : villages){
			tmp = new HashMap();
			if(result == null){
				setValue2Map4stat4(tmp,dv.getName(),0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
			}else{
				si = result.get(dv.getCode());
				if(si == null){
					setValue2Map4stat4(tmp,dv.getName(),0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
				}else{
					setValue2Map4stat4(tmp,dv.getName(),
							(Integer)si.get("s11_1"),
							(Integer)si.get("s11_2"),
							(Integer)si.get("s11_3"),
							(Integer)si.get("s12_1"),
							(Integer)si.get("s12_2"),
							(Integer)si.get("s12_3"),
							(Integer)si.get("s13_1"),
							(Integer)si.get("s13_2"),
							(Integer)si.get("s13_3"),
							(Integer)si.get("s14_1"),
							(Integer)si.get("s14_2"),
							(Integer)si.get("s14_3"),
							(Integer)si.get("s15_1"),
							(Integer)si.get("s15_2"),
							(Integer)si.get("s15_3"),
							(Integer)si.get("s16_1"),
							(Integer)si.get("s16_2"),
							(Integer)si.get("s16_3"),
							(Integer)si.get("s17"),
							(Integer)si.get("s18"),
							(Integer)si.get("s19_1"),
							(Integer)si.get("s19_2"),
							(Integer)si.get("s19_3"));
				}
			}
			lst.add(tmp);
		}
		lst.set(0, getTotal4(lst));
		return lst;
	}
	
	private Map getTotal4(List<Map> lst){
		Map tmp = new HashMap();
		Integer s11_1 = 0,s11_2 = 0,s11_3 = 0;
		Integer s12_1 = 0,s12_2 = 0,s12_3 = 0;
		Integer s13_1 = 0,s13_2 = 0,s13_3 = 0;
		Integer s14_1 = 0,s14_2 = 0,s14_3 = 0;
		Integer s15_1 = 0,s15_2 = 0,s15_3 = 0;
		Integer s16_1 = 0,s16_2 = 0,s16_3 = 0;
		Integer s17 = 0,s18 = 0;
		Integer s19_1 = 0,s19_2 = 0,s19_3 = 0;
		for(Map m : lst){
			s11_1 = IntegerUtil.add(s11_1,(Integer)m.get("s11_1"));
			s11_2 = IntegerUtil.add(s11_2,(Integer)m.get("s11_2"));
			s11_3 = IntegerUtil.add(s11_3,(Integer)m.get("s11_3"));
			s12_1 = IntegerUtil.add(s12_1,(Integer)m.get("s12_1"));
			s12_2 = IntegerUtil.add(s12_2,(Integer)m.get("s12_2"));
			s12_3 = IntegerUtil.add(s12_3,(Integer)m.get("s12_3"));
			s13_1 = IntegerUtil.add(s13_1,(Integer)m.get("s13_1"));
			s13_2 = IntegerUtil.add(s13_2,(Integer)m.get("s13_2"));
			s13_3 = IntegerUtil.add(s13_3,(Integer)m.get("s13_3"));
			s14_1 = IntegerUtil.add(s14_1,(Integer)m.get("s14_1"));
			s14_2 = IntegerUtil.add(s14_2,(Integer)m.get("s14_2"));
			s14_3 = IntegerUtil.add(s14_3,(Integer)m.get("s14_3"));
			s15_1 = IntegerUtil.add(s15_1,(Integer)m.get("s15_1"));
			s15_2 = IntegerUtil.add(s15_2,(Integer)m.get("s15_2"));
			s15_3 = IntegerUtil.add(s15_3,(Integer)m.get("s15_3"));
			s16_1 = IntegerUtil.add(s16_1,(Integer)m.get("s16_1"));
			s16_2 = IntegerUtil.add(s16_2,(Integer)m.get("s16_2"));
			s16_3 = IntegerUtil.add(s16_3,(Integer)m.get("s16_3"));
			s17 = IntegerUtil.add(s17,(Integer)m.get("s17"));
			s18 = IntegerUtil.add(s18,(Integer)m.get("s18"));
			s19_1 = IntegerUtil.add(s19_1,(Integer)m.get("s19_1"));
			s19_2 = IntegerUtil.add(s19_2,(Integer)m.get("s19_2"));
			s19_3 = IntegerUtil.add(s19_3,(Integer)m.get("s19_3"));
		}
		setValue2Map4stat4(tmp, "总计",s11_1,s11_2,s11_3,s12_1,s12_2,s12_3,s13_1,s13_2,s13_3,s14_1,s14_2,s14_3,s15_1,s15_2,s15_3,s16_1,s16_2,s16_3,s17,s18,s19_1,s19_2,s19_3);
		return tmp;
	}
	
	private void setValue2Map4stat4(Map map_tmp,String area,Integer s11_1,Integer s11_2,Integer s11_3,Integer s12_1,Integer s12_2,Integer s12_3,Integer s13_1,Integer s13_2,Integer s13_3,Integer s14_1,Integer s14_2,Integer s14_3,Integer s15_1,Integer s15_2,Integer s15_3,Integer s16_1,Integer s16_2,Integer s16_3,Integer s17,Integer s18,Integer s19_1,Integer s19_2,Integer s19_3){
		
		if(s11_1 == null) s11_1 = 0;
		if(s11_2 == null) s11_2 = 0;
		if(s11_3 == null) s11_3 = 0;
		if(s12_1 == null) s12_1 = 0;
		if(s12_2 == null) s12_2 = 0;
		if(s12_3 == null) s12_3 = 0;
		if(s13_1 == null) s13_1 = 0;
		if(s13_2 == null) s13_2 = 0;
		if(s13_3 == null) s13_3 = 0;
		if(s14_1 == null) s14_1 = 0;
		if(s14_2 == null) s14_2 = 0;
		if(s14_3 == null) s14_3 = 0;
		if(s15_1 == null) s15_1 = 0;
		if(s15_2 == null) s15_2 = 0;
		if(s15_3 == null) s15_3 = 0;
		if(s16_1 == null) s16_1 = 0;
		if(s16_2 == null) s16_2 = 0;
		if(s16_3 == null) s16_3 = 0;
		if(s19_1 == null) s19_1 = 0;
		if(s19_2 == null) s19_2 = 0;
		if(s19_3 == null) s19_3 = 0;
		if(s17 == null) s17 = 0;
		if(s18 == null) s18 = 0;
		
		map_tmp.put("s11_1", s11_1);
		map_tmp.put("s11_2", s11_2);
		map_tmp.put("s11_3", s11_3);
		map_tmp.put("s12_1", s12_1);
		map_tmp.put("s12_2", s12_2);
		map_tmp.put("s12_3", s12_3);
		map_tmp.put("s13_1", s13_1);
		map_tmp.put("s13_2", s13_2);
		map_tmp.put("s13_3", s13_3);
		map_tmp.put("s14_1", s14_1);
		map_tmp.put("s14_2", s14_2);
		map_tmp.put("s14_3", s14_3);
		map_tmp.put("s15_1", s15_1);
		map_tmp.put("s15_2", s15_2);
		map_tmp.put("s15_3", s15_3);
		map_tmp.put("s16_1", s16_1);
		map_tmp.put("s16_2", s16_2);
		map_tmp.put("s16_3", s16_3);
		map_tmp.put("s17", s17);
		map_tmp.put("s18", s18);
		map_tmp.put("s19_1", s19_1);
		map_tmp.put("s19_2", s19_2);
		map_tmp.put("s19_3", s19_3);
		
		
		map_tmp.put("area", area);
		
		Integer a1 = IntegerUtil.add(s11_1,s12_1,s13_1,s14_1,s15_1,s16_1);//一孩结扎合计
		map_tmp.put("a1", a1);


		Integer a2 = IntegerUtil.add(s11_2,s12_2,s13_2,s14_2,s15_2,s16_2);//二孩结扎合计
		map_tmp.put("a2", a2);
		

		Integer a3 = IntegerUtil.add(s11_3,s12_3,s13_3,s14_3,s15_3,s16_3);//三孩及以上结扎合计
		map_tmp.put("a3", a3);
		
	}
	
	/**
	 * 统计表-流出人员流量分析:总人数、已婚人数
	 * @param page
	 * @param startDate
	 * @param endDate
	 * @param area
	 * @return
	 */
	public List findStat5Reports(Page page,Date startDate,Date endDate,String area,Integer domicileType){
		List params = new ArrayList();
		StringBuilder sql = new StringBuilder()

		.append(" select * from ( ")
		//流出人员流量分析:总人数、已婚人数
		.append(" select count(1) as counth,p.area,11 as TYPEH from fhp_person_out as po LEFT JOIN fhp_person as p on p.ID = po.PERSON_ID ")
		.append(" where po.OUT_DATE BETWEEN ? AND ? and p.DOMICILE_TYPE = ? group by p.area ")
		.append(" union all ")
		.append(" select count(1) as counth,p.area,12 as TYPEH from fhp_person_out as po LEFT JOIN fhp_person as p on p.ID = po.PERSON_ID ")
		.append(" LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where po.OUT_DATE BETWEEN ? AND ? and p.DOMICILE_TYPE = ? and pb.MARRY_STATUS <> 175  group by p.area ")
		.append(" ) a where 1=1 ");
		
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		params.add(startDate);
		params.add(endDate);
		params.add(domicileType);
		
		if(StringUtils.isNotEmpty(area)){
			sql.append(" and a.AREA = ? ");
			params.add(area);
		}
		if(StringUtils.isNotEmpty(page.getOrderBy())){
			sql.append(" order by a.").append(page.getOrderBy());
			if(StringUtils.isNotEmpty(page.getOrder()))
				sql.append(" ").append(page.getOrder());
		}
		List result = this.flowStatReportsDao.findBySql(sql.toString(), params.toArray());
		return result;
	}
	
}