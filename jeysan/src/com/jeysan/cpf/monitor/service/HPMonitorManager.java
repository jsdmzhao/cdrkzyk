package com.jeysan.cpf.monitor.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.monitor.dao.HPMonitorDao;
import com.jeysan.modules.orm.Page;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class HPMonitorManager {
	private static Logger logger = LoggerFactory.getLogger(HPMonitorManager.class);
	
	private HPMonitorDao hpMonitorDao;
	
	@Autowired
	public void setHpMonitorDao(HPMonitorDao hpMonitorDao) {
		this.hpMonitorDao = hpMonitorDao;
	}
	
	public Page findDoubleCheckObjects(Page page,Integer domicileType,String area){
		List params = new ArrayList();
		StringBuilder sql = new StringBuilder()
		.append(" select p.PERSON_CODE,p.CODE,p.NAMEH,p.SEX,sp.NAMEH as NAMEH2,pb.MARRY_STATUS,pb.JOB,wc.METHOD,wc.OPS_DATE, ")
		.append(" (select min(wch.BIRTHDAY) from FHP_WOMAN_CHILDREN as wch where wch.PERSON_ID = p.ID) as minBirthday, ")
		.append(" (select count(1) from FHP_WOMAN_CHILDREN as wch where wch.PERSON_ID = p.ID) as childNum, ")
		.append(" pb.DOMICILE,pb.ADDRESS,pb.TEL,pb.COMPANY,p.SETTLE_IN_DATE,p.AREA ")
		.append(" from FHP_DOUBLE_CHECK_OBJECT as dco ")
		.append(" LEFT JOIN fhp_fertile_woman as fw on fw.ID = dco.WOMAN_ID ")
		.append(" LEFT JOIN fhp_person as p on p.ID = fw.PERSON_ID ")
		.append(" LEFT JOIN fhp_person_basic as pb on pb.PERSON_ID = p.ID ")
		.append(" LEFT JOIN fhp_spouse as sp on sp.PERSON_ID = p.ID ")
		.append(" LEFT JOIN fhp_woman_contracept as wc on wc.person_id = p.ID where p.DOMICILE_TYPE = ? ");
		params.add(domicileType);
		if(StringUtils.isNotEmpty(area)){
			sql.append(" and p.AREA = ? ");
			params.add(area);
		}
		if(StringUtils.isNotEmpty(page.getOrderBy())){
			sql.append(" order by ").append(page.getOrderBy());
			if(StringUtils.isNotEmpty(page.getOrder()))
				sql.append(" ").append(page.getOrder());
		}
		List result = this.hpMonitorDao.findBySql(sql.toString(), params.toArray());
		page.setResult(result);
		page.setTotalCount(result.size());
		return page;
	}
	
	public Page findBirth2Applys(Page page,Integer domicileType,Integer typeh,String area){
		List params = new ArrayList();
		StringBuilder sql = new StringBuilder()
		.append(" select p.PERSON_CODE,p.NAMEH,sp.NAMEH as NAMEH2, ")
		.append(" (select count(1) from FHP_WOMAN_CHILDREN as wch where wch.PERSON_ID = p.ID) as childNum, ")
		.append(" ba.DATEH,ba.TYPEH,ba.IS_SECOND,ba.COND,pb.DOMICILE,pb.ADDRESS,p.AREA ")
		.append(" from FHP_BIRTH2_APPLY as ba ")
		.append(" LEFT JOIN fhp_fertile_woman as fw on fw.ID = ba.WOMAN_ID ")
		.append(" LEFT JOIN fhp_person as p on p.ID = fw.PERSON_ID ")
		.append(" LEFT JOIN fhp_person_basic as pb on pb.PERSON_ID = p.ID ")
		.append(" LEFT JOIN fhp_spouse as sp on sp.PERSON_ID = p.ID where p.DOMICILE_TYPE = ? ");
		params.add(domicileType);
		if(typeh != null){
			sql.append(" and ba.TYPEH = ? ");
			params.add(typeh);
		}
		if(StringUtils.isNotEmpty(area)){
			sql.append(" and p.AREA = ? ");
			params.add(area);
		}
		if(StringUtils.isNotEmpty(page.getOrderBy())){
			sql.append(" order by ").append(page.getOrderBy());
			if(StringUtils.isNotEmpty(page.getOrder()))
				sql.append(" ").append(page.getOrder());
		}
		List result = this.hpMonitorDao.findBySql(sql.toString(), params.toArray());
		page.setResult(result);
		page.setTotalCount(result.size());
		return page;
	}

	public Page findWomanMatenalOver7Months(Page page,Integer domicileType,String area){
		List params = new ArrayList();
		StringBuilder sql = new StringBuilder()
		.append(" select p.PERSON_CODE,p.NAMEH,pb.ADDRESS,pb.MARRY_STATUS, ")
		.append(" (select count(1) from FHP_WOMAN_CHILDREN as wch where wch.PERSON_ID = p.ID) as childNum, ")
		.append(" wm.CONCEPT_DATE,wm.EDD,pb.HOUSE_NO,p.AREA,p.DOMICILE_TYPE ")
		.append(" from FHP_WOMAN_MATENAL as wm ")
		.append(" LEFT JOIN fhp_fertile_woman as fw on fw.ID = wm.WOMAN_ID ")
		.append(" LEFT JOIN fhp_person as p on p.ID = fw.PERSON_ID ")
		.append(" LEFT JOIN fhp_person_basic as pb on pb.PERSON_ID = p.ID where p.DOMICILE_TYPE = ? ")
		.append(" and ((wm.CONCEPT_RESULT is null and PERIOD_DIFF(CURRENT_DATE(),wm.CONCEPT_DATE)>=7) or (wm.CONCEPT_RESULT is not null and PERIOD_DIFF(END_DATE,wm.CONCEPT_DATE)>=7)) ");
		params.add(domicileType);
		if(StringUtils.isNotEmpty(area)){
			sql.append(" and p.AREA = ? ");
			params.add(area);
		}
		if(StringUtils.isNotEmpty(page.getOrderBy())){
			sql.append(" order by ").append(page.getOrderBy());
			if(StringUtils.isNotEmpty(page.getOrder()))
				sql.append(" ").append(page.getOrder());
		}
		List result = this.hpMonitorDao.findBySql(sql.toString(), params.toArray());
		page.setResult(result);
		page.setTotalCount(result.size());
		return page;
	}
	
	public Page findNoContracepts(Page page,Integer domicileType,Integer method,String area){
		List params = new ArrayList();
		StringBuilder sql = new StringBuilder()
		.append(" select p.PERSON_CODE,p.NAMEH,p.CODE,wc.METHOD,pb.ADDRESS,pb.BIRTHDAY,pb.HAVE_STATUS,pb.COMPANY, ")
		.append(" (select count(1) from FHP_WOMAN_CHILDREN as wch where wch.PERSON_ID = p.ID) as childNum, ")
		.append(" (select min(wch.BIRTHDAY) from FHP_WOMAN_CHILDREN as wch where wch.PERSON_ID = p.ID) as minBirthday, ")
		.append(" p.AREA,p.DOMICILE_TYPE,wc.NO_METHOD_TYPE ")
		.append(" from FHP_WOMAN_CONTRACEPT as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.PERSON_ID ")
		.append(" LEFT JOIN fhp_person_basic as pb on pb.PERSON_ID = p.ID ")
		.append(" where p.DOMICILE_TYPE = ? and wc.NO_METHOD_TYPE is not null ");
		params.add(domicileType);
		if(method != null){
			sql.append(" and wc.METHOD = ? ");
			params.add(method);
		}
		if(StringUtils.isNotEmpty(area)){
			sql.append(" and p.AREA = ? ");
			params.add(area);
		}
		if(StringUtils.isNotEmpty(page.getOrderBy())){
			sql.append(" order by ").append(page.getOrderBy());
			if(StringUtils.isNotEmpty(page.getOrder()))
				sql.append(" ").append(page.getOrder());
		}
		List result = this.hpMonitorDao.findBySql(sql.toString(), params.toArray());
		page.setResult(result);
		page.setTotalCount(result.size());
		return page;
	}

	public Page findDelayContracepts(Page page,Integer domicileType,String area){
		List params = new ArrayList();
		StringBuilder sql = new StringBuilder()
		.append(" select p.PERSON_CODE,p.NAMEH,pb.FIRST_MARRY_DATE,pb.ADDRESS,wc.DELAY_CAUSE,wc.DELAY_COMPANY,wc.DELAY_DATE,wc.DELAY_DOCTOR,wc.DELAY_END_CAUSE,p.AREA,p.DOMICILE_TYPE ")
		.append(" from FHP_WOMAN_CONTRACEPT as wc ")
		.append(" LEFT JOIN fhp_person as p on p.ID = wc.PERSON_ID ")
		.append(" LEFT JOIN fhp_person_basic as pb on pb.PERSON_ID = p.ID ")
		.append(" where wc.DELAY_CAUSE is not null and p.DOMICILE_TYPE = ? ");
		params.add(domicileType);
		if(StringUtils.isNotEmpty(area)){
			sql.append(" and p.AREA = ? ");
			params.add(area);
		}
		if(StringUtils.isNotEmpty(page.getOrderBy())){
			sql.append(" order by ").append(page.getOrderBy());
			if(StringUtils.isNotEmpty(page.getOrder()))
				sql.append(" ").append(page.getOrder());
		}
		List result = this.hpMonitorDao.findBySql(sql.toString(), params.toArray());
		page.setResult(result);
		page.setTotalCount(result.size());
		return page;
	}

	public Page findSocialUpbrings(Page page,Integer domicileType,String area){
		List params = new ArrayList();
		StringBuilder sql = new StringBuilder()
		.append(" select p.PERSON_CODE,p.NAMEH,sp.NAMEH as NAMEH2,wsu.CAUSE,wsu.TOTAL_MONEY,wsu.YET_MONEY, ")
		.append(" (select count(1) from FHP_WOMAN_UPBRING_DETAIL as wud where wud.UPBRING_ID = wsu.ID) as counth, ")
		.append(" p.DOMICILE_TYPE,p.AREA,pb.ADDRESS ")
		.append(" from FHP_WOMAN_SOCIAL_UPBRING as wsu  ")
		.append(" LEFT JOIN fhp_fertile_woman as fw on fw.ID = wsu.WOMAN_ID ")
		.append(" LEFT JOIN fhp_person as p on p.ID = fw.PERSON_ID ")
		.append(" LEFT JOIN fhp_person_basic as pb on pb.PERSON_ID = p.ID ")
		.append(" LEFT JOIN fhp_spouse as sp on sp.PERSON_ID = p.ID ")
		.append(" where p.DOMICILE_TYPE = ? ");
		params.add(domicileType);
		if(StringUtils.isNotEmpty(area)){
			sql.append(" and p.AREA = ? ");
			params.add(area);
		}
		if(StringUtils.isNotEmpty(page.getOrderBy())){
			sql.append(" order by ").append(page.getOrderBy());
			if(StringUtils.isNotEmpty(page.getOrder()))
				sql.append(" ").append(page.getOrder());
		}
		List result = this.hpMonitorDao.findBySql(sql.toString(), params.toArray());
		page.setResult(result);
		page.setTotalCount(result.size());
		return page;
	}
	

	public Page findBcsCerts(Page page,Integer domicileType,String area){
		List params = new ArrayList();
		StringBuilder sql = new StringBuilder()
		.append(" select p.PERSON_CODE,p.NAMEH,p.SEX,pb.BIRTHDAY,p.CODE,pb.HAVE_STATUS,bc.VALID_PEROID,pb.COMPANY,p.DOMICILE_TYPE,p.AREA,pb.ADDRESS,wc.METHOD ")
		.append(" from FHP_BCS_CERT as bc   ")
		.append(" LEFT JOIN fhp_fertile_woman as fw on fw.ID = bc.WOMAN_ID ")
		.append(" LEFT JOIN fhp_person as p on p.ID = fw.PERSON_ID ")
		.append(" LEFT JOIN fhp_person_basic as pb on pb.PERSON_ID = p.ID ")
		.append(" LEFT JOIN fhp_woman_contracept as wc on wc.person_id = p.ID ")
		.append(" where p.DOMICILE_TYPE = ? ");
		params.add(domicileType);
		if(StringUtils.isNotEmpty(area)){
			sql.append(" and p.AREA = ? ");
			params.add(area);
		}
		if(StringUtils.isNotEmpty(page.getOrderBy())){
			sql.append(" order by ").append(page.getOrderBy());
			if(StringUtils.isNotEmpty(page.getOrder()))
				sql.append(" ").append(page.getOrder());
		}
		List result = this.hpMonitorDao.findBySql(sql.toString(), params.toArray());
		page.setResult(result);
		page.setTotalCount(result.size());
		return page;
	}
}