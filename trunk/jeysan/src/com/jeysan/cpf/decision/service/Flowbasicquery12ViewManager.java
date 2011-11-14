package com.jeysan.cpf.decision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.decision.dao.Flowbasicquery12ViewDao;
import com.jeysan.cpf.decision.entity.Flowbasicquery12View;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class Flowbasicquery12ViewManager {
	private Flowbasicquery12ViewDao flowbasicquery12ViewDao;
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Flowbasicquery12View> searchFlowbasicquery12View(final Page<Flowbasicquery12View> page,final List<PropertyFilter> filter){
		return flowbasicquery12ViewDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFlowbasicquery12ViewDao(Flowbasicquery12ViewDao flowbasicquery12ViewDao) {
		this.flowbasicquery12ViewDao = flowbasicquery12ViewDao;
	}
	
	
}