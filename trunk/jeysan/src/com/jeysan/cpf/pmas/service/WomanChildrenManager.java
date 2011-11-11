package com.jeysan.cpf.pmas.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.pmas.dao.WomanChildrenDao;
import com.jeysan.cpf.pmas.entity.WomanChildren;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class WomanChildrenManager {
	private static Logger logger = LoggerFactory.getLogger(WomanChildrenManager.class);
	
	private WomanChildrenDao womanChildrenDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveWomanChildren(WomanChildren entity){
		womanChildrenDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveWomanChildrens(List<WomanChildren> entites){
		for(WomanChildren entity : entites)
			womanChildrenDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteWomanChildren(WomanChildren entity){
		womanChildrenDao.delete(entity);
	}
	public void deleteWomanChildren(Long id){
		womanChildrenDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteWomanChildrens(Long id){
		womanChildrenDao.batchExecute("delete WomanChildren where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteWomanChildrens(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteWomanChildrens(Long.parseLong(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public WomanChildren getWomanChildren(Long id){
		return womanChildrenDao.get(id);
	}
	@Transactional(readOnly = true)
	public WomanChildren getWomanChildrenByPersonId(Long personId){
		return womanChildrenDao.findUniqueBy("person.id", personId);
	}
	@Transactional(readOnly = true)
	public List<WomanChildren> findWomanChildsByPersonId(Long personId){
		return womanChildrenDao.findBy("person.id", personId);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<WomanChildren> searchWomanChildren(final Page<WomanChildren> page,final List<PropertyFilter> filter){
		return womanChildrenDao.findPage(page, filter);
	}
	
	@Autowired
	public void setWomanChildrenDao(WomanChildrenDao womanChildrenDao) {
		this.womanChildrenDao = womanChildrenDao;
	}
	
	
}