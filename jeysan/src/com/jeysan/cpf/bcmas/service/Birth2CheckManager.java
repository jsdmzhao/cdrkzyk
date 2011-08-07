package com.jeysan.cpf.bcmas.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.bcmas.dao.Birth2CheckDao;
import com.jeysan.cpf.bcmas.entity.Birth2Check;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class Birth2CheckManager {
	private static Logger logger = LoggerFactory.getLogger(Birth2CheckManager.class);
	
	private Birth2CheckDao birth2CheckDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveBirth2Check(Birth2Check entity){
		birth2CheckDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveBirth2Checks(List<Birth2Check> entites){
		for(Birth2Check entity : entites)
			birth2CheckDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteBirth2Check(Long id){
		birth2CheckDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteBirth2Checks(Long id){
		birth2CheckDao.batchExecute("delete Birth2Check where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteBirth2Checks(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteBirth2Checks(Long.parseLong(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public Birth2Check getBirth2Check(Long id){
		return birth2CheckDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Birth2Check> searchBirth2Check(final Page<Birth2Check> page,final List<PropertyFilter> filter){
		return birth2CheckDao.findPage(page, filter);
	}
	
	@Autowired
	public void setBirth2CheckDao(Birth2CheckDao birth2CheckDao) {
		this.birth2CheckDao = birth2CheckDao;
	}
	
	
}