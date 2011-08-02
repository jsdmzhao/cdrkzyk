package com.jeysan.cpf.daily.wf;

import org.fireflow.engine.EngineException;
import org.fireflow.engine.IWorkItem;
import org.fireflow.engine.taskinstance.IAssignable;
import org.fireflow.engine.taskinstance.IAssignmentHandler;
import org.fireflow.kernel.KernelException;

import com.jeysan.modules.security.springsecurity.SpringSecurityUtils;
import com.jeysan.modules.security.springsecurity.SpringUser;

/**
 * 该AssignmentHandler将TaskInstance分配给当前用户，并且立即结束新创建的workitem。
 * 适用于填写请假单环节。
 * @author 黄静
 *
 */
public class CurrentUserAssignmentHandler implements IAssignmentHandler{

	@Override
	public void assign(IAssignable assignable, String postCode) throws EngineException,
			KernelException {
		//取得当前系统用户，即请假申请人
		SpringUser currentUser = (SpringUser)SpringSecurityUtils.getCurrentUser();
		//为当前用户创建WorkItem
		IWorkItem wi = assignable.asignToActor(currentUser.getId_().toString());
		//签收新创建的WorkItem
		wi.claim();
		//结束新创建的WorkItem，触发流程实例往下流转
		wi.complete();
	}
}
