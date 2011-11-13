package com.jeysan.cpf.decision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.decision.dao.Flowbasicquery9ViewDao;
import com.jeysan.cpf.decision.entity.Flowbasicquery9View;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class Flowbasicquery9ViewManager {
	private Flowbasicquery9ViewDao flowbasicquery9ViewDao;
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Flowbasicquery9View> searchFlowbasicquery9View(final Page<Flowbasicquery9View> page,final List<PropertyFilter> filter){
		return flowbasicquery9ViewDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFlowbasicquery9ViewDao(Flowbasicquery9ViewDao flowbasicquery9ViewDao) {
		this.flowbasicquery9ViewDao = flowbasicquery9ViewDao;
	}
	
	
}