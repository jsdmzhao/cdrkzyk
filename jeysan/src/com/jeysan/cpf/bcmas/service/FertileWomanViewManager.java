package com.jeysan.cpf.bcmas.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.bcmas.dao.FertileWomanViewDao;
import com.jeysan.cpf.bcmas.entity.FertileWomanView;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class FertileWomanViewManager {
	private static Logger logger = LoggerFactory.getLogger(FertileWomanViewManager.class);
	
	private FertileWomanViewDao fertileWomanViewDao;

	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public FertileWomanView getFertileWomanView(Long id){
		return fertileWomanViewDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<FertileWomanView> searchFertileWomanView(final Page<FertileWomanView> page,final List<PropertyFilter> filter){
		return fertileWomanViewDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFertileWomanViewDao(FertileWomanViewDao fertileWomanViewDao) {
		this.fertileWomanViewDao = fertileWomanViewDao;
	}
	
	
}