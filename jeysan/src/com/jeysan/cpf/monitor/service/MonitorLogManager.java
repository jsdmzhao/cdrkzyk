package com.jeysan.cpf.monitor.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.monitor.dao.MonitorLogDao;
import com.jeysan.cpf.monitor.entity.MonitorLog;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class MonitorLogManager {
	private static Logger logger = LoggerFactory.getLogger(MonitorLogManager.class);
	
	private MonitorLogDao monitorLogDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveMonitorLog(MonitorLog entity){
		monitorLogDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveMonitorLogs(List<MonitorLog> entites){
		for(MonitorLog entity : entites)
			monitorLogDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteMonitorLog(Integer id){
		monitorLogDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteMonitorLogs(Integer id){
		monitorLogDao.batchExecute("delete MonitorLog where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteMonitorLogs(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteMonitorLogs(Integer.parseInt(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public MonitorLog getMonitorLog(Integer id){
		return monitorLogDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<MonitorLog> searchMonitorLog(final Page<MonitorLog> page,final List<PropertyFilter> filter){
		return monitorLogDao.findPage(page, filter);
	}
	
	@Autowired
	public void setMonitorLogDao(MonitorLogDao monitorLogDao) {
		this.monitorLogDao = monitorLogDao;
	}
	
	
}