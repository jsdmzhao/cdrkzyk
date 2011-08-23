package com.jeysan.cpf.pmas.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.pmas.dao.SpouseDao;
import com.jeysan.cpf.pmas.entity.Spouse;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class SpouseManager {
	private static Logger logger = LoggerFactory.getLogger(SpouseManager.class);
	
	private SpouseDao spouseDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveSpouse(Spouse entity){
		spouseDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveSpouses(List<Spouse> entites){
		for(Spouse entity : entites)
			spouseDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteSpouse(Long id){
		spouseDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteSpouses(Long id){
		spouseDao.batchExecute("delete Spouse where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteSpouses(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteSpouses(Long.parseLong(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public Spouse getSpouseByPersonId(Long id){
		return spouseDao.findUniqueBy("person.id", id);
	}
	/**
	 * 外键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public Spouse getSpouse(Long id){
		return spouseDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Spouse> searchSpouse(final Page<Spouse> page,final List<PropertyFilter> filter){
		return spouseDao.findPage(page, filter);
	}
	
	@Autowired
	public void setSpouseDao(SpouseDao spouseDao) {
		this.spouseDao = spouseDao;
	}
	
	
}