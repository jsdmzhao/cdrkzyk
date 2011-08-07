package com.jeysan.cpf.bcmas.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.bcmas.dao.FirstChildRegDao;
import com.jeysan.cpf.bcmas.entity.FirstChildReg;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class FirstChildRegManager {
	private static Logger logger = LoggerFactory.getLogger(FirstChildRegManager.class);
	
	private FirstChildRegDao firstChildRegDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveFirstChildReg(FirstChildReg entity){
		firstChildRegDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveFirstChildRegs(List<FirstChildReg> entites){
		for(FirstChildReg entity : entites)
			firstChildRegDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteFirstChildReg(Long id){
		firstChildRegDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteFirstChildRegs(Long id){
		firstChildRegDao.batchExecute("delete FirstChildReg where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteFirstChildRegs(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteFirstChildRegs(Long.parseLong(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public FirstChildReg getFirstChildReg(Long id){
		return firstChildRegDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<FirstChildReg> searchFirstChildReg(final Page<FirstChildReg> page,final List<PropertyFilter> filter){
		return firstChildRegDao.findPage(page, filter);
	}
	
	@Autowired
	public void setFirstChildRegDao(FirstChildRegDao firstChildRegDao) {
		this.firstChildRegDao = firstChildRegDao;
	}
	
	
}