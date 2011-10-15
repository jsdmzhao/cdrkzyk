package com.jeysan.cpf.decision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.decision.dao.Flowbasicquery3ViewDao;
import com.jeysan.cpf.decision.entity.Flowbasicquery3View;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class Flowbasicquery3ViewManager {
	private Flowbasicquery3ViewDao flowbasicquery3ViewDao;
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Flowbasicquery3View> searchFlowbasicquery3View(final Page<Flowbasicquery3View> page,final List<PropertyFilter> filter){
		return flowbasicquery3ViewDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFlowbasicquery3ViewDao(Flowbasicquery3ViewDao flowbasicquery3ViewDao) {
		this.flowbasicquery3ViewDao = flowbasicquery3ViewDao;
	}
	
	
}