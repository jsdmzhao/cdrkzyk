package com.jeysan.cpf.decision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.decision.dao.Fixbasicquery15ViewDao;
import com.jeysan.cpf.decision.entity.Fixbasicquery15View;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class Fixbasicquery15ViewManager {
	private Fixbasicquery15ViewDao fixbasicquery15ViewDao;
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Fixbasicquery15View> searchFixbasicquery15View(final Page<Fixbasicquery15View> page,final List<PropertyFilter> filter){
		return fixbasicquery15ViewDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFixbasicquery15ViewDao(Fixbasicquery15ViewDao fixbasicquery15ViewDao) {
		this.fixbasicquery15ViewDao = fixbasicquery15ViewDao;
	}
	
	
}