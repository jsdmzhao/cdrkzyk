package com.jeysan.cpf.decision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.decision.dao.Flowbasicquery1ViewDao;
import com.jeysan.cpf.decision.entity.Flowbasicquery1View;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class Flowbasicquery1ViewManager {
	
	private Flowbasicquery1ViewDao flowbasicquery1ViewDao;
	
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Flowbasicquery1View> searchFlowbasicquery1View(final Page<Flowbasicquery1View> page,final List<PropertyFilter> filter){
		return flowbasicquery1ViewDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFlowbasicquery1ViewDao(Flowbasicquery1ViewDao flowbasicquery1ViewDao) {
		this.flowbasicquery1ViewDao = flowbasicquery1ViewDao;
	}
	
	
}