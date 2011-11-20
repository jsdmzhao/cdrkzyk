package com.jeysan.cpf.daily.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.daily.dao.NoticeDao;
import com.jeysan.cpf.daily.entity.Notice;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class NoticeManager {
	private static Logger logger = LoggerFactory.getLogger(NoticeManager.class);
	
	private NoticeDao noticeDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveNotice(Notice entity){
		noticeDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveNotices(List<Notice> entites){
		for(Notice entity : entites)
			noticeDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteNotice(Long id){
		noticeDao.delete(id);
	}
	/**
	 * 用于无关联实体的批量删除
	 * @param ids
	 */
	public void deleteNotices(Long id){
		noticeDao.batchExecute("delete Notice where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteNotices(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteNotices(Long.parseLong(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public Notice getNotice(Long id){
		return noticeDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Notice> searchNotice(final Page<Notice> page,final List<PropertyFilter> filter){
		return noticeDao.findPage(page, filter);
	}
	
	@Autowired
	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}
	
	
}