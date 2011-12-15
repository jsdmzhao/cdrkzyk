package com.jeysan.cpf.decision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.decision.dao.Fixbasicquery1ViewDao;
import com.jeysan.cpf.decision.entity.Fixbasicquery1View;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class Fixbasicquery1ViewManager {
	private Fixbasicquery1ViewDao fixbasicquery1ViewDao;
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Fixbasicquery1View> searchFixbasicquery1View(final Page<Fixbasicquery1View> page,final List<PropertyFilter> filter){
		return fixbasicquery1ViewDao.findPage(page, filter);
	}
	@Transactional(readOnly = true)
	public Page<Fixbasicquery1View> searchFixbasicquery1View4Repeat(final Page<Fixbasicquery1View> page,final String repeat){
		return fixbasicquery1ViewDao.findPage4Repeat(page, repeat);
	}
	
	@Autowired
	public void setFixbasicquery1ViewDao(Fixbasicquery1ViewDao fixbasicquery1ViewDao) {
		this.fixbasicquery1ViewDao = fixbasicquery1ViewDao;
	}
	
	
}