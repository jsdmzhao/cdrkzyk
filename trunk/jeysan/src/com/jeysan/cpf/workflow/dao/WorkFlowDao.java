package com.jeysan.cpf.workflow.dao;

import org.fireflow.engine.definition.WorkflowDefinition;
import org.springframework.stereotype.Component;

import com.jeysan.modules.orm.hibernate.HibernateDao;


/**
 * @author 黄静
 *
 */
@Component
public class WorkFlowDao extends HibernateDao<WorkflowDefinition, String> {

}