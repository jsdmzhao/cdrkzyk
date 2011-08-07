package com.jeysan.cpf.bcmas.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.bcmas.dao.WomanContraceptDao;
import com.jeysan.cpf.bcmas.entity.WomanContracept;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class WomanContraceptManager {
	private static Logger logger = LoggerFactory.getLogger(WomanContraceptManager.class);
	
	private WomanContraceptDao womanContraceptDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveWomanContracept(WomanContracept entity){
		womanContraceptDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveWomanContracepts(List<WomanContracept> entites){
		for(WomanContracept entity : entites)
			womanContraceptDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteWomanContracept(Long id){
		womanContraceptDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteWomanContracepts(Long id){
		womanContraceptDao.batchExecute("delete WomanContracept where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteWomanContracepts(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteWomanContracepts(Long.parseLong(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public WomanContracept getWomanContracept(Long id){
		return womanContraceptDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<WomanContracept> searchWomanContracept(final Page<WomanContracept> page,final List<PropertyFilter> filter){
		return womanContraceptDao.findPage(page, filter);
	}
	
	@Autowired
	public void setWomanContraceptDao(WomanContraceptDao womanContraceptDao) {
		this.womanContraceptDao = womanContraceptDao;
	}
	
	
}