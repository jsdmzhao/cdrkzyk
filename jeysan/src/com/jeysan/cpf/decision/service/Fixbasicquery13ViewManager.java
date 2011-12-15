package com.jeysan.cpf.decision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.decision.dao.Fixbasicquery13ViewDao;
import com.jeysan.cpf.decision.entity.Fixbasicquery13View;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class Fixbasicquery13ViewManager {
	private Fixbasicquery13ViewDao fixbasicquery13ViewDao;
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Fixbasicquery13View> searchFixbasicquery13View(final Page<Fixbasicquery13View> page,final List<PropertyFilter> filter){
		return fixbasicquery13ViewDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFixbasicquery13ViewDao(Fixbasicquery13ViewDao fixbasicquery13ViewDao) {
		this.fixbasicquery13ViewDao = fixbasicquery13ViewDao;
	}
	
	
}