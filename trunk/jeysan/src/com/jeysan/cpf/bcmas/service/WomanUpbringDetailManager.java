package com.jeysan.cpf.bcmas.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.bcmas.dao.WomanUpbringDetailDao;
import com.jeysan.cpf.bcmas.entity.WomanUpbringDetail;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class WomanUpbringDetailManager {
	private static Logger logger = LoggerFactory.getLogger(WomanUpbringDetailManager.class);
	
	private WomanUpbringDetailDao womanUpbringDetailDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveWomanUpbringDetail(WomanUpbringDetail entity){
		womanUpbringDetailDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveWomanUpbringDetails(List<WomanUpbringDetail> entites){
		for(WomanUpbringDetail entity : entites)
			womanUpbringDetailDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteWomanUpbringDetail(Integer id){
		womanUpbringDetailDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteWomanUpbringDetails(Integer id){
		womanUpbringDetailDao.batchExecute("delete WomanUpbringDetail where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteWomanUpbringDetails(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteWomanUpbringDetails(Integer.parseInt(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public WomanUpbringDetail getWomanUpbringDetail(Integer id){
		return womanUpbringDetailDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<WomanUpbringDetail> searchWomanUpbringDetail(final Page<WomanUpbringDetail> page,final List<PropertyFilter> filter){
		return womanUpbringDetailDao.findPage(page, filter);
	}
	
	@Autowired
	public void setWomanUpbringDetailDao(WomanUpbringDetailDao womanUpbringDetailDao) {
		this.womanUpbringDetailDao = womanUpbringDetailDao;
	}
	
	
}