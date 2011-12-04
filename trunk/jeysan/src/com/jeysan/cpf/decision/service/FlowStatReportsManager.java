package com.jeysan.cpf.decision.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.decision.dao.FlowStatReportsDao;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.utils.date.DateUtil;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class FlowStatReportsManager {
	private static Logger logger = LoggerFactory.getLogger(FlowStatReportsManager.class);
	
	private FlowStatReportsDao flowStatReportsDao;

	@Autowired
	public void setFlowStatReportsDao(FlowStatReportsDao flowStatReportsDao) {
		this.flowStatReportsDao = flowStatReportsDao;
	}
	/**
	 * 统计表1-期间计划生育情况统计表 
	 * @param page
	 * @param startDate
	 * @param endDate
	 * @param area
	 * @return
	 */
	public Page findStat1Reports(Page page,Date startDate,Date endDate,String area){
		List params = new ArrayList();
		StringBuilder sql = new StringBuilder()

		.append(" select * from ( ")
		//一孩、政策内一孩、二孩、政策内二孩、三孩及以上、政策内三孩及以上
		.append(" select count(1) as counth,p.area,11 as TYPEH from fhp_woman_children as wc LEFT JOIN fhp_person as p on p.ID = wc.PERSON_ID ")
		.append(" where wc.BIRTHDAY BETWEEN ? AND ? ")
		.append(" and wc.CHILD_INDEX = 1 group by p.area  ")
		.append(" union all ")
		.append(" select count(1) as counth,p.area,12 as TYPEH from fhp_woman_children as wc LEFT JOIN fhp_person as p on p.ID = wc.PERSON_ID ")
		.append(" where wc.BIRTHDAY BETWEEN ? AND ? ")
		.append(" and wc.CHILD_INDEX = 1 and wc.POLICY = 290 group by p.area  ")
		.append(" union all ")
		.append(" select count(1) as counth,p.area,13 as TYPEH from fhp_woman_children as wc LEFT JOIN fhp_person as p on p.ID = wc.PERSON_ID ")
		.append(" where wc.BIRTHDAY BETWEEN ? AND ? ")
		.append(" and wc.CHILD_INDEX = 2 group by p.area ")
		.append(" union all ")
		.append(" select count(1) as counth,p.area,14 as TYPEH from fhp_woman_children as wc LEFT JOIN fhp_person as p on p.ID = wc.PERSON_ID ")
		.append(" where wc.BIRTHDAY BETWEEN ? AND ? ")
		.append(" and wc.CHILD_INDEX = 2 and wc.POLICY = 290 group by p.area ")
		.append(" union all ")
		.append(" select count(1) as counth,p.area,15 as TYPEH from fhp_woman_children as wc LEFT JOIN fhp_person as p on p.ID = wc.PERSON_ID ")
		.append(" where wc.BIRTHDAY BETWEEN ? AND ? ")
		.append(" and wc.CHILD_INDEX >= 3 group by p.area ")
		.append(" union all ")
		.append(" select count(1) as counth,p.area,16 as TYPEH from fhp_woman_children as wc LEFT JOIN fhp_person as p on p.ID = wc.PERSON_ID ")
		.append(" where wc.BIRTHDAY BETWEEN ? AND ? ")
		.append(" and wc.CHILD_INDEX >= 3 and wc.POLICY = 290 group by p.area ")

		.append(" union all ")
		//男扎、女扎、二孩结扎、纯二女结扎
		.append(" select count(1) as COUNTH,p.AREA,21 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id ")
		.append(" where wc.METHOD = 201 and wc.OPS_DATE  BETWEEN ? AND ? ")
		.append(" group by p.area ")
		.append(" union all ")
		.append(" select count(1) as COUNTH,p.AREA,22 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id ")
		.append(" where wc.METHOD = 202 and wc.OPS_DATE  BETWEEN ? AND ? ")
		.append(" group by p.area ")
		.append(" union all ")
		.append(" select count(1) as COUNTH,p.AREA,23 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id ")
		.append(" where (wc.METHOD = 201 or wc.METHOD = 202) ")
		.append(" and wc.OPS_DATE  BETWEEN ? AND ? ")
		.append(" and (select count(1) from fhp_woman_children as wc where wc.person_id = p.ID ) = 2 ")
		.append(" group by p.area ")
		.append(" union all ")
		.append(" select count(1) as COUNTH,p.AREA,24 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id ")
		.append(" where (wc.METHOD = 201 or wc.METHOD = 202) ")
		.append(" and wc.OPS_DATE  BETWEEN ? AND ? ")
		.append(" and (select count(1) from fhp_woman_children as wc where wc.person_id = p.ID ) = 2 ")
		.append(" and (select count(1) from fhp_woman_children as wc where wc.person_id = p.ID and wc.sex = 2 ) = 2 ")
		.append(" group by p.area ")

		.append(" union all ")
		//上环、一孩上环
		.append(" select count(1) as COUNTH,p.AREA,31 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id ")
		.append(" where wc.METHOD = 203 ")
		.append(" and wc.OPS_DATE  BETWEEN ? AND ? ")
		.append(" group by p.area ")
		.append(" union all ")
		.append(" select count(1) as COUNTH,p.AREA,32 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id ")
		.append(" where wc.METHOD = 203 ")
		.append(" and wc.OPS_DATE  BETWEEN ? AND ? ")
		.append(" and (select count(1) from fhp_woman_children as wc where wc.person_id = p.ID ) = 1 ")
		.append(" group by p.area ")

		.append(" union all  ")
		//补救措施一、补救措施二
		.append(" select count(1) as COUNTH,p.AREA,41 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id ")
		.append(" where wc.REPAIR_METHOD = 266 ")
		.append(" and wc.REPAIR_DATE  BETWEEN ? AND ? ")
		.append(" group by p.area ")
		.append(" union all ")
		.append(" select count(1) as COUNTH,p.AREA,42 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id ")
		.append(" where wc.REPAIR_METHOD = 267 ")
		.append(" and wc.REPAIR_DATE  BETWEEN ? AND ? ")
		.append(" group by p.area ")

		.append(" union all  ")
		//皮下埋植
		.append(" select count(1) as COUNTH,p.AREA,51 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id ")
		.append(" where wc.METHOD = 207 ")
		.append(" and wc.OPS_DATE  BETWEEN ? AND ? ")
		.append(" group by p.area ")
		.append(" ) a where 1=1 ");
		
		params.add(startDate);
		params.add(endDate);
		params.add(startDate);
		params.add(endDate);
		params.add(startDate);
		params.add(endDate);
		params.add(startDate);
		params.add(endDate);
		params.add(startDate);
		params.add(endDate);
		
		params.add(startDate);
		params.add(endDate);
		params.add(startDate);
		params.add(endDate);
		params.add(startDate);
		params.add(endDate);
		params.add(startDate);
		params.add(endDate);
		params.add(startDate);
		params.add(endDate);

		params.add(startDate);
		params.add(endDate);
		params.add(startDate);
		params.add(endDate);
		params.add(startDate);
		params.add(endDate);
		params.add(startDate);
		params.add(endDate);
		params.add(startDate);
		params.add(endDate);
		
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
		page.setResult(result);
		page.setTotalCount(result.size());
		return page;
	}
	
	/**
	 * 统计表2-期间人口自然变动及女性初婚情况统计表
	 * @param page
	 * @param startDate
	 * @param endDate
	 * @param area
	 * @return
	 */
	public Page findStat2Reports(Page page,Date startDate,Date endDate,String area){
		List params = new ArrayList();
		StringBuilder sql = new StringBuilder()

		.append(" select * from ( ")
		//一孩、政策内一孩、二孩、政策内二孩、三孩、政策内三孩
		.append(" select count(1) as counth,p.area,11 as TYPEH,wc.sex from fhp_woman_children as wc LEFT JOIN fhp_person as p on p.ID = wc.PERSON_ID ")
		.append(" where wc.BIRTHDAY BETWEEN ? AND ? ")
		.append(" and wc.CHILD_INDEX = 1 group by p.area,wc.sex  ")
		.append(" union all ")
		.append(" select count(1) as counth,p.area,12 as TYPEH,wc.sex from fhp_woman_children as wc LEFT JOIN fhp_person as p on p.ID = wc.PERSON_ID ")
		.append(" where wc.BIRTHDAY BETWEEN ? AND ? ")
		.append(" and wc.CHILD_INDEX = 1 and wc.POLICY = 290 group by p.area,wc.sex  ")
		.append(" union all ")
		.append(" select count(1) as counth,p.area,13 as TYPEH,wc.sex from fhp_woman_children as wc LEFT JOIN fhp_person as p on p.ID = wc.PERSON_ID ")
		.append(" where wc.BIRTHDAY BETWEEN ? AND ? ")
		.append(" and wc.CHILD_INDEX = 2 group by p.area,wc.sex ")
		.append(" union all ")
		.append(" select count(1) as counth,p.area,14 as TYPEH,wc.sex from fhp_woman_children as wc LEFT JOIN fhp_person as p on p.ID = wc.PERSON_ID ")
		.append(" where wc.BIRTHDAY BETWEEN ? AND ? ")
		.append(" and wc.CHILD_INDEX = 2 and wc.POLICY = 290 group by p.area,wc.sex ")
		.append(" union all ")
		.append(" select count(1) as counth,p.area,15 as TYPEH,wc.sex from fhp_woman_children as wc LEFT JOIN fhp_person as p on p.ID = wc.PERSON_ID ")
		.append(" where wc.BIRTHDAY BETWEEN ? AND ? ")
		.append(" and wc.CHILD_INDEX >= 3 group by p.area,wc.sex ")
		.append(" union all ")
		.append(" select count(1) as counth,p.area,16 as TYPEH,wc.sex from fhp_woman_children as wc LEFT JOIN fhp_person as p on p.ID = wc.PERSON_ID ")
		.append(" where wc.BIRTHDAY BETWEEN ? AND ? ")
		.append(" and wc.CHILD_INDEX >= 3 and wc.POLICY = 290 group by p.area,wc.sex ")
		.append(" union all ")
		//死亡
		.append(" select count(1) as counth,p.area,21 as TYPEH,-1 from fhp_death_reg as dr LEFT JOIN fhp_person as p on p.ID = dr.PERSON_ID ")
		.append(" where dr.DATEH  BETWEEN ? AND ? ")
		.append(" union all ")
		//女性初婚、20岁以下、23岁以上
		.append(" select count(1) as counth,p.area,31 as TYPEH,-1 from fhp_person as p LEFT JOIN fhp_person_basic as pb on pb.PERSON_ID = p.ID ")
		.append(" where p.SEX = 2 and pb.FIRST_MARRY_DATE BETWEEN ? AND ? ")
		.append(" union all ")
		.append(" select count(1) as counth,p.area,32 as TYPEH,-1 from fhp_person as p LEFT JOIN fhp_person_basic as pb on pb.PERSON_ID = p.ID ")
		.append(" where p.SEX = 2 and pb.FIRST_MARRY_DATE BETWEEN ? AND ? and p.age <= 20 ")
		.append(" union all ")
		.append(" select count(1) as counth,p.area,33 as TYPEH,-1 from fhp_person as p LEFT JOIN fhp_person_basic as pb on pb.PERSON_ID = p.ID ")
		.append(" where p.SEX = 2 and pb.FIRST_MARRY_DATE BETWEEN ? AND ? and p.age >= 23 ")
		.append(" ) a where 1=1 ");
		
		params.add(startDate);
		params.add(endDate);
		params.add(startDate);
		params.add(endDate);
		params.add(startDate);
		params.add(endDate);
		params.add(startDate);
		params.add(endDate);
		params.add(startDate);
		params.add(endDate);
		
		params.add(startDate);
		params.add(endDate);
		params.add(startDate);
		params.add(endDate);
		params.add(startDate);
		params.add(endDate);
		params.add(startDate);
		params.add(endDate);
		params.add(startDate);
		params.add(endDate);
		
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
		page.setResult(result);
		page.setTotalCount(result.size());
		return page;
	}

	/**
	 * 统计表3-已婚育龄夫妇节育情况统计表
	 * @param page
	 * @param startDate
	 * @param endDate
	 * @param area
	 * @return
	 */
	public Page findStat3Reports(Page page,Date startDate,Date endDate,String area){
		List params = new ArrayList();
		StringBuilder sql = new StringBuilder()

		.append(" select * from ( ")
		//已婚妇女人数
		.append(" select count(1) as counth,p.area,11 as TYPEH from fhp_person as p LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where pb.MARRY_STATUS <> 175 group by p.area ")
		
		.append(" union all ")
		//男扎、女扎、二孩结扎、纯二女结扎
		.append(" select count(1) as COUNTH,p.AREA,21 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD = 201 and wc.OPS_DATE  BETWEEN ? AND ? and pb.MARRY_STATUS <> 175 ")
		.append(" group by p.area ")
		.append(" union all ")
		.append(" select count(1) as COUNTH,p.AREA,22 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD = 202 and wc.OPS_DATE  BETWEEN ? AND ? and pb.MARRY_STATUS <> 175 ")
		.append(" group by p.area ")
		.append(" union all ")
		.append(" select count(1) as COUNTH,p.AREA,23 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where (wc.METHOD = 201 or wc.METHOD = 202) ")
		.append(" and wc.OPS_DATE  BETWEEN ? AND ? and pb.MARRY_STATUS <> 175 ")
		.append(" and (select count(1) from fhp_woman_children as wc where wc.person_id = p.ID ) = 2 ")
		.append(" group by p.area ")
		.append(" union all ")
		.append(" select count(1) as COUNTH,p.AREA,24 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where (wc.METHOD = 201 or wc.METHOD = 202) ")
		.append(" and wc.OPS_DATE  BETWEEN ? AND ? and pb.MARRY_STATUS <> 175 ")
		.append(" and (select count(1) from fhp_woman_children as wc where wc.person_id = p.ID ) = 2 ")
		.append(" and (select count(1) from fhp_woman_children as wc where wc.person_id = p.ID and wc.sex = 2 ) = 2 ")
		.append(" group by p.area ")
		
		.append(" union all ")
		//上环、一孩上环
		.append(" select count(1) as COUNTH,p.AREA,31 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD = 203 ")
		.append(" and wc.OPS_DATE  BETWEEN ? AND ? and pb.MARRY_STATUS <> 175 ")
		.append(" group by p.area ")
		.append(" union all ")
		.append(" select count(1) as COUNTH,p.AREA,32 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id ")
		.append(" LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD = 203 ")
		.append(" and wc.OPS_DATE  BETWEEN ? AND ? and pb.MARRY_STATUS <> 175 ")
		.append(" and (select count(1) from fhp_woman_children as wc where wc.person_id = p.ID ) = 1 ")
		.append(" group by p.area ")
		
		.append(" union all  ")
		//补救措施一、补救措施二
		.append(" select count(1) as COUNTH,p.AREA,41 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.REPAIR_METHOD = 266 ")
		.append(" and wc.REPAIR_DATE  BETWEEN ? AND ?  and pb.MARRY_STATUS <> 175 ")
		.append(" group by p.area ")
		.append(" union all ")
		.append(" select count(1) as COUNTH,p.AREA,42 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.REPAIR_METHOD = 267 ")
		.append(" and wc.REPAIR_DATE  BETWEEN ? AND ? and pb.MARRY_STATUS <> 175 ")
		.append(" group by p.area ")
		
		.append(" union all  ")
		//皮下埋植
		.append(" select count(1) as COUNTH,p.AREA,51 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD = 207 ")
		.append(" and wc.OPS_DATE  BETWEEN ? AND ? and pb.MARRY_STATUS <> 175 ")
		.append(" group by p.area ")
		
		.append(" union all  ")
		//男扎、女扎、放环、服药、避孕套、外用药、皮下埋植、其它
		.append(" select count(1) as COUNTH,p.AREA,61 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD = 201 and pb.MARRY_STATUS <> 175 ")
		.append(" group by p.area ")
		.append(" union all  ")
		.append(" select count(1) as COUNTH,p.AREA,62 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD = 202 and pb.MARRY_STATUS <> 175 ")
		.append(" group by p.area ")
		.append(" union all  ")
		.append(" select count(1) as COUNTH,p.AREA,63 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD = 203 and pb.MARRY_STATUS <> 175 ")
		.append(" group by p.area ")
		.append(" union all  ")
		.append(" select count(1) as COUNTH,p.AREA,64 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD = 204 and pb.MARRY_STATUS <> 175 ")
		.append(" group by p.area ")
		.append(" union all  ")
		.append(" select count(1) as COUNTH,p.AREA,65 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD = 205 and pb.MARRY_STATUS <> 175 ")
		.append(" group by p.area ")
		.append(" union all  ")
		.append(" select count(1) as COUNTH,p.AREA,66 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD = 206 and pb.MARRY_STATUS <> 175 ")
		.append(" group by p.area ")
		.append(" union all  ")
		.append(" select count(1) as COUNTH,p.AREA,67 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD = 207 and pb.MARRY_STATUS <> 175 ")
		.append(" group by p.area ")
		.append(" union all  ")
		.append(" select count(1) as COUNTH,p.AREA,68 as TYPEH from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD >= 209 and wc.METHOD <= 212 and pb.MARRY_STATUS <> 175 ")
		.append(" group by p.area ")
		
		.append(" union all  ")
		//领独身子女证：本期、期末
		.append(" select count(1) as COUNTH,p.AREA,71 as TYPEH from FHP_TOC_CERT as tc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = tc.PERSON_ID LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where tc.ISS_DATE BETWEEN ? AND ? and pb.MARRY_STATUS <> 175 ")
		.append(" group by p.area ")
		.append(" union all ")
		.append(" select count(1) as COUNTH,p.AREA,72 as TYPEH from FHP_TOC_CERT as tc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = tc.PERSON_ID LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where tc.ISS_DATE BETWEEN ? AND ? and pb.MARRY_STATUS <> 175 ")
		.append(" group by p.area ")
		
		.append(" union all  ")
		//取环
		.append(" select count(1) as COUNTH,p.AREA,81 as TYPEH from FHP_GET_IUD as gi ")
		.append(" LEFT JOIN fhp_fertile_woman as fw on fw.ID = gi.WOMAN_ID LEFT JOIN fhp_person as p on p.ID = fw.PERSON_ID ")
		.append(" LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where gi.DATEH BETWEEN ? AND ? and pb.MARRY_STATUS <> 175 ")
		.append(" group by p.area ")
		.append(" ) a where 1=1 ");
		
		params.add(startDate);
		params.add(endDate);
		params.add(startDate);
		params.add(endDate);
		params.add(startDate);
		params.add(endDate);
		params.add(startDate);
		params.add(endDate);
		params.add(startDate);
		params.add(endDate);
		
		params.add(startDate);
		params.add(endDate);
		params.add(startDate);
		params.add(endDate);
		params.add(startDate);
		params.add(endDate);
		params.add(startDate);
		params.add(endDate);
		params.add(startDate);
		params.add(endDate);
		//期末人数
		int year = startDate.getYear() - 1;
		params.add(DateUtil.createUtilDate(year+"-01-01 00:00:00"));
		params.add(DateUtil.createUtilDate(year+"-12-31 23:59:59"));

		params.add(startDate);
		params.add(endDate);
		
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
		page.setResult(result);
		page.setTotalCount(result.size());
		return page;
	}
	
	/**
	 * 统计表4-期间分孩次落实节育措施情况统计表
	 * @param page
	 * @param startDate
	 * @param endDate
	 * @param area
	 * @return
	 */
	public Page findStat4Reports(Page page,Date startDate,Date endDate,String area){
		List params = new ArrayList();
		StringBuilder sql = new StringBuilder()

		.append(" select * from ( ")
		//一孩：男扎、女扎、放环、避孕套具、皮下埋植、其它、纯二女
		.append(" select count(1) as COUNTH,p.AREA,11 as TYPEH, ")
		.append(" (select count(1) from fhp_woman_children as wc where wc.person_id = p.ID ) as CHIND_INDEX ")
		.append(" from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD = 201 and wc.OPS_DATE  BETWEEN ? AND ? and pb.MARRY_STATUS <> 175 ")
		.append(" group by p.area ")
		.append(" union all ")
		.append(" select count(1) as COUNTH,p.AREA,12 as TYPEH, ")
		.append(" (select count(1) from fhp_woman_children as wc where wc.person_id = p.ID ) as CHIND_INDEX from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD = 202 and wc.OPS_DATE  BETWEEN ? AND ? and pb.MARRY_STATUS <> 175 ")
		.append(" group by p.area ")
		.append(" union all ")
		.append(" select count(1) as COUNTH,p.AREA,13 as TYPEH, ")
		.append(" (select count(1) from fhp_woman_children as wc where wc.person_id = p.ID ) as CHIND_INDEX from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD = 203 and wc.OPS_DATE  BETWEEN ? AND ? and pb.MARRY_STATUS <> 175 ")
		.append(" group by p.area ")
		.append(" union all ")
		.append(" select count(1) as COUNTH,p.AREA,14 as TYPEH, ")
		.append(" (select count(1) from fhp_woman_children as wc where wc.person_id = p.ID ) as CHIND_INDEX from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD >= 204 and wc.METHOD <= 206 and wc.OPS_DATE  BETWEEN ? AND ? and pb.MARRY_STATUS <> 175 ")
		.append(" group by p.area ")
		.append(" union all ")
		.append(" select count(1) as COUNTH,p.AREA,15 as TYPEH, ")
		.append(" (select count(1) from fhp_woman_children as wc where wc.person_id = p.ID ) as CHIND_INDEX from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD >= 207 and wc.OPS_DATE  BETWEEN ? AND ? and pb.MARRY_STATUS <> 175 ")
		.append(" group by p.area ")
		.append(" union all ")
		.append(" select count(1) as COUNTH,p.AREA,16 as TYPEH, ")
		.append(" (select count(1) from fhp_woman_children as wc where wc.person_id = p.ID ) as CHIND_INDEX from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD >= 209 and wc.METHOD <= 212 and wc.OPS_DATE  BETWEEN ? AND ? and pb.MARRY_STATUS <> 175 ")
		.append(" group by p.area ")
		.append(" union all ")
		.append(" select count(1) as COUNTH,p.AREA,16 as TYPEH , -1 as CHIND_INDEX from fhp_woman_contracept as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.person_id LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where wc.METHOD <> 208 and wc.OPS_DATE  BETWEEN ? AND ? and pb.MARRY_STATUS <> 175 ")
		.append(" and (select count(1) from fhp_woman_children as wc where wc.person_id = p.ID ) = 2 ")
		.append(" and (select count(1) from fhp_woman_children as wc where wc.person_id = p.ID and wc.sex = 2 ) = 2 ")
		.append(" group by p.area ")
		.append(" ) a where 1=1 ");
		
		params.add(startDate);
		params.add(endDate);
		params.add(startDate);
		params.add(endDate);
		params.add(startDate);
		params.add(endDate);
		params.add(startDate);
		params.add(endDate);
		params.add(startDate);
		params.add(endDate);
		
		params.add(startDate);
		params.add(endDate);
		params.add(startDate);
		params.add(endDate);
		
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
		page.setResult(result);
		page.setTotalCount(result.size());
		return page;
	}
	
	/**
	 * 统计表-流出人员流量分析:总人数、已婚人数
	 * @param page
	 * @param startDate
	 * @param endDate
	 * @param area
	 * @return
	 */
	public Page findStat5Reports(Page page,Date startDate,Date endDate,String area){
		List params = new ArrayList();
		StringBuilder sql = new StringBuilder()

		.append(" select * from ( ")
		//流出人员流量分析:总人数、已婚人数
		.append(" select count(1) as counth,p.area,11 as TYPEH from fhp_person_out as po LEFT JOIN fhp_person as p on p.ID = po.PERSON_ID ")
		.append(" where po.OUT_DATE BETWEEN ? AND ? group by p.area ")
		.append(" union all ")
		.append(" select count(1) as counth,p.area,12 as TYPEH from fhp_person_out as po LEFT JOIN fhp_person as p on p.ID = po.PERSON_ID ")
		.append(" LEFT JOIN fhp_person_basic as pb on pb.ID = p.ID ")
		.append(" where po.OUT_DATE BETWEEN ? AND ? and pb.MARRY_STATUS <> 175  group by p.area ")
		.append(" ) a where 1=1 ");
		
		params.add(startDate);
		params.add(endDate);
		params.add(startDate);
		params.add(endDate);
		
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
		page.setResult(result);
		page.setTotalCount(result.size());
		return page;
	}
	
}