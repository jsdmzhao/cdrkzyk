package com.jeysan.cpf.bcmas.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.bcmas.dao.BcsCertDao;
import com.jeysan.cpf.bcmas.entity.BcsCert;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class BcsCertManager {
	private static Logger logger = LoggerFactory.getLogger(BcsCertManager.class);
	
	private BcsCertDao bcsCertDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveBcsCert(BcsCert entity){
		bcsCertDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveBcsCerts(List<BcsCert> entites){
		for(BcsCert entity : entites)
			bcsCertDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteBcsCert(Integer id){
		bcsCertDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteBcsCerts(Integer id){
		bcsCertDao.batchExecute("delete BcsCert where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteBcsCerts(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteBcsCerts(Integer.parseInt(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public BcsCert getBcsCert(Integer id){
		return bcsCertDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<BcsCert> searchBcsCert(final Page<BcsCert> page,final List<PropertyFilter> filter){
		return bcsCertDao.findPage(page, filter);
	}
	
	@Autowired
	public void setBcsCertDao(BcsCertDao bcsCertDao) {
		this.bcsCertDao = bcsCertDao;
	}
	
	
}