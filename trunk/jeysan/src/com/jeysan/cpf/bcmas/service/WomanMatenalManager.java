package com.jeysan.cpf.bcmas.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.bcmas.dao.WomanMatenalDao;
import com.jeysan.cpf.bcmas.entity.WomanMatenal;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class WomanMatenalManager {
	private static Logger logger = LoggerFactory.getLogger(WomanMatenalManager.class);
	
	private WomanMatenalDao womanMatenalDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveWomanMatenal(WomanMatenal entity){
		womanMatenalDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveWomanMatenals(List<WomanMatenal> entites){
		for(WomanMatenal entity : entites)
			womanMatenalDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteWomanMatenal(Long id){
		womanMatenalDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteWomanMatenals(Long id){
		womanMatenalDao.batchExecute("delete WomanMatenal where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteWomanMatenals(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteWomanMatenals(Long.parseLong(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public WomanMatenal getWomanMatenal(Long id){
		return womanMatenalDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<WomanMatenal> searchWomanMatenal(final Page<WomanMatenal> page,final List<PropertyFilter> filter){
		return womanMatenalDao.findPage(page, filter);
	}
	
	@Autowired
	public void setWomanMatenalDao(WomanMatenalDao womanMatenalDao) {
		this.womanMatenalDao = womanMatenalDao;
	}
	
	
}