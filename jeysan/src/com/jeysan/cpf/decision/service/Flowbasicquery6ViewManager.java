package com.jeysan.cpf.decision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.decision.dao.Flowbasicquery6ViewDao;
import com.jeysan.cpf.decision.entity.Flowbasicquery6View;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class Flowbasicquery6ViewManager {
	private Flowbasicquery6ViewDao flowbasicquery6ViewDao;
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Flowbasicquery6View> searchFlowbasicquery6View(final Page<Flowbasicquery6View> page,final List<PropertyFilter> filter){
		return flowbasicquery6ViewDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFlowbasicquery6ViewDao(Flowbasicquery6ViewDao flowbasicquery6ViewDao) {
		this.flowbasicquery6ViewDao = flowbasicquery6ViewDao;
	}
	
	
}