package com.jeysan.cpf.bcmas.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.bcmas.dao.DoubleCheck2Dao;
import com.jeysan.cpf.bcmas.entity.DoubleCheck2;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class DoubleCheck2Manager {
	private static Logger logger = LoggerFactory.getLogger(DoubleCheck2Manager.class);
	
	private DoubleCheck2Dao doubleCheck2Dao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveDoubleCheck2(DoubleCheck2 entity){
		doubleCheck2Dao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveDoubleCheck2s(List<DoubleCheck2> entites){
		for(DoubleCheck2 entity : entites)
			doubleCheck2Dao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteDoubleCheck2(Long id){
		doubleCheck2Dao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteDoubleCheck2s(Long id){
		doubleCheck2Dao.batchExecute("delete DoubleCheck2 where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteDoubleChecks(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteDoubleCheck2s(Long.parseLong(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public DoubleCheck2 getDoubleCheck2(Long id){
		return doubleCheck2Dao.get(id);
	}
	/**
	 * 通过年份查找
	 * @param year
	 * @return
	 */
	@Transactional(readOnly = true)
	public DoubleCheck2 getDoubleCheck2ByYear(Integer year){
		return doubleCheck2Dao.findUniqueBy("year", year);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<DoubleCheck2> searchDoubleCheck(final Page<DoubleCheck2> page,final List<PropertyFilter> filter){
		return doubleCheck2Dao.findPage(page, filter);
	}
	
	@Transactional(readOnly = true)
	public List<DoubleCheck2> getAllDoubleCheck(){
		return doubleCheck2Dao.getAll("year",false);
	}
	
	@Autowired
	public void setDoubleCheck2Dao(DoubleCheck2Dao doubleCheck2Dao) {
		this.doubleCheck2Dao = doubleCheck2Dao;
	}
	
	
}