package com.jeysan.cpf.decision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.decision.dao.Fixbasicquery18ViewDao;
import com.jeysan.cpf.decision.entity.Fixbasicquery18View;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class Fixbasicquery18ViewManager {
	private Fixbasicquery18ViewDao fixbasicquery18ViewDao;
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Fixbasicquery18View> searchFixbasicquery18View(final Page<Fixbasicquery18View> page,final List<PropertyFilter> filter){
		return fixbasicquery18ViewDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFixbasicquery18ViewDao(Fixbasicquery18ViewDao fixbasicquery18ViewDao) {
		this.fixbasicquery18ViewDao = fixbasicquery18ViewDao;
	}
	
	
}