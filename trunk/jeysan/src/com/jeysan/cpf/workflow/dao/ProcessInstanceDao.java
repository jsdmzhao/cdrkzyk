package com.jeysan.cpf.workflow.dao;

import org.fireflow.engine.impl.ProcessInstance;
import org.springframework.stereotype.Component;

import com.jeysan.modules.orm.hibernate.HibernateDao;


/**
 * @author 黄静
 *
 */
@Component
public class ProcessInstanceDao extends HibernateDao<ProcessInstance, String> {

}