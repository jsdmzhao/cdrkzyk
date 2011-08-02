package com.jeysan.cpf.pmas.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.pmas.dao.PersonInDao;
import com.jeysan.cpf.pmas.entity.PersonIn;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class PersonInManager {
	private static Logger logger = LoggerFactory.getLogger(PersonInManager.class);
	
	private PersonInDao personInDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void savePersonIn(PersonIn entity){
		personInDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void savePersonIns(List<PersonIn> entites){
		for(PersonIn entity : entites)
			personInDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deletePersonIn(Integer id){
		personInDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deletePersonIns(Integer id){
		personInDao.batchExecute("delete PersonIn where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deletePersonIns(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deletePersonIns(Integer.parseInt(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public PersonIn getPersonIn(Integer id){
		return personInDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<PersonIn> searchPersonIn(final Page<PersonIn> page,final List<PropertyFilter> filter){
		return personInDao.findPage(page, filter);
	}
	
	@Autowired
	public void setPersonInDao(PersonInDao personInDao) {
		this.personInDao = personInDao;
	}
	
	
}