package com.jeysan.cpf.pmas.service;

import java.util.List;
import java.util.Map;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.jeysan.cpf.bcmas.dao.FertileWomanDao;
import com.jeysan.cpf.pmas.dao.PersonDao;
import com.jeysan.cpf.pmas.entity.Person;
import com.jeysan.cpf.util.Constants;
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
	private FertileWomanDao fertileWomanDao;
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
	public void deletePerson(Long id){
		//fertileWomanDao.delete(fertileWomanDao.findUniqueBy("person.id", id));
		personDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deletePersons(Long id){
		//fertileWomanDao.batchExecute("delete FertileWoman where person.id = ? ", id);
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
				deletePersons(Long.parseLong(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public Person getPerson(Long id){
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
	
	@Transactional(readOnly = true)
	public <T> Page<Person> searchPerson(final Page<Person> page,final Map<String,T> values){
		StringBuilder hql = new StringBuilder();
		hql.append("select p from Person as p where (p.cancelType = ")
		.append(Constants.CANCEL_TYPE.OLD_AGE)
		.append(" or  p.cancelType = ").append(Constants.CANCEL_TYPE.PERSON_OUT)
		.append(" or  p.cancelType = ").append(Constants.CANCEL_TYPE.DEATH)
		.append(") AND DATEDIFF(CURRENT_DATE(),p.cancelDate) >= 730 ");
		List params = Lists.newArrayList();
		if(values != null){
			if(values.get("nameh")!=null){
				hql.append(" and p.nameh like ? ");
				params.add("%"+values.get("nameh")+"%");
			}
			if(values.get("sex")!=null){
				hql.append(" and p.sex = ? ");
				params.add(values.get("sex"));
			}
			if(values.get("code")!=null){
				hql.append(" and p.code = ? ");
				params.add(values.get("code"));
			}
			if(values.get("kind")!=null){
				hql.append(" and p.kind = ? ");
				params.add(values.get("kind"));
			}
			if(values.get("personCode")!=null){
				hql.append(" and p.personCode = ? ");
				params.add(values.get("personCode"));
			}
			if(values.get("area")!=null){
				hql.append(" and p.area = ? ");
				params.add(values.get("area"));
			}
			if(values.get("cancelType")!=null){
				hql.append(" and p.cancelType = ? ");
				params.add(values.get("cancelType"));
			}
		}
		if(StringUtils.isNotEmpty(page.getOrderBy())){
			hql.append(" order by p.").append(page.getOrderBy());
			if(StringUtils.isNotEmpty(page.getOrder()))
				hql.append(" ").append(page.getOrder());
		}
		return personDao.findPage(page, hql.toString(), params.toArray());
	}
	
	@Autowired
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}
	
	@Autowired
	public void setFertileWomanDao(FertileWomanDao fertileWomanDao) {
		this.fertileWomanDao = fertileWomanDao;
	}
	
	
}