package com.jeysan.cpf.decision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.decision.dao.Fixbasicquery4ViewDao;
import com.jeysan.cpf.decision.entity.Fixbasicquery4View;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class Fixbasicquery4ViewManager {
	private Fixbasicquery4ViewDao fixbasicquery4ViewDao;
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Fixbasicquery4View> searchFixbasicquery4View(final Page<Fixbasicquery4View> page,final List<PropertyFilter> filter){
		return fixbasicquery4ViewDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFixbasicquery4ViewDao(Fixbasicquery4ViewDao fixbasicquery4ViewDao) {
		this.fixbasicquery4ViewDao = fixbasicquery4ViewDao;
	}
	
	
}