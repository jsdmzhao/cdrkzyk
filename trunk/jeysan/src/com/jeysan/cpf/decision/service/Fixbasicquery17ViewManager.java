package com.jeysan.cpf.decision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.decision.dao.Fixbasicquery17ViewDao;
import com.jeysan.cpf.decision.entity.Fixbasicquery17View;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class Fixbasicquery17ViewManager {
	private Fixbasicquery17ViewDao fixbasicquery17ViewDao;
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Fixbasicquery17View> searchFixbasicquery17View(final Page<Fixbasicquery17View> page,final List<PropertyFilter> filter){
		return fixbasicquery17ViewDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFixbasicquery17ViewDao(Fixbasicquery17ViewDao fixbasicquery17ViewDao) {
		this.fixbasicquery17ViewDao = fixbasicquery17ViewDao;
	}
	
	
}