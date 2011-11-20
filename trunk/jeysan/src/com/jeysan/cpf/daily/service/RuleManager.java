package com.jeysan.cpf.daily.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.daily.dao.RuleDao;
import com.jeysan.cpf.daily.entity.Rule;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class RuleManager {
	private static Logger logger = LoggerFactory.getLogger(RuleManager.class);
	
	private RuleDao ruleDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveRule(Rule entity){
		ruleDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveRules(List<Rule> entites){
		for(Rule entity : entites)
			ruleDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteRule(Long id){
		ruleDao.delete(id);
	}
	public void deleteRule(Rule entity){
		ruleDao.delete(entity);
	}
	/**
	 * 用于无关联实体的批量删除
	 * @param ids
	 */
	public void deleteRules(Long id){
		ruleDao.batchExecute("delete Rule where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteRules(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteRules(Long.parseLong(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public Rule getRule(Long id){
		return ruleDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Rule> searchRule(final Page<Rule> page,final List<PropertyFilter> filter){
		return ruleDao.findPage(page, filter);
	}
	
	@Autowired
	public void setRuleDao(RuleDao ruleDao) {
		this.ruleDao = ruleDao;
	}
	
	
}