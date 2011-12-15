package com.jeysan.cpf.decision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.decision.dao.Fixbasicquery5ViewDao;
import com.jeysan.cpf.decision.entity.Fixbasicquery5View;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class Fixbasicquery5ViewManager {
	private Fixbasicquery5ViewDao fixbasicquery5ViewDao;
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Fixbasicquery5View> searchFixbasicquery5View(final Page<Fixbasicquery5View> page,final List<PropertyFilter> filter){
		return fixbasicquery5ViewDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFixbasicquery5ViewDao(Fixbasicquery5ViewDao fixbasicquery5ViewDao) {
		this.fixbasicquery5ViewDao = fixbasicquery5ViewDao;
	}
	
	
}