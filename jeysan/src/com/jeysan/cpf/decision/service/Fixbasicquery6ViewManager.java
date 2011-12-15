package com.jeysan.cpf.decision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.decision.dao.Fixbasicquery6ViewDao;
import com.jeysan.cpf.decision.entity.Fixbasicquery6View;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class Fixbasicquery6ViewManager {
	private Fixbasicquery6ViewDao fixbasicquery6ViewDao;
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Fixbasicquery6View> searchFixbasicquery6View(final Page<Fixbasicquery6View> page,final List<PropertyFilter> filter){
		return fixbasicquery6ViewDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFixbasicquery6ViewDao(Fixbasicquery6ViewDao fixbasicquery6ViewDao) {
		this.fixbasicquery6ViewDao = fixbasicquery6ViewDao;
	}
	
	
}