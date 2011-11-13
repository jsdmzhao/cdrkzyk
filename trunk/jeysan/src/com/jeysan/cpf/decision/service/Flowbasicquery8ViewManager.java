package com.jeysan.cpf.decision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.decision.dao.Flowbasicquery8ViewDao;
import com.jeysan.cpf.decision.entity.Flowbasicquery8View;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class Flowbasicquery8ViewManager {
	private Flowbasicquery8ViewDao flowbasicquery8ViewDao;
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Flowbasicquery8View> searchFlowbasicquery8View(final Page<Flowbasicquery8View> page,final List<PropertyFilter> filter){
		return flowbasicquery8ViewDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFlowbasicquery8ViewDao(Flowbasicquery8ViewDao flowbasicquery8ViewDao) {
		this.flowbasicquery8ViewDao = flowbasicquery8ViewDao;
	}
	
	
}