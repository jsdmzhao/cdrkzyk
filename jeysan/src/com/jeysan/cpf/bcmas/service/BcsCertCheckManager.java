package com.jeysan.cpf.bcmas.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.bcmas.dao.BcsCertCheckDao;
import com.jeysan.cpf.bcmas.entity.BcsCertCheck;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class BcsCertCheckManager {
	private static Logger logger = LoggerFactory.getLogger(BcsCertCheckManager.class);
	
	private BcsCertCheckDao bcsCertCheckDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveBcsCertCheck(BcsCertCheck entity){
		bcsCertCheckDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveBcsCertChecks(List<BcsCertCheck> entites){
		for(BcsCertCheck entity : entites)
			bcsCertCheckDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteBcsCertCheck(Long id){
		bcsCertCheckDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteBcsCertChecks(Long id){
		bcsCertCheckDao.batchExecute("delete BcsCertCheck where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteBcsCertChecks(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteBcsCertChecks(Long.parseLong(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public BcsCertCheck getBcsCertCheck(Long id){
		return bcsCertCheckDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<BcsCertCheck> searchBcsCertCheck(final Page<BcsCertCheck> page,final List<PropertyFilter> filter){
		return bcsCertCheckDao.findPage(page, filter);
	}
	
	@Autowired
	public void setBcsCertCheckDao(BcsCertCheckDao bcsCertCheckDao) {
		this.bcsCertCheckDao = bcsCertCheckDao;
	}
	
	
}