package com.jeysan.cpf.decision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.decision.dao.Fixbasicquery20ViewDao;
import com.jeysan.cpf.decision.entity.Fixbasicquery20View;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class Fixbasicquery20ViewManager {
	private Fixbasicquery20ViewDao fixbasicquery20ViewDao;
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Fixbasicquery20View> searchFixbasicquery20View(final Page<Fixbasicquery20View> page,final List<PropertyFilter> filter){
		return fixbasicquery20ViewDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFixbasicquery20ViewDao(Fixbasicquery20ViewDao fixbasicquery20ViewDao) {
		this.fixbasicquery20ViewDao = fixbasicquery20ViewDao;
	}
	
	
}