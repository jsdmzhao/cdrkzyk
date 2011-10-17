package com.jeysan.cpf.decision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.decision.dao.Flowbasicquery5ViewDao;
import com.jeysan.cpf.decision.entity.Flowbasicquery5View;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class Flowbasicquery5ViewManager {
	private Flowbasicquery5ViewDao flowbasicquery5ViewDao;
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Flowbasicquery5View> searchFlowbasicquery5View(final Page<Flowbasicquery5View> page,final List<PropertyFilter> filter){
		return flowbasicquery5ViewDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFlowbasicquery5ViewDao(Flowbasicquery5ViewDao flowbasicquery5ViewDao) {
		this.flowbasicquery5ViewDao = flowbasicquery5ViewDao;
	}
	
	
}