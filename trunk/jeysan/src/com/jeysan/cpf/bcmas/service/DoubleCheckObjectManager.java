package com.jeysan.cpf.bcmas.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.bcmas.dao.DoubleCheckObjectDao;
import com.jeysan.cpf.bcmas.entity.DoubleCheckObject;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class DoubleCheckObjectManager {
	private static Logger logger = LoggerFactory.getLogger(DoubleCheckObjectManager.class);
	
	private DoubleCheckObjectDao doubleCheckObjectDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveDoubleCheckObject(DoubleCheckObject entity){
		doubleCheckObjectDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveDoubleCheckObjects(List<DoubleCheckObject> entites){
		for(DoubleCheckObject entity : entites)
			doubleCheckObjectDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteDoubleCheckObject(Long id){
		doubleCheckObjectDao.delete(id);
	}
	/**
	 * 用于无关联实体的批量删除
	 * @param ids
	 */
	public void deleteDoubleCheckObjects(Long id){
		doubleCheckObjectDao.batchExecute("delete DoubleCheckObject where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteDoubleCheckObjects(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteDoubleCheckObjects(Long.parseLong(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public DoubleCheckObject getDoubleCheckObject(Long id){
		return doubleCheckObjectDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<DoubleCheckObject> searchDoubleCheckObject(final Page<DoubleCheckObject> page,final List<PropertyFilter> filter){
		return doubleCheckObjectDao.findPage(page, filter);
	}
	
	@Autowired
	public void setDoubleCheckObjectDao(DoubleCheckObjectDao doubleCheckObjectDao) {
		this.doubleCheckObjectDao = doubleCheckObjectDao;
	}
	
	
}