package com.jeysan.cpf.decision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.decision.dao.Fixbasicquery2ViewDao;
import com.jeysan.cpf.decision.entity.Fixbasicquery2View;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class Fixbasicquery2ViewManager {
	private Fixbasicquery2ViewDao fixbasicquery2ViewDao;
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Fixbasicquery2View> searchFixbasicquery2View(final Page<Fixbasicquery2View> page,final List<PropertyFilter> filter){
		return fixbasicquery2ViewDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFixbasicquery2ViewDao(Fixbasicquery2ViewDao fixbasicquery2ViewDao) {
		this.fixbasicquery2ViewDao = fixbasicquery2ViewDao;
	}
	
	
}