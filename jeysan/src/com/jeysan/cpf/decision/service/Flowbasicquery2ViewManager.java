package com.jeysan.cpf.decision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.decision.dao.Flowbasicquery2ViewDao;
import com.jeysan.cpf.decision.entity.Flowbasicquery2View;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class Flowbasicquery2ViewManager {
	private Flowbasicquery2ViewDao flowbasicquery2ViewDao;
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Flowbasicquery2View> searchFlowbasicquery2View(final Page<Flowbasicquery2View> page,final List<PropertyFilter> filter){
		return flowbasicquery2ViewDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFlowbasicquery2ViewDao(Flowbasicquery2ViewDao flowbasicquery2ViewDao) {
		this.flowbasicquery2ViewDao = flowbasicquery2ViewDao;
	}
	
	
}