package com.jeysan.cpf.bcmas.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.bcmas.dao.BcsCertChangeDao;
import com.jeysan.cpf.bcmas.entity.BcsCertChange;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class BcsCertChangeManager {
	private static Logger logger = LoggerFactory.getLogger(BcsCertChangeManager.class);
	
	private BcsCertChangeDao bcsCertChangeDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveBcsCertChange(BcsCertChange entity){
		bcsCertChangeDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveBcsCertChanges(List<BcsCertChange> entites){
		for(BcsCertChange entity : entites)
			bcsCertChangeDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteBcsCertChange(Long id){
		bcsCertChangeDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteBcsCertChanges(Long id){
		bcsCertChangeDao.batchExecute("delete BcsCertChange where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteBcsCertChanges(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteBcsCertChanges(Long.parseLong(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public BcsCertChange getBcsCertChange(Long id){
		return bcsCertChangeDao.get(id);
	}
	@Transactional(readOnly = true)
	public BcsCertChange getBcsCertChangeByCertId(Long certId){
		return bcsCertChangeDao.findUniqueBy("certId", certId);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<BcsCertChange> searchBcsCertChange(final Page<BcsCertChange> page,final List<PropertyFilter> filter){
		return bcsCertChangeDao.findPage(page, filter);
	}
	
	@Autowired
	public void setBcsCertChangeDao(BcsCertChangeDao bcsCertChangeDao) {
		this.bcsCertChangeDao = bcsCertChangeDao;
	}
	
	
}