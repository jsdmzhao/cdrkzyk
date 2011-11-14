package com.jeysan.cpf.decision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.decision.dao.Flowbasicquery13ViewDao;
import com.jeysan.cpf.decision.entity.Flowbasicquery13View;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class Flowbasicquery13ViewManager {
	private Flowbasicquery13ViewDao flowbasicquery13ViewDao;
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Flowbasicquery13View> searchFlowbasicquery13View(final Page<Flowbasicquery13View> page,final List<PropertyFilter> filter){
		return flowbasicquery13ViewDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFlowbasicquery13ViewDao(Flowbasicquery13ViewDao flowbasicquery13ViewDao) {
		this.flowbasicquery13ViewDao = flowbasicquery13ViewDao;
	}
	
	
}