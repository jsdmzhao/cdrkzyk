package com.jeysan.cpf.monitor.service;

import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.monitor.dao.MonitorSwitchDao;
import com.jeysan.cpf.monitor.entity.MonitorSwitch;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class MonitorSwitchManager {
	private static Logger logger = LoggerFactory.getLogger(MonitorSwitchManager.class);
	
	private MonitorSwitchDao monitorSwitchDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveMonitorSwitch(MonitorSwitch entity){
		monitorSwitchDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveMonitorSwitchs(List<MonitorSwitch> entites){
		for(MonitorSwitch entity : entites)
			monitorSwitchDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteMonitorSwitch(Integer id){
		monitorSwitchDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteMonitorSwitchs(Integer id){
		monitorSwitchDao.batchExecute("delete MonitorSwitch where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteMonitorSwitchs(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteMonitorSwitchs(Integer.parseInt(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public MonitorSwitch getMonitorSwitch(Integer id){
		return monitorSwitchDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<MonitorSwitch> searchMonitorSwitch(final Page<MonitorSwitch> page,final List<PropertyFilter> filter){
		return monitorSwitchDao.findPage(page, filter);
	}
	
	@Autowired
	public void setMonitorSwitchDao(MonitorSwitchDao monitorSwitchDao) {
		this.monitorSwitchDao = monitorSwitchDao;
	}
	
	
}