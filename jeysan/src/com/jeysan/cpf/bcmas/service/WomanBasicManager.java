package com.jeysan.cpf.bcmas.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.bcmas.dao.WomanBasicDao;
import com.jeysan.cpf.bcmas.entity.WomanBasic;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class WomanBasicManager {
	private static Logger logger = LoggerFactory.getLogger(WomanBasicManager.class);
	
	private WomanBasicDao womanBasicDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveWomanBasic(WomanBasic entity){
		womanBasicDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveWomanBasics(List<WomanBasic> entites){
		for(WomanBasic entity : entites)
			womanBasicDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteWomanBasic(Integer id){
		womanBasicDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteWomanBasics(Integer id){
		womanBasicDao.batchExecute("delete WomanBasic where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteWomanBasics(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteWomanBasics(Integer.parseInt(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public WomanBasic getWomanBasic(Integer id){
		return womanBasicDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<WomanBasic> searchWomanBasic(final Page<WomanBasic> page,final List<PropertyFilter> filter){
		return womanBasicDao.findPage(page, filter);
	}
	
	@Autowired
	public void setWomanBasicDao(WomanBasicDao womanBasicDao) {
		this.womanBasicDao = womanBasicDao;
	}
	
	
}