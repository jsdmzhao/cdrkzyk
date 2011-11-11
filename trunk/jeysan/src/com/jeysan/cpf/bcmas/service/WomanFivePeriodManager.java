package com.jeysan.cpf.bcmas.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.bcmas.dao.WomanFivePeriodDao;
import com.jeysan.cpf.bcmas.entity.WomanFivePeriod;
import com.jeysan.cpf.util.Constants;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class WomanFivePeriodManager {
	private static Logger logger = LoggerFactory.getLogger(WomanFivePeriodManager.class);
	
	private WomanFivePeriodDao womanFivePeriodDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveWomanFivePeriod(WomanFivePeriod entity){
		womanFivePeriodDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveWomanFivePeriods(List<WomanFivePeriod> entites){
		for(WomanFivePeriod entity : entites)
			womanFivePeriodDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteWomanFivePeriod(Long id){
		womanFivePeriodDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteWomanFivePeriods(Long id){
		womanFivePeriodDao.batchExecute("delete WomanFivePeriod where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteWomanFivePeriods(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteWomanFivePeriods(Long.parseLong(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public WomanFivePeriod getWomanFivePeriod(Long id){
		return womanFivePeriodDao.get(id);
	}
	@Transactional(readOnly = true)
	public List<WomanFivePeriod> findWomanFivePeriods(Long fertileWomanId){
		return womanFivePeriodDao.find("from WomanFivePeriod as wfp where wfp.fertileWoman.id = ? and wfp.eduType != ? order by wfp.eduDate ", fertileWomanId , "229");
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<WomanFivePeriod> searchWomanFivePeriod(final Page<WomanFivePeriod> page,final List<PropertyFilter> filter){
		return womanFivePeriodDao.findPage(page, filter);
	}
	
	@Autowired
	public void setWomanFivePeriodDao(WomanFivePeriodDao womanFivePeriodDao) {
		this.womanFivePeriodDao = womanFivePeriodDao;
	}
	
	
}