package com.jeysan.cpf.bcmas.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.bcmas.dao.LostRegDao;
import com.jeysan.cpf.bcmas.entity.LostReg;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class LostRegManager {
	private static Logger logger = LoggerFactory.getLogger(LostRegManager.class);
	
	private LostRegDao lostRegDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveLostReg(LostReg entity){
		lostRegDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveLostRegs(List<LostReg> entites){
		for(LostReg entity : entites)
			lostRegDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteLostReg(Long id){
		lostRegDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteLostRegs(Long id){
		lostRegDao.batchExecute("delete LostReg where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteLostRegs(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteLostRegs(Long.parseLong(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public LostReg getLostReg(Long id){
		return lostRegDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<LostReg> searchLostReg(final Page<LostReg> page,final List<PropertyFilter> filter){
		return lostRegDao.findPage(page, filter);
	}
	
	@Autowired
	public void setLostRegDao(LostRegDao lostRegDao) {
		this.lostRegDao = lostRegDao;
	}
	
	
}