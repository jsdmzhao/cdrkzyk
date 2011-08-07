package com.jeysan.cpf.bcmas.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.bcmas.dao.WomanPunishDao;
import com.jeysan.cpf.bcmas.entity.WomanPunish;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class WomanPunishManager {
	private static Logger logger = LoggerFactory.getLogger(WomanPunishManager.class);
	
	private WomanPunishDao womanPunishDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveWomanPunish(WomanPunish entity){
		womanPunishDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveWomanPunishs(List<WomanPunish> entites){
		for(WomanPunish entity : entites)
			womanPunishDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteWomanPunish(Long id){
		womanPunishDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteWomanPunishs(Long id){
		womanPunishDao.batchExecute("delete WomanPunish where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteWomanPunishs(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteWomanPunishs(Long.parseLong(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public WomanPunish getWomanPunish(Long id){
		return womanPunishDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<WomanPunish> searchWomanPunish(final Page<WomanPunish> page,final List<PropertyFilter> filter){
		return womanPunishDao.findPage(page, filter);
	}
	
	@Autowired
	public void setWomanPunishDao(WomanPunishDao womanPunishDao) {
		this.womanPunishDao = womanPunishDao;
	}
	
	
}