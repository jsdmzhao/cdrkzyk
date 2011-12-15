package com.jeysan.cpf.decision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.decision.dao.Fixbasicquery8ViewDao;
import com.jeysan.cpf.decision.entity.Fixbasicquery8View;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class Fixbasicquery8ViewManager {
	private Fixbasicquery8ViewDao fixbasicquery8ViewDao;
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Fixbasicquery8View> searchFixbasicquery8View(final Page<Fixbasicquery8View> page,final List<PropertyFilter> filter){
		return fixbasicquery8ViewDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFixbasicquery8ViewDao(Fixbasicquery8ViewDao fixbasicquery8ViewDao) {
		this.fixbasicquery8ViewDao = fixbasicquery8ViewDao;
	}
	
	
}