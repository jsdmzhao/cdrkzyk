package com.jeysan.cpf.bcmas.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.bcmas.dao.FertileWomanDcViewDao;
import com.jeysan.cpf.bcmas.entity.FertileWomanDcView;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class FertileWomanDcViewManager {
	private static Logger logger = LoggerFactory.getLogger(FertileWomanDcViewManager.class);
	
	private FertileWomanDcViewDao fertileWomanDcViewDao;

	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public FertileWomanDcView getFertileWomanDcView(String id){
		return fertileWomanDcViewDao.get(id);
	}
	@Transactional(readOnly = true)
	public FertileWomanDcView getFertileWomanDcView(Long dcId,Long womanId){
		return fertileWomanDcViewDao.findUnique("from FertileWomanDcView where id_ = ? and dcId = ? ", womanId,dcId);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<FertileWomanDcView> searchFertileWomanView(final Page<FertileWomanDcView> page,final List<PropertyFilter> filter){
		return fertileWomanDcViewDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFertileWomanDcViewDao(FertileWomanDcViewDao fertileWomanDcViewDao) {
		this.fertileWomanDcViewDao = fertileWomanDcViewDao;
	}
	
	
}