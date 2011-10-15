package com.jeysan.cpf.decision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.decision.dao.Flowbasicquery4ViewDao;
import com.jeysan.cpf.decision.entity.Flowbasicquery4View;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class Flowbasicquery4ViewManager {
	private Flowbasicquery4ViewDao flowbasicquery4ViewDao;
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Flowbasicquery4View> searchFlowbasicquery4View(final Page<Flowbasicquery4View> page,final List<PropertyFilter> filter){
		return flowbasicquery4ViewDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFlowbasicquery4ViewDao(Flowbasicquery4ViewDao flowbasicquery4ViewDao) {
		this.flowbasicquery4ViewDao = flowbasicquery4ViewDao;
	}
	
	
}