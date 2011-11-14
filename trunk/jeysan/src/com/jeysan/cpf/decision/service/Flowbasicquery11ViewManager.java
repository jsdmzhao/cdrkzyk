package com.jeysan.cpf.decision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.decision.dao.Flowbasicquery11ViewDao;
import com.jeysan.cpf.decision.entity.Flowbasicquery11View;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class Flowbasicquery11ViewManager {
	private Flowbasicquery11ViewDao flowbasicquery11ViewDao;
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Flowbasicquery11View> searchFlowbasicquery11View(final Page<Flowbasicquery11View> page,final List<PropertyFilter> filter){
		return flowbasicquery11ViewDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFlowbasicquery11ViewDao(Flowbasicquery11ViewDao flowbasicquery11ViewDao) {
		this.flowbasicquery11ViewDao = flowbasicquery11ViewDao;
	}
	
	
}