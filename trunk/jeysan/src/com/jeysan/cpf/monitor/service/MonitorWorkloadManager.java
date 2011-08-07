package com.jeysan.cpf.monitor.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.monitor.dao.MonitorWorkloadDao;
import com.jeysan.cpf.monitor.entity.MonitorWorkload;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class MonitorWorkloadManager {
	private static Logger logger = LoggerFactory.getLogger(MonitorWorkloadManager.class);
	
	private MonitorWorkloadDao monitorWorkloadDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveMonitorWorkload(MonitorWorkload entity){
		monitorWorkloadDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveMonitorWorkloads(List<MonitorWorkload> entites){
		for(MonitorWorkload entity : entites)
			monitorWorkloadDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteMonitorWorkload(Long id){
		monitorWorkloadDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteMonitorWorkloads(Long id){
		monitorWorkloadDao.batchExecute("delete MonitorWorkload where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteMonitorWorkloads(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteMonitorWorkloads(Long.parseLong(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public MonitorWorkload getMonitorWorkload(Long id){
		return monitorWorkloadDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<MonitorWorkload> searchMonitorWorkload(final Page<MonitorWorkload> page,final List<PropertyFilter> filter){
		return monitorWorkloadDao.findPage(page, filter);
	}
	
	@Autowired
	public void setMonitorWorkloadDao(MonitorWorkloadDao monitorWorkloadDao) {
		this.monitorWorkloadDao = monitorWorkloadDao;
	}
	
	
}