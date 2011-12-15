package com.jeysan.cpf.decision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.decision.dao.Fixbasicquery11ViewDao;
import com.jeysan.cpf.decision.entity.Fixbasicquery11View;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class Fixbasicquery11ViewManager {
	private Fixbasicquery11ViewDao fixbasicquery11ViewDao;
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Fixbasicquery11View> searchFixbasicquery11View(final Page<Fixbasicquery11View> page,final List<PropertyFilter> filter){
		return fixbasicquery11ViewDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFixbasicquery11ViewDao(Fixbasicquery11ViewDao fixbasicquery11ViewDao) {
		this.fixbasicquery11ViewDao = fixbasicquery11ViewDao;
	}
	
	
}