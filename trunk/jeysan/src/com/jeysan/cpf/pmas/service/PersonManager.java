package com.jeysan.cpf.pmas.service;

import java.util.HashMap;
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
	public void deletePerson(Person entity){
		//fertileWomanDao.delete(fertileWomanDao.findUniqueBy("person.id", id));
		personDao.delete(entity);
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
	@Transactional(readOnly = true)
	public boolean getPersonByCertCodeOrPersonCode(String code , boolean isCert , boolean filterSelf , Long id){
		StringBuilder hql = new StringBuilder();
		hql.append("select 1 as r from Person as p where p.")
		.append(isCert?"code":"personCode")
		.append(" = ? ");
		if(filterSelf){
			hql.append(" and p.id <> ?");
		}
		if(!filterSelf)
			return personDao.createQuery(hql.toString(),code).list().size() > 0;
		else
			return personDao.createQuery(hql.toString(),code,id).list().size() > 0;
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
		.append(") AND DATEDIFF(CURRENT_DATE(),p.dateh) >= 730 ");
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
	/**
	 * result.put("totalNum", 1000);
		result.put("maleNum", 800);
		result.put("femaleNum", 200);
		result.put("fertileWomanNum", 150);
		result.put("notFertileWomanNum", 50);
	 * @param houseCode
	 * @return
	 */
	@Transactional(readOnly = true)
	public Map<String,Integer> queryPersonNumByHouseCode(String houseCode){
		Integer totalNum = 0;
		Map<String,Integer> result = new HashMap<String,Integer>();
		if(StringUtils.isNotEmpty(houseCode)){
			StringBuilder hql = new StringBuilder();
			hql.append("select p.sex,count(*) as num from Person as p left join p.personBasic as pb,House as h where (p.cancelType = ")
			.append(Constants.CANCEL_TYPE.NORMAL)
			.append(" or p.cancelType = ")
			.append(Constants.CANCEL_TYPE.RENEW)
			.append(") and pb.houseId = h.id and h.houseCode = ? group by p.sex ");
			List<Object[]> sex_result = personDao.find(hql.toString(), houseCode);
			Integer  tmp = 0 ,type = null;
			if(sex_result.size() > 0){
				for(Object[] o : sex_result){
					tmp = Integer.parseInt(o[1].toString());
					type = (Integer)o[0];
					if(tmp != null)
						totalNum += tmp;
					if(type == Constants.SEX.MALE.intValue()){
						result.put("maleNum", tmp);
					}else if(type == Constants.SEX.FEMALE.intValue()){
						result.put("femaleNum", tmp);
					}else if(type == Constants.SEX.NOKNOW.intValue()){
						result.put("noKnowNum", tmp);
					}else if(type == Constants.SEX.NONOTIFY.intValue()){
						result.put("noNotifyNum", tmp);
					}
				}
			}
			hql.delete(0, hql.length()-1);
			hql.append("select p.kind,count(*) as num from Person as p left join p.personBasic as pb,House as h where (p.cancelType = ")
			.append(Constants.CANCEL_TYPE.NORMAL)
			.append(" or p.cancelType = ")
			.append(Constants.CANCEL_TYPE.RENEW)
			.append(") and pb.houseId = h.id and h.houseCode = ? group by p.kind ");
			List<Object[]> kind_result = personDao.find(hql.toString(), houseCode);
			if(kind_result.size() > 0){
				for(Object[] o : kind_result){
					tmp = Integer.parseInt(o[1].toString());
					type = (Integer)o[0];
					if(type != null){
						if(type == Constants.FW_KIND.FW.intValue()){
							result.put("fertileWomanNum", tmp);
						}else if(type == Constants.FW_KIND.NOT_FW.intValue()){
							result.put("notFertileWomanNum", tmp);
						}
					}
				}
			}
		}
		result.put("totalNum", totalNum);
		return result;
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