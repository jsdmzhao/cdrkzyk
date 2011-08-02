package com.jeysan.cpf.pmas.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.pmas.dao.PersonBasicDao;
import com.jeysan.cpf.pmas.entity.PersonBasic;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class PersonBasicManager {
	private static Logger logger = LoggerFactory.getLogger(PersonBasicManager.class);
	
	private PersonBasicDao personBasicDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void savePersonBasic(PersonBasic entity){
		personBasicDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void savePersonBasics(List<PersonBasic> entites){
		for(PersonBasic entity : entites)
			personBasicDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deletePersonBasic(Integer id){
		personBasicDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deletePersonBasics(Integer id){
		personBasicDao.batchExecute("delete PersonBasic where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deletePersonBasics(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deletePersonBasics(Integer.parseInt(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public PersonBasic getPersonBasic(Integer id){
		return personBasicDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<PersonBasic> searchPersonBasic(final Page<PersonBasic> page,final List<PropertyFilter> filter){
		return personBasicDao.findPage(page, filter);
	}
	
	@Autowired
	public void setPersonBasicDao(PersonBasicDao personBasicDao) {
		this.personBasicDao = personBasicDao;
	}
	
	
}