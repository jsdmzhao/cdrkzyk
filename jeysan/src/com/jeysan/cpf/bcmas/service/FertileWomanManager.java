package com.jeysan.cpf.bcmas.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.bcmas.dao.FertileWomanDao;
import com.jeysan.cpf.bcmas.entity.FertileWoman;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class FertileWomanManager {
	private static Logger logger = LoggerFactory.getLogger(FertileWomanManager.class);
	
	private FertileWomanDao fertileWomanDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveFertileWoman(FertileWoman entity){
		fertileWomanDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveFertileWomans(List<FertileWoman> entites){
		for(FertileWoman entity : entites)
			fertileWomanDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteFertileWoman(Long id){
		fertileWomanDao.delete(id);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteFertileWomanByPersonId(Long id){
		fertileWomanDao.batchExecute("delete FertileWoman where person.id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteFertileWomans(Long id){
		fertileWomanDao.batchExecute("delete FertileWoman where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteFertileWomans(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteFertileWomans(Long.parseLong(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public FertileWoman getFertileWoman(Long id){
		return fertileWomanDao.get(id);
	}
	/**
	 * 外键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public FertileWoman getFertileWomanByPersonId(Long id){
		List<FertileWoman> lst = fertileWomanDao.findBy("person.id", id);
		if(lst != null && lst.size() > 0)
			return lst.get(0);
		return null;
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<FertileWoman> searchFertileWoman(final Page<FertileWoman> page,final List<PropertyFilter> filter){
		return fertileWomanDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFertileWomanDao(FertileWomanDao fertileWomanDao) {
		this.fertileWomanDao = fertileWomanDao;
	}
	
	
}