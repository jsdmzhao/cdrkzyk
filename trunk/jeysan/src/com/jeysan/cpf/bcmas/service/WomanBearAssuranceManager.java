package com.jeysan.cpf.bcmas.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.bcmas.dao.WomanBearAssuranceDao;
import com.jeysan.cpf.bcmas.entity.WomanBearAssurance;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class WomanBearAssuranceManager {
	private static Logger logger = LoggerFactory.getLogger(WomanBearAssuranceManager.class);
	
	private WomanBearAssuranceDao womanBearAssuranceDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveWomanBearAssurance(WomanBearAssurance entity){
		womanBearAssuranceDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveWomanBearAssurances(List<WomanBearAssurance> entites){
		for(WomanBearAssurance entity : entites)
			womanBearAssuranceDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteWomanBearAssurance(Long id){
		womanBearAssuranceDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteWomanBearAssurances(Long id){
		womanBearAssuranceDao.batchExecute("delete WomanBearAssurance where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteWomanBearAssurances(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteWomanBearAssurances(Long.parseLong(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public WomanBearAssurance getWomanBearAssurance(Long id){
		return womanBearAssuranceDao.get(id);
	}
	@Transactional(readOnly = true)
	public List<WomanBearAssurance> findWomanBearAssurances(Long fertileWomanId){
		return womanBearAssuranceDao.find("from WomanBearAssurance as wba where wba.fertileWoman.id = ? order by wba.dateh", fertileWomanId);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<WomanBearAssurance> searchWomanBearAssurance(final Page<WomanBearAssurance> page,final List<PropertyFilter> filter){
		return womanBearAssuranceDao.findPage(page, filter);
	}
	
	@Autowired
	public void setWomanBearAssuranceDao(WomanBearAssuranceDao womanBearAssuranceDao) {
		this.womanBearAssuranceDao = womanBearAssuranceDao;
	}
	
	
}