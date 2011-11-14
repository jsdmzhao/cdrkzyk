package com.jeysan.cpf.decision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.decision.dao.Flowbasicquery14ViewDao;
import com.jeysan.cpf.decision.entity.Flowbasicquery14View;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class Flowbasicquery14ViewManager {
	private Flowbasicquery14ViewDao flowbasicquery14ViewDao;
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Flowbasicquery14View> searchFlowbasicquery14View(final Page<Flowbasicquery14View> page,final List<PropertyFilter> filter){
		return flowbasicquery14ViewDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFlowbasicquery14ViewDao(Flowbasicquery14ViewDao flowbasicquery14ViewDao) {
		this.flowbasicquery14ViewDao = flowbasicquery14ViewDao;
	}
	
	
}