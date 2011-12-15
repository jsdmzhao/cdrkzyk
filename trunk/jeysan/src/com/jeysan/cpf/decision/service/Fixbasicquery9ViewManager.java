package com.jeysan.cpf.decision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.decision.dao.Fixbasicquery9ViewDao;
import com.jeysan.cpf.decision.entity.Fixbasicquery9View;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class Fixbasicquery9ViewManager {
	private Fixbasicquery9ViewDao fixbasicquery9ViewDao;
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Fixbasicquery9View> searchFixbasicquery9View(final Page<Fixbasicquery9View> page,final List<PropertyFilter> filter){
		return fixbasicquery9ViewDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFixbasicquery9ViewDao(Fixbasicquery9ViewDao fixbasicquery9ViewDao) {
		this.fixbasicquery9ViewDao = fixbasicquery9ViewDao;
	}
	
	
}