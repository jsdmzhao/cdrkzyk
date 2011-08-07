package com.jeysan.cpf.monitor.dao;

import org.springframework.stereotype.Component;

import com.jeysan.cpf.monitor.entity.MonitorLog;
import com.jeysan.modules.orm.hibernate.HibernateDao;


/**
 * @author 黄静
 *
 */
@Component
public class MonitorLogDao extends HibernateDao<MonitorLog, Long> {

}