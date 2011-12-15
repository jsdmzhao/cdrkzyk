package com.jeysan.cpf.decision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.decision.dao.Fixbasicquery14ViewDao;
import com.jeysan.cpf.decision.entity.Fixbasicquery14View;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class Fixbasicquery14ViewManager {
	private Fixbasicquery14ViewDao fixbasicquery14ViewDao;
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Fixbasicquery14View> searchFixbasicquery14View(final Page<Fixbasicquery14View> page,final List<PropertyFilter> filter){
		return fixbasicquery14ViewDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFixbasicquery14ViewDao(Fixbasicquery14ViewDao fixbasicquery14ViewDao) {
		this.fixbasicquery14ViewDao = fixbasicquery14ViewDao;
	}
	
	
}