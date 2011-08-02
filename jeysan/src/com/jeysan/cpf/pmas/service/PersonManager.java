package com.jeysan.cpf.pmas.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.pmas.dao.PersonDao;
import com.jeysan.cpf.pmas.entity.Person;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class PersonManager {
	private static Logger logger = LoggerFactory.getLogger(PersonManager.class);
	
	private PersonDao personDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void savePerson(Person entity){
		personDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void savePersons(List<Person> entites){
		for(Person entity : entites)
			personDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deletePerson(Integer id){
		personDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deletePersons(Integer id){
		personDao.batchExecute("delete Person where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deletePersons(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deletePersons(Integer.parseInt(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public Person getPerson(Integer id){
		return personDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Person> searchPerson(final Page<Person> page,final List<PropertyFilter> filter){
		return personDao.findPage(page, filter);
	}
	
	@Autowired
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}
	
	
}