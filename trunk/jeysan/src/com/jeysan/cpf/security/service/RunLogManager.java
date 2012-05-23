package com.jeysan.cpf.security.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.security.dao.RunLogDao;
import com.jeysan.cpf.security.entity.RunLog;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class RunLogManager {
	private static Logger logger = LoggerFactory.getLogger(RunLogManager.class);
	
	private RunLogDao runLogDao;
	/**
	 * 增加
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public void saveRunLog(RunLog entity){
		runLogDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveRunLogs(List<RunLog> entites){
		for(RunLog entity : entites)
			runLogDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteRunLog(Long id){
		runLogDao.delete(id);
	}
	/**
	 * 用于无关联实体的批量删除
	 * @param ids
	 */
	public void deleteRunLogs(Long id){
		runLogDao.batchExecute("delete RunLog where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteRunLogs(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteRunLogs(Long.parseLong(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public RunLog getRunLog(Long id){
		return runLogDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<RunLog> searchRunLog(final Page<RunLog> page,final List<PropertyFilter> filter){
		return runLogDao.findPage(page, filter);
	}
	
	@Autowired
	public void setRunLogDao(RunLogDao runLogDao) {
		this.runLogDao = runLogDao;
	}
	
	
}