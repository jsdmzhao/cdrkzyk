package com.jeysan.cpf.decision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.decision.dao.Fixbasicquery10ViewDao;
import com.jeysan.cpf.decision.entity.Fixbasicquery10View;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class Fixbasicquery10ViewManager {
	private Fixbasicquery10ViewDao fixbasicquery10ViewDao;
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Fixbasicquery10View> searchFixbasicquery10View(final Page<Fixbasicquery10View> page,final List<PropertyFilter> filter){
		return fixbasicquery10ViewDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFixbasicquery10ViewDao(Fixbasicquery10ViewDao fixbasicquery10ViewDao) {
		this.fixbasicquery10ViewDao = fixbasicquery10ViewDao;
	}
	
	
}