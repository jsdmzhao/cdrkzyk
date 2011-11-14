package com.jeysan.cpf.decision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.decision.dao.Flowbasicquery15ViewDao;
import com.jeysan.cpf.decision.entity.Flowbasicquery15View;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class Flowbasicquery15ViewManager {
	private Flowbasicquery15ViewDao flowbasicquery15ViewDao;
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Flowbasicquery15View> searchFlowbasicquery15View(final Page<Flowbasicquery15View> page,final List<PropertyFilter> filter){
		return flowbasicquery15ViewDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFlowbasicquery15ViewDao(Flowbasicquery15ViewDao flowbasicquery15ViewDao) {
		this.flowbasicquery15ViewDao = flowbasicquery15ViewDao;
	}
	
	
}