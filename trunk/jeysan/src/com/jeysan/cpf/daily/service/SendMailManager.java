package com.jeysan.cpf.daily.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.daily.dao.SendMailDao;
import com.jeysan.cpf.daily.entity.SendMail;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class SendMailManager {
	private static Logger logger = LoggerFactory.getLogger(SendMailManager.class);
	
	private SendMailDao sendMailDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveSendMail(SendMail entity){
		sendMailDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveSendMails(List<SendMail> entites){
		for(SendMail entity : entites)
			sendMailDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteSendMail(Long id){
		sendMailDao.delete(id);
	}
	/**
	 * 用于无关联实体的批量删除
	 * @param ids
	 */
	public void deleteSendMails(Long id){
		sendMailDao.batchExecute("delete SendMail where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteSendMails(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteSendMails(Long.parseLong(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public SendMail getSendMail(Long id){
		return sendMailDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<SendMail> searchSendMail(final Page<SendMail> page,final List<PropertyFilter> filter){
		return sendMailDao.findPage(page, filter);
	}
	
	@Autowired
	public void setSendMailDao(SendMailDao sendMailDao) {
		this.sendMailDao = sendMailDao;
	}
	
	
}