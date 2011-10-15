package com.jeysan.cpf.workflow.service;

import java.util.List;

import org.fireflow.engine.RuntimeContext;
import org.fireflow.engine.definition.WorkflowDefinition;
import org.fireflow.engine.persistence.IPersistenceService;
import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.workflow.dao.ProcessInstanceDao;
import com.jeysan.cpf.workflow.dao.WorkFlowDao;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class ProcessInstanceManager {
	private static Logger logger = LoggerFactory.getLogger(ProcessInstanceManager.class);
	private RuntimeContext runtimeContext;
	private ProcessInstanceDao processInstanceDao;
	private WorkFlowDao workFlowDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveWorkflowDefinition(WorkflowDefinition entity){
		//workFlowDao.save(entity);
		IPersistenceService persistenceService = runtimeContext.getPersistenceService();
		persistenceService.saveOrUpdateWorkflowDefinition(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteWorkflowDefinition(String id){
		workFlowDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteWorkflowDefinitions(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteWorkflowDefinition(id);
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public WorkflowDefinition getWorkflowDefinition(String id){
		return workFlowDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<WorkflowDefinition> searchWorkflowDefinition(final Page<WorkflowDefinition> page,final List<PropertyFilter> filter){
		return workFlowDao.findPage(page, filter);
	}
	@Autowired
	public void setWorkFlowDao(WorkFlowDao workFlowDao) {
		this.workFlowDao = workFlowDao;
	}
	@Autowired
	public void setRuntimeContext(RuntimeContext runtimeContext) {
		this.runtimeContext = runtimeContext;
	}
	@Autowired
	public void setProcessInstanceDao(ProcessInstanceDao processInstanceDao) {
		this.processInstanceDao = processInstanceDao;
	}
	
}