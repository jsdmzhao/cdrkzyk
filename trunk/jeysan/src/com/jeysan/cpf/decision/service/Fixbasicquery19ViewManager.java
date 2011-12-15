package com.jeysan.cpf.decision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.decision.dao.Fixbasicquery19ViewDao;
import com.jeysan.cpf.decision.entity.Fixbasicquery19View;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class Fixbasicquery19ViewManager {
	private Fixbasicquery19ViewDao fixbasicquery19ViewDao;
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Fixbasicquery19View> searchFixbasicquery19View(final Page<Fixbasicquery19View> page,final List<PropertyFilter> filter){
		return fixbasicquery19ViewDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFixbasicquery19ViewDao(Fixbasicquery19ViewDao fixbasicquery19ViewDao) {
		this.fixbasicquery19ViewDao = fixbasicquery19ViewDao;
	}
	
	
}