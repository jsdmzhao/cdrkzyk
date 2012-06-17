package com.jeysan.cpf.pmas.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.pmas.dao.PersonOutDao;
import com.jeysan.cpf.pmas.entity.PersonOut;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class PersonOutManager {
	private static Logger logger = LoggerFactory.getLogger(PersonOutManager.class);
	
	private PersonOutDao personOutDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void savePersonOut(PersonOut entity){
		personOutDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void savePersonOuts(List<PersonOut> entites){
		for(PersonOut entity : entites)
			personOutDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deletePersonOut(Long id){
		personOutDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deletePersonOuts(Long id){
		personOutDao.batchExecute("delete PersonOut where id = ? ", id);
	}
	public void deletePersonOutsByPersonId(Long personId){
		personOutDao.batchExecute("delete PersonOut where person.id = ? ", personId);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deletePersonOuts(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deletePersonOuts(Long.parseLong(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public PersonOut getPersonOut(Long id){
		return personOutDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<PersonOut> searchPersonOut(final Page<PersonOut> page,final List<PropertyFilter> filter){
		return personOutDao.findPage(page, filter);
	}
	
	@Autowired
	public void setPersonOutDao(PersonOutDao personOutDao) {
		this.personOutDao = personOutDao;
	}
	
	
}