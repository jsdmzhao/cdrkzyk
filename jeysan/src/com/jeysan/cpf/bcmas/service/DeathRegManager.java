package com.jeysan.cpf.bcmas.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.bcmas.dao.DeathRegDao;
import com.jeysan.cpf.bcmas.entity.DeathReg;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class DeathRegManager {
	private static Logger logger = LoggerFactory.getLogger(DeathRegManager.class);
	
	private DeathRegDao deathRegDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveDeathReg(DeathReg entity){
		deathRegDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveDeathRegs(List<DeathReg> entites){
		for(DeathReg entity : entites)
			deathRegDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteDeathReg(Long id){
		deathRegDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteDeathRegs(Long id){
		deathRegDao.batchExecute("delete DeathReg where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteDeathRegs(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteDeathRegs(Long.parseLong(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public DeathReg getDeathReg(Long id){
		return deathRegDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<DeathReg> searchDeathReg(final Page<DeathReg> page,final List<PropertyFilter> filter){
		return deathRegDao.findPage(page, filter);
	}
	
	@Autowired
	public void setDeathRegDao(DeathRegDao deathRegDao) {
		this.deathRegDao = deathRegDao;
	}
	
	
}