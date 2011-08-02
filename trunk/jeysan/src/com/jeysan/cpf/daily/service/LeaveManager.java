package com.jeysan.cpf.daily.service;

import java.util.List;

import org.fireflow.engine.IProcessInstance;
import org.fireflow.engine.IWorkItem;
import org.fireflow.engine.IWorkflowSession;
import org.fireflow.engine.RuntimeContext;
import org.fireflow.engine.persistence.IPersistenceService;
import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.daily.dao.LeaveDao;
import com.jeysan.cpf.daily.entity.Leave;
import com.jeysan.modules.exception.ServiceException;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class LeaveManager {
	private static Logger logger = LoggerFactory.getLogger(LeaveManager.class);
	private RuntimeContext runtimeContext;
	private LeaveDao leaveDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveLeave(Leave entity) throws ServiceException{
		leaveDao.save(entity);
	}
	/**
	 * 保存流程审批信息并提交
	 * @param entity
	 */
	public void saveLeave(Leave entity,String wiid) throws ServiceException{
		try{
			leaveDao.save(entity);
			IWorkflowSession wflsession = runtimeContext.getWorkflowSession();
			IWorkItem wi = wflsession.findWorkItemById(wiid);
			updateVariables(wi.getTaskInstance().getProcessInstanceId(),entity);
			wi.complete();
			//entity.setWfState(wflsession.findProcessInstanceById(wi.getTaskInstance().getProcessInstanceId()).getState());
			//leaveDao.save(entity);
			Integer state = wflsession.findProcessInstanceById(wi.getTaskInstance().getProcessInstanceId()).getState();
			leaveDao.updateState(entity.getId(), state);
		}catch(Exception e){
			logger.error("处理请假流程失败了："+e);
			e.printStackTrace();
			throw new ServiceException(e);
		}
	}
	
	private void updateVariables(String processInstanceId,Leave entity){
		IPersistenceService persistenceService = runtimeContext.getPersistenceService();
		IProcessInstance processInstance = runtimeContext.getWorkflowSession().findProcessInstanceById(processInstanceId);
		//IProcessInstance processInstance = persistenceService.findAliveProcessInstanceById(processInstanceId);
		if(entity.getWfLevel() != null){
			if(entity.getWfLevel() == 2 && entity.getDeptorCheck() != null){
				if(entity.getDeptorCheck() == 12)
					processInstance.setProcessInstanceVariable("DeptorCheck", true);
				else if(entity.getDeptorCheck() == 13)
					processInstance.setProcessInstanceVariable("DeptorCheck", false);
			}
			if(entity.getWfLevel() == 3 && entity.getBossCheck() != null){
				if(entity.getBossCheck() == 12)
					processInstance.setProcessInstanceVariable("BossCheck", true);
				else if(entity.getBossCheck() == 13)
					processInstance.setProcessInstanceVariable("BossCheck", false);
			}
		}
		persistenceService.saveOrUpdateProcessInstance(processInstance);
	}
	
	/**
	 * 启动流程
	 * @param entity
	 */
	public void saveLeave4WF(Leave entity) throws ServiceException{
		try{
			IWorkflowSession workflowSession = runtimeContext.getWorkflowSession();
			IProcessInstance processInstance = workflowSession.createProcessInstance("LeaveProcess", entity.getLeaveEmployeeId().toString());
			processInstance.setProcessInstanceVariable("SJID", entity.getId());
			processInstance.setProcessInstanceVariable("LeaveCount", entity.getLeaveCount());
			processInstance.run();
			//entity.setWfPiid(processInstance.getId());
			//entity.setWfState(processInstance.getState());
			//leaveDao.save(entity);
			leaveDao.updateState(entity.getId(), processInstance.getState(),processInstance.getId());
		}catch(Exception e){
			logger.error("启动请假流程失败了："+e);
			e.printStackTrace();
			throw new ServiceException(e);
		}
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveLeaves(List<Leave> entites){
		for(Leave entity : entites)
			leaveDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteLeave(Long id){
		leaveDao.delete(id);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteLeaves(Long id){
		leaveDao.batchExecute("delete Leave where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteLeaves(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteLeaves(Long.parseLong(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public Leave getLeave(Long id){
		return leaveDao.get(id);
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Leave> searchLeave(final Page<Leave> page,final List<PropertyFilter> filter){
		return leaveDao.findPage(page, filter);
	}
	
	@Autowired
	public void setLeaveDao(LeaveDao leaveDao) {
		this.leaveDao = leaveDao;
	}
	
	@Autowired
	public void setRuntimeContext(RuntimeContext runtimeContext) {
		this.runtimeContext = runtimeContext;
	}

}