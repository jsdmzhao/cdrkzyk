package com.jeysan.cpf.decision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.decision.dao.Fixbasicquery7ViewDao;
import com.jeysan.cpf.decision.entity.Fixbasicquery7View;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class Fixbasicquery7ViewManager {
	private Fixbasicquery7ViewDao fixbasicquery7ViewDao;
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Fixbasicquery7View> searchFixbasicquery7View(final Page<Fixbasicquery7View> page,final List<PropertyFilter> filter){
		return fixbasicquery7ViewDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFixbasicquery7ViewDao(Fixbasicquery7ViewDao fixbasicquery7ViewDao) {
		this.fixbasicquery7ViewDao = fixbasicquery7ViewDao;
	}
	
	
}