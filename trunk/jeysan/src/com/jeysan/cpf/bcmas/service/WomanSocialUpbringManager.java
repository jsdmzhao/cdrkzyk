package com.jeysan.cpf.bcmas.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.bcmas.dao.WomanSocialUpbringDao;
import com.jeysan.cpf.bcmas.entity.WomanSocialUpbring;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class WomanSocialUpbringManager {
	private static Logger logger = LoggerFactory.getLogger(WomanSocialUpbringManager.class);
	
	private WomanSocialUpbringDao womanSocialUpbringDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveWomanSocialUpbring(WomanSocialUpbring entity){
		womanSocialUpbringDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveWomanSocialUpbrings(List<WomanSocialUpbring> entites){
		for(WomanSocialUpbring entity : entites)
			womanSocialUpbringDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteWomanSocialUpbring(Long id){
		womanSocialUpbringDao.delete(id);
	}
	/**
	 * 用于无关联实体的批量删除
	 * @param ids
	 */
	public void deleteWomanSocialUpbrings(Long id){
		womanSocialUpbringDao.batchExecute("delete WomanSocialUpbring where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteWomanSocialUpbrings(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteWomanSocialUpbring(Long.parseLong(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public WomanSocialUpbring getWomanSocialUpbring(Long id){
		return womanSocialUpbringDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<WomanSocialUpbring> searchWomanSocialUpbring(final Page<WomanSocialUpbring> page,final List<PropertyFilter> filter){
		return womanSocialUpbringDao.findPage(page, filter);
	}
	
	@Autowired
	public void setWomanSocialUpbringDao(WomanSocialUpbringDao womanSocialUpbringDao) {
		this.womanSocialUpbringDao = womanSocialUpbringDao;
	}
	
	
}