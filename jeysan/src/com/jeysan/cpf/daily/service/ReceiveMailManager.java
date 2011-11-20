package com.jeysan.cpf.daily.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.daily.dao.ReceiveMailDao;
import com.jeysan.cpf.daily.entity.ReceiveMail;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class ReceiveMailManager {
	private static Logger logger = LoggerFactory.getLogger(ReceiveMailManager.class);
	
	private ReceiveMailDao receiveMailDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveReceiveMail(ReceiveMail entity){
		receiveMailDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveReceiveMails(List<ReceiveMail> entites){
		for(ReceiveMail entity : entites)
			receiveMailDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteReceiveMail(Long id){
		receiveMailDao.delete(id);
	}
	/**
	 * 用于无关联实体的批量删除
	 * @param ids
	 */
	public void deleteReceiveMails(Long id){
		receiveMailDao.batchExecute("delete ReceiveMail where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteReceiveMails(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteReceiveMails(Long.parseLong(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public ReceiveMail getReceiveMail(Long id){
		return receiveMailDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<ReceiveMail> searchReceiveMail(final Page<ReceiveMail> page,final List<PropertyFilter> filter){
		return receiveMailDao.findPage(page, filter);
	}
	
	@Autowired
	public void setReceiveMailDao(ReceiveMailDao receiveMailDao) {
		this.receiveMailDao = receiveMailDao;
	}
	
	
}