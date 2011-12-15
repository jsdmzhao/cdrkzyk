package com.jeysan.cpf.decision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.decision.dao.Fixbasicquery12ViewDao;
import com.jeysan.cpf.decision.entity.Fixbasicquery12View;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class Fixbasicquery12ViewManager {
	private Fixbasicquery12ViewDao fixbasicquery12ViewDao;
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Fixbasicquery12View> searchFixbasicquery12View(final Page<Fixbasicquery12View> page,final List<PropertyFilter> filter){
		return fixbasicquery12ViewDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFixbasicquery12ViewDao(Fixbasicquery12ViewDao fixbasicquery12ViewDao) {
		this.fixbasicquery12ViewDao = fixbasicquery12ViewDao;
	}
	
	
}