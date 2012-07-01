package com.jeysan.cpf.security.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.jeysan.cpf.security.dao.DictSubDao;
import com.jeysan.cpf.security.entity.DictSub;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class DictSubManager {
	private static Logger logger = LoggerFactory.getLogger(DictSubManager.class);
	
	private DictSubDao dictSubDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveDictSub(DictSub entity){
		dictSubDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveDictSubs(List<DictSub> newEntites,List<DictSub> oldEntites){
		List<Integer> newIds = Lists.newArrayList();
		for(DictSub newSub:newEntites){
			if(newSub.getId()!=null)
				newIds.add(newSub.getId());
		}
		for(DictSub oldSub : oldEntites){
			if(!newIds.contains(oldSub.getId())){
				oldSub.setDict(null);
				dictSubDao.delete(oldSub);
			}
		}
		for(DictSub entity : newEntites)
			dictSubDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteDictSub(Integer id){
		dictSubDao.delete(id);
	}
	@Transactional(readOnly = true)
	public List<DictSub> loadAllDictSubs(){
		return dictSubDao.find("select d from DictSub as d order by d.dict , d.subIndex ");
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteDictSubs(Integer id){
		dictSubDao.batchExecute("delete DictSub where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteDictSubs(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteDictSubs(Integer.parseInt(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public DictSub getDictSub(Integer id){
		return dictSubDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<DictSub> searchDictSub(final Page<DictSub> page,final List<PropertyFilter> filter){
		return dictSubDao.findPage(page, filter);
	}
	
	@Autowired
	public void setDictSubDao(DictSubDao dictSubDao) {
		this.dictSubDao = dictSubDao;
	}
	
	
}