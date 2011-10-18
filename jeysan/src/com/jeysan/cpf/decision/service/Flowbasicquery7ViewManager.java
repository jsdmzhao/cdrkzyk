package com.jeysan.cpf.decision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.decision.dao.Flowbasicquery7ViewDao;
import com.jeysan.cpf.decision.entity.Flowbasicquery7View;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class Flowbasicquery7ViewManager {
	private Flowbasicquery7ViewDao flowbasicquery7ViewDao;
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Flowbasicquery7View> searchFlowbasicquery7View(final Page<Flowbasicquery7View> page,final List<PropertyFilter> filter){
		return flowbasicquery7ViewDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFlowbasicquery7ViewDao(Flowbasicquery7ViewDao flowbasicquery7ViewDao) {
		this.flowbasicquery7ViewDao = flowbasicquery7ViewDao;
	}
	
	
}