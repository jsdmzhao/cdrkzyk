﻿package com.jeysan.cpf.bcmas.service;

import java.util.List;
import java.util.Map;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.bcmas.dao.DoubleCheckDao;
import com.jeysan.cpf.bcmas.entity.DoubleCheck;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class DoubleCheckManager {
	private static Logger logger = LoggerFactory.getLogger(DoubleCheckManager.class);
	
	private DoubleCheckDao doubleCheckDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveDoubleCheck(DoubleCheck entity){
		doubleCheckDao.save(entity);
		//doubleCheckDao.flush();
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveDoubleChecks(List<DoubleCheck> entites){
		for(DoubleCheck entity : entites)
			doubleCheckDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteDoubleCheck(Long id){
		doubleCheckDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteDoubleChecks(Long id){
		doubleCheckDao.batchExecute("delete DoubleCheck where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteDoubleChecks(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteDoubleChecks(Long.parseLong(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public DoubleCheck getDoubleCheck(Long id){
		return doubleCheckDao.get(id);
	}
	/**
	 * 通过批次id和妇女id查找
	 * @param dcId
	 * @param womanId
	 * @return
	 */
	@Transactional(readOnly = true)
	public DoubleCheck getDoubleCheckByFID(Long dcId,Long womanId){
		return doubleCheckDao.findUnique("from DoubleCheck where fertileWoman.id = ? and dc2.id = ? ", womanId,dcId);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<DoubleCheck> searchDoubleCheck(final Page<DoubleCheck> page,final List<PropertyFilter> filter){
		return doubleCheckDao.findPage(page, filter);
	}
	
	@Transactional(readOnly = true)
	public <T> Page searchDoubleCheckByHql(final Page page,final Map<String,T> values){
		StringBuilder hql = new StringBuilder();
		hql.append("select fw DoubleCheck as dc left join dc.fertileWoman as fw");
		return doubleCheckDao.findPage(page, hql.toString(), values);
	}
	
	@Autowired
	public void setDoubleCheckDao(DoubleCheckDao doubleCheckDao) {
		this.doubleCheckDao = doubleCheckDao;
	}
	
	
}