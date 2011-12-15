package com.jeysan.cpf.decision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.decision.dao.Fixbasicquery16ViewDao;
import com.jeysan.cpf.decision.entity.Fixbasicquery16View;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class Fixbasicquery16ViewManager {
	private Fixbasicquery16ViewDao fixbasicquery16ViewDao;
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Fixbasicquery16View> searchFixbasicquery16View(final Page<Fixbasicquery16View> page,final List<PropertyFilter> filter){
		return fixbasicquery16ViewDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFixbasicquery16ViewDao(Fixbasicquery16ViewDao fixbasicquery16ViewDao) {
		this.fixbasicquery16ViewDao = fixbasicquery16ViewDao;
	}
	
	
}