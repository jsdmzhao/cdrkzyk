﻿package com.jeysan.cpf.bcmas.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.bcmas.dao.AssuranceDao;
import com.jeysan.cpf.bcmas.entity.Assurance;
import com.jeysan.cpf.util.Constants;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class AssuranceManager {
	private static Logger logger = LoggerFactory.getLogger(AssuranceManager.class);
	
	private AssuranceDao assuranceDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveAssurance(Assurance entity){
		assuranceDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveAssurances(List<Assurance> entites){
		for(Assurance entity : entites)
			assuranceDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteAssurance(Long id){
		assuranceDao.batchExecute("delete Assurance where fertileWoman.id = ?", id);
		assuranceDao.batchExecute("update FertileWoman set assStatus = ? where id = ?", Constants.ASS_STATUS.NO_ASS,id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteAssurances(Long id){
		assuranceDao.batchExecute("delete Assurance where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteAssurances(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteAssurance(Long.parseLong(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public Assurance getAssurance(Long id){
		return assuranceDao.get(id);
	}
	@Transactional(readOnly = true)
	public Assurance getAssuranceByWomanId(Long womanId){
		return assuranceDao.findUnique("from Assurance where fertileWoman.id = ? ", womanId );
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Assurance> searchAssurance(final Page<Assurance> page,final List<PropertyFilter> filter){
		return assuranceDao.findPage(page, filter);
	}
	
	@Autowired
	public void setAssuranceDao(AssuranceDao assuranceDao) {
		this.assuranceDao = assuranceDao;
	}
	
	
}