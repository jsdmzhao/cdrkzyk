package com.jeysan.cpf.bcmas.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.bcmas.dao.DoubleCheckDetailDao;
import com.jeysan.cpf.bcmas.entity.DoubleCheckDetail;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class DoubleCheckDetailManager {
	private static Logger logger = LoggerFactory.getLogger(DoubleCheckDetailManager.class);
	
	private DoubleCheckDetailDao doubleCheckDetailDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveDoubleCheckDetail(DoubleCheckDetail entity){
		doubleCheckDetailDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveDoubleCheckDetails(List<DoubleCheckDetail> entites){
		for(DoubleCheckDetail entity : entites)
			doubleCheckDetailDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteDoubleCheckDetail(Long id){
		doubleCheckDetailDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteDoubleCheckDetails(Long id){
		doubleCheckDetailDao.batchExecute("delete DoubleCheckDetail where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteDoubleCheckDetails(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteDoubleCheckDetails(Long.parseLong(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public DoubleCheckDetail getDoubleCheckDetail(Long id){
		return doubleCheckDetailDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<DoubleCheckDetail> searchDoubleCheckDetail(final Page<DoubleCheckDetail> page,final List<PropertyFilter> filter){
		return doubleCheckDetailDao.findPage(page, filter);
	}
	
	@Autowired
	public void setDoubleCheckDetailDao(DoubleCheckDetailDao doubleCheckDetailDao) {
		this.doubleCheckDetailDao = doubleCheckDetailDao;
	}
	
	
}