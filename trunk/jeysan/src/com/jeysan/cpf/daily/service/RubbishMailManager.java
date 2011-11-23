package com.jeysan.cpf.daily.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.daily.dao.RubbishMailDao;
import com.jeysan.cpf.daily.entity.RubbishMail;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class RubbishMailManager {
	private static Logger logger = LoggerFactory.getLogger(RubbishMailManager.class);
	
	private RubbishMailDao rubbishMailDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveRubbishMail(RubbishMail entity){
		rubbishMailDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveRubbishMails(List<RubbishMail> entites){
		for(RubbishMail entity : entites)
			rubbishMailDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteRubbishMail(Long id){
		rubbishMailDao.delete(id);
	}
	public void deleteRubbishMail(RubbishMail entity){
		rubbishMailDao.delete(entity);
	}
	/**
	 * 用于无关联实体的批量删除
	 * @param ids
	 */
	public void deleteRubbishMails(Long id){
		rubbishMailDao.batchExecute("delete RubbishMail where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteRubbishMails(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteRubbishMails(Long.parseLong(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public RubbishMail getRubbishMail(Long id){
		return rubbishMailDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<RubbishMail> searchRubbishMail(final Page<RubbishMail> page,final List<PropertyFilter> filter){
		return rubbishMailDao.findPage(page, filter);
	}
	
	@Autowired
	public void setRubbishMailDao(RubbishMailDao rubbishMailDao) {
		this.rubbishMailDao = rubbishMailDao;
	}
	
	
}