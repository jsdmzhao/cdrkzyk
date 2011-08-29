package com.jeysan.cpf.bcmas.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.bcmas.dao.AssStatusViewDao;
import com.jeysan.cpf.bcmas.entity.AssStatusView;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class AssStatusViewManager {
	private static Logger logger = LoggerFactory.getLogger(AssStatusViewManager.class);
	
	private AssStatusViewDao assStatusViewDao;

	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public AssStatusView getAssStatusView(Long id){
		return assStatusViewDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<AssStatusView> searchAssStatusView(final Page<AssStatusView> page,final List<PropertyFilter> filter){
		return assStatusViewDao.findPage(page, filter);
	}
	
	@Autowired
	public void setAssStatusViewDao(AssStatusViewDao assStatusViewDao) {
		this.assStatusViewDao = assStatusViewDao;
	}
	
	
	
}