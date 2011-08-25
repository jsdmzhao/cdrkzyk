package com.jeysan.cpf.bcmas.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.bcmas.dao.GetIudDao;
import com.jeysan.cpf.bcmas.entity.GetIud;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class GetIudManager {
	private static Logger logger = LoggerFactory.getLogger(GetIudManager.class);
	
	private GetIudDao getIudDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveGetIud(GetIud entity){
		getIudDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveGetIuds(List<GetIud> entites){
		for(GetIud entity : entites)
			getIudDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteGetIud(Long id){
		getIudDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteGetIuds(Long id){
		getIudDao.batchExecute("delete GetIud where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteGetIuds(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteGetIuds(Long.parseLong(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public GetIud getGetIud(Long id){
		return getIudDao.get(id);
	}
	/**
	 * 外键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public GetIud getGetIudByWomanId(Long id){
		return getIudDao.findUniqueBy("fertileWoman.id",id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<GetIud> searchGetIud(final Page<GetIud> page,final List<PropertyFilter> filter){
		return getIudDao.findPage(page, filter);
	}
	
	@Autowired
	public void setGetIudDao(GetIudDao getIudDao) {
		this.getIudDao = getIudDao;
	}
	
	
}