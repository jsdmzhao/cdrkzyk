package com.jeysan.cpf.monitor.service;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.monitor.dao.HPMonitorDao;
import com.jeysan.cpf.pmas.dao.HouseDao;
import com.jeysan.cpf.pmas.entity.House;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class HPMonitorManager {
	private static Logger logger = LoggerFactory.getLogger(HPMonitorManager.class);
	
	private HPMonitorDao hpMonitorDao;
	
	public HPMonitorDao getHpMonitorDao() {
		return hpMonitorDao;
	}
	
	@Autowired
	public void setHpMonitorDao(HPMonitorDao hpMonitorDao) {
		this.hpMonitorDao = hpMonitorDao;
	}
	
	public List getListDoublecheckData()throws SQLException
	{
		return hpMonitorDao.getListDoublecheckData();
	}
	
	public List getOverBirth()throws SQLException
	{
		return hpMonitorDao.getOverBirth();
	}
	
	public List getNoContraception()throws SQLException
	{
		return hpMonitorDao.getNoContraception();
	}

	
}