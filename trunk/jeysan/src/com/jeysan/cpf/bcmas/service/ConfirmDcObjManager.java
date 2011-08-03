package com.jeysan.cpf.bcmas.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.bcmas.dao.ConfirmDcObjDao;
import com.jeysan.cpf.bcmas.entity.ConfirmDcObj;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class ConfirmDcObjManager {
	private static Logger logger = LoggerFactory.getLogger(ConfirmDcObjManager.class);
	
	private ConfirmDcObjDao confirmDcObjDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveConfirmDcObj(ConfirmDcObj entity){
		confirmDcObjDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveConfirmDcObjs(List<ConfirmDcObj> entites){
		for(ConfirmDcObj entity : entites)
			confirmDcObjDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteConfirmDcObj(Integer id){
		confirmDcObjDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteConfirmDcObjs(Integer id){
		confirmDcObjDao.batchExecute("delete ConfirmDcObj where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteConfirmDcObjs(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteConfirmDcObjs(Integer.parseInt(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public ConfirmDcObj getConfirmDcObj(Integer id){
		return confirmDcObjDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<ConfirmDcObj> searchConfirmDcObj(final Page<ConfirmDcObj> page,final List<PropertyFilter> filter){
		return confirmDcObjDao.findPage(page, filter);
	}
	
	@Autowired
	public void setConfirmDcObjDao(ConfirmDcObjDao confirmDcObjDao) {
		this.confirmDcObjDao = confirmDcObjDao;
	}
	
	
}