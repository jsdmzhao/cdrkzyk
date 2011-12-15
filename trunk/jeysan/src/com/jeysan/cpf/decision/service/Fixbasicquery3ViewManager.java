package com.jeysan.cpf.decision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.decision.dao.Fixbasicquery3ViewDao;
import com.jeysan.cpf.decision.entity.Fixbasicquery3View;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class Fixbasicquery3ViewManager {
	private Fixbasicquery3ViewDao fixbasicquery3ViewDao;
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Fixbasicquery3View> searchFixbasicquery3View(final Page<Fixbasicquery3View> page,final List<PropertyFilter> filter){
		return fixbasicquery3ViewDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFixbasicquery3ViewDao(Fixbasicquery3ViewDao fixbasicquery3ViewDao) {
		this.fixbasicquery3ViewDao = fixbasicquery3ViewDao;
	}
	
	
}