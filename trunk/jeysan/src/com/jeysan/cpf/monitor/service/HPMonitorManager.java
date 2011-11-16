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
	
}