package com.jeysan.cpf.bcmas.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.bcmas.dao.WomanAwardDao;
import com.jeysan.cpf.bcmas.entity.WomanAward;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class WomanAwardManager {
	private static Logger logger = LoggerFactory.getLogger(WomanAwardManager.class);
	
	private WomanAwardDao womanAwardDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveWomanAward(WomanAward entity){
		womanAwardDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveWomanAwards(List<WomanAward> entites){
		for(WomanAward entity : entites)
			womanAwardDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteWomanAward(Integer id){
		womanAwardDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteWomanAwards(Integer id){
		womanAwardDao.batchExecute("delete WomanAward where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteWomanAwards(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteWomanAwards(Integer.parseInt(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public WomanAward getWomanAward(Integer id){
		return womanAwardDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<WomanAward> searchWomanAward(final Page<WomanAward> page,final List<PropertyFilter> filter){
		return womanAwardDao.findPage(page, filter);
	}
	
	@Autowired
	public void setWomanAwardDao(WomanAwardDao womanAwardDao) {
		this.womanAwardDao = womanAwardDao;
	}
	
	
}