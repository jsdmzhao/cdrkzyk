package com.jeysan.cpf.monitor.dao;

import org.springframework.stereotype.Component;

import com.jeysan.cpf.monitor.entity.MonitorWorkload;
import com.jeysan.modules.orm.hibernate.HibernateDao;


/**
 * @author 黄静
 *
 */
@Component
public class MonitorWorkloadDao extends HibernateDao<MonitorWorkload, Long> {

}