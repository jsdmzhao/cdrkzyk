package com.jeysan.cpf.bcmas.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.bcmas.dao.Birth2ApplyDao;
import com.jeysan.cpf.bcmas.entity.Birth2Apply;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class Birth2ApplyManager {
	private static Logger logger = LoggerFactory.getLogger(Birth2ApplyManager.class);
	
	private Birth2ApplyDao birth2ApplyDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveBirth2Apply(Birth2Apply entity){
		birth2ApplyDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveBirth2Applys(List<Birth2Apply> entites){
		for(Birth2Apply entity : entites)
			birth2ApplyDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteBirth2Apply(Integer id){
		birth2ApplyDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteBirth2Applys(Integer id){
		birth2ApplyDao.batchExecute("delete Birth2Apply where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteBirth2Applys(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteBirth2Applys(Integer.parseInt(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public Birth2Apply getBirth2Apply(Integer id){
		return birth2ApplyDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Birth2Apply> searchBirth2Apply(final Page<Birth2Apply> page,final List<PropertyFilter> filter){
		return birth2ApplyDao.findPage(page, filter);
	}
	
	@Autowired
	public void setBirth2ApplyDao(Birth2ApplyDao birth2ApplyDao) {
		this.birth2ApplyDao = birth2ApplyDao;
	}
	
	
}