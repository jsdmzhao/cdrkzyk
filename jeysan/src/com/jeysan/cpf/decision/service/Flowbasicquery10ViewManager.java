package com.jeysan.cpf.decision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.decision.dao.Flowbasicquery10ViewDao;
import com.jeysan.cpf.decision.entity.Flowbasicquery10View;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class Flowbasicquery10ViewManager {
	private Flowbasicquery10ViewDao flowbasicquery10ViewDao;
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Flowbasicquery10View> searchFlowbasicquery10View(final Page<Flowbasicquery10View> page,final List<PropertyFilter> filter){
		return flowbasicquery10ViewDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFlowbasicquery10ViewDao(Flowbasicquery10ViewDao flowbasicquery10ViewDao) {
		this.flowbasicquery10ViewDao = flowbasicquery10ViewDao;
	}
	
	
}