package com.jeysan.cpf.workflow.service;

import org.fireflow.engine.IWorkItem;
import org.fireflow.engine.IWorkflowSession;
import org.fireflow.engine.RuntimeContext;
import org.fireflow.engine.impl.WorkItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.workflow.dao.WorkItemDao;
import com.jeysan.modules.exception.ServiceException;
import com.jeysan.modules.orm.Page;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class WorkItemManager {
	private static Logger logger = LoggerFactory.getLogger(WorkItemManager.class);
	private RuntimeContext runtimeContext;
	private WorkItemDao workItemDao;
	/**
	 * 待办
	 * @param page
	 * @param actorId
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<WorkItem> findTodoWorkItems(Page<WorkItem> page,String actorId) {
        return workItemDao.findTodoWorkItems(page,actorId);
    }
	/**
	 * 已办
	 * @param page
	 * @param actorId
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<WorkItem> findHaveDoneWorkItems(Page<WorkItem> page,String actorId) {
        return workItemDao.findHaveDoneWorkItems(page,actorId);
    }
	/**
	 * 签收工单
	 * @param workItemId
	 * @return
	 */
	public void claimWorkItem(String workItemId) {
		IWorkflowSession wflsession = runtimeContext.getWorkflowSession();
		IWorkItem wi = wflsession.findWorkItemById(workItemId);
		try {
			if (wi != null) {
				wi.claim();
			}
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}
	/**
	 * 结束工单
	 * @param workItemId
	 * @return
	 */
	public void completeWorkItem(String workItemId) {
		IWorkflowSession wflsession = runtimeContext.getWorkflowSession();
		IWorkItem wi = wflsession.findWorkItemById(workItemId);
		try {
			if (wi != null) {
				wi.complete();
			}
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}
	
	@Autowired
	public void setRuntimeContext(RuntimeContext runtimeContext) {
		this.runtimeContext = runtimeContext;
	}
	@Autowired
	public void setWorkItemDao(WorkItemDao workItemDao) {
		this.workItemDao = workItemDao;
	}
	
	
}