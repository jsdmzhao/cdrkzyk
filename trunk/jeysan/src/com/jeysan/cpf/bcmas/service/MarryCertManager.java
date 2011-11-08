package com.jeysan.cpf.bcmas.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.bcmas.dao.MarryCertDao;
import com.jeysan.cpf.bcmas.entity.MarryCert;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class MarryCertManager {
	private static Logger logger = LoggerFactory.getLogger(MarryCertManager.class);
	
	private MarryCertDao marryCertDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveMarryCert(MarryCert entity){
		marryCertDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveMarryCerts(List<MarryCert> entites){
		for(MarryCert entity : entites)
			marryCertDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteMarryCert(Long id){
		marryCertDao.delete(id);
	}
	public void deleteMarryCert(MarryCert entity){
		marryCertDao.delete(entity);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteMarryCerts(Long id){
		marryCertDao.batchExecute("delete MarryCert where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteMarryCerts(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteMarryCerts(Long.parseLong(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public MarryCert getMarryCert(Long id){
		return marryCertDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<MarryCert> searchMarryCert(final Page<MarryCert> page,final List<PropertyFilter> filter){
		return marryCertDao.findPage(page, filter);
	}
	
	@Autowired
	public void setMarryCertDao(MarryCertDao marryCertDao) {
		this.marryCertDao = marryCertDao;
	}
	
	
}